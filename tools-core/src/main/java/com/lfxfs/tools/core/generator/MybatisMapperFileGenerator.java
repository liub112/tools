package com.lfxfs.tools.core.generator;

import com.lfxfs.tools.core.AbstractFileGenerator;
import com.lfxfs.tools.core.generator.criteria.mapper.MybatisInsertConstructionCriteria;
import com.lfxfs.tools.core.generator.criteria.mapper.MybatisSelectConstructionCriteria;
import com.lfxfs.tools.core.generator.criteria.mapper.MybatisUpdateConstructionCriteria;
import com.lfxfs.tools.core.model.FilePage;
import com.lfxfs.tools.core.model.Table;
import com.lfxfs.tools.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MybatisMapperFileGenerator extends AbstractFileGenerator {
    public static final String DEFAULT_PATH_SUFFIX="mapper";

    public MybatisMapperFileGenerator(String CLASS_ROOT_PATH, String PACKAGE_ROOT_NAME) {
        super(CLASS_ROOT_PATH, PACKAGE_ROOT_NAME);
    }

    /**
     * 注册过滤器组
     */
    @Override
    public void registerConstructionCriteria() {
        ConstructionCriteria mabatisInsertConstructionCriteria = new MybatisInsertConstructionCriteria();
        ConstructionCriteria mabatisSelectConstructionCriteria = new MybatisSelectConstructionCriteria();
        ConstructionCriteria mabatisUpdateConstructionCriteria = new MybatisUpdateConstructionCriteria();
        addConstructionCriteria(mabatisInsertConstructionCriteria);
        addConstructionCriteria(mabatisSelectConstructionCriteria);
        addConstructionCriteria(mabatisUpdateConstructionCriteria);
    }

    @Override
    public List<FilePage> generate() {
        List<FilePage> filePages = new ArrayList<>();
        for (CRITERIA_ORM_ENUM ENU: CRITERIA_ORM_ENUM.values()) {
            FilePage  filePage = new FilePage();
            StringBuffer sb = new StringBuffer();
            //getClassName
            filePage.setFilePath(CLASS_ROOT_PATH+"\\"+DEFAULT_PATH_SUFFIX);
            filePage.setFileName(ENU.fileName);

            sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><!--Converted at: Sat Apr 27 10:16:15 CST 2013-->\n" +
                    "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \n" +
                    "\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n")
                    .append("<mapper namespace=\""+PACKAGE_ROOT_NAME+"."+MybatisDaoFileGenerator.DEFAULT_PATH_SUFFIX+"."+ENU.fileName+"\">\n")
                    .append("\n");

            for (Table table:tableList) {
                String methodName = ENU.methodPrefix+StringUtils.underlineToCamel3(table.getTableName());
                String parameterType  = PACKAGE_ROOT_NAME+"."+ModelFileGenerator.DEFAULT_PATH_SUFFIX+"."
                        +StringUtils.underlineToCamel3(table.getTableName());
                if(constructionCriterias != null){
                    for (ConstructionCriteria criteria:
                            constructionCriterias) {
                        String unit = criteria.constructionCriteria(table,methodName
                                ,parameterType,ENU);
                        if(unit !=null)
                            sb.append(unit);
                    }
                }
            }
            sb.append("</mapper>");
            filePage.setFileFormat("xml");
            filePage.setFileContent(sb);
            filePages.add(filePage);
        }
        return filePages;
    }


}
