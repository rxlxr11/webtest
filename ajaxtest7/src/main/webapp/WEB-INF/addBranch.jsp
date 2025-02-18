<%--
  Created by IntelliJ IDEA.
  User: xinrongli
  Date: 2025/2/18
  Time: 18:39
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
    <div>
        <span>网点名称</span>
        <input type="text" name="branchName">
    </div>

    <div>
        <span>营业执照</span>
        <input type="text" name="businessNo">
    </div>

    <div>
        <span>所在城区</span>
        <input type="text" name="cityArea">
    </div>

    <div>
        <span>网店地址</span>
        <input type="text" name="branchAddress">
    </div>

    <div>
        <span>联系电话</span>
        <input type="text" name="branchTelephone">
    </div>

    <div>
        <span>网点简介</span>
        <textarea name="branchSummary"></textarea>
    </div>

</form>
<button onclick="confirmForm()">添加</button>
</body>
</html>
<script type="text/javascript">
    function confirmForm(){
        addBranch();
    }

    function addBranch(){

        var branch={}

        branch.name=$("input[name='branchName']").val();
        branch.businessNo=$("input[name='businessNo']").val();
        branch.cityArea=$("input[name='cityArea']").val();
        branch.address=$("input[name='branchAddress']").val();
        branch.branchTelephone=$("input[name='branchTelephone']").val();
        branch.branchSummary=$("textarea[name='branchSummary']").val();
        var branchJson = JSON.stringify(branch);
        $.ajax({
            url: "addBranch",
            type: "post",
            data: branchJson,
            dataType: "text",
            contentType: "application/json;utf-8",
            success: function (result){
                alert(result)
            },
            error: function (){}
        })

    }

    function queryByBusinessNo(){
        $.ajax({
            url: "queryByBusinessName",
            type: "get",
            data: {"businessNo":businessNo},
            dataType: "text",
            success: function (result){

            },
            error: function (){}
        })

    }
</script>



