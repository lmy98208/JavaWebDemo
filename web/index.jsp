<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2019/7/4
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path=request.getContextPath();
  String basePath=request.getScheme()+"://"+request.getServerName()+":"
          +request.getServerPort()+path+"/";
%>
<html>
  <head>
    <title>首页（JSP）</title>
    <link rel="stylesheet" href="<%=basePath%>static/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>static/css/bootstrap-theme.css">
  </head>
  <body>
      <table class="table table-bordered table-striped ">
        <thead>
          <th>ID</th>
          <th>分类名称</th>
          <th>备注</th>
        </thead>
        <c:forEach var="category" items="${list}">
          <tr class="success">
            <%--与方法名有关，与属性名无关--%>
            <td>${category.id}</td>
            <td>${category.category}</td>
            <td>${category.remark}</td>
          </tr>
        </c:forEach>
      </table>
  </body>
</html>
