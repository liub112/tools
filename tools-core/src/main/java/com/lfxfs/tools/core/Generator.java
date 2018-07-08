package com.lfxfs.tools.core;

import com.lfxfs.tools.core.generator.ModelFileGenerator;
import com.lfxfs.tools.core.metaData.MySqlExtractTableMetaData;
import com.lfxfs.tools.core.metaData.OracleExtractTableMetaData;
import com.lfxfs.tools.core.metaData.TestExtractTableMetaData;
import com.lfxfs.tools.core.model.FilePage;
import com.lfxfs.tools.core.model.Table;
import com.lfxfs.tools.utils.StringUtils;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 逆向model生成器
 */
public class Generator {
    /**
     * 数据源
     */
    private DataSource dataSource;
    /**
     * 抽取表元数据接口
     */
    private ExtractTableMetaData extractTableMetaDate;
    /**
     * 类生成器
     */
    private List<AbstractFileGenerator> fileGenerators;

    public Generator() throws IllegalAccessException, InstantiationException
            , ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        fileGenerators = new ArrayList<>();
        Properties properties= loadProperties();
        registerDataSource(properties);
        registerExtractTableMetaDate();
        registerFileGenerators(properties);
    }

    /**
     * 加载配置文件
     */
    public Properties loadProperties(){
        Properties properties=new Properties();
        try{
            InputStream is=ClassLoader.getSystemResourceAsStream("tool.properties");
            properties.load(is);

            System.out.println(properties);
        }catch (IOException e){
            e.printStackTrace();
        }
        return  properties;
    }
    /**
     *注册数据源
     */
    public void registerDataSource(Properties properties){
        if(properties==null)return;
        dataSource = new DataSource(properties);
    }
    /**
     *注册抽取表模型接口
     */
    public void registerExtractTableMetaDate(){
        if(dataSource.pullDataSourceType()=="mysql"){
            extractTableMetaDate = new MySqlExtractTableMetaData();
        }else if(dataSource.pullDataSourceType()=="oracle"){
            extractTableMetaDate = new OracleExtractTableMetaData();
        }else{
            extractTableMetaDate = new TestExtractTableMetaData();
        }
    }

    /**
     *注册类生成器
     */
    public void registerFileGenerators(Properties properties) throws ClassNotFoundException
            , IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String beanStr = properties.getProperty("tool.beans.file.generator.register");
        String rootPath = properties.getProperty("tool.beans.file.generator.rootPath");
        String rootPackage = properties.getProperty("tool.beans.file.generator.rootPackage");
        if(!StringUtils.isNotBank(rootPath)){
            throw new RuntimeException("tool.beans.file.generator.rootPath is null!");
        }
        if(!StringUtils.isNotBank(rootPackage)){
            throw new RuntimeException("tool.beans.file.generator.rootPackage is null!");

        }
        File rootDir = new File(rootPath);
        if(!rootDir.isDirectory()){
            throw new RuntimeException(rootPath+"is not a directory!");
        }
        if(!StringUtils.isNotBank(beanStr)){
            fileGenerators.add(new ModelFileGenerator(rootPath,rootPackage));
            return;
        }
        String[] beans = beanStr.split(",");
        for (int i = 0; i < beans.length; i++) {
            Class clz = Class.forName(beans[i]);
            Constructor constructor = clz.getConstructor(String.class, String.class);

            AbstractFileGenerator fileGenerator = (AbstractFileGenerator)constructor.newInstance(rootPath,
                    rootPackage);
            fileGenerators.add(fileGenerator);
        }

    }
    /**
     *获取表数据
     */
    public List<Table> obtainTableMetaData(){
        return extractTableMetaDate.extractTableMetaData(dataSource);
    }
    /**
     *生成文件页
     */
    public List<FilePage> generatorFilePages(List<Table> tables) {
        List<FilePage> filePages = new ArrayList<>();
        for (AbstractFileGenerator fileGenerator:fileGenerators){
            fileGenerator.setTableList(tables);
            filePages.addAll(fileGenerator.constuctFilePage());
        }
        return filePages;
    }

    /**
     *输出目标文件
     */
    public void output(){
        //抽取元数据
        List<Table> tables = obtainTableMetaData();
        //生成文件tab页
        List<FilePage> filePages = generatorFilePages(tables);
        for (int i = 0; i < filePages.size(); i++) {
            output(filePages.get(i));
        }
    }

    private void output(FilePage filePage){
        BufferedWriter writer=null;
        try{
            /**
             * create file directory
             */
            File dir = new File(filePage.getFilePath());
            if (!dir.exists()){
                dir.mkdir();
            }

            //create File
            String classStr  = dir.getPath()+"\\"+filePage.getFileName()+"."+filePage.getFileFormat();
            File f = new File(classStr);
            //if not exists,Then create
            if(!f.exists()){
                f.createNewFile();
            }

            /**
             *Instantiation Instantiation a StringBuffer in order to handle
             * Generic class data
             */
            writer=new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(f), "UTF-8"));
            writer.write(filePage.getFileContent().toString());
            writer.close();
            System.out.println("File["+classStr+"] is created.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
