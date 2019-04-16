<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>设备信息</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-container">

<form id="id_from" class="layui-form layui-form-pane"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">维护信息</label>
        <div class="layui-input-block">
            <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item" style="text-align: right">
        <div class="layui-input-block">
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            <button class="layui-btn" lay-submit lay-filter="submit">确定</button>
        </div>
    </div>
</form>

<script src="js/jquery.js"></script>
<script src="layui/layui.all.js"></script>

<script>
    // 表单模块
    layui.use('form', function(){
        var form = layui.form;
        // 用于监听提交事件
        form.on('submit(submit)', function(data){
            $.post("/record_add",
                {},
                function (data, status) {
                    if (data == 1) {
                        layer.msg("添加成功");
                        $("#id_addFrom")[0].reset();
                        layui.table.reload("id_mainTable");
                    }
                });

            return false; //false阻止表单跳转
        });
    });
</script>
</body>
</html>