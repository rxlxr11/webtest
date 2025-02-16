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
<link rel="stylesheet" href="static/css/theme.css">
<body>
<p class="title" >学员信息列表</p>

<div class="table-container">
    <table border="1px" cellspacing="0pxSS">
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
</div>




</body>

</html>
<script type="text/javascript">
    queryAll();
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
                        <tr>
                            <td>\${result[i].sId}</td>
                            <td><a href="javascript:;" onclick="toUpdate(\${result[i].sId})">\${result[i].sName}</a></td>
                            <td>\${result[i].sGender}</td>
                            <td>\${result[i].sAge}</td>
                            <td>\${result[i].sAddress}</td>
                            <td>\${result[i].sEmail}</td>
                            <td><a href="javascript:;" onclick="confirmDelete(\${result[i].sId})">删除</a></td>
                        </tr>
                    `
                }
                $("#t1").siblings().remove();
                $("#t1").after(temp);

            },
            error: function (){}

        })
    }

    function confirmDelete(id){
        var flag = confirm("确认删除该学员信息");
        if (flag){
            deleteById(id);
        }
    }

    function deleteById(id){
        $.ajax({
            url: "deleteById",
            type: "get",
            data: {"id": id},
            dataType: "text",
            success: function (result){
                if (result=="success"){
                    alert("删除成功");
                    queryAll();
                }else {
                    alert("删除失败");
                }
            },
            error: function (){
                alert("网络忙...")
            }
        })
    }

    function toUpdate(id){
        window.location.href="toUpdateById?id="+id;
    }
</script>