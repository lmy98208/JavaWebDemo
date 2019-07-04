package com.njnu.demo1.servlet;

import com.njnu.demo1.Bean.Category;
import com.njnu.demo1.Dao.ICategoryDao;
import com.njnu.demo1.Dao.SimpleDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("你请求的servlet的get方法");
        ICategoryDao dao= SimpleDaoFactory.getDao();
        List<Category> list =dao.findAll();
//        for (Category c:list) {
////            System.out.println("Id:"+c.getId()+"\tCategory:"+c.getCategory()+"\tRemark:"+c.getRemark());
////        }
        request.setAttribute("list",list);
        //跳转页面
        //1.转发 可以携带request参数
        request.getRequestDispatcher("index.jsp").forward(request,response);
        //2.重定向 丢失参数，地址栏发生变化
        //response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
