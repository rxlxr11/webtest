<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/3/1
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<body>
<form id="updateCommodityForm">
    <input type="text" name="commodityId" hidden="hidden" readonly>
    <div>
        <span>名称</span>
        <input type="text" name="commodityName">
    </div>

    <div>
        <span>价格</span>
        <input type="number" name="commodityPrice">
    </div>
    <div>
        <span>数量</span>
        <input type="number" name="commodityCount">
    </div>

    <div>
        <span>类型</span>
        <select name="typeId" id="typeSelect">
            <option value="0">--请选择--</option>
        </select>
    </div>



</form>
<button onclick="confirmForm()">修改</button>
</body>
</html>
<script type="text/javascript">
    var id = ${param.id};
    getTypes();
    queryById(id);

    function queryById(id){
        $.ajax({
            url: "${pageContext.request.contextPath}/commodity/queryById?id="+id,
            type: "get",
            dataType: "json",
            success: function (result){

                    $("input[name='commodityId']").val(result.commodityId);
                    $("input[name='commodityName']").val(result.commodityName);
                    $("input[name='commodityPrice']").val(result.commodityPrice);
                    $("input[name='commodityCount']").val(result.commodityCount);
                    $("#typeSelect").val(result.typeId);


            },
            error: function (){
                alert("网络忙")
            }
        })

    }

    function updateCommodity(){
        var data={};
        var array = $("#updateCommodityForm").serializeArray();

        for (let i = 0; i < array.length; i++) {
            data[array[i].name]=array[i].value;
        }

        $.ajax({
            url: "${pageContext.request.contextPath}/commodity/updateById",
            type: "post",
            data: JSON.stringify(data),
            dataType: "text",
            contentType: "application/json;utf-8",
            success: function (result){
                alert(result);
                if (result=="success"){
                    window.location.href="${pageContext.request.contextPath}/page/toCommodityList"
                }

            },
            error: function (){
                alert("网络忙")
            }
        })
    }

    function confirmForm(){
        var name = $("input[name='commodityName']").val();
        if (name==null||name==''){
            alert("名称为空")
        }else {
            updateCommodity();
        }

    }

    function getTypes(){
        $.ajax({
            url: "${pageContext.request.contextPath}/type/queryAll",
            type: "get",
            dataType: "json",
            success: function (result){
                var typeSelect = $("#typeSelect");
                typeSelect.empty(); // 清空旧数据
                typeSelect.append('<option value="">--请选择--</option>');

                $.each(result, function (index, type) {
                    typeSelect.append('<option value="' + type.typeId + '">' + type.typeName + '</option>');
                })

            },
            error: function (){
                alert("网络忙")
            }
        })
    }
</script>
