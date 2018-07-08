package com.lfxfs.tools.core.generator.criteria.mapper;

import com.lfxfs.tools.core.generator.CRITERIA_ORM_ENUM;
import com.lfxfs.tools.core.generator.Constant;
import com.lfxfs.tools.core.generator.ConstructionCriteria;
import com.lfxfs.tools.core.model.Field;
import com.lfxfs.tools.core.model.Table;
import com.lfxfs.tools.utils.StringUtils;

public class MybatisInsertConstructionCriteria implements ConstructionCriteria {
    @Override
    public String constructionCriteria(Table table, String methodName, String parameterType, CRITERIA_ORM_ENUM ENU) {
        if(ENU!= CRITERIA_ORM_ENUM.CRITERIA_ORM_ENUM_METHOD_SAVE) return null;

        StringBuffer sb = new StringBuffer();
        sb.append("  <insert id=\""+methodName
                +"\" parameterType=\""+parameterType+"\">\n")
                .append("    insert into "+table.getTableName()+"(\n")
                .append("        <trim prefixOverrides=\",\">\n");
        for (Field field:table.getFields())  {
            sb.append("           <if test=\""+ StringUtils.underlineToCamel(field.getField())+" != null\">,\n")
                    .append("             "+field.getField().toUpperCase()+"\n")
                    .append("           </if>\n");
        }

        sb.append("        </trim>\n      )\n")
                .append("    values(\n")
                .append("        <trim prefixOverrides=\",\">\n");

        for (Field field:table.getFields())  {
            sb.append("           <if test=\""+StringUtils.underlineToCamel(field.getField())+" != null\">,\n")
                    .append("             #{"+StringUtils.underlineToCamel(field.getField())+",jdbcType="+ Constant.JDBC_TYPE_CONVERSION_TRANSFER.get(field.getDataType())+"}\n")
                    .append("           </if>\n");
        }
        sb.append("        </trim>\n      )\n");
        sb.append("  </insert>\n\n");
        return sb.toString();
    }
}
