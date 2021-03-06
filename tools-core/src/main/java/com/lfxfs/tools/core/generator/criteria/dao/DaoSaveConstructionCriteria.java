package com.lfxfs.tools.core.generator.criteria.dao;

import com.lfxfs.tools.core.generator.CRITERIA_ORM_ENUM;
import com.lfxfs.tools.core.generator.ConstructionCriteria;
import com.lfxfs.tools.core.model.Table;
import com.lfxfs.tools.utils.StringUtils;

public class DaoSaveConstructionCriteria implements ConstructionCriteria {
    @Override
    public String constructionCriteria(Table table, String methodName, String parameterType, CRITERIA_ORM_ENUM ENU) {
        if(ENU!= CRITERIA_ORM_ENUM.CRITERIA_ORM_ENUM_METHOD_SAVE) return null;

        StringBuffer sb = new StringBuffer();
        sb.append("\t/**\n" +
                "\t *保存"+table.getComments()+"表\n" +
                "\t */\n")
                .append("\tpublic  void "+methodName+"(" +
                        StringUtils.underlineToCamel3(table.getTableName())+" "+StringUtils.underlineToCamel(table.getTableName())
                        +");\n");
        return sb.toString();
    }
}
