<%--
  Created by IntelliJ IDEA.
  User: xinrongli
  Date: 2025/2/16
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="static/css/theme.css">
</head>
<script src="static/js/jquery.js"></script>
<body>
<button onclick="toQueryByCondition()">返回</button>
<table border="1px" >
    <tr>
        <th>游戏列表</th>
    </tr>

    <tr id="t1">
        <th>&nbsp;&nbsp;游戏名称&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;游戏类别&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;发行公司&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;发行年份&nbsp;&nbsp;</th>
    </tr>



</table>

</body>
</html>
<script>
    queryByCondition();

    async function queryByCondition(){

        var gameJson = ${sessionScope.gameCondition}
        gameJson = JSON.stringify(gameJson);
        console.log(gameJson)

        await $.ajax({
            url: "queryByCondition",
            type: "post",
            data: gameJson,
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success: function (result){
                if (result.length==0){
                    alert("没有查询到")
                }else {
                    var temp ="";
                    for ( var i in result){
                        temp+=`
                    <tr>
                        <td>\${result[i].gameName}</td>
                        <td>\${result[i].gameType}</td>
                        <td>\${result[i].gameCompany}</td>
                        <td>\${result[i].gameYear}</td>
                    </tr>

                    `
                    }
                    $("#t1").siblings().remove();
                    $("#t1").after(temp);

                }


            },
            error: function (){
                alert("网络忙")
            }

        })

        gameJson = "{'gameName':'','gameType':'','gameCompany':'','gameYear':''}"
        console.log(gameJson)
        setCondition(gameJson)
    }

    async function setCondition(gameJson) {

        var game = {}
        game.gameName = $("input[name='gameName']").val();
        game.gameType = $("input[name='gameType']").val();
        game.gameCompany = $("input[name='gameCompany']").val();
        game.gameYear = $("input[name='gameYear']").val();
        gameJson = JSON.stringify(game);

        await $.ajax({
            url: "setCondition",
            type: "post",
            data: gameJson,
            dataType: "text",
            contentType: "application/json;utf-8",
            success: function () {
                if (window.location.href!="http://localhost:8080/ajaxtest3_war_exploded/toGameList"){
                    window.location.href = "toGameList"
                }

            },
            error: function () {
            }

        })
    }

    function toQueryByCondition(){
        window.location.href="toQueryByCondition"
    }
</script>