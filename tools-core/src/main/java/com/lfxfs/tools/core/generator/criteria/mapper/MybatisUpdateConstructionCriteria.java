package com.lfxfs.tools.core.generator.criteria.mapper;

import com.lfxfs.tools.core.generator.CRITERIA_ORM_ENUM;
import com.lfxfs.tools.core.generator.Constant;
import com.lfxfs.tools.core.generator.ConstructionCriteria;
import com.lfxfs.tools.core.model.Field;
import com.lfxfs.tools.core.model.Table;
import com.lfxfs.tools.utils.StringUtils;

public class MybatisUpdateConstructionCriteria implements ConstructionCriteria {
    @Override
    public String constructionCriteria(Table table, String methodName, String parameterType, CRITERIA_ORM_ENUM ENU) {
        if(ENU!= CRITERIA_ORM_ENUM.CRITERIA_ORM_ENUM_METHOD_UPDATE) return null;

        StringBuffer sb = new StringBuffer();
        sb.append("\t<update id=\""+methodName
                +"\" parameterType=\""+parameterType+"\">\n")
                .append("\t\tupdate "+table.getTableName()+"\n")
                .append("\t\t<set>\n");
        for (Field field:table.getFields())  {
            sb.append("\t\t\t<if test=\""+ StringUtils.underlineToCamel(field.getField())+" != null\">,\n")
                    .append("\t\t\t\t"+field.getField()+"\n")
                    .append("\t\t\t</if>\n");
        }

        sb.append("\t\t</set>\n")
                .append("\t\twhere\n")
                .append("\t\t<trim prefixOverrides=\",\">\n");

        for (Field field:table.getFields())  {
            sb.append("\t\t\t<if test=\""+StringUtils.underlineToCamel(field.getField())+" != null\">,\n")
                    .append("\t\t\t\t#{"+StringUtils.underlineToCamel(field.getField())+",jdbcType="+ Constant.JDBC_TYPE_CONVERSION_TRANSFER.get(field.getDataType())+"}\n")
                    .append("\t\t\t</if>\n");
        }
        sb.append("\t\t</trim>\n");
        sb.append("\t</update>\n\n");
        return sb.toString();
    }
}
