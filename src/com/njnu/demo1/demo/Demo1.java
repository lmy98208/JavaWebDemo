package com.njnu.demo1.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo1 {
    public static void main(String[] args) {

        Statement statement=null;
        Connection connection=null;
        ResultSet resultSet=null;
        try{

            String sql="select * from category";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("remark"));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("JDBC Driver not found");
        }finally {
            try {
                connection.close();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
