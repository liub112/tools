package com.lfxfs.tools.core.generator;

import com.lfxfs.tools.core.AbstractFileGenerator;
import com.lfxfs.tools.core.generator.criteria.dao.DaoQueryConstructionCriteria;
import com.lfxfs.tools.core.generator.criteria.dao.DaoSaveConstructionCriteria;
import com.lfxfs.tools.core.generator.criteria.dao.DaoUpdateConstructionCriteria;
import com.lfxfs.tools.core.model.FilePage;
import com.lfxfs.tools.core.model.Table;
import com.lfxfs.tools.utils.NetWorkUtils;
import com.lfxfs.tools.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MybatisDaoFileGenerator extends AbstractFileGenerator {
    public static final String DEFAULT_PATH_SUFFIX="dao";

    public MybatisDaoFileGenerator(String CLASS_ROOT_PATH, String PACKAGE_ROOT_NAME) {
        super(CLASS_ROOT_PATH, PACKAGE_ROOT_NAME);
    }

    /**
     * 注册过滤器组
     */
    @Override
    public void registerConstructionCriteria() {
        ConstructionCriteria daoQueryConstructionCriteria = new DaoQueryConstructionCriteria();
        ConstructionCriteria daoSaveConstructionCriteria = new DaoSaveConstructionCriteria();
        ConstructionCriteria daoUpdateConstructionCriteria = new DaoUpdateConstructionCriteria();
        addConstructionCriteria(daoQueryConstructionCriteria);
        addConstructionCriteria(daoSaveConstructionCriteria);
        addConstructionCriteria(daoUpdateConstructionCriteria);
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

            sb.append("package "+PACKAGE_ROOT_NAME+"."+MybatisDaoFileGenerator.DEFAULT_PATH_SUFFIX+";")
                    .append("\n")
                    .append("\n")
                    .append("import org.springframework.stereotype.Repository;\n");

            for (Table table:tableList) {
                sb.append("import "+PACKAGE_ROOT_NAME+"."+ModelFileGenerator.DEFAULT_PATH_SUFFIX+"."+StringUtils.underlineToCamel3(table.getTableName())+";\n");
            }

            sb.append("\n")
                    .append("/**\n" +
                            " *@author "+ NetWorkUtils.getHostName()+"\n" +
                            " */\n")
                    .append("@Repository\n")
                    .append("public interface ").append(ENU.fileName).append("{\n");

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
            sb.append("}");
            filePage.setFileFormat("java");
            filePage.setFileContent(sb);
            filePages.add(filePage);
        }
        return filePages;
    }


}
