package com.lfxfs.tools.core.metaData;

import com.lfxfs.tools.core.DataSource;
import com.lfxfs.tools.core.ExtractTableMetaData;
import com.lfxfs.tools.core.model.Field;
import com.lfxfs.tools.core.model.Table;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

public class OracleExtractTableMetaData implements ExtractTableMetaData{
    @Override
    public List<Table> extractTableMetaData(DataSource dataSource) {
        List<Table> lists = new ArrayList<Table>();
        Connection conn = null;
        String sql ="select aa.id,\n" +
                "       aa.table_name,\n" +
                "       aa.table_comments,\n" +
                "       aa.column_name,\n" +
                "       data_type,\n" +
                "       (select colm.comments\n" +
                "          from dba_col_comments colm\n" +
                "         where colm.table_name = aa.table_name\n" +
                "           and colm.column_name = aa.column_name\n" +
                "           and colm.comments is not null\n" +
                "           and rownum = 1)\n" +
                "  from (select distinct us.table_name,\n" +
                "                        (select distinct comments\n" +
                "                           from dba_tab_comments cc\n" +
                "                          where cc.table_name = t.TABLE_NAME\n" +
                "                            and cc.comments is not null\n" +
                "                            and rownum = 1) table_comments,\n" +
                "                        us.COLUMN_NAME column_name,\n" +
                "                        data_type,\n" +
                "                        us.COLUMN_ID id\n" +
                "          from dba_tab_comments t, dba_tab_columns us\n" +
                "         where us.TABLE_NAMe = t.TABLE_NAME\n" +
                "           and t.OWNER = us.OWNER\n" +
                "           and lower(t.table_name) in ('customer_interaction_event'," +
                "'customer_order','order_item')\n" +
                "         order by us.COLUMN_ID) aa";
        try {
            conn = dataSource.getConnection();
            PreparedStatement prtm = conn.prepareStatement(sql);
            ResultSet rs = prtm.executeQuery();
            Set<Table> tableSet = new HashSet<Table>();
            List<Field> fieldList = new ArrayList<Field>();
            while(rs.next()){
                String tableName=	rs.getString(2);
                String tablecomments = rs.getString(3);
                Table table = new Table(tableName,tablecomments);
                tableSet.add(table);

                String columnName = rs.getString(4);
                String dataType = rs.getString(5);
                String columncomments = rs.getString(6);
                Field field = new Field(tableName,columnName,columncomments,dataType);
                fieldList.add(field);
            }
            Iterator<Table> it = tableSet.iterator();
            while (it.hasNext()) {
                Table t = it.next();
                List<Field> fields = new ArrayList<>();
                for (int i = 0; i <fieldList.size() ; i++) {
                    Field field = fieldList.get(i);
                    if(field.getTableName().equals(t.getTableName())){
                        fields.add(field);
                    }
                }
                t.setFields(fields);
                lists.add(t);
            }

            rs.close();
            prtm.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "查询表元数据："+e.getMessage());
        }finally{
            dataSource.closeConnection(conn);
        }
        return lists;

    }
}
