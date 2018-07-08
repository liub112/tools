package com.lfxfs.tools.core.generator;

/**
 * 持久层映射枚举类
 * @author think
 */
public enum CRITERIA_ORM_ENUM {
    CRITERIA_ORM_ENUM_METHOD_SAVE("GenerateExampleSaveDao",1,"save"),
    CRITERIA_ORM_ENUM_METHOD_UPDATE("GenerateExampleUpdateDao",2,"update"),
    CRITERIA_ORM_ENUM_METHOD_QUERY("GenerateExampleQueryDao",3,"query");
//    CRITERIA_ORM_ENUM_METHOD_DELETE("GenerateExampleDeleteDao",4,"delete");

    public String fileName;

    public Integer criteriaType;

    public  String methodPrefix;

    CRITERIA_ORM_ENUM(String fileName, Integer criteriaType, String methodPrefix) {
        this.fileName = fileName;
        this.criteriaType = criteriaType;
        this.methodPrefix = methodPrefix;
    }
}
