package com.njnu.demo1.Dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement statement;

    private ReadProperties properties=ReadProperties.getInstance();
//    String url="jdbc:mysql://localhost:3306/test";
//    String pwd="root";
//    String username="root";

    /**
     * 连接DB
     * @return
     */
    private  Connection getConnection(){
        try{

            Class.forName(properties.driver);
            connection= DriverManager.getConnection(properties.dburl,properties.username,properties.pwd);
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * select * from xxx
     * @param sql
     * @param objects
     * @return
     */
    public  ResultSet query(String sql,Object ...objects){
        if(getConnection()==null){
            return null;
        }
        try {
            statement=connection.prepareStatement(sql);
            if(objects!=null&&objects.length>0){
                int i=1;
                for (Object obj:objects) {
                    statement.setObject(i,obj);
                    i++;
                }
            }
            return statement.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 更新：增删改
     * @param sql
     * @param objects
     * @return
     */
    public int update(String sql,Object ...objects){
        if(getConnection()==null){
            return -1;
        }
        try {
            statement=connection.prepareStatement(sql);
            if (objects != null && objects.length > 0) {
                int i = 1;
                for (Object obj : objects) {
                    statement.setObject(i, obj);
                    i++;
                }
            }
            return statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
     *
     * @param tClass
     * @param sql
     * @param objects
     * @param <T>
     * @return
     */
    public <T> List<T> getListBySql(Class<T> tClass, String sql, Object ...objects){
        ResultSet rs=this.query(sql,objects);
        List<T>list=new ArrayList<>();
        try{
            //getClass() 得到类型；getMethods() 得到方法
            //得到类的属性，即对应数据库中的列名
            Field[] fields=tClass.getDeclaredFields();
            while (rs.next()){
                T t=tClass.newInstance();
                for (int i=0;i<fields.length;i++){
                    Field field=fields[i];
                    //设置可以访问
                    field.setAccessible(true);
                    //拿到列名
                    String fieldName=field.getName();
                    //java数据类型与数据库数据类型映射
                    Object objValue=rs.getObject(fieldName);
                    if(objValue instanceof BigDecimal)
                    {
                        BigDecimal bigDecimal=(BigDecimal)objValue;
                        field.set(t, bigDecimal.intValue());
                    }else {
                        //属性setter（对应的对象，值）
                        field.set(t, objValue);
                    }
                }
                list.add(t);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void closeAll(){
        try {
            if (statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
