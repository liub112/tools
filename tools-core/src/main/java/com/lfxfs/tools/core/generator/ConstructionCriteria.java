package com.lfxfs.tools.core.generator;

import com.lfxfs.tools.core.model.Table;

public interface ConstructionCriteria {


    String constructionCriteria(Table table, String methodName, String parameterType
            , CRITERIA_ORM_ENUM ENU);

}
