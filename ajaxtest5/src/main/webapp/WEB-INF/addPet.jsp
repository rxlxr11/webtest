<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/2/17
  Time: 15:31
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
        <span></span>
        <input type="text" name="petName" required>
        <span hidden="hidden" id="errMsg">昵称重复</span>
    </div>

    <div>
        <span></span>
        <select name="petBreed" id="breedSelect" required>
            <option value="--请选择--">--请选择--</option>
            <option value="狗">狗</option>
            <option value="猫">猫</option>
            <option value="老鼠">老鼠</option>
        </select>

    </div>

    <div>
        <span>性别</span>
        <label for="male">雄</label>
        <input type="radio" id="male" value="雄" name="petSex" checked>
        <label for="female">雌</label>
        <input type="radio" id="female" value="雌" name="petSex">
    </div>

    <div>
        <span></span>
        <input type="text" name="birthday" required>
    </div>

    <div>
        <span></span>
        <textarea name="petDesc"></textarea>
    </div>
</form>
<button onclick="confirmForm()">增加</button>
</body>
</html>

<script type="text/javascript">

    $("input[name='petName']").change(queryByName)
    var msg='';
    var flag = false;

    function queryByName(){
        var petName=$("input[name='petName']").val();
        $.ajax({
            url: "queryByName",
            type: "get",
            data: {"name":petName},
            dataType: "text",
            success: function (result){
                if (result=="no"){
                    $("#errMsg").prop("hidden",false)
                    msg="昵称重复";
                    flag = true;

                }else {
                    $("#errMsg").prop("hidden",true)
                    msg = "";
                    flag = false;
                }
            },
            error: function (){ alert("网络忙")}
        })
    }

    function confirmForm(){
        var petName=$("input[name='petName']").val();
        var birthday=$("input[name='birthday']").val();
        var petBreed=$("select[name='petBreed']").val();

        if (petName==null||petName==""){
            msg+="昵称为空"
            flag = true
        }

        if (petBreed=="--请选择--"){
            msg+="品种未选择"
            flag = true
        }

        if (birthday==null||birthday==""){
            msg+="日期为空"
            flag = true
        } else if (!/^\d{4}-\d{2}-\d{2}$/.test(birthday)){
            msg+="日期格式为yyyy-MM-dd"
            flag = true
        }

        if (!flag){
            addPet();
        }else {
            alert(msg);
            msg="";
        }
    }

    function addPet(){
        var pet={}

        pet.petName=$("input[name='petName']").val();
        pet.petSex=$("input[name='petSex']").val();
        pet.birthday=$("input[name='birthday']").val();
        pet.petBreed=$("select[name='petBreed']").val();
        pet.desc=$("textarea[name='petDesc']").val();

        var petJson = JSON.stringify(pet);
        $.ajax({
            url: "addPet",
            type: "post",
            data: petJson,
            dataType: "text",
            contentType: "application/json;utf-8",
            success: function (result){
                if (result=="success"){
                    alert("新增成功");
                    window.location.href="toQueryAll"
                }else {
                    alert("新增失败")
                }
            },
            error: function (){}
        })
    }
</script>
