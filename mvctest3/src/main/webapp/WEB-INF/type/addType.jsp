<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/3/1
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<body>
<form id="addTypeForm">
    <div>
        <input type="text" name="typeName">
    </div>

</form>
<button onclick="addType()">新增</button>
</body>
</html>
<script type="text/javascript">
    function addType(){
        var data={};
        var array = $("#addTypeForm").serializeArray();

        for (let i = 0; i < array.length; i++) {
            data[array[i].name]=array[i].value;
        }

        $.ajax({
            url: "${pageContext.request.contextPath}/type/addType",
            type: "post",
            data: JSON.stringify(data),
            dataType: "text",
            contentType: "application/json;utf-8",
            success: function (result){
                alert(result);
                if (result=="success"){
                    window.location.href
                }

            },
            error: function (){
                alert("网络忙")
            }
        })
    }
</script>
