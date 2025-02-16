<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/2/16
  Time: 16:24
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
        <th>游戏列表</th>
    </tr>

    <tr>
        <th>&nbsp;&nbsp;游戏名称&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;游戏类别&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;发行公司&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;发行年份&nbsp;&nbsp;</th>
    </tr>

    <c:forEach items="${games}" var="game">

        <tr>
            <td>${game.gameName}</td>
            <td>${game.gameType}</td>
            <td>${game.gameCompany}</td>
            <td>${game.gameYear}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
