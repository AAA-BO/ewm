<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>维护组管理</title>
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
            <button class="layui-btn layui-btn-sm" lay-event="addStaff">设置维护人员</button>
            <button class="layui-btn layui-btn-sm" lay-event="addEquipment">设置维护设备</button>
        </div>
    </script>
    <!--列工具栏-->
    <script type="text/html" id="mainTool">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="staff">该组人员</button>
            <button class="layui-btn layui-btn-sm" lay-event="equipment">该组设备</button>
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
                    <label class="layui-form-label">维护组名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">维护组说明</label>
                    <div class="layui-input-block">
                        <textarea name="info" rows="8" placeholder="请输入内容" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item" style="text-align: right;">
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
                        <input type="text" name="oid" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">维护组名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">维护组说明</label>
                    <div class="layui-input-block">
                        <textarea rows="8" name="info" placeholder="请输入内容" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item" style="text-align: right;">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="updateSubmit">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <%--该组人员--%>
    <div id="staffPanel" class="layui-card">
        <div class="layui-card-header">设置维护设备</div>
        <div class="layui-card-body">
            <form id="id_staffFrom" class="layui-form layui-form-pane">
                <table id="id_staffTable" lay-filter="staffTable"></table>
                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        <button class="layui-btn" lay-submit lay-filter="removeStaffSubmit">移除</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <%--该组设备--%>
    <div id="equipmentPanel" class="layui-card">
        <div class="layui-card-header">设置维护设备</div>
        <div class="layui-card-body">
            <form id="id_equipmentFrom" class="layui-form layui-form-pane">
                <table id="id_equipmentTable" lay-filter="equipmentTable"></table>
                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        <button class="layui-btn" lay-submit lay-filter="removeEquipmentSubmit">移除</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!--批量关联维护人员-->
    <div id="addStaffPanel" class="layui-card">
        <div class="layui-card-header">设置维护人员</div>
        <div class="layui-card-body">
            <form id="id_addStaffFrom" class="layui-form layui-form-pane">
                <table id="id_addStaffTable" lay-filter="addStaffTable"></table>
                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        <button class="layui-btn" lay-submit lay-filter="addStaffSubmit">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--批量关联维护设-->
    <div id="addEquipmentPanel" class="layui-card">
        <div class="layui-card-header">设置维护设备</div>
        <div class="layui-card-body">
            <form id="id_addEquipmentFrom" class="layui-form layui-form-pane">
                <table id="id_addEquipmentTable" lay-filter="addEquipmentTable"></table>
                <div class="layui-form-item" style="text-align: right">
                    <div class="layui-input-block">
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        <button class="layui-btn" lay-submit lay-filter="addEquipmentSubmit">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <%--生成二维码--%>
    <div id="qrcodePanel" class="layui-card">
        <div class="layui-card-header">二维码</div>
        <div class="layui-card-body">
            <%--<div id="id_qrcode" onclick="showQrcodeInfo(this);" style="text-align: center"></div>--%>
                <iframe id="id_qrcode" width="300px" height="425px" frameborder="0" style="margin-top: -135px" scrolling="no"></iframe>
        </div>
    </div>


</div>
<script src="js/jquery.js"></script>
<script src="layui/layui.all.js"></script>
<script src="js/qrcode.js"></script>

<script>
    var mainClickItemId = 0;

    // table操作
    layui.use('layer', function () {
        var table = layui.table;
        var tableIns = table.render({
            elem: '#id_mainTable'
            , url: '/maintainGroup_list'
            , title: '维护组数据'
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
                , {field: 'name', title: '维护组名称'}
                , {field: 'info', title: '维护组说明'}
                , {field: 'staffNumber', title: '维护员工数量'}
                , {field: 'equipmentNumber', title: '维护设备数量'}
                , {title: '操作', width: 310, toolbar: '#mainTool', fixed: 'right'}
            ]]
        });

        //监听表头工具栏的事件(传入table对象的filter)
        table.on('toolbar(mainTable)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'add':
                    // 打开添加模态框
                    layer.open({
                        type: 1
                        , offset: '50px'
                        , title: false
                        , resize: false
                        , shade: [0.8, '#393D49']
                        , area: ['600px', '400px']
                        , content: $('#addPanel')
                        , cancel: function (index, layero) {// 点击关闭按钮后回调
                            $("#id_addFrom")[0].reset();
                            return true;
                        }
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
                    layui.use('form', function () {
                        var form = layui.form;
                        form.val("updateFrom", checkStatus.data[0]);
                    });
                    // 显示模态框
                    layer.open({
                        type: 1
                        , offset: '50px'
                        , title: false
                        , area: ['600px', '400px']
                        , resize: false
                        , shade: [0.8, '#393D49']
                        , content: $('#updatePanel')
                        , cancel: function (index, layero) {
                            $("#id_updateFrom")[0].reset();
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

                        $.post("/maintainGroup_delete",
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
                case 'addStaff': //设置该组的维护人员
                    // 获取选中条数
                    var checkStatus = table.checkStatus('id_mainTable');
                    if (checkStatus.data.length == 0) {
                        layer.msg("请至少选中一行", {icon: 7});
                        return;
                    }

                    table.render({
                        elem: '#id_addStaffTable'
                        , height: 'full-210'
                        , url: '/staff_getAll' //数据接口
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
                        , cols: [[ //表头
                            {type: 'checkbox', width: 50, fixed: 'left'}
                            , {field: 'oid', title: 'ID', sort: true}
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
                            , {
                                title: '工地', templet: function (rowData) {
                                    if (rowData.site == null) {
                                        return "未设置";
                                    }
                                    return rowData.site.name;
                                }
                            }
                            , {field: 'phone', title: '手机'}
                        ]]
                    });

                    // 显示模态框
                    layer.open({
                        type: 1
                        , offset: '50px'
                        , title: false
                        , resize: false
                        , area: ['1200px', '655px']
                        , shade: [0.8, '#393D49']
                        , content: $('#addStaffPanel')
                    });
                    break;
                case 'addEquipment': //设置该组的设备
                    // 获取选中条数
                    var checkStatus = table.checkStatus('id_mainTable');
                    if (checkStatus.data.length == 0) {
                        layer.msg("请至少选中一行", {icon: 7});
                        return;
                    }

                    table.render({
                        elem: '#id_addEquipmentTable'
                        , height: 'full-210'
                        , url: '/equipment_getAll' //数据接口
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
                        , cols: [[ //表头
                            {type: 'checkbox', width: 50, fixed: 'left'}
                            , {field: 'oid', title: 'ID', sort: true}
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
                            , {
                                title: '工地', templet: function (rowData) {
                                    if (rowData.site == null) {
                                        return "未设置";
                                    }
                                    return rowData.site.name;
                                }
                            }

                            , {field: 'phone', title: '手机'}
                        ]]
                    });

                    // 显示模态框
                    layer.open({
                        type: 1
                        , offset: '50px'
                        , title: false
                        , resize: false
                        , area: ['1200px', '655px']
                        , shade: [0.8, '#393D49']
                        , content: $('#addEquipmentPanel')
                    });
                    break;
            }
        });


        //监听列工具栏
        table.on('tool(mainTable)', function (obj) { //注：tool中是列工具栏所属table的filter
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if (layEvent === 'staff') { //该组员工
                mainClickItemId = obj.data.oid;

                table.render({
                    elem: '#id_staffTable'
                    , height: 'full-210'
                    , url: '/maintainGroup_staff'
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
                    , cols: [[ //表头
                        {type: 'checkbox', width: 50, fixed: 'left'}
                        , {field: 'oid', title: 'ID', sort: true}
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
                        , {
                            title: '工地', templet: function (rowData) {
                                if (rowData.site == null) {
                                    return "未设置";
                                }
                                return rowData.site.name;
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
                    , area: ['1200px', '655px']
                    , shade: [0.8, '#393D49']
                    , content: $('#staffPanel')
                });
            } else if (layEvent === 'equipment') { //该组设备
                mainClickItemId = obj.data.oid;

                table.render({
                    elem: '#id_equipmentTable'
                    , height: 'full-210'
                    , url: '/maintainGroup_equipment' //数据接口
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
                    , cols: [[ //表头
                        {type: 'checkbox', width: 50, fixed: 'left'}
                        , {field: 'oid', title: 'ID', sort: true}
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
                    , area: ['1200px', '655px']
                    , shade: [0.8, '#393D49']
                    , content: $('#equipmentPanel')
                });
            } else if (layEvent === 'qrcode') {
                // 获取当前操行的oid
                showId = obj.data.oid;
                // $("#id_qrcode").empty();//清空子元素
                // var qrcode = new QRCode(document.getElementById("id_qrcode"), {
                //     width: 300,
                //     height: 300
                // });
                // qrcode.makeCode("/maintainGroup_phone_home?oid=" + showId);
                // // 生成二维码到panel
                // $("#id_qrcode").append("点击模拟扫描二维码");//清空子元素
                $("#id_qrcode").attr("src",'https://cli.im/api/qrcode/code?text=192.168.43.241:8080/maintainGroup_phone_home?oid='+showId+'&mhid=sELPDFnok80gPHovKdI" ')

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
    layui.use('form', function () {
        var form = layui.form;
        // 用于监听提交事件
        form.on('submit(addSubmit)', function (data) {
            $.post("/maintainGroup_add",
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

        form.on('submit(updateSubmit)', function (data) {
            $.post("/maintainGroup_update",
                data.field,
                function (data, status) {
                    if (data == 1) {
                        layer.msg("更新成功");
                        layui.table.reload("id_mainTable");
                    }
                });
            return false; //false阻止表单跳转
        });

        form.on('submit(addStaffSubmit)', function (data) {
            // 获取维护组的选中项
            var checkStatus_mt = layui.table.checkStatus('id_mainTable');
            var staffIdArray = new Array();
            for (var data_index in checkStatus_mt.data) {
                staffIdArray.push(checkStatus_mt.data[data_index].oid);
            }
            var maintainGroupIdsStr = staffIdArray.join(',');

            // 获取员工的选中项
            var checkStatus_bt = layui.table.checkStatus('id_addStaffTable');
            var equipmentIdArray = new Array();
            for (var data_index in checkStatus_bt.data) {
                equipmentIdArray.push(checkStatus_bt.data[data_index].oid);
            }
            var staffIdsStr = equipmentIdArray.join(',');

            $.post("/maintainGroup_addStaff",
                {maintainGroupIds: maintainGroupIdsStr, staffIds: staffIdsStr},
                function (data, status) {
                    if (data == 1) {
                        layer.msg("关联成功");
                        layui.table.reload("id_mainTable");
                        layui.table.reload("id_addStaffTable");
                    }
                });
            return false;
        });

        form.on('submit(addEquipmentSubmit)', function (data) {
            // 获取维护组的选中项
            var checkStatus_mt = layui.table.checkStatus('id_mainTable');
            var staffIdArray = new Array();
            for (var data_index in checkStatus_mt.data) {
                staffIdArray.push(checkStatus_mt.data[data_index].oid);
            }
            var maintainGroupIdsStr = staffIdArray.join(',');

            // 获取设备的选中项
            var checkStatus_bt = layui.table.checkStatus('id_addEquipmentTable');
            var equipmentIdArray = new Array();
            for (var data_index in checkStatus_bt.data) {
                equipmentIdArray.push(checkStatus_bt.data[data_index].oid);
            }
            var equipmentIdsStr = equipmentIdArray.join(',');

            $.post("/maintainGroup_addEquipment",
                {maintainGroupIds: maintainGroupIdsStr, equipmentIds: equipmentIdsStr},
                function (data, status) {
                    if (data == 1) {
                        layer.msg("关联成功");
                        layui.table.reload("id_mainTable");
                        layui.table.reload("id_addEquipmentTable");
                    }
                });
            return false;
        });

        form.on('submit(removeStaffSubmit)', function (data) {
            // 获取员工的选中项
            var checkStatus_bt = layui.table.checkStatus('id_staffTable');
            var equipmentIdArray = new Array();
            for (var data_index in checkStatus_bt.data) {
                equipmentIdArray.push(checkStatus_bt.data[data_index].oid);
            }
            var staffIdsStr = equipmentIdArray.join(',');

            $.post("/maintainGroup_remveStaff",
                {oid: mainClickItemId, staffIds: staffIdsStr},
                function (data, status) {
                    if (data == 1) {
                        layer.msg("移除成功");
                        layui.table.reload("id_mainTable");
                        layui.table.reload("id_staffTable");
                    }
                });
            return false;
        });

        form.on('submit(removeEquipmentSubmit)', function (data) {
            // 获取员工的选中项
            var checkStatus_bt = layui.table.checkStatus('id_equipmentTable');
            var equipmentIdArray = new Array();
            for (var data_index in checkStatus_bt.data) {
                equipmentIdArray.push(checkStatus_bt.data[data_index].oid);
            }
            var equipmentIdsStr = equipmentIdArray.join(',');

            $.post("/maintainGroup_remveEquipment",
                {oid: mainClickItemId, equipmentIds: equipmentIdsStr},
                function (data, status) {
                    if (data == 1) {
                        layer.msg("移除成功");
                        layui.table.reload("id_mainTable");
                        layui.table.reload("id_equipmentTable");
                    }
                });
            return false;
        });

    });

    // 点击模拟扫描二维码
    function showQrcodeInfo(obj) {
        window.open($(obj).attr("title"));
    }
</script>
</body>
</html>