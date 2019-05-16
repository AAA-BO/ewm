<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>设备关联模板</title>
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
            <button class="layui-btn layui-btn-sm" lay-event="batch" disabled>批量关联</button>
        </div>
    </script>
    <!--列工具栏-->
    <script type="text/html" id="mainTool">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="show">查看模板</button>
            <button class="layui-btn layui-btn-sm" lay-event="relevance">关联模板</button>
        </div>
    </script>
</div>


<div style="position: absolute;top: -9999px;left: -9999px;">

    <%--查看模板--%>
    <div id="showPanel" class="layui-card">
        <div class="layui-card-header">查看模板</div>
        <div class="layui-card-body">
            <div class="layui-form layui-form-pane">
                <div id="id_showMuban"></div>

                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <div class="layui-btn layui-btn-primary" >重置</div>
                        <div class="layui-btn" >提交</div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <%--关联模板--%>
    <div id="relevancePanel" class="layui-card">
        <div class="layui-card-header">关联模板</div>
        <div class="layui-card-body">
            <table id="id_relevanceTable" lay-filter="relevanceTable"></table>
        </div>
    </div>
    <!--关联模板 列工具栏-->
    <script type="text/html" id="relevanceTool">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="showMuban">预览模板</button>
            <button class="layui-btn layui-btn-sm" lay-event="useMuban">使用模板</button>
        </div>
    </script>

</div>
<script src="js/jquery.js"></script>
<script src="layui/layui.all.js"></script>
<script src="js/qrcode.js"></script>

<script>
    var selectE = 0;

    layui.use('layer', function () {
        var table = layui.table;
        var tableIns = table.render({
            elem: '#id_mainTable'
            , url: '/equipment_list' //数据接口
            , title: '设备关联模板数据'//结合toolbar右侧导出功能
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
            , limits: [1, 2, 10, 20]
            , cols: [[ //表头
                {type: 'checkbox', width: 50, fixed: 'left'}
                , {field: 'oid', title: 'ID', sort: true, hide: true}
                , {field: 'name', title: '设备名称'}
                , {
                     title: '工地', templet: function (rowData) {
                        if (rowData.site == null) {
                            return "未设置";
                        }
                        return rowData.site.name;
                    }
                }
                ,{title: '模板名称', templet: function (rowData) {
                        if (rowData.mubanName == null || rowData.mubanName == "") {
                            return "未设置";
                        }
                        return rowData.mubanName;
                    }}
                , {title: '操作', width: 310, toolbar: '#mainTool', fixed: 'right'}
            ]]
        });

        //监听表头工具栏的事件(传入table对象的filter)
        table.on('toolbar(mainTable)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'batch': //批量关联
                    break;
            }
        });

        //监听列工具栏
        table.on('tool(mainTable)', function (obj) { //注：tool中是列工具栏所属table的filter
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if (layEvent === 'show') { //查看模板
                // 获取模板数据
                $.post("/muban_show",
                    {name: data.mubanName},
                    function (data, status) {
                        if (data != null) {
                            // 解析生成相应样式
                            data.data.forEach(function (item, i) {
                                switch (item.filedType) {
                                    case '文本框':
                                        $("#id_showMuban").append('<div class="layui-form-item">\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            <input type="text" placeholder="请输入" autocomplete="off"\n' +
                                            '                                   class="layui-input">\n' +
                                            '                        </div>\n' +
                                            '                    </div>\n');
                                        break;
                                    case '文本域':
                                        $("#id_showMuban").append('<div class="layui-form-item">\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            <textarea placeholder="请输入" autocomplete="off" class="layui-textarea" ></textarea>' +
                                            '                        </div>\n' +
                                            '                    </div>\n');
                                        break;
                                    case '数字':
                                        $("#id_showMuban").append('<div class="layui-form-item">\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            <input type="number"  placeholder="请输入" autocomplete="off"\n' +
                                            '                                   class="layui-input">\n' +
                                            '                        </div>\n' +
                                            '                    </div>\n');
                                        break;
                                    case '日期时间':
                                        $("#id_showMuban").append('<div class="layui-form-item">\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            <input type="datetime-local" placeholder="请输入" autocomplete="off"\n' +
                                            '                                   class="layui-input">\n' +
                                            '                        </div>\n' +
                                            '                    </div>\n');
                                        break;
                                    case '下拉列表':
                                        var dom = "";
                                        item.filedItem.split('|').forEach(function (item, i) {
                                            dom += '<option value="">' + item + '</option>\n'
                                        });

                                        $("#id_showMuban").append('<div class="layui-form-item">\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            <select name="">\n' +
                                            '                                <option value=""></option>\n' + dom +
                                            '                            </select>\n' +
                                            '                        </div>\n' +
                                            '                    </div>');
                                        layui.form.render();
                                        break;
                                    case '单选按钮':
                                        var dom = "";
                                        item.filedItem.split('|').forEach(function (item, i) {
                                            if (i == 0) {
                                                dom += '<input type="radio" name="test" value="test'+i+'" title="' + item + '" checked>'
                                            } else {
                                                dom += '<input type="radio" name="test" value="test'+i+'" title="' + item + '">'
                                            }

                                        });
                                        $("#id_showMuban").append('<div class="layui-form-item" pane>\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            ' + dom +
                                            '                        </div>\n' +
                                            '                    </div>');
                                        layui.form.render();
                                        break;
                                    case '复选框':
                                        var dom = "";
                                        item.filedItem.split('|').forEach(function (item, i) {
                                            dom += '<input type="checkbox" lay-skin="primary" name="" title="' + item + '">'
                                        });

                                        $("#id_showMuban").append('<div class="layui-form-item" pane>\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            ' + dom +
                                            '                        </div>\n' +
                                            '                    </div>');
                                        layui.form.render();
                                        break;
                                }
                            });
                        }
                    });

                layer.open({
                    type: 1
                    , offset: '50px'
                    , title: false
                    , resize: false
                    , area: ['1200px', '600px']
                    , shade: [0.8, '#393D49']
                    , content: $('#showPanel')
                    , cancel: function (index, layero) {
                        $("#id_showMuban").empty();
                        return true;
                    }

                });
            } else if (layEvent === 'relevance') { //关联模板
                table.render({
                    elem: '#id_relevanceTable'
                    , height: 'full-210'
                    , url: '/muban_listByNameNotWith' //数据接口
                    , where: {
                        oid: obj.data.oid
                        , name:obj.data.mubanName
                    }
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
                    , cols: [[
                         {field: 'name', title: '模板名'}
                        , {title: '操作', width: 320, toolbar: '#relevanceTool', fixed: 'right'}
                    ]]
                });
                // 设置当前操作的设备的id
                selectE = obj.data.oid;
                layer.open({
                    type: 1
                    , offset: '50px'
                    , title: false
                    , resize: false
                    , area: ['1200px', '600px']
                    , shade: [0.8, '#393D49']
                    , content: $('#relevancePanel')
                });
            }
        });

        // 监听关联工具栏
        table.on('tool(relevanceTable)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;
            var tr = obj.tr;

            if (layEvent === 'showMuban') { //预览模板
                $.post("/muban_show",
                    {name: data.name},
                    function (data, status) {
                        if (data != null) {
                            // 解析生成相应样式
                            data.data.forEach(function (item, i) {
                                switch (item.filedType) {
                                    case '文本框':
                                        $("#id_showMuban").append('<div class="layui-form-item">\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            <input type="text" placeholder="请输入" autocomplete="off"\n' +
                                            '                                   class="layui-input">\n' +
                                            '                        </div>\n' +
                                            '                    </div>\n');
                                        break;
                                    case '文本域':
                                        $("#id_showMuban").append('<div class="layui-form-item">\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            <textarea placeholder="请输入" autocomplete="off" class="layui-textarea" ></textarea>' +
                                            '                        </div>\n' +
                                            '                    </div>\n');
                                        break;
                                    case '数字':
                                        $("#id_showMuban").append('<div class="layui-form-item">\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            <input type="number"  placeholder="请输入" autocomplete="off"\n' +
                                            '                                   class="layui-input">\n' +
                                            '                        </div>\n' +
                                            '                    </div>\n');
                                        break;
                                    case '日期时间':
                                        $("#id_showMuban").append('<div class="layui-form-item">\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            <input type="datetime-local" placeholder="请输入" autocomplete="off"\n' +
                                            '                                   class="layui-input">\n' +
                                            '                        </div>\n' +
                                            '                    </div>\n');
                                        break;
                                    case '下拉列表':
                                        var dom = "";
                                        item.filedItem.split('|').forEach(function (item, i) {
                                            dom += '<option value="">' + item + '</option>\n'
                                        });

                                        $("#id_showMuban").append('<div class="layui-form-item">\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            <select name="">\n' +
                                            '                                <option value=""></option>\n' + dom +
                                            '                            </select>\n' +
                                            '                        </div>\n' +
                                            '                    </div>');
                                        layui.form.render();
                                        break;
                                    case '单选按钮':
                                        var dom = "";
                                        item.filedItem.split('|').forEach(function (item, i) {
                                            if (i == 0) {
                                                dom += '<input type="radio" name="test" value="test'+i+'" title="' + item + '" checked>'
                                            } else {
                                                dom += '<input type="radio" name="test" value="test'+i+'" title="' + item + '">'
                                            }

                                        });
                                        $("#id_showMuban").append('<div class="layui-form-item" pane>\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            ' + dom +
                                            '                        </div>\n' +
                                            '                    </div>');
                                        layui.form.render();
                                        break;
                                    case '复选框':
                                        var dom = "";
                                        item.filedItem.split('|').forEach(function (item, i) {
                                            dom += '<input type="checkbox" lay-skin="primary" name="" title="' + item + '">'
                                        });

                                        $("#id_showMuban").append('<div class="layui-form-item" pane>\n' +
                                            '                        <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                        <div class="layui-input-block">\n' +
                                            '                            ' + dom +
                                            '                        </div>\n' +
                                            '                    </div>');
                                        layui.form.render();
                                        break;
                                }
                            });
                        }
                    });

                layer.open({
                    type: 1
                    , offset: '50px'
                    , title: false
                    , resize: false
                    , area: ['1200px', '600px']
                    , shade: [0.8, '#393D49']
                    , content: $('#showPanel')
                    , cancel: function (index, layero) {
                        $("#id_showMuban").empty();
                        return true;
                    }
                });
            } else if (layEvent === 'useMuban') { //设置模板
                $.post("/equipment_useMuban",
                    {mubanName: data.name
                        ,oid:selectE
                    },
                    function (data, status) {
                        if (data == 1) {
                            layer.msg("设置成功");
                            layui.table.reload("id_mainTable");
                        }
                    });
            }
        });

    });






    // 表单模块
    layui.use('form', function () {
        var form = layui.form;
        form.on('submit(relevanceSubmit)', function (data) { // 关联提交
            $.post("/equipment_add",
                data.field,
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