<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/2/16
  Time: 12:01
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
    <tr id="t1">
        <th>&nbsp;&nbsp;学员编号&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;学员姓名&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;学员性别&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;学员年龄&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;家庭住址&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;Email&nbsp;&nbsp;</th>
        <th>&nbsp;&nbsp;操作&nbsp;&nbsp;</th>
    </tr>
</table>

<script type="text/javascript">
    function queryAll(){

        $.ajax({
            url: "queryAll",
            type: "get",
            data: "",
            dataType: "json",
            success: function (result){

                var temp ="";
                for (var i in result) {
                    temp+=`


                    `
                }

            }

        })
    }
</script>
</body>
</html>
