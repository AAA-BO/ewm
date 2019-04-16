<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>维护记录管理</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">

    <!-- 内容主体区域 -->
    <!--table-->
    <div>
        <!--tab内容-->
        <table id="id_mainTable" lay-filter="mainTable"></table>

        <!--表头工具栏-->
        <script type="text/html" id="mainToolbar">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm layui-btn-disabled" lay-event="add">添加</button>
                <button class="layui-btn layui-btn-sm layui-btn-disabled" lay-event="update">编辑</button>
                <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
            </div>
        </script>
        <!--列工具栏-->
        <script type="text/html" id="mainTool">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm" lay-event="equipment">xxx</button>
                <button class="layui-btn layui-btn-sm" lay-event="record">xxx</button>
            </div>
        </script>
    </div>


<!--add & update 面板，利用绝对定位实现隐藏效果-->
<div style="position: absolute;top: -9999px;left: -9999px;">

    <!--add-->
    <%--<div id="addPanel" class="layui-card">
        <div class="layui-card-header">添加</div>
        <div class="layui-card-body">
            <form id="id_addFrom" class="layui-form layui-form-pane"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        <button class="layui-btn" lay-submit lay-filter="addSubmit">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>--%>

    <!--update-->
    <%--<div id="updatePanel" class="layui-card">
        <div class="layui-card-header">更新</div>
        <div class="layui-card-body">
            <form id="id_updateFrom" class="layui-form layui-form-pane" lay-filter="updateFrom"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
                <div class="layui-form-item" hidden>
                    <label class="layui-form-label">ID</label>
                    <div class="layui-input-block">
                        <input type="text" name="oid" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        <button class="layui-btn" lay-submit lay-filter="updateSubmit">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>--%>

    <%--所管理的设备--%>
    <div id="equipmentPanel" class="layui-card">
        <table id="id_equipmentTable" lay-filter="equipmentTable"></table>
    </div>

    <%--维护记录--%>
    <div id="recordPanel" class="layui-card">
        <table id="id_recordTable" lay-filter="recordTable"></table>
    </div>


</div>
<script src="js/jquery.js"></script>
<script src="layui/layui.all.js"></script>

<script>
    // table操作
    layui.use('layer', function () {
        var table = layui.table;
        //第一个实例
        var tableIns = table.render({
            // id:'maintable'
            elem: '#id_mainTable'
            ,url: '/record_list' //数据接口
            , title: '维护记录数据'//结合toolbar右侧导出功能
            , toolbar: '#mainToolbar'
            , initSort: {
                field: 'oid'
                , type: 'asc'
            }
            , text: {
                none: '暂无相关数据' //默认：无数据。
            }
            , skin: 'line' //行边框风格
            , even: true //开启隔行背景
            , size: 'lg' //大尺寸的表格
            , page: true //开启分页
            ,limits:[1,2,10,20]
            , cols: [[ //表头
                {type: 'checkbox', width: 30}
                , {field: 'oid', title: 'ID',  sort: true}
                , {title: '维护人员', templet: function(rowData){
                            return rowData.staff.name;
                   }}
                , {title: '维护设备', templet: function(rowData){
                        return rowData.equipment.name;
                   }}
                , {field: 'date', title: '维护时间', templet: function(rowData){
                        return new Date(rowData.date.time).toLocaleString();
                    }}
                , {field: 'info', title: '维护信息'}
                // ,{title: '操作', width: 200, toolbar: '#mainTool' ,fixed: 'right'}
            ]]
        });

        //监听表头工具栏的事件(传入table对象的filter)
        table.on('toolbar(mainTable)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'add':
                    /*// 初始化form模块
                    layui.use('form', function () {
                        var form = layui.form;

                        //各种基于事件的操作，下面会有进一步介绍
                    });
                    // 打开添加模态框
                    layer.open({
                        type: 1
                        , offset: '50px'
                        , title: false
                        , resize: false
                        , area: ['*', '*']
                        , shade: [0.8, '#393D49']
                        , content: $('#addPanel')
                        ,cancel: function(index, layero){// 点击关闭按钮后回调
                            $("#id_addFrom")[0].reset();
                            return true;
                        }
                    });*/

                    break;
                case 'delete':
                    // 获取选中条数
                    var checkStatus = table.checkStatus('id_mainTable');
                    if (checkStatus.data.length == 0) {
                        layer.msg("请选中要删除的行", {icon: 7});
                        return;
                    }

                    layer.confirm('确认要删除选中的行吗？', {icon: 3, title: '警告'}, function (index) {
                        // 获取选中项id
                        var deleteIds = new Array();
                        for (data_index in checkStatus.data) {
                            deleteIds.push(checkStatus.data[data_index].oid);
                        }
                        var deleteIdsStr = deleteIds.join(',');

                        $.post("/record_delete",
                            {ids: deleteIdsStr},
                            function (data, status) {
                                if (data == 1) {
                                    layer.msg("删除成功");
                                    // 重载table数据
                                    tableIns.reload();
                                    // 关闭询问框
                                    layer.close(index);
                                }
                            });
                    });
                    break;
                case 'update':
                    break;
            }
            ;
        });

        //监听列工具栏
        table.on('tool(mainTable)', function (obj) { //注：tool中是列工具栏所属table的filter
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if (layEvent === 'equipment') { //查看所管理的设备
                /*table.render({
                    elem: '#equipmentTable'
                    ,url: '/demo/table/user/' //数据接口
                    ,page: true //开启分页
                    ,cols: [[ //表头
                        {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                        ,{field: 'username', title: '用户名', width:80}
                        ,{field: 'sex', title: '性别', width:80, sort: true}
                        ,{field: 'city', title: '城市', width:80}
                        ,{field: 'sign', title: '签名', width: 177}
                        ,{field: 'experience', title: '积分', width: 80, sort: true}
                        ,{field: 'score', title: '评分', width: 80, sort: true}
                        ,{field: 'classify', title: '职业', width: 80}
                        ,{field: 'wealth', title: '财富', width: 135, sort: true}
                    ]]
                });*/

                layer.msg(obj.data.oid);
            }else if (layEvent === 'record') { //查看维护记录
                layer.msg(obj.data.oid);
            }
        });
    });
</script>
</body>
</html>