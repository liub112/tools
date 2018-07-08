package com.lfxfs.tools.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 */
public class DataSource {
    private Properties properties;

    public DataSource(Properties properties){
        this.properties = properties;
    }

    public String pullDataSourceType(){
        String dataSourceType = "";
        if(properties.getProperty("tool.beans.file.generator.driverClass").contains("mysql")){
            dataSourceType ="mysql";
        }
        if(properties.getProperty("tool.beans.file.generator.driverClass").contains("oracle")){
            dataSourceType ="oracle";
        }
        return dataSourceType;
    }

    public  Connection getConnection() throws Exception {
        Class.forName(properties.getProperty("tool.beans.file.generator.driverClass"));
        Connection conn = DriverManager.getConnection(properties.getProperty("tool.beans.file.generator.dbUrl")
                ,properties.getProperty("tool.beans.file.generator.dbUser"),properties.getProperty("tool.beans.file.generator.dbPassWord"));
        return conn;
    }

    public  void  closeConnection(Connection conn) {
        if(conn!=null){
            try {
                conn.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
