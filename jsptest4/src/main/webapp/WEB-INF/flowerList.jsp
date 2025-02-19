<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/2/17
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="static/css/theme.css">
</head>
<body>
<a href="toAddFlower">新增</a>
<table border="1px">
    <tr>
        <th>花卉编号</th>
        <th>花卉名称</th>
        <th>别名</th>
        <th>科属</th>
        <th>价格(元/支)</th>
        <th>原产地</th>
    </tr>

    <c:forEach items="${flowers}" var="flower">
        <tr>
            <td>${flower.id}</td>
            <td>${flower.name}</td>
            <td>${flower.nickName}</td>
            <td>${flower.property}</td>
            <td>${flower.price}</td>
            <td>${flower.production}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
