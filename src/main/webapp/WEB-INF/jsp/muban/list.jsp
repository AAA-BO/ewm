<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>模板管理</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">

<div>

    <!--tab内容-->
    <table id="id_mainTable" lay-filter="mainTable"></table>

    <!--表头工具栏-->
    <script type="text/html" id="mainToolbar">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
            <%--<button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>--%>
            <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
        </div>
    </script>

    <!--列工具栏-->
    <script type="text/html" id="mainTool">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="showMuban">预览模板</button>
            <button class="layui-btn layui-btn-sm" lay-event="guanlian">所关联设备</button>
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
                <div id="item_div_id">
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">属性名</label>
                    <div class="layui-input-block">
                        <input id="propName" type="text" placeholder="请输入" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">属性类型</label>
                    <div class="layui-input-block">
                        <select id="proptype" lay-filter="proptype_add">
                            <option value="文本框">文本框</option>
                            <option value="文本域">文本域</option>
                            <option value="数字">数字</option>
                            <option value="日期时间">日期时间</option>
                            <option value="下拉列表">下拉列表</option>
                            <option value="单选按钮">单选按钮</option>
                            <option value="复选框">复选框</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item" id="item_id" hidden>
                    <label class="layui-form-label">可选项(|)</label>
                    <div class="layui-input-block">
                        <input id="propitem" type="text" placeholder="请输入" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <div class="layui-btn" onclick="addOne();">添加</div>
                        <div class="layui-btn" onclick="removeLast();">移除</div>
                        <div class="layui-btn" onclick="removeAll();">清空</div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">模板名称</label>
                    <div class="layui-input-block">
                        <input id="mubanName" type="text" placeholder="请输入" autocomplete="off"
                               class="layui-input" lay-verify="required">
                    </div>
                </div>
                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="addSubmit">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>


    <%--预览模板--%>
    <div id="equipmentPanel" class="layui-card">
        <div class="layui-card-header">预览模板</div>
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


    <%--所管理的设备--%>
    <div id="guanlianPanel" class="layui-card">
        <div class="layui-card-header">所关联设备</div>
        <div class="layui-card-body">
            <table id="id_guanlianTable" lay-filter="guanlianTable"></table>
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
            , url: '/muban_list' //数据接口
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
                , {field: 'name', title: '模板名'}
                , {title: '操作', width: 320, toolbar: '#mainTool', fixed: 'right'}
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
                        , area: ['1200px', '680px']
                        , content: $('#addPanel')
                        , cancel: function (index, layero) {
                            $("#item_div_id").empty();
                            $("#item_id").attr("hidden", "hidden");
                            $("#id_addFrom")[0].reset();
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
                        var deleteNames = new Array();
                        for (var data_index in checkStatus.data) {
                            deleteNames.push(checkStatus.data[data_index].name);
                        }
                        var deleteNamesStr = deleteNames.join(',');

                        $.post("/muban_delete",
                            {names: deleteNamesStr},
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

            if (layEvent === 'showMuban') { //预览模板
                // 获取模板数据
                $.post("/muban_show",
                    {name: data.name},
                    function (data, status) {
                        if (data != null) {
                            console.log(data);
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
                                        $("#id_showMuban").append('<div class="layui-form-item layui-form-text">\n' +
                                            '                    <label class="layui-form-label">' + item.filedName + '</label>\n' +
                                            '                    <div class="layui-input-block">\n' +
                                            '                        <textarea name="info" placeholder="请输入内容" class="layui-textarea"></textarea>\n' +
                                            '                    </div>\n' +
                                            '                </div>');
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
                    , content: $('#equipmentPanel')
                    , cancel: function (index, layero) {
                        $("#id_showMuban").empty();
                        return true;
                    }

                });

            } else if (layEvent === 'guanlian') { //查看关联设备
                table.render({
                    elem: '#id_guanlianTable'
                    , height: 'full-210'
                    , url: '/equipment_guanlianshebei' //数据接口
                    , where: {mubanName: obj.data.name}
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
                    ]]
                });
                layer.open({
                    type: 1
                    , offset: '50px'
                    , title: false
                    , resize: false
                    , area: ['1200px', '600px']
                    , shade: [0.8, '#393D49']
                    , content: $('#guanlianPanel')
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
            $.post("/muban_add",
                {
                    mubanData: "[" + mubanArray.join(",") + "]"
                },
                function (data, status) {
                    if (data == 1) {
                        $("#item_div_id").empty();
                        $("#item_id").attr("hidden", "hidden");
                        $("#id_addFrom")[0].reset();
                        layer.msg("添加成功");
                        layui.table.reload("id_mainTable");
                    }
                });

            return false; //false阻止表单跳转
        });

        // 表单onselect事件
        form.on('select(proptype_add)', function (data) {
            if (data.value == "下拉列表" || data.value == "单选按钮" || data.value == "复选框") {
                $("#item_id").removeAttr("hidden");
            } else {
                $("#item_id").attr("hidden", "hidden");
            }
            selectItem = data.value;
        });
    });

    var selectItem = "文本框";
    var mubanArray = new Array();

    function addOne() {
        if ($("#mubanName").val() == "") {
            layer.msg("请填写模板名");
            return;
        }
        if ($("#propName").val() == "") {
            layer.msg("请填写属性名");
            return;
        }
        console.log($("#propitem").val());

        switch (selectItem) {
            case '文本框':
                $("#item_div_id").append('<div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">' + $("#propName").val() + '</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="text" name="' + $("#propName").val() + '" placeholder="请输入" autocomplete="off"\n' +
                    '                                   class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n');
                mubanArray.push("{name:" + $("#mubanName").val() +
                    ",filedName:" + $("#propName").val() +
                    ",filedType:" + selectItem +
                    ",filedItem:''}");
                break;
            case '文本域':
                $("#item_div_id").append('<div class="layui-form-item layui-form-text">\n' +
                    '                    <label class="layui-form-label">'+ $("#propName").val() +'</label>\n' +
                    '                    <div class="layui-input-block">\n' +
                    '                        <textarea name="'+ $("#propName").val() +'" placeholder="请输入内容" class="layui-textarea"></textarea>\n' +
                    '                    </div>\n' +
                    '                </div>');
                mubanArray.push("{name:" + $("#mubanName").val() +
                    ",filedName:" + $("#propName").val() +
                    ",filedType:" + selectItem +
                    ",filedItem:''}");
                break;
            case '数字':
                $("#item_div_id").append('<div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">' + $("#propName").val() + '</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="number" name="' + $("#propName").val() + '" placeholder="请输入" autocomplete="off"\n' +
                    '                                   class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n');
                mubanArray.push("{name:" + $("#mubanName").val() +
                    ",filedName:" + $("#propName").val() +
                    ",filedType:" + selectItem +
                    ",filedItem:''}");
                break;
            case '日期时间':
                $("#item_div_id").append('<div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">' + $("#propName").val() + '</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <input type="datetime-local" name="' + $("#propName").val() + '" placeholder="请输入" autocomplete="off"\n' +
                    '                                   class="layui-input">\n' +
                    '                        </div>\n' +
                    '                    </div>\n');
                mubanArray.push("{name:" + $("#mubanName").val() +
                    ",filedName:" + $("#propName").val() +
                    ",filedType:" + selectItem +
                    ",filedItem:''}");
                break;
            case '下拉列表':
                var dom = "";
                $("#propitem").val().split('|').forEach(function (item, i) {
                    dom += '<option value="' + item + '">' + item + '</option>\n'
                });

                $("#item_div_id").append('<div class="layui-form-item">\n' +
                    '                        <label class="layui-form-label">' + $("#propName").val() + '</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            <select name="' + $("#propName").val() + '">\n' +
                    '                                <option value=""></option>\n' + dom +
                    '                            </select>\n' +
                    '                        </div>\n' +
                    '                    </div>');
                layui.form.render();
                mubanArray.push("{name:" + $("#mubanName").val() +
                    ",filedName:" + $("#propName").val() +
                    ",filedType:" + selectItem +
                    ",filedItem:" + $("#propitem").val() + "}");
                break;
            case '单选按钮':
                var dom = "";
                $("#propitem").val().split('|').forEach(function (item, i) {
                    if (i == 0) {
                        dom += '<input type="radio" name="' + $("#propName").val() + '" value="' + item + '" title="' + item + '" checked>'
                    } else {
                        dom += '<input type="radio" name="' + $("#propName").val() + '" value="' + item + '" title="' + item + '">'
                    }

                });
                $("#item_div_id").append('<div class="layui-form-item" pane>\n' +
                    '                        <label class="layui-form-label">' + $("#propName").val() + '</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            ' + dom +
                    '                        </div>\n' +
                    '                    </div>');
                layui.form.render();
                mubanArray.push("{name:" + $("#mubanName").val() +
                    ",filedName:" + $("#propName").val() +
                    ",filedType:" + selectItem +
                    ",filedItem:" + $("#propitem").val() +
                    "}");
                break;
            case '复选框':
                var dom = "";
                $("#propitem").val().split('|').forEach(function (item, i) {
                    dom += '<input type="checkbox" lay-skin="primary" name="' + item + '" title="' + item + '">'
                });

                $("#item_div_id").append('<div class="layui-form-item" pane>\n' +
                    '                        <label class="layui-form-label">' + $("#propName").val() + '</label>\n' +
                    '                        <div class="layui-input-block">\n' +
                    '                            ' + dom +
                    '                        </div>\n' +
                    '                    </div>');
                layui.form.render();
                mubanArray.push("{name:" + $("#mubanName").val() +
                    ",filedName:" + $("#propName").val() +
                    ",filedType:" + selectItem +
                    ",filedItem:" + $("#propitem").val() +
                    "}");
                break;
        }
    }

    function removeLast() {
        $("#item_div_id > div:last").remove();
        mubanArray.pop();
    }

    function removeAll() {
        $("#item_div_id").empty();
    }


</script>
</body>
</html>