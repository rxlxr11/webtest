<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/2/17
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="static/css/theme.css">
</head>
<script src="static/js/jquery.js"></script>
<body>
<form action="addFlower" id="addFlowerForm">
    <div>
        <span>鲜花名称</span>
        <input type="text" name="flowerName" required="required">
    </div>

    <div>
        <span>鲜花别名</span>
        <input type="text" name="flowerNickName" required="required">
    </div>

    <div>
        <span>鲜花科属</span>
        <input type="text" name="flowerProperty" required="required">
    </div>

    <div>
        <span>鲜花价格</span>
        <input type="text" name="flowerPrice" required="required">
    </div>
    <div>
        <span>鲜花产地</span>
        <input type="text" name="flowerProduction" required="required">
    </div>

</form>

<button onclick="submitForm()">添加</button>
<button onclick="resetForm()">重置</button>
</body>

<script type="text/javascript">
    var allowIf;
    allowIf = "${requestScope.allowIf}";
    if (allowIf!=null&&allowIf!=""){
        if (allowIf=="no"){
            alert("名称重复")
        }
    }
    function submitForm(){
        var msg='';
        var flag = false;


        var flowerName = $("input[name='flowerName']").val();
        var flowerNickName = $("input[name='flowerNickName']").val();
        var flowerProperty = $("input[name='flowerProperty']").val();
        var flowerPrice = $("input[name='flowerPrice']").val();
        var flowerProduction = $("input[name='flowerProduction']").val();

        if (flowerName==null||flowerName==""){
            msg+="名称为空";
            flag = true;
        }

        if (flowerNickName==null||flowerNickName==""){
            msg+="别名为空";
            flag = true;
        }

        if (flowerProperty==null||flowerProperty==""){
            msg+="科属为空";
            flag = true;
        }

        if (flowerPrice==null||flowerPrice==""){
            msg+="价格为空";
            flag = true;
        }

        if (flowerProduction==null||flowerProduction==""){
            msg+="产地为空";
            flag = true;
        }

        if (!flag){
            $("#addFlowerForm").submit();

        }else {
            alert(msg)
        }


    }

    function resetForm(){
        $("input[name='flowerName']").val("");
        $("input[name='flowerNickName']").val("");
        $("input[name='flowerProperty']").val("");
        $("input[name='flowerPrice']").val("");
        $("input[name='flowerProduction']").val("");
    }



</script>
</html>
