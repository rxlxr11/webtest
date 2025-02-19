<%--
  Created by IntelliJ IDEA.
  User: xinrongli
  Date: 2025/2/18
  Time: 18:30
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
<button onclick="backToList()">返回</button>

</body>
</html>
<script type="text/javascript">
    var id = ${param.id};
    queryById(id);

    function queryById(id){
        $.ajax({
            url: "queryById",
            type: "get",
            data: {"id":id},
            dataType: "json",
            success: function (result){
                $("input[name='branchName']").val(result.name);
                $("input[name='businessNo']").val(result.businessNo);
                $("input[name='cityArea']").val(result.cityArea);
                $("input[name='branchAddress']").val(result.address);
                $("input[name='branchTelephone']").val(result.branchTelephone);
                $("textarea[name='branchSummary']").val(result.branchSummary);

            },
            error: function (){}
        })
    }

    function backToList(){
        window.location.href="toQueryAll"
    }



</script>