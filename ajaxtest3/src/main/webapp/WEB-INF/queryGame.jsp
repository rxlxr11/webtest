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
<script src="static/js/jquery.js"></script>
<body>
<form id="queryForm">
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

<button onclick="confirmForm()">查询</button>
<button onclick="toAddGame()">新增</button>
</body>
</html>

<script type="text/javascript">

  function confirmForm(){
    setCondition();
  }

  function setCondition(){
    var game ={}
    game.gameName=$("input[name='gameName']").val();
    game.gameType=$("input[name='gameType']").val();
    game.gameCompany=$("input[name='gameCompany']").val();
    game.gameYear=$("input[name='gameYear']").val();
    var gameJson = JSON.stringify(game);
    $.ajax({
      url: "setCondition",
      type: "post",
      data: gameJson,
      dataType: "text",
      contentType: "application/json;utf-8",
      success: function (){

          window.location.href="toGameList"


      },
      error: function (){}

    })

  }



  function toAddGame(){
    window.location.href="toAddGame";
  }
</script>
