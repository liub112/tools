package com.lfxfs.tools.core.generator.criteria.dao;

import com.lfxfs.tools.core.generator.CRITERIA_ORM_ENUM;
import com.lfxfs.tools.core.generator.ConstructionCriteria;
import com.lfxfs.tools.core.model.Table;
import com.lfxfs.tools.utils.StringUtils;

@Deprecated
public class DaoDeleteConstructionCriteria implements ConstructionCriteria {
    @Override
    public String constructionCriteria(Table table, String methodName, String parameterType, CRITERIA_ORM_ENUM ENU) {
//        if(ENU!= CRITERIA_ORM_ENUM.CRITERIA_ORM_ENUM_METHOD_DELETE) return null;
        StringBuffer sb = new StringBuffer();
        sb.append("    /**\n" +
                "     *删除"+table.getComments()+"表数据\n" +
                "     */\n")
                .append("    public  void"+methodName+"(" +
                        StringUtils.underlineToCamel3(table.getTableName())+" "+StringUtils.underlineToCamel(table.getTableName())
                        +");\n")
                .append(" ");
        return sb.toString();
    }
}
