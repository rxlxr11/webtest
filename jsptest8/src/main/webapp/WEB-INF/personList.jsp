<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xinrongli
  Date: 2025/2/19
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
  <tr>
    <th>编号</th>
    <th>姓名</th>
    <th>性别</th>
    <th>年龄</th>
    <th>等级</th>
    <th>部门</th>
    <th>操作</th>
  </tr>

  <c:forEach items="${people}" var="person">
    <tr>
      <td>${person.id}</td>
      <td>${person.name}</td>
      <td>${person.sex}</td>
      <td>${person.age}</td>
      <td>${person.rank}</td>
      <td>${person.department}</td>
      <td><a href="deleteById?id=${person.id}">删除</a></td>

    </tr>
  </c:forEach>
</table>

<a href="toAddPerson">新增</a>
</body>
</html>
