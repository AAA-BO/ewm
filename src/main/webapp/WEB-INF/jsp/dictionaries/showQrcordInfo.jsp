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
<table class="layui-table" lay-even lay-skin="nob">
    <thead>
    <tr>
        <td colspan="2" style="text-align: center">设备信息</td>
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
<button class="layui-btn layui-btn-sm" onclick="openMaintenancePanel();">进行维护</button>
<button class="layui-btn layui-btn-sm" onclick="openAllRecord();">所有记录</button>
<button class="layui-btn layui-btn-sm" onclick="openMyRecord();">我的记录</button>

<s:if test="#session.loginUser == null">
    <a class="layui-btn layui-btn-sm" href="/staff_phoneLoginPage?oid=${oid}">登录账户</a>
</s:if>


<div style="position: absolute;top: -9999px;left: -9999px;">
    <%--维护记录--%>
    <div id="maintenancePanel" class="layui-card">
        <div class="layui-card-header">维护</div>
        <div class="layui-card-body">
            <form id="id_from" class="layui-form layui-form-pane"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
                <div class="layui-form-item" hidden>
                    <label class="layui-form-label">ID</label>
                    <div class="layui-input-block">
                        <input type="text" name="equipment.oid" autocomplete="off" class="layui-input" value="${oid}">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">维护信息</label>
                    <div class="layui-input-block">
                        <textarea name="info" placeholder="请输入内容" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        <button class="layui-btn" lay-submit lay-filter="submit">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <%--所有维护记录--%>
    <div id="recordPanel" class="layui-card">
        <div class="layui-card-header">维护记录</div>
        <div class="layui-card-body">
            <table id="id_recordTable" lay-filter="recordTable" ></table>
        </div>
    </div>

    <%--我的维护记录--%>
    <div id="myEecordPanel" class="layui-card">
        <div class="layui-card-header">维护记录</div>
        <div class="layui-card-body">
            <table id="id_myEecordTable" lay-filter="myEecordTable"></table>
        </div>
    </div>

</div>

<script src="js/jquery.js"></script>
<script src="layui/layui.all.js"></script>

<script>
    function openMaintenancePanel() {
        // 发送ajax查询当前登录用户是否有权限维护该设备
        $.post("/equipment_maintenanceAuthority",
            {oid: ${oid}},
            function (data, status) {
                if (data == 1) {
                    // 显示模态框
                    layer.open({
                        type: 1
                        , offset: '50px'
                        , title: false
                        , resize: false
                        // , area: ['200px', '200px']
                        , shade: [0.8, '#393D49']
                        , content: $('#maintenancePanel')
                    });
                } else if (data == 0) {
                    layer.msg("没有权限");
                } else if (data == 3) {
                    layer.msg("请先登录");
                }
            });


    }

    function openAllRecord() {
        layui.table.render({
            elem: '#id_recordTable'
            , url: '/equipment_showRecord_phone' //数据接口
            , where: {oid: ${oid}}
            , initSort: {
                field: 'oid'
                , type: 'asc'
            }
            , skin: 'line' //行边框风格
            , even: true //开启隔行背景
            , size: 'sm' //大尺寸的表格
            , page: false //开启分页
            ,limit:0
            , cols: [[ //表头
                {field: 'oid', title: 'ID'}
                , {
                    title: '人员', templet: function (rowData) {
                        return rowData.staff.name;
                    }
                }
                , {
                    field: 'date', title: '时间', templet: function (rowData) {
                        return new Date(rowData.date.time).toLocaleString();
                    }
                }
                , {field: 'info', title: '信息'}
            ]]
        });
        layer.open({
            type: 1
            , offset: '20px'
            , title: false
            , resize: false
            , area: ['350px', '600px']
            , shade: [0.8, '#393D49']
            , content: $('#recordPanel')
        });


    }

    function openMyRecord() {
        // 发送ajax查询当前登录用户是否有权限维护该设备
        $.post("/equipment_myRecord",
            {oid: ${oid}},
            function (data, status) {
                if (data == 3) {
                    layer.msg("请先登录");
                }else {
                    layui.table.render({
                        elem: '#id_myEecordTable'
                        , url: '/equipment_myRecord' //数据接口
                        , where: {oid: ${oid}}
                        , initSort: {
                            field: 'oid'
                            , type: 'asc'
                        }
                        ,limit:0
                        , skin: 'line' //行边框风格
                        , even: true //开启隔行背景
                        , size: 'sm' //大尺寸的表格
                        , page: false //开启分页
                        , cols: [[ //表头
                            {field: 'oid', title: 'ID'}

                            , {
                                field: 'date', title: '时间', templet: function (rowData) {
                                    return new Date(rowData.date.time).toLocaleString();
                                }
                            }
                            , {field: 'info', title: '信息'}
                        ]]
                    });

                    // 显示模态框
                    layer.open({
                        type: 1
                        , offset: '20px'
                        , title: false
                        , resize: false
                        , area: ['350px', '600px']
                        , shade: [0.8, '#393D49']
                        , content: $('#myEecordPanel')
                    });
                }
            });


    }

    // 表单模块
    layui.use('form', function () {
        var form = layui.form;
        // 用于监听提交事件
        form.on('submit(submit)', function (data) {
            $.post("/record_add",
                data.field,
                function (data, status) {
                    if (data == 1) {
                        layer.msg("添加成功");
                        $("#id_from")[0].reset();
                    }
                });

            return false; //false阻止表单跳转
        });
    });
</script>
</body>
</html>