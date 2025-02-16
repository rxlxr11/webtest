<%--
  Created by IntelliJ IDEA.
  User: xinrongli
  Date: 2025/2/16
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="addGameForm">
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

<button onclick="addGame()">添加</button>
</body>

</html>
