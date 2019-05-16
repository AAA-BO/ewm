<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>加入申请</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">

<div>
    <!--tab内容-->
    <table id="id_mainTable" lay-filter="mainTable"></table>
</div>

<!--列工具栏-->
<script type="text/html" id="mainTool">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="sayYes">同意</button>
        <button class="layui-btn layui-btn-sm" lay-event="sayNo">拒绝</button>
    </div>
</script>

<script src="js/jquery.js"></script>
<script src="layui/layui.all.js"></script>

<script>
    var showId = 0;

    layui.use('layer', function () {
        var table = layui.table;
        var tableIns = table.render({
            elem: '#id_mainTable'
            , url: '/dictionaries_joinlist'
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
                {title: '申请人ID',templet: function (rowData) {
                        return rowData.value.split(",")[0];
                  }}
                ,{title: '申请人',templet: function (rowData) {
                        return rowData.value.split(",")[1];
                    }}
                ,{title: '维护组ID',templet: function (rowData) {
                        return rowData.value.split(",")[2];
                    }}
                ,{title: '维护组',templet: function (rowData) {
                        return rowData.value.split(",")[3];
                    }}
                ,{title: '申请时间',templet: function (rowData) {
                        return rowData.value.split(",")[4];
                    }}
                , {title: '操作', width: 150, toolbar: '#mainTool', fixed: 'right'}

            ]]
        });


        //监听列工具栏
        table.on('tool(mainTable)', function (obj) { //注：tool中是列工具栏所属table的filter
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if (layEvent === 'sayYes') { //通过
                $.post("/maintainGroup_join",
                    {
                        say:'yes'
                        ,oid: data.oid
                    },
                    function (data, status) {
                        if (data != null) {
                            if (data == 1) {
                                layer.msg("操作成功");
                                tableIns.reload();
                            }
                        }
                    });
            }else if (layEvent === 'sayNo') { //不通过
                $.post("/maintainGroup_join",
                    {
                        say:'no'
                        ,oid: data.oid
                    },
                    function (data, status) {
                        if (data != null) {
                            if (data == 1) {
                                layer.msg("操作成功");
                                tableIns.reload();
                            }
                        }
                    });
            }
        });
    })
</script>
</body>
</html>