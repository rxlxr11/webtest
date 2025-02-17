<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/2/17
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="static/js/jquery.js"></script>
<body>
<button onclick="toAddPet()">新增</button>

<select name="queryBreed" id="breedSelect">
    <option value="--请选择--">--请选择--</option>
    <option value="狗">狗</option>
    <option value="猫">猫</option>
    <option value="老鼠">老鼠</option>
</select>

<button onclick="queryByBreed()">查询</button>
<table>
    <tr id="t1">
        <th>宠物昵称</th>
        <th>出生日期</th>
        <th>性别</th>
    </tr>

</table>
</body>
</html>
<script type="text/javascript">

    queryAll()
    function queryAll(){
        $.ajax({
            url: "queryAll",
            type: "get",
            data: "",
            dataType: "json",
            success: function (result){
               var temp="";
               for ( var i in result){
                   temp+=`
                       <tr>
                        <td>\${result[i].petName}</td>
                        <td>\${result[i].birthday}</td>
                        <td>\${result[i].petSex}</td>
                       </tr>
                   `
               }
               $("#t1").siblings().remove()
                $("#t1").after(temp);
            },
            error: function (){}
        })
    }

    function toAddPet(){
        window.location.href="toAddPet"
    }

    function queryByBreed(){
        var breed = $("select[name='queryBreed']").val();
        if (breed == ""|| breed=="--请选择--"){

        }else{
            $.ajax({
                url: "queryByBreed",
                type: "get",
                data: {"breed":breed},
                dataType: "json",
                success: function (result){
                    var temp="";
                    for ( var i in result){
                        temp+=`
                       <tr>
                        <td>\${result[i].petName}</td>
                        <td>\${result[i].birthday}</td>
                        <td>\${result[i].petSex}</td>
                       </tr>
                   `
                    }
                    $("#t1").siblings().remove()
                    $("#t1").after(temp);
                },
                error: function (){}
            })
        }
    }

</script>