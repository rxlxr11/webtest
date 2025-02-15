<%--
  Created by IntelliJ IDEA.
  User: xinrongli
  Date: 2025/2/15
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="static/js/jquery.js"></script>
<body>

<form action="addBook">
    <div>
        <input type="text" name="bookName" required>
    </div>

    <div>
        <input type="text" name="bookAuthor" required>
    </div>

    <div>
        <input type="text" name="bookTime" required>
    </div>

    <div>
        <select name="bookType" id="typeSelect">
            <option value="0">未分类</option>
            <option value="1">计算机</option>
            <option value="2">小说</option>
            <option value="3">杂项</option>
        </select>
    </div>



    <button>增加图书</button>
</form>
</body>

<script type="text/javascript">

</script>
</html>
