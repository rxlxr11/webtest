<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xinrongli
  Date: 2025/2/18
  Time: 10:33
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
    <th>家庭住址</th>
    <th>Email</th>
    <th>操作</th>
  </tr>

  <c:forEach items="${membersInfos}" var="member">
    <tr>
      <td>${member.id}</td>
      <td><a href="toUpdateById?id=${member.id}">${member.mName}</a></td>
      <td>${member.mGender}</td>
      <td>${member.mAge}</td>
      <td>${member.mAddress}</td>
      <td>${member.mEmail}</td>
      <td><a href="deleteById?id=${member.id}">删除</a></td>
    </tr>
  </c:forEach>

</table>

</body>
</html>
