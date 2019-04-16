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
<body class="layui-layout-body">

    <!-- 内容主体区域 -->
    <!--table-->
    <div>
        <!--tab内容-->
        <table id="id_mainTable" lay-filter="mainTable"></table>

        <!--表头工具栏-->
        <script type="text/html" id="mainToolbar">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm" lay-event="batch">批量关联</button>
            </div>
        </script>
        <!--列工具栏-->
        <script type="text/html" id="mainTool">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm" lay-event="equipment">查看管理设备</button>
                <button class="layui-btn layui-btn-sm" lay-event="relevance">关联设备</button>
            </div>
        </script>

        <!--列工具栏(所管理设备)-->
        <script type="text/html" id="glsbTool">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm" lay-event="glsb_delete">取消关联</button>
            </div>
        </script>
    </div>


<!--add & update 面板，利用绝对定位实现隐藏效果-->
<div style="position: absolute;top: -9999px;left: -9999px;">

    <!--关联-->
    <div id="relevancePanel" class="layui-card">
        <div class="layui-card-header">关联设备</div>
        <div class="layui-card-body">
            <form id="id_relevanceFrom" class="layui-form layui-form-pane" lay-filter="relevanceFrom">
                <table id="id_relevanceTable" lay-filter="relevanceTable"></table>
                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        <button class="layui-btn" lay-submit lay-filter="relevanceSubmit">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!--批量关联-->
    <div id="batchPanel" class="layui-card">
        <div class="layui-card-header">批量关联</div>
        <div class="layui-card-body">
            <form id="id_batchFrom" class="layui-form layui-form-pane" lay-filter="batchFrom">
                <table id="id_batchTable" lay-filter="batchTable"></table>
                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        <button class="layui-btn" lay-submit lay-filter="batchSubmit">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <%--所管理的设备--%>
    <div id="equipmentPanel" class="layui-card">
        <div class="layui-card-header">所管理设备</div>
        <div class="layui-card-body">
            <table id="id_equipmentTable" lay-filter="equipmentTable"></table>
        </div>
    </div>



</div>
<script src="js/jquery.js"></script>
<script src="layui/layui.all.js"></script>

<script>
    var beShowId = 0;

    // table操作
    layui.use('layer', function () {
        var table = layui.table;
        //第一个实例
        var tableIns = table.render({
            elem: '#id_mainTable'
            ,url: '/staff_list' //数据接口
            , title: '员工数据'//结合toolbar右侧导出功能
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
                {type: 'checkbox', width: 50, fixed: 'left'}// 全选： LAY_CHECKED: true , fixed: 'left'
                , {field: 'oid', title: 'ID',  sort: true}//, fixed: 'left'  width: 80,
                , {field: 'name', title: '姓名'}//,edit:'true' width: 80,
                ,{title: '操作',width: 200, toolbar: '#mainTool' ,fixed: 'right'}
            ]]
        });

        //监听表头工具栏的事件(传入table对象的filter)
        table.on('toolbar(mainTable)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'batch':
                    // 获取选中条数
                    var checkStatus = table.checkStatus('id_mainTable');
                    if (checkStatus.data.length == 0) {
                        layer.msg("请选中要进行关联的人员", {icon: 7});
                        return;
                    }


                    layui.use('table', function(){
                        var table = layui.table;

                        //第一个实例
                        table.render({
                            elem: '#id_batchTable'
                            ,height: 460
                            ,url: '/equipment_getAll' //数据接口
                            ,page: false //开启分页
                            ,cols: [[ //表头
                                 {type: 'checkbox', width: 50, fixed: 'left'}
                                ,{field: 'oid', title: 'ID', sort: true}
                                ,{field: 'name', title: '设备名'}
                            ]]
                        });

                    });
                    // 打开批量关联模态框
                    layer.open({
                        type: 1
                        , offset: '50px'
                        , title: false
                        , resize: false
                        , area: ['1200px', '600px']
                        , shade: [0.8, '#393D49']
                        , content: $('#batchPanel')
                    });
                    break;
            }
        });


        //监听列工具栏
        table.on('tool(mainTable)', function (obj) { //注：tool中是列工具栏所属table的filter
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if (layEvent === 'equipment') { //查看所管理的设备
                beShowId = obj.data.oid;

                table.render({
                    elem: '#id_equipmentTable'
                    ,height: 'full-210'
                    ,url: '/staff_showEquipment' //数据接口
                    ,where: {oid: obj.data.oid}
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
                    ,cols: [[ //表头
                        {field: 'oid', title: 'ID',  sort: true}
                        , {field: 'name', title: '名称'}
                        ,{title: '操作',width: 100, toolbar: '#glsbTool' ,fixed: 'right'}
                    ]]
                });
                layer.open({
                    type: 1
                    , offset: '50px'
                    , title: false
                    , resize: false
                    ,area: ['1200px', '600px']
                    , shade: [0.8, '#393D49']
                    , content: $('#equipmentPanel')
                });

            } else if(layEvent === 'relevance') { // 点击关联设备按钮
                beShowId = obj.data.oid;

                // 初始化relevanceTable数据表格，查询当前用户未关联设备
                layui.use('table', function(){
                    var table = layui.table;

                    //第一个实例
                    table.render({
                        elem: '#id_relevanceTable'
                        ,where: {oid: obj.data.oid}
                        ,height: 460
                        ,url: '/staff_getNotRelevance' //数据接口
                        ,page: false //开启分页
                        ,cols: [[ //表头
                            {type: 'checkbox', width: 50, fixed: 'left'}
                            ,{field: 'oid', title: 'ID', sort: true}
                            ,{field: 'name', title: '设备名'}
                        ]]
                    });

                });
                // 打开关联模态框
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

        //监听列工具栏
        table.on('tool(equipmentTable)', function (obj) { //注：tool中是列工具栏所属table的filter
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if (layEvent === 'glsb_delete') { //查看所管理的设备
                layer.msg(1);
                layer.confirm('确认要取消关联吗？', {icon: 3, title: '警告'}, function (index) {
                    // 获取选中项id
                    $.post("/staff_cancel",
                        {oid: beShowId,equipmentId:obj.data.oid},
                        function (data, status) {
                            if (data == 1) {
                                layer.msg("取消关联成功");
                                // 重载table数据
                                table.reload("id_equipmentTable");
                                // 关闭询问框
                                layer.close(index);
                            }
                        });

                });

            }
        });

    });

    // 表单模块
    layui.use('form', function(){
        var form = layui.form;

        form.on('submit(batchSubmit)', function(data){
            // 获取mainTable的选中项
            var checkStatus_mt = layui.table.checkStatus('id_mainTable');
            var staffIdArray = new Array();
            for (data_index in checkStatus_mt.data) {
                staffIdArray.push(checkStatus_mt.data[data_index].oid);
            }
            var staffIdsStr = staffIdArray.join(',');

            // 获取batchTable的选中项
            var checkStatus_bt = layui.table.checkStatus('id_batchTable');
            var equipmentIdArray = new Array();
            for (data_index in checkStatus_bt.data) {
                equipmentIdArray.push(checkStatus_bt.data[data_index].oid);
            }
            var equipmentIdsStr = equipmentIdArray.join(',');

            $.post("/staff_batch",
                { staffIds:staffIdsStr, equipmentIds:equipmentIdsStr },
                function (data, status) {
                    if (data == 1) {
                        layer.msg("关联成功");
                        layui.table.reload("id_batchTable");
                    }
                });
            return false; //false阻止表单跳转，不关闭窗口
        });



        form.on('submit(relevanceSubmit)', function(data){
            var staffIdsStr = beShowId;

            // 获取relevanceTable的选中项
            var checkStatus_rt = layui.table.checkStatus('id_relevanceTable');
            var equipmentIdArray = new Array();
            for (data_index in checkStatus_rt.data) {
                equipmentIdArray.push(checkStatus_rt.data[data_index].oid);
            }
            var equipmentIdsStr = equipmentIdArray.join(',');

            $.post("/staff_batch",
                { staffIds:staffIdsStr, equipmentIds:equipmentIdsStr },
                function (data, status) {
                    if (data == 1) {
                        layer.msg("关联成功");
                        layui.table.reload("id_relevanceTable");
                    }
                });
            return false; //false阻止表单跳转
        });

    });

</script>
</body>
</html>