package com.lfxfs.tools.core.generator.criteria.mapper;

import com.lfxfs.tools.core.generator.CRITERIA_ORM_ENUM;
import com.lfxfs.tools.core.generator.ConstructionCriteria;
import com.lfxfs.tools.core.model.Table;

@Deprecated
public class MybatisDeleteConstructionCriteria implements ConstructionCriteria {
    @Override
    public String constructionCriteria(Table table, String methodName, String parameterType, CRITERIA_ORM_ENUM ENU) {
//        if(ENU!= CRITERIA_ORM_ENUM.CRITERIA_ORM_ENUM_METHOD_DELETE) return null;

        StringBuffer sb = new StringBuffer();

        return null;
    }
}
