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
<form action="queryByCondition" id="queryForm">
    <div>
        <span></span>
        <input type="text" name="gameName">
    </div>

    <div>
        <span></span>
        <input type="text" name="gameType">
    </div>

    <div>
        <span></span>
        <input type="text" name="gameCompany">
    </div>

    <div>
        <span></span>
        <input type="text" name="gameYear">
    </div>

</form>

<button onclick="cofirmForm()">查询</button>
<button onclick="toAddGame()">新增</button>


</body>
</html>
<script>
    function confirmForm(){

    }

    function toAddGame(){
        window.location.href="toAddGame"
    }
</script>