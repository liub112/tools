package com.lfxfs.tools.core.metaData;

import com.lfxfs.tools.core.DataSource;
import com.lfxfs.tools.core.ExtractTableMetaData;
import com.lfxfs.tools.core.model.Field;
import com.lfxfs.tools.core.model.Table;

import java.util.ArrayList;
import java.util.List;

public class TestExtractTableMetaData implements ExtractTableMetaData{
    @Override
    public List<Table> extractTableMetaData(DataSource dataSource) {
        List<Table> tableLists = new ArrayList<>();
        tableLists.add(tableDataFactory("APP_VERSION","APP版本"));
        tableLists.add(tableDataFactory("CUSTOMER_ORDER","客户订单"));
        tableLists.add(tableDataFactory("ORDER_ITEM","订单项"));
        tableLists.add(tableDataFactory("BO_SERV","功能产品"));
        tableLists.add(tableDataFactory("APPLET_VERSION","APPLET版本"));
        return tableLists;
    }

    public  Table tableDataFactory(String tableName,String tcomments){
        Table table = new Table();
        table.setTableName(tableName);
        table.setComments(tcomments);
        for (int i = 0; i <5 ; i++) {
            Field field = new Field();
            String key ="",dataType="",comments ="";
            switch (i){
                case 0:
                    key = "cust_order_id";
                    dataType ="Long";
                    comments ="主键";
                    break;
                case 1:
                    key = "app_name";
                    dataType ="String";
                    comments ="app名称";
                    break;
                case 2:
                    key = "app_version";
                    dataType ="Date";
                    comments ="app版本";
                    break;
                case 3:
                    key = "create_date";
                    dataType ="Date";
                    comments ="创建时间";
                    break;
                case 4:
                    key = "version_publisher";
                    dataType ="String";
                    comments ="版本发布人";
                    break;
                default:
                    break;
            }
            field.setField(key);
            field.setDataType(dataType);
            field.setFieldComments(comments);
            table.addField(field);
        }
        return table;
    }
}
