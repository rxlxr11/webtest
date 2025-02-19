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
        <input type="text" name="businessNo" id="noInput">
        <span id="errMsg" hidden="hidden">重复</span>
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

    var msg = "";
    var flag = false;

    $("#noInput").change(queryByBusinessNo)

    function confirmForm(){
        var name=$("input[name='branchName']").val();
        var businessNo=$("input[name='businessNo']").val();
        var cityArea=$("input[name='cityArea']").val();
        var address=$("input[name='branchAddress']").val();


        if (name==null||name==""){
            msg+="名称为空";
            flag = true;
        }

        if (businessNo==null||businessNo==""){
            msg+="编号为空";
            flag = true;
        }



        if (cityArea==null||cityArea==""){
            msg+="城区为空";
            flag = true;
        }

        if (address==null||address==""){
            msg+="地址为空";
            flag = true;
        }

        if (!flag){
            addBranch();
        }else {
            alert(msg);
            msg="";
        }

    }

    async function addBranch(){

        var branch={}

        branch.name=$("input[name='branchName']").val();
        branch.businessNo=$("input[name='businessNo']").val();
        branch.cityArea=$("input[name='cityArea']").val();
        branch.address=$("input[name='branchAddress']").val();
        branch.branchTelephone=$("input[name='branchTelephone']").val();
        branch.branchSummary=$("textarea[name='branchSummary']").val();
        var branchJson = JSON.stringify(branch);
        await $.ajax({
            url: "addBranch",
            type: "post",
            data: branchJson,
            dataType: "text",
            contentType: "application/json;utf-8",
            success: function (result){
                if (result=="success"){
                    alert("新增成功")
                    window.location.href="toQueryAll"
                }else {
                    alert("新增失败")
                }
            },
            error: function (){}
        })

    }

    async function queryByBusinessNo(){
        var businessNo=$("input[name='businessNo']").val();
        await $.ajax({
            url: "queryByBusinessNo",
            type: "get",
            data: {"businessNo":businessNo},
            dataType: "text",
            success: function (result){
                if (result==0){
                    $("#errMsg").prop("hidden" ,true);
                    msg="";
                    flag = false;
                }else {
                    $("#errMsg").prop("hidden" ,false);
                    msg="重复";
                    flag = true;
                }


            },
            error: function (){

            }
        })

    }
</script>



