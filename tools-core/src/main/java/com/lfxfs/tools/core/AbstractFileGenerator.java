package com.lfxfs.tools.core;

import com.lfxfs.tools.core.generator.ConstructionCriteria;
import com.lfxfs.tools.core.model.FilePage;
import com.lfxfs.tools.core.model.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象类生成器
 * @author think
 */
public abstract class AbstractFileGenerator {
    /**
     *类路径
     */
    protected String CLASS_ROOT_PATH="";
    /**
     *包名
     */
    protected String PACKAGE_ROOT_NAME="";
    /**
     * 表名称
     */
    protected List<Table> tableList = new ArrayList<>();

    protected List<ConstructionCriteria> constructionCriterias = new ArrayList<>();


    public AbstractFileGenerator(String CLASS_ROOT_PATH, String PACKAGE_ROOT_NAME) {
        this.CLASS_ROOT_PATH = CLASS_ROOT_PATH;
        this.PACKAGE_ROOT_NAME = PACKAGE_ROOT_NAME;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }


    protected void addConstructionCriteria(ConstructionCriteria constructionCriteria)  {
        constructionCriterias.add(constructionCriteria);
    }

    /**
     * 注册过滤器组
     */
    public abstract void registerConstructionCriteria();



    /**
     * filePages
     * @return
     */
    public abstract List<FilePage> generate();

    /**
     * 构造文件
     * @return
     */
    public  List<FilePage> constuctFilePage(){
        registerConstructionCriteria();
        return generate();
    }
}
