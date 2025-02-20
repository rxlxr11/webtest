<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/2/20
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="static/js/jquery.js"></script>
<body>
<form >
    <div>
        <span>项目编号</span>
        <input type="text" name="id" readonly>
    </div>

    <div>
        <span>项目名称</span>
        <input type="text" name="projectName" readonly>
    </div>


    <div>
        <span>申报开始日期</span>
        <input type="text" name="startDate" readonly>
    </div>

    <div>
        <span>申报结束日期</span>
        <input type="text" name="endDate" readonly>
    </div>

    <div>
        <span>申报状态</span>
        <select name="status" id="statusSelect">
            <option value="0">已申报</option>
            <option value="1">审核中</option>
            <option value="2">已审核</option>
        </select>
    </div>
</form>
<button onclick="updateById()">审核</button>
<button onclick="backToPage()">反回</button>
</body>
</html>
<script>

    queryById();
    function updateById(){
        var project={};
        project.id=$("input[name='id']").val();
        project.projectName=$("input[name='projectName']").val();
        project.startDate=$("input[name='startDate']").val();
        project.endDate=$("input[name='endDate']").val();
        project.status=$("select[name='status']").val();
        var projectJson = JSON.stringify(project);
        $.ajax({
            url: "updateById",
            type: "post",
            data: projectJson,
            dataType: "text",
            contentType: "application/json;utf-8",
            success: function (result){
                if (result=="success"){
                    alert("成功")
                    window.location.href="toProjectPage"
                }else {
                    alert("失败")
                }
            },
            error: function (){}
        })
    }

    function queryById(){
        var id =  ${param.id}
        $.ajax({
            url: "queryById",
            type: "get",
            data: {"id":id},
            dataType: "json",
            success: function (result){
                $("input[name='id']").val(result.id);
                $("input[name='projectName']").val(result.projectName);
                $("input[name='startDate']").val(result.startDate);
                $("input[name='endDate']").val(result.endDate);


                if (result.status == 0) {
                    // 已申报，显示所有选项
                    $("#statusSelect").html(`
                    <option value="0">已申报</option>
                    <option value="1">审核中</option>
                    <option value="2">已审核</option>
                `);
                } else if (result.status == 1) {
                    // 审核中，显示审核中和已审核
                    $("#statusSelect").html(`
                    <option value="1">审核中</option>
                    <option value="2">已审核</option>
                `);
                } else if (result.status == 2) {
                    // 已审核，显示已审核
                    $("#statusSelect").html(`
                    <option value="2">已审核</option>
                `);

                    $("select[name='status']").val(result.status);
                }
            },
            error: function (){

            }
        })
    }

    function backToPage(){
        window.location.href="toProjectPage"
    }
</script>
