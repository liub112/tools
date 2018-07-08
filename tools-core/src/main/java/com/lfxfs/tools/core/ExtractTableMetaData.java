package com.lfxfs.tools.core;

import com.lfxfs.tools.core.model.Table;

import java.util.List;

/**
 *抽取表模型接口
 * @author think
 */
public interface ExtractTableMetaData {
    public List<Table> extractTableMetaData(DataSource dataSource);

}
