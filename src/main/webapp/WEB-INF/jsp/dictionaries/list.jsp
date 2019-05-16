<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>数据字典</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">

<div>
    <%--搜索框--%>
    <div class="search">
        类型：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="search_type_id" autocomplete="off">
        </div>
        数据：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="search_value_id" autocomplete="off">
        </div>
        <button class="layui-btn" id="search_btn_id">搜索</button>
    </div>

    <!--tab内容-->
    <table id="id_mainTable" lay-filter="mainTable"></table>

    <!--表头工具栏-->
    <script type="text/html" id="mainToolbar">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
            <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
            <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
        </div>
    </script>
</div>


<!--add&update面板-->
<div style="position: absolute;top: -9999px;left: -9999px;">

    <!--add-->
    <div id="addPanel" class="layui-card">
        <div class="layui-card-header">添加</div>
        <div class="layui-card-body">
            <form id="id_addFrom" class="layui-form layui-form-pane">
                <div class="layui-form-item">
                    <label class="layui-form-label">类型</label>
                    <div class="layui-input-block">
                        <select name="group" id="group_select_add_id" lay-filter="group_add">
                            <option value="">新增类型</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item" id="type_add_id">
                    <label class="layui-form-label">类型</label>
                    <div class="layui-input-block">
                        <input type="text" name="type" placeholder="请输入" autocomplete="off"
                               class="layui-input" lay-verify="required">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">数据</label>
                    <div class="layui-input-block">
                        <input type="text" name="value" placeholder="请输入" autocomplete="off"
                               class="layui-input" lay-verify="required">
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
    </div>

    <!--update-->
    <div id="updatePanel" class="layui-card">
        <div class="layui-card-header">更新</div>
        <div class="layui-card-body">
            <form id="id_updateFrom" class="layui-form layui-form-pane" lay-filter="updateFrom">
                <div class="layui-form-item" hidden>
                    <label class="layui-form-label">ID</label>
                    <div class="layui-input-block">
                        <input type="text" name="oid" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">类型</label>
                    <div class="layui-input-block">
                        <input type="text" name="type" placeholder="请输入" autocomplete="off"
                               class="layui-input" lay-verify="required" disabled>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">数据</label>
                    <div class="layui-input-block">
                        <input type="text" name="value" placeholder="请输入" autocomplete="off"
                               class="layui-input" lay-verify="required">
                    </div>
                </div>
                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <%--<button type="reset" class="layui-btn layui-btn-primary">重置</button>--%>
                        <button class="layui-btn" lay-submit lay-filter="updateSubmit">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>

<script src="js/jquery.js"></script>
<script src="layui/layui.all.js"></script>

<script>
    var showId = 0;

    layui.use('layer', function () {
        var table = layui.table;
        var tableIns = table.render({
            elem: '#id_mainTable'
            , url: '/dictionaries_list' //数据接口
            , title: '数据字典'//结合toolbar右侧导出功能
            , toolbar: '#mainToolbar'
            , initSort: {
                field: 'oid'
                , type: 'asc'
            }
            , text: {
                none: '无数据'
            }
            , skin: 'line' //行边框风格
            , even: true //开启隔行背景
            , size: 'lg' //大尺寸的表格
            , page: true //开启分页
            , limits: [1, 2, 10, 20]
            , cols: [[
                {type: 'checkbox', width: 50, fixed: 'left'}
                , {field: 'oid', title: 'ID', sort: true, hide: true}
                , {field: 'type', title: '类型'}
                , {field: 'value', title: '数据'}
            ]]
        });

        //监听表头工具栏按钮
        table.on('toolbar(mainTable)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'add':
                    // 获取类型分类数据
                    $.post("/dictionaries_getTypeGroup",
                        function (data, status) {
                            console.log(data);
                            if (data != null) {
                                data.forEach(function (item, i) {
                                    // 将工地数据加入
                                    $("#group_select_add_id").append('<option value="' + item + '">' + item + '</option>');
                                });
                            }
                            // 重新渲染表单
                            layui.form.render();
                        });
                    // 打开添加模态框
                    layer.open({
                        type: 1
                        , offset: '25px'
                        , title: false
                        , resize: false
                        , shade: [0.8, '#393D49']
                        , content: $('#addPanel')
                        , cancel: function (index, layero) {
                            $("#group_select_add_id").html('<option value="">新增类型</option>');
                            $("#id_addFrom")[0].reset();
                            return true;
                        }
                    });
                    break;
                case
                'update' :
                    // 判断是否只选中一行
                    var checkStatus = table.checkStatus('id_mainTable');
                    if (checkStatus.data.length != 1) {
                        layer.msg("请选中一行数据", {icon: 7});
                        return;
                    }

                    layui.use('form', function () {
                        var form = layui.form;
                        // 数据回显
                        form.val("updateFrom", checkStatus.data[0]);
                    });

                    // 显示模态框
                    layer.open({
                        type: 1
                        , offset: '25px'
                        , title: false
                        , resize: false
                        , shade: [0.8, '#393D49']
                        , content: $('#updatePanel')
                        , cancel: function (index, layero) {
                            $("#id_updateFrom")[0].reset();
                            return true;
                        }
                    });
                    break;
                case
                'delete'
                :
                    // 获取选中条数
                    var checkStatus = table.checkStatus('id_mainTable');
                    if (checkStatus.data.length == 0) {
                        layer.msg("请选中要删除的行", {icon: 7});
                        return;
                    }

                    layer.confirm('确认要删除选中的行吗？', {icon: 3, title: '警告'}, function (index) {
                        // 获取选中项id
                        var deleteIds = new Array();
                        for (var data_index in checkStatus.data) {
                            deleteIds.push(checkStatus.data[data_index].oid);
                        }
                        var deleteIdsStr = deleteIds.join(',');

                        $.post("/dictionaries_delete",
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
            }
        })

        //监听列工具栏
        table.on('tool(mainTable)', function (obj) { //注：tool中是列工具栏所属table的filter
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if (layEvent === 'equipment') { //查看所管理的设备
                table.render({
                    elem: '#id_equipmentTable'
                    , height: 'full-210'
                    , url: '/staff_showEquipment' //数据接口
                    , where: {oid: obj.data.oid}
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
                    , limits: [1, 2, 10, 20]
                    , cols: [[ //表头
                        {field: 'oid', title: 'ID', sort: true}
                        , {field: 'name', title: '名称'}
                    ]]
                });
                layer.open({
                    type: 1
                    , offset: '50px'
                    , title: false
                    , resize: false
                    , area: ['1200px', '600px']
                    , shade: [0.8, '#393D49']
                    , content: $('#equipmentPanel')
                });

            } else if (layEvent === 'record') { //查看维护记录
                table.render({
                    elem: '#id_recordTable'
                    , height: 'full-210'
                    , url: '/staff_showRecord' //数据接口
                    , where: {oid: obj.data.oid}
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
                    , limits: [1, 2, 10, 20]
                    , cols: [[ //表头
                        {field: 'oid', title: 'ID'}
                        , {
                            title: '维护设备', templet: function (rowData) {
                                return rowData.equipment.name;
                            }
                        }
                        , {
                            field: 'date', title: '维护时间', templet: function (rowData) {
                                return new Date(rowData.date.time).toLocaleString();
                            }
                        }
                        , {field: 'info', title: '维护信息'}
                    ]]
                });
                layer.open({
                    type: 1
                    , offset: '50px'
                    , title: false
                    , resize: false
                    , area: ['1200px', '600px']
                    , shade: [0.8, '#393D49']
                    , content: $('#recordPanel')
                });
            }
        });
    })
    ;

    // 表单模块
    layui.use('form', function () {
        var form = layui.form;

        // 用于监听表单的提交
        form.on('submit(addSubmit)', function (data) {
            $.post("/dictionaries_add",
                data.field,
                function (data, status) {
                    if (data == 1) {
                        layer.msg("添加成功");
                        // TODO
                        // 重新加载下拉框数据
                        $("#group_select_add_id").html('<option value="">新增类型</option>');
                        $.post("/dictionaries_getTypeGroup",
                            function (data, status) {
                                if (data != null) {
                                    data.forEach(function (item, i) {
                                        // 将工地数据加入
                                        $("#group_select_add_id").append('<option value="' + item + '">' + item + '</option>');
                                    });
                                }
                                // 重新渲染表单
                                layui.form.render();
                            });
                        // 展示中间类型框
                        $("#type_add_id input[name='type']").val("");
                        $("#type_add_id").removeAttr("hidden");
                        $("#id_addFrom")[0].reset();
                        layui.table.reload("id_mainTable");
                    }
                });

            return false; //false阻止表单跳转
        });

        form.on('submit(updateSubmit)', function (data) {
            $.post("/dictionaries_update",
                data.field,
                function (data, status) {
                    if (data == 1) {
                        layer.msg("修改成功");
                        layui.table.reload("id_mainTable");
                    }
                });
            return false; //false阻止表单跳转
        });

        // 表单onselect事件
        form.on('select(group_add)', function (data) {
            if (data.value == "") {
                $("#type_add_id input[name='type']").val("");
                $("#type_add_id").removeAttr("hidden");
            } else {
                $("#type_add_id input[name='type']").val(data.value);
                $("#type_add_id").attr("hidden", "hidden");
            }
        });
    });

    $('#search_btn_id').on('click', function(){
        var type = $("#search_type_id").val();
        var value = $("#search_value_id").val();

        // $.post("/dictionaries_search",
        //     { type:type,value:value},
        //     function (data, status) {
        //         layui.table.reload('id_mainTable',data.data);
        //     });
        layui.table.reload('id_mainTable', {
            url: '/dictionaries_search'
            ,where: {
                type:type,
                value:value
            }

        });

    });


</script>
</body>
</html>