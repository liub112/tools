package com.lfxfs.tools.core.metaData;

import com.lfxfs.tools.core.DataSource;
import com.lfxfs.tools.core.ExtractTableMetaData;
import com.lfxfs.tools.core.model.Field;
import com.lfxfs.tools.core.model.Table;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MySqlExtractTableMetaData implements ExtractTableMetaData{
    @Override
    public List<Table> extractTableMetaData(DataSource dataSource) {
        List<Table> lists = new ArrayList<Table>();
        Connection conn = null;
        String sql ="select * from dba_tables order by create_date desc";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            conn = dataSource.getConnection();
            PreparedStatement prtm = conn.prepareStatement(sql);
            ResultSet rs = prtm.executeQuery();
            while(rs.next()){
                String tableName=	rs.getString(1);
                String comments = rs.getString(2);
                Table table = new Table(tableName,comments);
                List<Field> fields = queryTableFiedByTableName(conn,tableName);
                table.setFields(fields);
                lists.add(table);
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
