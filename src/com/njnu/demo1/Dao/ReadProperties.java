package com.njnu.demo1.Dao;

import java.util.Properties;

/**
 * 读文件耗费资源——单例模式
 */
public class ReadProperties {
    //静态对象，默认null
    private static ReadProperties readProperties;
    public String dburl="";
    public String username="";
    public String pwd="";
    public String driver="";
    public String type="";

    private ReadProperties(){readFile();}
    public static ReadProperties getInstance(){
        if(readProperties==null){
            readProperties=new ReadProperties();
        }
        return readProperties;
    }
    private void readFile(){
        Properties properties=new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/com/njnu/demo1/db.properties"));
            dburl=properties.getProperty("jdbc.url");
            username=properties.getProperty("jdbc.username");
            pwd=properties.getProperty("jdbc.password");
            driver=properties.getProperty("jdbc.driver");
            type=properties.getProperty("jdbc.type");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
