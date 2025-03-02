<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/3/1
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
<body>
<div class="head-container">
    <form id="conditionForm">
        <div>
            <span>名称</span>
            <input type="text" name="commodityName">
        </div>
        <div>
            <span>最低价</span>
            <input type="number" name="minPrice">
        </div>
        <div>
            <span>最高价</span>
            <input type="number" name="maxPrice">
        </div>

        <div>
            <span>类型</span>
            <select name="typeId" id="typeSelect">
                <option value="0">--请选择--</option>
            </select>
        </div>

    </form>
    <button onclick="setCondition()">查询</button>
    <button onclick="ResetCondition()">重置</button>
</div>
<div class="list-container">
    <table>
        <tr id="t1">
            <th>名称</th>
            <th>价格</th>
            <th>数量</th>
            <th>类型</th>
            <th>操作</th>

        </tr>


    </table>
</div>

<div class="footer">
    <div>
        <a href="javascript:;" onclick="queryPage(1)">首页</a>
        <a href="javascript:;" onclick="queryPage(curPage-1<1?1:curPage-1)">上一页</a>
        <a href="javascript:;" onclick="queryPage(curPage+1>totalPage?totalPage:curPage+1)">下一页</a>
        <a href="javascript:;" onclick="queryPage(totalPage)">末页</a>
    </div>

    <div>
        <button onclick="toAddCommodity()">新增商品</button>
        <button onclick="toAddType()">新增种类</button>
    </div>


</div>

</body>
</html>
<script type="text/javascript">
    var curPage=1;
    var totalPage=0;

    queryPage(1);
    getTypes();

    function queryPage(page){
        $.ajax({
            url: "${pageContext.request.contextPath}/commodity/queryPage?curPage="+page,
            type: "get",
            dataType: "json",
            success: function (result){
                curPage = result.curPage;
                totalPage = result.totalPage;
                var commodities = result.commodities;
                var temp = "";
                for (var i in commodities) {
                    temp+=`
                            <tr>
            <td>\${commodities[i].commodityName}</td>
            <td>\${commodities[i].commodityPrice}</td>
            <td>\${commodities[i].commodityCount}</td>
            <td>\${commodities[i].type.typeName}</td>
                        <td><a href="javascript:;" onclick="toUpdateCommodity(\${commodities[i].commodityId})">修改</a>
                <a href="javascript:;" onclick="deleteById(\${commodities[i].commodityId})">删除</a>
            </td>
        </tr>

                    `
                }
                $("#t1").siblings().remove();
                $("#t1").after(temp)

            },
            error: function (){
                alert("网络忙")
            }
        })

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


    function setCondition() {
        var condition = {
            commodityName: $("input[name='commodityName']").val(),
            minPrice: $("input[name='minPrice']").val(),
            maxPrice: $("input[name='maxPrice']").val(),
            typeId: $("#typeSelect").val()
        };

        $.ajax({
            url: "${pageContext.request.contextPath}/page/setCondition",
            type: "post",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(condition),
            success: function () {
                queryPage(1);
            },
            error: function () {
                alert("查询失败");
            }
        });
    }


    function ResetCondition() {
        $("#conditionForm")[0].reset();
        setCondition();
    }

    function deleteById(id) {
        if (confirm("确定要删除该商品")) {
            $.ajax({
                url: "${pageContext.request.contextPath}/commodity/deleteById?id=" + id,
                type: "delete",
                dataType: "text",
                success: function (result) {
                    if (result === "success") {
                        alert("删除成功");
                        queryPage(curPage);
                    } else {
                        alert("删除失败");
                    }
                },
                error: function () {
                    alert("网络忙");
                }
            });
        }
    }

    function toUpdateCommodity(id){
        window.location.href="${pageContext.request.contextPath}/page/toUpdateCommodity?id="+id;
    }

    function toAddCommodity(){
        window.location.href="${pageContext.request.contextPath}/page/toAddCommodity"
    }

    function toAddType(){
        window.location.href="${pageContext.request.contextPath}/page/toAddType"
    }


</script>
