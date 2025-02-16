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

<form>
    <div><input type="text" name="sId" readonly hidden="hidden"></div>
    <div><span>学员姓名：</span><input type="text" name="sName" required></div>
    <div><span>学员性别：</span><input type="text" name="sGender" required></div>
    <div><span>学院年龄：</span><input type="text" name="sAge" required></div>
    <div><span>家庭住址：</span><input type="text" name="sAddress"></div>
    <div><span>&nbsp;&nbsp;Email&nbsp;&nbsp;&nbsp;：</span><input type="text" name="sEmail"></div>
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
                $("input[name='sId']").val(result.sId);
                $("input[name='sName']").val(result.sName);
                $("input[name='sGender']").val(result.sGender);
                $("input[name='sAge']").val(result.sAge);
                $("input[name='sAddress']").val(result.sAddress);
                $("input[name='sEmail']").val(result.sEmail);
            },
            error: function (){}
        })
    }

    function confirmForm(){
        var msg = '';
        var flag = false;
        var sName = $("input[name='sName']").val();
        var sGender = $("input[name='sGender']").val();
        var sAge = $("input[name='sAge']").val();

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
        var stu ={};

        stu.sId = $("input[name='sId']").val();
        stu.sName = $("input[name='sName']").val();
        stu.sGender = $("input[name='sGender']").val();
        stu.sAge = $("input[name='sAge']").val();
        stu.sAddress = $("input[name='sAddress']").val();
        stu.sEmail = $("input[name='sEmail']").val();

        var stuJson = JSON.stringify(stu);
        $.ajax({
            url: "updateById",
            type: "post",
            data: stuJson,
            dataType: "text",
            contentType: "application/json;utf-8",
            success: function (result){
                if (result=="success"){
                    alert("修改成功")
                    window.location.href="toQueryAll";
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