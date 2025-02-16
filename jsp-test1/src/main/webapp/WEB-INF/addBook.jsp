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
<link rel="stylesheet" href="static/css/theme.css">
<body>

<p class="title">新增图书信息</p>

<div class="form-container">
    <form action="addBook" id="addBookForm" >
        <div>
            <span>图书名称：</span>
            <input type="text" name="bookName" required>
        </div>

        <div>
            <span>图书作者：</span>
            <input type="text" name="bookAuthor" required>
        </div>

        <div>
            <span>购买日期：</span>
            <input type="text" name="bookTime" placeholder="yyyy-MM-dd" required>
        </div>

        <div>
            <span>图书类别：</span>
            <select name="bookType" id="typeSelect">
                <option value="0">未分类</option>
                <option value="1">计算机</option>
                <option value="2">小说</option>
                <option value="3">杂项</option>
            </select>
        </div>


    </form>
    <button onclick="confirmForm()">增加图书</button>
</div>


</body>

<script type="text/javascript">

    function confirmForm(){

        var bookName = $("input[name='bookName']").val();
        var bookAuthor = $("input[name='bookAuthor']").val();
        var bookTime = $("input[name='bookTime']").val();
        var bookType = $("input[name='bookType']").val();

        var flag = false;
        var msg = "";

        if (!bookName) {
            msg += " 图书名称为空 " ;
            flag = true;
        }
        if (!bookAuthor) {
            msg += " 作者姓名为空 " ;
            flag = true;
        }
        if (!bookTime) {
            msg += " 购买时间为空 " ;
            flag = true;
        }
        if (bookType==0){
            msg += " 图书未分类 " ;
            flag = true;
        }

        var datePattern = /^\d{4}-\d{2}-\d{2}$/;
        if (bookTime&&!datePattern.test(bookTime)) {
            msg += "日期格式错误";
            flag = true;
        }

        if (!flag){
            msg = "提交成功";
        }

        alert(msg);

        if (!flag){
            $("#addBookForm").submit();
        }


    }

</script>
</html>
