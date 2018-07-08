package com.lfxfs.tools.core.model;

import com.lfxfs.tools.core.generator.Constant;

public class Field {
    /**
     * 表名
     */
    private String tableName;
    /**
     * 字段
     */
    private String field;
    /**
     * 自动描述
     */
    private String fieldComments;

    /**
     * JAVA字段类型
     * @return
     */
    private String dataType;

    /**
     * JDBC自动类型
     */
    private  String jdbcType;

    public Field() {
    }

    public Field(String tableName,String field, String fieldComments, String jdbcType) {
        this.tableName = tableName;
        this.field = field;
        this.fieldComments = fieldComments;
        this.jdbcType = jdbcType;
        this.dataType = Constant.getKey(jdbcType);
    }


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldComments() {
        return fieldComments ==null?"":fieldComments;
    }

    public void setFieldComments(String fieldComments) {
        this.fieldComments = fieldComments;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
