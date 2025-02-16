<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2025/2/15
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="static/js/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/moment@2.29.1/moment.min.js"></script>
<link rel="stylesheet" href="static/css/theme.css">
<body>
<p class="title" >图书信息</p>

<div class="table-container">
    <table border="1px">
        <tr>
            <th>&nbsp;&nbsp;&nbsp;&nbsp;图书名称&nbsp;&nbsp;&nbsp;&nbsp;</th>
            <th>&nbsp;&nbsp;&nbsp;&nbsp;图书作者&nbsp;&nbsp;&nbsp;&nbsp;</th>
            <th>&nbsp;&nbsp;&nbsp;&nbsp;购买时间&nbsp;&nbsp;&nbsp;&nbsp;</th>
            <th>&nbsp;&nbsp;&nbsp;&nbsp;图书分类&nbsp;&nbsp;&nbsp;&nbsp;</th>
            <th>&nbsp;&nbsp;&nbsp;&nbsp;操作&nbsp;&nbsp;&nbsp;&nbsp;</th>
        </tr>

        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>
                    <script type="text/javascript">
                        var date = moment("${book.time}");
                        document.write(date.format("YYYY-MM-DD"));
                    </script>

                </td>
                <td>
                    <c:choose>
                        <c:when test="${book.type ==1 }">
                            <p>计算机/软件</p>
                        </c:when>
                        <c:when test="${book.type ==2 }">
                            <p>小说/文稿</p>
                        </c:when>
                        <c:when test="${book.type ==3 }">
                            <p>杂项</p>
                        </c:when>
                        <c:otherwise>
                            <p>未分类</p>
                        </c:otherwise>
                    </c:choose>

                </td>
                <td><a href="javascript:;" onclick="confirmDelete(${book.id})">删除</a></td>
            </tr>
        </c:forEach>


    </table>
</div>

<div>
    <a href="toAddBook" style="text-decoration:none"  >新增图书信息</a>
</div>



</body>
<script type="text/javascript">

    $("tr:even").css("background-color", "rgba(82,146,237,0.56)")
    $("tr:first").css("background-color", "rgba(0,102,255,0.56)")

    function confirmDelete(bookId) {

        var deleteUrl = "deleteById?id=" + bookId;
        if (confirm("确定删除吗？")) {
            window.location.href = deleteUrl;  // 跳转到删除页面
        }
    }
</script>
</html>
