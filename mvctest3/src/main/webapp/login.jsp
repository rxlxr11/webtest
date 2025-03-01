<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/3/1
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<body>

<form id="loginForm">
    <div>
        <span>username</span>
        <input type="text" name="userName">
    </div>

    <div>
        <span>password</span>
        <input type="password" name="password">
    </div>

</form>

<button onclick="login()">login</button>

</body>
</html>
<script type="text/javascript">

    function login(){
        var data={};
        var array = $("#loginForm").serializeArray();

        for (let i = 0; i < array.length; i++) {
            data[array[i].name]=array[i].value;
        }

        $.ajax({
            url:"login",
            type: "post",
            data: JSON.stringify(data),
            dataType: "text",
            contentType: "application/json;utf-8",
            success: function (result){
                alert(result);
                if (result=="success"){
                    window.location.href="${pageContext.request.contextPath}/page/toCommodityList";

                }
            },
            error: function (){
                alert("网络忙")
            }
        })

    }
</script>
