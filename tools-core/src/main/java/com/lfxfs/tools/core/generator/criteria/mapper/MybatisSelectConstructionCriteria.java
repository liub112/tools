package com.lfxfs.tools.core.generator.criteria.mapper;

import com.lfxfs.tools.core.generator.CRITERIA_ORM_ENUM;
import com.lfxfs.tools.core.generator.Constant;
import com.lfxfs.tools.core.generator.ConstructionCriteria;
import com.lfxfs.tools.core.model.Field;
import com.lfxfs.tools.core.model.Table;
import com.lfxfs.tools.utils.StringUtils;

import java.util.List;

public class MybatisSelectConstructionCriteria implements ConstructionCriteria {
    @Override
    public String constructionCriteria(Table table, String methodName, String parameterType, CRITERIA_ORM_ENUM ENU) {
        if(ENU!= CRITERIA_ORM_ENUM.CRITERIA_ORM_ENUM_METHOD_QUERY) return null;

        StringBuffer sb = new StringBuffer();
        sb.append("\t<select id=\""+methodName
                +"\" parameterType=\""+parameterType+"\"\n\t\tresultType=\""+parameterType+"\">\n")
                .append("\t\tselect  ");
        List<Field> fields = table.getFields();
        for (int i = 0; i < fields.size()-1; i++) {
            Field field = fields.get(i);
            sb.append(""+field.getField()+" \""
                    + StringUtils.underlineToCamel(field.getField())+"\",");
            if(i%4==3){
                sb.append("\n\t\t\t");
            }
        }
        sb.append(""+fields.get(fields.size()-1).getField()+" \""
                +StringUtils.underlineToCamel(fields.get(fields.size()-1).getField())+"\"\n");

        sb.append("\t\tfrom "+table.getTableName()+"\n")
                .append("\t\twhere\n")
                .append("\t\t<trim prefixOverrides=\",\">\n");

        for (Field field:table.getFields())  {
            sb.append("\t\t\t<if test=\""+StringUtils.underlineToCamel(field.getField())+" != null\">,\n")
                    .append("\t\t\t\t#{"+StringUtils.underlineToCamel(field.getField())+",jdbcType="+ Constant.JDBC_TYPE_CONVERSION_TRANSFER.get(field.getDataType())+"}\n")
                    .append("\t\t\t </if>\n");
        }
        sb.append("\t\t</trim>\n");
        sb.append("\t</select>\n\n");
        return sb.toString();
    }
}
