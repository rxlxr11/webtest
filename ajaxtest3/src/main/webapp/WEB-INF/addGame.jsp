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
    <input type="text" name="gameName" required>
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

<button onclick="confirmName()">添加</button>
</body>

</html>

<script type="text/javascript">
  async function confirmName(){
    var flag = false;
    var msg = ""
    var gameName = $("input[name='gameName']").val()
    var gameYear = $("input[name='gameYear']").val()
    if (!(/^\d{4}$/.test(gameYear))&&gameYear!=null&&gameYear!=''){
      msg+="年份为4位数字"
      flag = true
    }

    if (gameName==null||gameName=='')
    {
      alert("ceshi2")
      msg+="游戏名为空"
      flag = true
    }else {
      await $.ajax({
        url: "queryByName",
        type: "get",
        data: {"gameName":gameName},
        dataType: "text",
        success: function (result){
          if (result=="no"){
            alert("ceshi 1")
            msg += "游戏名重复";
            flag = true;
          }else {
            alert("测试")
          }
        },
        error: function (){}
      })
    }

    if (!flag){
      addGame()
    }else {
      alert(msg)
    }


  }

  async function addGame(){
    var game={};
    game.gameName = $("input[name='gameName']").val()
    game.gameType = $("input[name='gameType']").val()
    game.gameCompany = $("input[name='gameCompany']").val()
    game.gameYear = $("input[name='gameYear']").val()
    var gameJson = JSON.stringify(game);

    await $.ajax({
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
