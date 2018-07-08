package com.lfxfs.tools.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Table {
    /**
     * 表名
     */
    private String tableName;
    /**
     * 描述
     */
    private String comments;
    /**
     * 字段
     */
    private List<Field> fields = new ArrayList<>();

    public Table() {
    }


    public Table(String tableName, String comments) {
        this.tableName = tableName;
        this.comments = comments;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public void addField(Field field) {
        this.fields.add(field);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Objects.equals(tableName, table.tableName) &&
                Objects.equals(comments, table.comments) &&
                Objects.equals(fields, table.fields);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tableName, comments, fields);
    }
}
