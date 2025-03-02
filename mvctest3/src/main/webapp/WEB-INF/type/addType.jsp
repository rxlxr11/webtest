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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/addPage.css">
<body>
<div>
    <form id="addTypeForm">
        <div>
            <span>名称</span>
            <input type="text" name="typeName">
        </div>

    </form>
</div>

<div>
    <button onclick="confirmForm()">新增</button>
</div>

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
                    window.location.href="${pageContext.request.contextPath}/page/toCommodityList"
                }

            },
            error: function (){
                alert("网络忙")
            }
        })
    }

    function confirmForm(){
        var name = $("input[name='typeName']").val();
        if (name==null||name==''){
            alert("名称为空")
        }else {
            $.ajax({
                url: "${pageContext.request.contextPath}/type/queryByName?name="+name,
                type: "get",
                dataType: "text",
                success: function (result){
                    if (result=="yes"){
                        addType();
                    }else {
                        alert("名称为空或者重复")
                    }

                },
                error: function (){
                    alert("网络忙")
                }
            })
        }

    }
</script>
