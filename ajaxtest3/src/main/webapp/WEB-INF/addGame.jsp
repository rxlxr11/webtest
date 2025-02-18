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
<form id="addGameForm">
  <div>
    <span></span>
    <input type="text" name="gameName" id="nameInput" required>
    <span id="errMsg" hidden="hidden">游戏名重复</span>
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

<button onclick="confirmForm()">添加</button>
</body>

</html>

<script type="text/javascript">

  $("#nameInput").change(queryByName);
  var flag = false
  var msg=""

  function queryByName(){
    var gameName = $("input[name='gameName']").val()
    $.ajax({
      url: "queryByName",
      type: "get",
      data: {"gameName":gameName},
      dataType: "text",
      success: function (result){
        if (result=="no"){
          $("#errMsg").prop("hidden", false);
          msg+="游戏名重复"
          flag = true
        }else {
          $("#errMsg").prop("hidden", true);
          msg=""
          flag = false
        }
      },
      error: function (){}
    })
  }

  function confirmForm(){

    var gameName = $("input[name='gameName']").val()
    var gameYear = $("input[name='gameYear']").val()

    if (gameYear==null||gameYear==''){
      msg+="年份为空"
      flag = true
    }else if (!(/^\d{4}$/.test(gameYear))){
      msg+="年份为4位数字"
      flag = true
    }


    if (gameName==null||gameName=='')
    {
      msg+="游戏名为空"
      flag = true
    }

    if (!flag){
      addGame()
    }else {
      alert(msg)
      msg = ""
    }

  }

  function addGame(){
    var game={};
    game.gameName = $("input[name='gameName']").val()
    game.gameType = $("input[name='gameType']").val()
    game.gameCompany = $("input[name='gameCompany']").val()
    game.gameYear = $("input[name='gameYear']").val()
    var gameJson = JSON.stringify(game);

    $.ajax({
      url: "addGame",
      type: "post",
      data: gameJson,
      dataType: "text",
      contentType: "application/json;utf-8",
      success: function (result){
        if (result=="success"){
          alert("新增成功")
          window.location.href="toGameList"
        }else {
          alert("新增失败")
        }
      },
      error: function (){
        alert("网络忙")
      }
    })

  }
</script>
