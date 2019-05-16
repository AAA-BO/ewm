<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>工地管理</title>
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
                <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
                <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
                <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
            </div>
        </script>
        <!--列工具栏-->
        <script type="text/html" id="mainTool">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm" lay-event="staff">所有员工</button>
                <button class="layui-btn layui-btn-sm" lay-event="equipment">所有设备</button>
                <button class="layui-btn layui-btn-sm" lay-event="qrcode">生成二维码</button>
            </div>
        </script>
    </div>


<!--add & update 面板，利用绝对定位实现隐藏效果-->
<div style="position: absolute;top: -9999px;left: -9999px;">

    <!--add-->
    <div id="addPanel" class="layui-card">
        <div class="layui-card-header">添加</div>
        <div class="layui-card-body">
            <form id="id_addFrom" class="layui-form layui-form-pane"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">工地名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">工地信息</label>
                    <div class="layui-input-block">
                        <input type="text" name="info" placeholder="请输入" autocomplete="off" class="layui-input">
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
            <form id="id_updateFrom" class="layui-form layui-form-pane" lay-filter="updateFrom"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
                <div class="layui-form-item" hidden>
                    <label class="layui-form-label">ID</label>
                    <div class="layui-input-block">
                        <input type="text" name="oid" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">工地名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">工地信息</label>
                    <div class="layui-input-block">
                        <input type="text" name="info" placeholder="请输入" autocomplete="off" class="layui-input">
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
    </div>

    <%--所属维护人员--%>
    <div id="staffPanel" class="layui-card">
        <div class="layui-card-header">工地员工</div>
        <div class="layui-card-body">
            <table id="id_staffTable" lay-filter="staffTable"></table>
        </div>
    </div>

    <%--所有设备--%>
    <div id="equipmentPanel" class="layui-card">
        <div class="layui-card-header">工地设备</div>
        <div class="layui-card-body">
            <table id="id_equipmentTable" lay-filter="equipmentTable"></table>
        </div>
    </div>

    <%--生成二维码--%>
    <div id="qrcodePanel" class="layui-card">
        <div class="layui-card-header">二维码</div>
        <div class="layui-card-body">
            <%--<div id="id_qrcode" onclick="showQrcodeInfo(this);" style="text-align: center"></div>--%>
            <iframe id="id_qrcode" width="300px" height="425px" frameborder="0" style="margin-top: -135px" scrolling="no"></iframe>
            <%--<div id="id_qrcode" onclick="showQrcodeInfo(this);" style="text-align: center"></div>--%>
        </div>
    </div>


</div>
<script src="js/jquery.js"></script>
<script src="layui/layui.all.js"></script>
<script src="js/qrcode.js"></script>

<script>
    // table操作
    layui.use('layer', function () {
        var table = layui.table;
        //第一个实例
        var tableIns = table.render({
            elem: '#id_mainTable'
            ,url: '/site_list' //数据接口
            , title: '设备数据'//结合toolbar右侧导出功能
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
                {type: 'checkbox', width: 50, fixed: 'left'}
                , {field: 'oid', title: 'ID',  sort: true,hide:true}
                , {field: 'name', title: '工地名'}
                , {field: 'info', title: '工地信息'}
                , {field: 'staffNumber', title: '员工数量'}
                , {field: 'equipmentNumber', title: '设备数量'}
                ,{title: '操作',width: 260, toolbar: '#mainTool' ,fixed: 'right'}
            ]]
        });

        //监听表头工具栏的事件(传入table对象的filter)
        table.on('toolbar(mainTable)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'add':
                    // 初始化form模块
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
                        , shade: [0.8, '#393D49']
                        , content: $('#addPanel')
                        ,cancel: function(index, layero){// 点击关闭按钮后回调
                            $("#id_addFrom")[0].reset();
                            return true;
                        }
                    });

                    break;
                case 'delete':
                    // 获取选中条数
                    var checkStatus = table.checkStatus('id_mainTable');
                    console.log(checkStatus.data);
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

                        $.post("/site_delete",
                            {ids: deleteIdsStr},
                            function (data, status) {
                                if (data == 1) {
                                    layer.msg("删除成功");
                                    // 重载table数据
                                    tableIns.reload();
                                }
                            });
                        // 关闭询问框
                        layer.close(index);
                    });


                    break;
                case 'update':
                    // 获取选中行数据
                    var checkStatus = table.checkStatus('id_mainTable');
                    if (checkStatus.data.length != 1) {
                        layer.msg("请选中一行数据", {icon: 7});
                        return;
                    }
                    // 获取选中行的数据，填充数据到模态框 form.val
                    layui.use('form', function() {
                        var form = layui.form;
                        form.val("updateFrom",checkStatus.data[0]);
                    });

                    // 显示模态框
                    layer.open({
                        type: 1
                        , offset: '50px'
                        , title: false
                        , resize: false
                        , shade: [0.8, '#393D49']
                        , content: $('#updatePanel')
                    });
                    break;
            }
            ;
        });

        //监听列工具栏
        table.on('tool(mainTable)', function (obj) { //注：tool中是列工具栏所属table的filter
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if (layEvent === 'staff') { //工地员工
                table.render({
                    elem: '#id_staffTable'
                    ,height: 'full-210'
                    ,url: '/site_staff' //数据接口
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
                    ,cols: [[ //表头
                        {field: 'oid', title: 'ID',  sort: true}
                        , {field: 'name', title: '姓名'}
                        , {field: 'username', title: '账户'}
                        , {
                            field: 'department', title: '部门', templet: function (rowData) {
                                if (rowData.department == null || rowData.department == "") {
                                    return "未设置";
                                }
                                return rowData.department;
                            }
                        }
                        , {field: 'phone', title: '手机'}
                    ]]
                });
                layer.open({
                    type: 1
                    , offset: '50px'
                    , title: false
                    , resize: false
                    ,area: ['1200px', '600px']
                    , shade: [0.8, '#393D49']
                    , content: $('#staffPanel')
                });
            }else if (layEvent === 'equipment') { //工地设备
                table.render({
                    elem: '#id_equipmentTable'
                    ,height: 'full-210'
                    ,url: '/site_equipment' //数据接口
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
                    ,cols: [[ //表头
                        {field: 'oid', title: 'ID'}
                        , {field: 'name', title: '设备名称'}
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
            }else if (layEvent === 'qrcode') {
                // 获取当前操行的oid
                showId = obj.data.oid;
                // $("#id_qrcode").empty();//清空子元素
                // var qrcode = new QRCode(document.getElementById("id_qrcode"), {
                //     width : 300,
                //     height : 300
                // });
                // qrcode.makeCode("/site_phone_home?oid="+showId);
                // // 生成二维码到panel

                // var ewm = '<img src="//qr.api.cli.im/qr?data=qwer&amp;level=H&amp;transparent=0&amp;bgcolor=%23FFFFFF&amp;forecolor=images%2Fforecolor%2F34.png&amp;background=images%2Fbackground%2Fbg5.png&amp;blockpixel=12&amp;marginblock=2&amp;logourl=&amp;size=400&amp;text=&amp;logoshape=no&amp;fontsize=30&amp;fontfamily=msyh.ttf&amp;fontcolor=&amp;incolor=&amp;outcolor=&amp;qrcode_eyes=&amp;wper=0.7&amp;hper=0.7&amp;tper=0.15&amp;lper=0.15&amp;eye_use_fore=1&amp;qrpad=10&amp;kid=cliim&amp;time=1557193121&amp;key=82cd3c99ec195e8f91fedf4292ac0678" id="qrcode_plugins_img" class="qrcode_plugins_img" style="background: rgb(255, 255, 255); width: 300px; display: inline-block; min-height: 300px;" date-qrid="245125">';
                // $("#id_qrcode").html(ewm);
                // $("#id_qrcode").append("点击更换二维码样式");//清空子元素
                $("#id_qrcode").attr("src",'https://cli.im/api/qrcode/code?text=192.168.43.241:8080/site_phone_home?oid='+showId+'&mhid=sELPDFnok80gPHovKdI" ')

                layer.open({
                    type: 1
                    , offset: '50px'
                    , title: false
                    , resize: false
                    ,area: ['330px', '360px']
                    , shade: [0.8, '#393D49']
                    , content: $('#qrcodePanel')
                });
            }
        });



    });

    // 表单模块
    layui.use('form', function(){
        var form = layui.form;
        // 用于监听提交事件
        form.on('submit(addSubmit)', function(data){
            $.post("/site_add",
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

        form.on('submit(updateSubmit)', function(data){
            $.post("/site_update",
                data.field,
                function (data, status) {
                    if (data == 1) {
                        layer.msg("更新成功");
                        layui.table.reload("id_mainTable");
                    }
                });
            return false; //false阻止表单跳转
        });

    });

    // 点击模拟扫描二维码
    function showQrcodeInfo(obj) {
        window.open($(obj).attr("title"));
    }
</script>
</body>
</html>