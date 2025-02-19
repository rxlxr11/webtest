<%--
  Created by IntelliJ IDEA.
  User: xinrongli
  Date: 2025/2/18
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="static/js/jquery.js"></script>
<body>
<button onclick="toAddBranch()">新增</button>
<table>
  <tr id="t1">
    <th>网点名称</th>
    <th>所在地区</th>
    <th>网点地址</th>
    <th>联系电话</th>
    <th>操作</th>
  </tr>



</table>
</body>
</html>

<script type="text/javascript">
  queryAll();
  function queryAll(){
    $.ajax({
      url: "queryAll",
      type: "get",
      data: "",
      dataType: "json",
      success: function (result){
        var temp = "";

        for (var i in result){
          temp += `
            <tr>
                <td>\${result[i].name}</td>
                <td>\${result[i].cityArea}</td>
                <td>\${result[i].address}</td>
                <td>\${result[i].branchTelephone}</td>
                <td><a href="javascript:;" onclick="toDetail(\${result[i].id})">查询</a></td>
            </tr>
        `
        }
        $("#t1").siblings().remove();
        $("#t1").after(temp);
      },
      error: function (){}
    })

  }


  function toDetail(id){

    window.location.href="toDetail?id="+id;

  }

  function toAddBranch(){
    window.location.href="toAddBranch"
  }

</script>
