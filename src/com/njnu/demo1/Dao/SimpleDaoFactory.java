package com.njnu.demo1.Dao;

import com.njnu.demo1.Dao.mysql.MySqlCategoryDao;
import com.njnu.demo1.Dao.oracle.OracleCategoryDao;

public class SimpleDaoFactory {
    public static ICategoryDao getDao(){
        ICategoryDao iCategoryDao=null;
        ReadProperties readProperties=ReadProperties.getInstance();
        String type=readProperties.type;
        if(type.equals("mysql")){
            iCategoryDao=new MySqlCategoryDao();
        }else if(type.equals("oracle")){
            iCategoryDao=new OracleCategoryDao();
        }else {


        }
        return iCategoryDao;
    }
}
