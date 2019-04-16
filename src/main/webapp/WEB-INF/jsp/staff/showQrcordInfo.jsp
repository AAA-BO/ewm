<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>员工管理</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-container">
<table class="layui-table" lay-even lay-skin="nob">
    <thead>
    <tr>
        <td colspan="2" style="text-align: center">员工信息</td>
    </thead>
    <tbody>
    <tr>
        <td>编号</td>
        <td>${oid}</td>
    </tr>
    <tr>
        <td>姓名</td>
        <td>${name}</td>
    </tr>
    </tbody>
</table>
<script src="js/jquery.js"></script>
<script src="layui/layui.all.js"></script>

<script>

</script>
</body>
</html>