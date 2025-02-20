<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/2/20
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="static/js/jquery.js"></script>
<body>

<select name="queryStatus" id="statusSelect">
    <option value="-1">全部</option>
    <option value="0">已申报</option>
    <option value="1">审核中</option>
    <option value="2">已审核</option>
</select>

<button onclick="queryByStatus(1)">查询</button>
<table border="1px">
    <tr id="t1">
        <th>项目编号</th>
        <th>项目名称</th>
        <th>申报开始日期</th>
        <th>申报结束日期</th>
        <th>申报状态</th>
        <th>操作</th>
    </tr>





</table>

<a href="javascript:;" onclick="queryPage(1)">首页</a>
<a href="javascript:;" onclick="queryPage(currentPage-1<1?1:currentPage-1)">上一页</a>
<a href="javascript:;" onclick="queryPage(currentPage+1>totalPage?totalPage:currentPage+1)">下一页</a>
<a href="javascript:;" onclick="queryPage(totalPage)">末页</a>
<div>
    <span id="curPageDisplay">第</span>
</div>

<div>
    <span id="totalPageDisplay">共</span>
</div>




</body>
</html>
<script>

    var currentPage = 1;
    var totalPage = 0;
    var currentStatus = -1;

    $("#statusSelect").change(statusChange);

    queryPage(1);
    function queryPage(curPage){

        if (currentStatus != -1) {
            queryByStatus(curPage); // 根据status进行查询
        } else{
            $.ajax({
                url: "queryPage",
                type: "get",
                data: {"curPage":curPage,"status": currentStatus},
                dataType: "json",
                success: function (result){
                    totalPage = result.totalPage;
                    currentPage = result.curPage;
                    console.log("aa",totalPage,currentPage)
                    var temp = ""
                    for (var i in result.projectInfos) {
                        var statusStr = toStr(result.projectInfos[i].status);
                        var auditLink = "";


                        if (statusStr !== "已审核") {
                            auditLink = `<a href="javascript:;" onclick="toCheckProject(\${result.projectInfos[i].id})">审核</a>`;
                        }

                        temp += `
                    <tr>
                        <td>\${result.projectInfos[i].id}</td>
                        <td>\${result.projectInfos[i].projectName}</td>
                        <td>\${result.projectInfos[i].startDate}</td>
                        <td>\${result.projectInfos[i].endDate}</td>
                        <td>\${statusStr}</td>
                        <td>\${auditLink}</td>
                    </tr>
                `;
                    }
                    $("#t1").siblings().remove();
                    $("#t1").after(temp);

                    $("#curPageDisplay").siblings().remove();
                    $("#curPageDisplay").after("<span>" + currentPage + "</span>");
                    $("#totalPageDisplay").siblings().remove();
                    $("#totalPageDisplay").after("<span>" + totalPage + "</span>");



                    $("tr:odd").css("background-color", "#98d4f1");

                    // 标题行变色
                    $("th").css("background-color", "#0095b1");

                    removeReviewedLinks();


                },
                error: function (){

                }
            })
        }


    }

    function queryByStatus(curPage){

        var status = $("#statusSelect").val()

        $.ajax({
            url: "queryByStatus",
            type: "get",
            data: {"curPage":curPage,"status":status},
            dataType: "json",
            success: function (result){

                totalPage = result.totalPage;
                currentPage = result.curPage;

                var temp = ""
                for (var i in result.projectInfos) {
                    var statusStr = toStr(result.projectInfos[i].status);
                    var auditLink = "";


                    if (statusStr !== "已审核") {
                        auditLink = `<a href="javascript:;" onclick="toCheckProject(\${result.projectInfos[i].id})">审核</a>`;
                    }

                    temp += `
                    <tr>
                        <td>\${result.projectInfos[i].id}</td>
                        <td>\${result.projectInfos[i].projectName}</td>
                        <td>\${result.projectInfos[i].startDate}</td>
                        <td>\${result.projectInfos[i].endDate}</td>
                        <td>\${statusStr}</td>
                        <td>\${auditLink}</td>
                    </tr>
                `;
                }
                $("#t1").siblings().remove();
                $("#t1").after(temp);

                $("#curPageDisplay").siblings().remove();
                $("#curPageDisplay").after("<span>" + currentPage + "</span>");
                $("#totalPageDisplay").siblings().remove();
                $("#totalPageDisplay").after("<span>" + totalPage + "</span>");

                $("tr:odd").css("background-color", "#98d4f1");

                // 标题行变色
                $("th").css("background-color", "#0095b1");
                removeReviewedLinks();
            },
            error: function (){

            }
        })
    }

    function toCheckProject(id){
        window.location.href="toCheckProject?id="+id;
    }

    function statusChange(){
        currentStatus = $("#statusSelect").val()
    }

    function removeReviewedLinks(){
        // 遍历所有的“审核”链接
        $("td a").each(function() {
            var statusCell = $(this).closest("tr").find("td:eq(4)"); // 第五列是状态列
            var status = statusCell.text().trim();


            // 如果状态是“已审核”，则删除操作链接
            if (status === "已审核") {
                $(this).remove();
            }
        });
    }


    function toStr(m){
        switch (m) {
            case 0:
                return  "已申报";
                break;
            case 1:
                return  "审核中";
                break;
            case 2:
                return  "已审核";
                break;
            default:
                return  "未知状态"; // 如果status值不在0, 1, 2内，显示默认信息
                break;
        }
    }
</script>
