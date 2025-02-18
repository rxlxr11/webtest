<%--
  Created by IntelliJ IDEA.
  User: xinrongli
  Date: 2025/2/18
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="static/js/jquery.js"></script>
<body>
<form action="updateById" id="updateForm">
    <input type="text" name="id" value="${member.id}" hidden="hidden" readonly="readonly">
    <div>
        <span></span>
        <input type="text" name="mName" value="${member.mName}">
    </div>

    <div>
        <span></span>
        <div>
            <span></span>
            <label for="male">男</label>
            <input type="radio" name="mGender" value="男" id="male" ${member.mGender == '男' ? 'checked' : ''}>
            <label for="female">女</label>
            <input type="radio" name="mGender" value="女" id="female" ${member.mGender == '女' ? 'checked' : ''}>
        </div>
    </div>

    <div>
        <span></span>
        <input type="text" name="mAge" value="${member.mAge}">
    </div>

    <div>
        <span></span>
        <input type="text" name="mAddress" value="${member.mAddress}">
    </div>

    <div>
        <span></span>
        <input type="text" name="mEmail" value="${member.mEmail}">
    </div>
</form>
<button onclick="confirmForm()">修改</button>
<button onclick="resetForm()">重置</button>
</body>
</html>

<script type="text/javascript">
    function confirmForm() {
        var flag = false;
        var msg = "";

        var name = $("input[name='mName']").val();
        var age = $("input[name='mAge']").val();

        if (name==null||name==""){
            msg+="姓名为空";
            flag = true;
        }

        if (age=null||age==""){
            msg+="年龄为空";
            flag = true;
        }

        if (!flag){
            $("#updateForm").submit();
        }else {
            alert(msg)
        }

    }

    function resetForm() {
        $("input[name='mName']").val("");
        $("input[name='mGender']").val("");
        $("input[name='mAge']").val("");
        $("input[name='mAddress']").val("");
        $("input[name='mEmail']").val("");
    }

</script>
