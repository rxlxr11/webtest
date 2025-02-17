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

    function confirmForm(){
        var msg='';
        var flag = false;

        var petName=$("input[name='petName']").val();
        var petSex=$("input[name='petSex']").val();
        var birthday=$("input[name='birthday']").val();
        var petBreed=$("select[name='petBreed']").val();

        if (){

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
                    window.location.href="queryAll"
                }else {
                    alert("新增失败")
                }
            },
            error: function (){}
        })
    }
</script>
