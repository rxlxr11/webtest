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
<body>
<table>
    <tr>
        <th>图书名称</th>
        <th>图书作者</th>
        <th>购买时间</th>
        <th>图书分类</th>
        <th>操作</th>
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
            <td><a href="deleteById?id=${book.id}">删除</a></td>
        </tr>
    </c:forEach>


</table>

<a href="toAddBook">新增图书信息</a>
</body>
<script type="text/javascript">

</script>
</html>
