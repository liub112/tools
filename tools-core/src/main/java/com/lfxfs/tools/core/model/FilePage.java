package com.lfxfs.tools.core.model;

import java.io.Serializable;

public class FilePage implements Serializable{

    private static final long serialVersionUID = -3603971923216208051L;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 文件名
     */
    private String fileName;
    /**
     *文件格式
     */
    private String fileFormat;
    /**
     *文件内容
     */
    private StringBuffer fileContent;


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public StringBuffer getFileContent() {
        return fileContent;
    }

    public void setFileContent(StringBuffer fileContent) {
        this.fileContent = fileContent;
    }
}
