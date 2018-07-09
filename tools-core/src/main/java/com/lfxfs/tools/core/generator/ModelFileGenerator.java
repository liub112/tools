package com.lfxfs.tools.core.generator;

import com.lfxfs.tools.core.AbstractFileGenerator;
import com.lfxfs.tools.core.model.Field;
import com.lfxfs.tools.core.model.FilePage;
import com.lfxfs.tools.core.model.Table;
import com.lfxfs.tools.utils.NetWorkUtils;
import com.lfxfs.tools.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModelFileGenerator extends AbstractFileGenerator {
    public static final String DEFAULT_PATH_SUFFIX="model";

    public ModelFileGenerator(String CLASS_ROOT_PATH, String PACKAGE_ROOT_NAME) {
        super(CLASS_ROOT_PATH, PACKAGE_ROOT_NAME);
    }

    /**
     * 注册过滤器组
     */
    @Override
    public void registerConstructionCriteria() {

    }


    @Override
    public List<FilePage> generate() {
        List<FilePage> filePages = new ArrayList<>();
        Random random = new Random();
        for (Table table:tableList) {
            String className = StringUtils.underlineToCamel3(table.getTableName());
            FilePage  filePage = new FilePage();
            StringBuffer sb = new StringBuffer();
            //getClassName
            filePage.setFilePath(CLASS_ROOT_PATH+"\\"+DEFAULT_PATH_SUFFIX);
            filePage.setFileName(className);
            sb.append("package "+PACKAGE_ROOT_NAME+"."+DEFAULT_PATH_SUFFIX+";")
                    .append("\n")
                    .append("\n")
                    .append("import java.io.Serializable;\n")
                    .append("import java.util.Date;\n")
                    .append("\n")
                    .append("/**\n" +
                            " *@author "+ NetWorkUtils.getHostName()+"\n" +
                            " */\n")
                    .append("public class ").append(className).append(" implements Serializable{\n")
                    .append("\t/**\n")
                    .append("\t * serialVersionUID\n" +
                            "\t*/\n")
                    .append("\tprivate static final long serialVersionUID = ")
                    .append(random.nextLong()).append("L;\n");
            for (Field field:table.getFields()) {
                sb.append("\t/**\n" +
                        "\t * "+field.getFieldComments().replaceAll("\\n","\n     *")+"\n" +
                        "\t */\n")
                        .append("\tprivate ")
                        .append(field.getDataType())
                        .append(" ")
                        .append(StringUtils.underlineToCamel(field.getField())+";\n");

            }

            for (Field field:table.getFields()) {
                sb.append("\t/**\n" +
                        "\t * Gets the value of "+ field.getFieldComments().replaceAll("\\n","\n     *") +"\n"+
                        "\t * @return the value of "+ field.getFieldComments().replaceAll("\\n","\n     *") +"\n" +
                        " \t */\n")
                        .append("\tpublic "+ field.getDataType()
                                +" get"+ StringUtils.underlineToCamel3(field.getField()) +"() {\n")
                        .append("\t\treturn "+ StringUtils.underlineToCamel(field.getField()) +";\n")
                        .append("\t}\n")
                        .append("\t/**\n" +
                                "\t * Sets the value of "+ field.getFieldComments().replaceAll("\\n","\n     *") +"        \n" +
                                "\t */\n")
                        .append("\tpublic void set"+ StringUtils.underlineToCamel3(field.getField())
                                +"("+ field.getDataType() +" "+ StringUtils.underlineToCamel(field.getField()) +") {\n")
                        .append(" \t\tthis."+ StringUtils.underlineToCamel(field.getField())
                                +" = "+ StringUtils.underlineToCamel(field.getField()) +";\n")
                        .append("\t}")
                        .append("\n");
            }
            sb.append("}");
            filePage.setFileFormat("java");
            filePage.setFileContent(sb);
            filePages.add(filePage);
        }


        return filePages;
    }


}
