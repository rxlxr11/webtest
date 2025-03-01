<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/2/16
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="static/js/jquery.js"></script>
<body>

<form id="fm">
    <div><input type="text" name="sid" readonly hidden="hidden"></div>
    <div><span>学员姓名：</span><input type="text" name="sname" required></div>
    <div><span>学员性别：</span><input type="text" name="sgender" required></div>
    <div><span>学院年龄：</span><input type="text" name="sage" required></div>
    <div><span>家庭住址：</span><input type="text" name="saddress"></div>
    <div><span>&nbsp;&nbsp;Email&nbsp;&nbsp;&nbsp;：</span><input type="text" name="semail"></div>
</form>

<button onclick="confirmForm()">修改</button>

</body>

</html>

<script type="text/javascript">
    queryById(${param.id});
    function queryById(id){

        $.ajax({
            url: "queryById",
            type: "get",
            data: {"id":id},
            dataType: "json",
            success: function (result){
                $("input[name='sid']").val(result.sid);
                $("input[name='sname']").val(result.sname);
                $("input[name='sgender']").val(result.sgender);
                $("input[name='sage']").val(result.sage);
                $("input[name='saddress']").val(result.saddress);
                $("input[name='semail']").val(result.semail);
            },
            error: function (){}
        })
    }

    function confirmForm(){
        var msg = '';
        var flag = false;
        var sName = $("input[name='sname']").val();
        var sGender = $("input[name='sgender']").val();
        var sAge = $("input[name='sage']").val();

        if (!sName){
            msg+= " 学员姓名为空 ";
            flag = true;
        }

        if (!sGender){
            msg+= " 学员性别为空 ";
            flag = true;
        }

        if (!sAge){
            msg+= " 学员年龄为空 ";
            flag = true;
        }

        if (!flag){
            msg = "提交成功"
        }

        alert(msg);

        if (!flag){
            updateById();
        }


    }

    function updateById(){


        var  array=$("#fm").serializeArray();
        var data={};
        for(var i = 0;i<array.length;i++){
            data[array[i].name]=array[i].value;
        }

        var stuJson = JSON.stringify(data);
        $.ajax({
            url: "${pageContext.request.contextPath}/updateById",
            type: "post",
            data: stuJson,
            dataType: "text",
            contentType: "application/json;utf-8",
            success: function (result){
                if (result=="success"){
                    alert("修改成功")
                    window.location.href="${pageContext.request.contextPath}/toStudentList";
                }else {
                    alert("修改失败")
                }
            },
            error: function (){
                alert("网络忙...")
            }

        })

    }

</script>