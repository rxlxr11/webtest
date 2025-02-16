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
</head>
<script src="static/js/jquery.js"></script>
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

</table>

</body>
</html>
<script>
    queryByCondition();

    function queryByCondition(){

        var gameJson = ${sessionScope.gameCondition};
        gameJson = JSON.stringify(gameJson);

        $.ajax({
            url: "queryByCondition",
            type: "post",
            data: gameJson,
            dataType: "json",
            contentType: "application/json;utf-8",
            success: function (){


            },
            error: function (){}

        })

    }
</script>