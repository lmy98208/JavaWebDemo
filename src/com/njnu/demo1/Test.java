package com.njnu.demo1;

import com.njnu.demo1.Bean.Category;
import com.njnu.demo1.Dao.ICategoryDao;
import com.njnu.demo1.Dao.SimpleDaoFactory;

import java.util.List;

public class Test {
    public static void main(String[] args) {
//        CategoryDao categoryDao=new CategoryDao();
//        List<Category> list=categoryDao.findById(2);
//        //List<Category> list=categoryDao.findAll();
//        BookDao bookDao=new BookDao();
//        List<Book> bookList=bookDao.findAll();
        ICategoryDao dao= SimpleDaoFactory.getDao();
        List<Category>list =dao.findAll();
        for (Category c:list) {
            System.out.println("Id:"+c.getId()+"\tCategory:"+c.getCategory()+"\tRemark:"+c.getRemark());
        }
//        for (Book b:bookList){
//            System.out.println("Id:"+b.getAuthor());
//        }
    }
}
