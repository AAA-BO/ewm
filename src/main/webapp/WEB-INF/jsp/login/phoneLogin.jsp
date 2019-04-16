<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>移动端登录</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-container" style="padding-top: 15px">

<form class="layui-form layui-form-pane" action="/staff_login" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">账户</label>
        <div class="layui-input-block">
            <input type="text" name="username" required lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" hidden>
        <input type="text" name="isPhone" value="true">
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="text-align: right">
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            <button class="layui-btn" lay-submit>登录</button>
        </div>
    </div>
</form>

<div hidden id="msg"><s:actionerror/></div>

<script src="js/jquery.js"></script>
<script src="layui/layui.all.js"></script>

<script>
    $(function () {
        var msg = $("#msg").text();
        if(msg!="" ) {
            layer.msg(msg);
        }

    });

</script>
</body>
</html>