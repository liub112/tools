package com.lfxfs.tools.core.generator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Constant {
    public static Map JDBC_TYPE_CONVERSION_TRANSFER = new HashMap<String,String>();
    static {
        JDBC_TYPE_CONVERSION_TRANSFER.put("String","VARCHAR");
        JDBC_TYPE_CONVERSION_TRANSFER.put("String","VARCHAR2");
        JDBC_TYPE_CONVERSION_TRANSFER.put("Long","DECIMAL");
        JDBC_TYPE_CONVERSION_TRANSFER.put("Date","TIMESTAMP");
        JDBC_TYPE_CONVERSION_TRANSFER.put("Long","NUMBER");
        JDBC_TYPE_CONVERSION_TRANSFER.put("Date","DATE");


/*      JDBCType            JavaType
        CHAR                String
        VARCHAR             String
        LONGVARCHAR         String
        NUMERIC             java.math.BigDecimal
        DECIMAL             java.math.BigDecimal
        BIT                 boolean
        BOOLEAN             boolean
        TINYINT             byte
        SMALLINT            short
        INTEGER             int
        BIGINT              long
        REAL                float
        FLOAT               double
        DOUBLE              double
        BINARY              byte[]
        VARBINARY           byte[]
        LONGVARBINARY               byte[]
        DATE                java.sql.Date
        TIME                java.sql.Time
        TIMESTAMP           java.sql.Timestamp
        CLOB                Clob
        BLOB                Blob
        ARRAY               Array
        DISTINCT            mapping of underlying type
        STRUCT              Struct
        REF                 Ref
        DATALINK            java.net.URL[color=red][/color]*/
    }

    //根据value值获取到对应的一个key值
    public static String getKey(String value){
        String key = null;
        Iterator<Map.Entry<String, String>> it = JDBC_TYPE_CONVERSION_TRANSFER.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            if(entry.getValue().equals(value)){
                key = entry.getKey();
            }
        }
        return key;
    }
}
