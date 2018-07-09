package com.lfxfs.tools.core.metaData;

import com.lfxfs.tools.core.DataSource;
import com.lfxfs.tools.core.ExtractTableMetaData;
import com.lfxfs.tools.core.model.Field;
import com.lfxfs.tools.core.model.Table;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class MySqlExtractTableMetaData implements ExtractTableMetaData{
    @Override
    public List<Table> extractTableMetaData(DataSource dataSource) {
        List<Table> lists = new ArrayList<Table>();
        Connection conn = null;
        String sql ="SELECT A.ordinal_position, \n" +
                "\tB.TABLE_NAME,\n" +
                "\tb.table_COMMENT,\n" +
                "\tA.COLUMN_NAME,\n" +
                "\tA.DATA_TYPE,\n" +
                "\tA.COLUMN_COMMENT\n" +
                "FROM\n" +
                "\tinformation_schema.COLUMNS a,\n" +
                "\tinformation_schema.TABLES b \n" +
                "WHERE\n" +
                "\ta.TABLE_SCHEMA = b.TABLE_SCHEMA \n" +
                "\tAND A.TABLE_NAME = B.TABLE_NAME\n" +
                "\tAND a.table_schema = 'apolloconfigdb' \n" +
                "\tAND B.table_type = 'base table' \n" +
                "\tAND A.table_name = 'appnamespace' \n" +
                "ORDER BY\n" +
                "\tA.ordinal_position";
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

    private List<Field> queryTableFiedByTableName(Connection conn,String tableName) throws SQLException {
        List<Field> fields = new ArrayList<>();
        String sql ="select * from dba_columents WHERE  table_name= '"+tableName+"' order by create_date desc";
        PreparedStatement prtm = conn.prepareStatement(sql);
        ResultSet rs = prtm.executeQuery();
        while(rs.next()){
            String tableNameStr=	rs.getString(1);
            String fieldStr=	rs.getString(2);
            String fieldComments = rs.getString(3);
            String dataType = rs.getString(4);
            Field field = new Field(tableNameStr,fieldStr,fieldComments,dataType);
            fields.add(field);
        }
        rs.close();
        prtm.close();
        return  fields;
    }
}
