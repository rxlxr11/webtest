<%--
  Created by IntelliJ IDEA.
  User: xinrongli
  Date: 2025/2/19
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="addPerson">
    <div>

        <span></span>
        <input type="text" name="personName" required>
    </div>

    <div>
        <span></span>
        <select  name="sex" required>
            <option value="err">-请选择-</option>
            <option value="男">男</option>
            <option value="女">女</option>
        </select>
    </div>

    <div>
        <span></span>
        <input type="text" name="age" required>
    </div>

    <div>
        <span></span>
        <select  name="rank" required>
            <option value="err">-请选择-</option>
            <option value="1级">1级</option>
            <option value="2级">2级</option>
        </select>
    </div>

    <div>
        <span></span>
        <select  name="department" required>
            <option value="err">-请选择-</option>
            <option value="开发部">开发部</option>
            <option value="后勤部">后勤部</option>
        </select>
    </div>


    <button>提交</button>
</form>
</body>
</html>

