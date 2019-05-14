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
            <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
            <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
            <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
            <button class="layui-btn layui-btn-sm" lay-event="tongji">维护次数一周统计图</button>
        </div>
    </script>
    <!--列工具栏-->
    <script type="text/html" id="mainTool">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="equipment">查看管理设备</button>
            <button class="layui-btn layui-btn-sm" lay-event="record">查看维护记录</button>
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
            <form id="id_addFrom" class="layui-form layui-form-pane">
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off"
                               class="layui-input" lay-verify="required">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">账户</label>
                    <div class="layui-input-block">
                        <input type="text" name="username" placeholder="请输入" autocomplete="off"
                               class="layui-input" lay-verify="required|username">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input type="text" name="password" placeholder="请输入" autocomplete="off"
                               class="layui-input" lay-verify="required|password">
                    </div>
                </div>
                <%--新加字段--%>
                <div class="layui-form-item" pane>
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                        <input type="radio" name="sex" value="男" title="男" checked>
                        <input type="radio" name="sex" value="女" title="女">
                    </div>
                </div>
                <div class="layui-form-item" pane>
                    <label class="layui-form-label">年龄</label>
                    <div class="layui-input-block">
                        <input type="number" name="age" placeholder="请输入" autocomplete="off"
                               class="layui-input" lay-verify="required">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">工地</label>
                    <div class="layui-input-block">
                        <select name="site.oid" id="site_select_add_id">
                            <option value=""></option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">部门</label>
                    <div class="layui-input-block">
                        <select name="department" id="department_select_add_id">
                            <option value=""></option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item" pane>
                    <label class="layui-form-label">职称</label>
                    <div class="layui-input-block" id="zhicheng_div_add_id">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">手机</label>
                    <div class="layui-input-block">
                        <input type="tel" name="phone" placeholder="请输入" autocomplete="off"
                               class="layui-input" lay-verify="required|phone">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-input-block">
                        <input type="email" name="email" placeholder="请输入" autocomplete="off"
                               class="layui-input" lay-verify="email">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">头像</label>
                    <div class="layui-input-block">
                        <button type="button" class="layui-btn" id="upload_add">
                            <i class="layui-icon">&#xe67c;</i>上传图片
                        </button>
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
                        <input type="text" name="oid" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input"
                               lay-verify="required">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">账户</label>
                    <div class="layui-input-block">
                        <input type="text" name="username" placeholder="请输入" autocomplete="off" class="layui-input"
                               lay-verify="required|username">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input type="text" name="password" placeholder="请输入" autocomplete="off" class="layui-input"
                               lay-verify="required|password">
                    </div>
                </div>
                <%--新加字段--%>
                <div class="layui-form-item" pane>
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                        <input type="radio" name="sex" value="男" title="男" checked>
                        <input type="radio" name="sex" value="女" title="女">
                    </div>
                </div>
                <div class="layui-form-item" pane>
                    <label class="layui-form-label">年龄</label>
                    <div class="layui-input-block">
                        <input type="number" name="age" placeholder="请输入" autocomplete="off" class="layui-input"
                               lay-verify="required">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">工地</label>
                    <div class="layui-input-block">
                        <select name="site.oid" id="site_select_update_id">
                            <option value=""></option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">部门</label>
                    <div class="layui-input-block">
                        <select name="department" id="department_select_update_id">
                            <option value=""></option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item" pane>
                    <label class="layui-form-label">职称</label>
                    <div class="layui-input-block" id="zhicheng_div_update_id">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">手机</label>
                    <div class="layui-input-block">
                        <input type="tel" name="phone" placeholder="请输入" autocomplete="off" class="layui-input"
                               lay-verify="required|phone">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-input-block">
                        <input type="email" name="email" placeholder="请输入" autocomplete="off" class="layui-input"
                               lay-verify="email">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">头像</label>
                    <div class="layui-input-block">
                        <button type="button" class="layui-btn" id="upload_update">
                            <i class="layui-icon">&#xe67c;</i>上传图片
                        </button>
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

    <%--所管理的设备--%>
    <div id="equipmentPanel" class="layui-card">
        <div class="layui-card-header">所管理设备</div>
        <div class="layui-card-body">
            <table id="id_equipmentTable" lay-filter="equipmentTable"></table>
        </div>
    </div>

    <%--维护记录--%>
    <div id="recordPanel" class="layui-card">
        <div class="layui-card-header">维护记录</div>
        <div class="layui-card-body">
            <table id="id_recordTable" lay-filter="recordTable"></table>
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

    <%--统计图--%>
    <div id="tongjiPanel" class="layui-card">
        <div class="layui-card-header">统计图</div>
        <div class="layui-card-body">
            <%--<div class="layui-form">

            </div>--%>
            <div id="container" style="height: 600px"></div>
        </div>
    </div>


</div>
<script src="js/jquery.js"></script>
<script src="layui/layui.all.js"></script>
<script src="js/qrcode.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>

<script>
    var showId = 0;

    // table操作
    layui.use('layer', function () {
        var table = layui.table;
        //第一个实例
        var tableIns = table.render({
            elem: '#id_mainTable'
            , url: '/staff_list' //数据接口
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
            , limits: [1, 2, 10, 20]
            , cols: [[ //表头
                {type: 'checkbox', width: 50, fixed: 'left'}// 全选： LAY_CHECKED: true
                , {field: 'oid', title: 'ID', sort: true, hide: true}
                , {field: 'name', title: '姓名'}
                , {field: 'username', title: '账户'}
                , {field: 'password', title: '密码', hide: true}
                , {
                    title: '性别', templet: function (rowData) {
                        switch (rowData.sex) {
                            case "":
                                return "未设置";
                                break;
                            default:
                                return rowData.sex;
                        }
                    }
                }
                , {field: 'age', title: '年龄'}
                , {
                    title: '工地', templet: function (rowData) {
                        if (rowData.site == null) {
                            return "未设置";
                        }
                        return rowData.site.name;
                    }
                }
                , {
                    field: 'department', title: '部门', templet: function (rowData) {
                        if (rowData.department == null || rowData.department == "") {
                            return "未设置";
                        }
                        return rowData.department;
                    }
                }
                , {
                    field: 'zhicheng', title: '职称', templet: function (rowData) {
                        if (rowData.zhicheng == null || rowData.zhicheng == "") {
                            return "未设置";
                        }
                        return rowData.zhicheng;
                    }
                }
                , {field: 'phone', title: '手机'}
                , {field: 'email', title: '邮箱', hide: true}
                , {field: 'image', title: '头像', hide: true}
                , {title: '操作', width: 320, toolbar: '#mainTool', fixed: 'right'}
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
                        // 异步加载，使用ajax加载所有工地数据
                        $.post("/site_list",
                            function (data, status) {
                                if (data != null) {
                                    data.data.forEach(function (o, i) {
                                        $("#site_select_add_id").append('<option value="' + o.oid + '">' + o.name + '</option>');
                                        form.render();
                                    });
                                }
                            });
                        // 从数据字典加载部门数据
                        $.post("/dictionaries_getByType",
                            {type: '部门'},
                            function (data, status) {
                                if (data != null) {
                                    data.data.forEach(function (item, i) {
                                        $("#department_select_add_id").append('<option value="' + item.value + '">' + item.value + '</option>');
                                        form.render();
                                    });
                                }
                            });
                        // 从数据字典加载职称数据
                        $.post("/dictionaries_getByType",
                            {type: '职称'},
                            function (data, status) {
                                if (data != null) {
                                    data.data.forEach(function (item, i) {
                                        $("#zhicheng_div_add_id").append('<input type="checkbox" lay-skin="primary" name="zhicheng_' + item.value + '" title="' + item.value + '">');
                                        form.render();
                                    });
                                }
                            });
                    });


                    // 打开添加模态框
                    layer.open({
                        type: 1
                        , offset: '25px'
                        , title: false
                        , resize: false
                        , area: ['1000px', '680px']
                        , shade: [0.8, '#393D49']
                        , content: $('#addPanel')
                        // 表单在关闭时,要清除其中的
                        // 1.输入值
                        // 2.选择项
                        // 3.后来添加的DOM元素
                        , cancel: function (index, layero) {
                            // 清除1.输入值	2.选择项可以用重置表单实现
                            // 重置表单就是把表单中的所有输入、选择重置为表单默认。不会删除后来添加的DOM节点!
                            $("#id_addFrom")[0].reset();
                            // 清除3.后来添加的DOM元素就需要操作DOM元素进行删除
                            $("#site_select_add_id").html('<option value=""></option>');
                            // 清除从数据字典查询的部门数据和职称数据
                            $("#department_select_add_id").html('<option value=""></option>');
                            $("#zhicheng_div_add_id").html('<option value=""></option>');

                            return true;
                        }
                    });
                    break;

                case 'update':
                    // 判断是否只选中一行
                    var checkStatus = table.checkStatus('id_mainTable');
                    if (checkStatus.data.length != 1) {
                        layer.msg("请选中一行数据", {icon: 7});
                        return;
                    }

                    layui.use('form', function () {
                        var form = layui.form;
                        // 发送同步请求，获取工地数据
                        $.ajax({
                            async: false
                            , url: "/site_list"
                            , success: function (data, status) {
                                if (data != null) {
                                    data.data.forEach(function (o, i) {
                                        // 将工地数据加入DOM
                                        $("#site_select_update_id").append('<option value="' + o.oid + '">' + o.name + '</option>');
                                    });
                                }
                            }
                        });

                        // 同步请求,从数据字典加载部门数据
                        $.ajax({
                            async: false
                            , url: "/dictionaries_getByType"
                            , data: {type: '部门'}
                            , success: function (data, status) {
                                if (data != null) {
                                    data.data.forEach(function (item, i) {
                                        $("#department_select_update_id").append('<option value="' + item.value + '">' + item.value + '</option>');
                                        form.render();
                                    });
                                }
                            }
                        });
                        // 同步请求,从数据字典加载职称数据
                        $.ajax({
                            async: false
                            , url: "/dictionaries_getByType"
                            , data: {type: '职称'}
                            , success: function (data, status) {
                                if (data != null) {
                                    data.data.forEach(function (item, i) {
                                        $("#zhicheng_div_update_id").append('<input type="checkbox" lay-skin="primary" name="zhicheng_' + item.value + '" title="' + item.value + '">');
                                        form.render();
                                    });
                                }
                            }
                        });

                        // 调整选中行数据的格式，使其能正确回显
                        var data = checkStatus.data[0];
                        //职称
                        var zhicheng = checkStatus.data[0].zhicheng;
                        if (checkStatus.data[0].zhicheng != "") {
                            $.each(checkStatus.data[0].zhicheng.split(','), function (i, item) {
                                data['zhicheng_' + item] = true;
                            });
                        }
                        // 工地
                        if (checkStatus.data[0].site != null) {
                            data["site.oid"] = checkStatus.data[0].site.oid;
                        }

                        form.val("updateFrom", data);

                        // 重新渲染表单
                        form.render();

                    });

                    // 显示模态框
                    layer.open({
                        type: 1
                        , offset: '25px'
                        , title: false
                        , resize: false
                        , area: ['1200px', '680px']
                        , shade: [0.8, '#393D49']
                        , content: $('#updatePanel')
                        , cancel: function (index, layero) {
                            $("#id_updateFrom")[0].reset();
                            // 清除3.后来添加的DOM元素就需要操作DOM元素进行删除
                            $("#site_select_update_id").html('<option value=""></option>');
                            // 清除从数据字典查询的部门数据和职称数据
                            $("#department_select_update_id").html('<option value=""></option>');
                            $("#zhicheng_div_update_id").html('<option value=""></option>');
                            return true;
                        }
                    });
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
                        for (var data_index in checkStatus.data) {
                            deleteIds.push(checkStatus.data[data_index].oid);
                        }
                        var deleteIdsStr = deleteIds.join(',');

                        $.post("/staff_delete",
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
                case 'tongji':
                    // 获取选中条数
                    var checkStatus = table.checkStatus('id_mainTable');
                    if (checkStatus.data.length == 0) {
                        layer.msg("请选中要查看统计数据的人员", {icon: 7});
                        return;
                    }

                    // 显示模态框
                    layer.open({
                        type: 1
                        , offset: '25px'
                        , title: false
                        , resize: false
                        , area: ['1600px', '665px']
                        , shade: [0.8, '#393D49']
                        , content: $('#tongjiPanel')
                        , cancel: function (index, layero) {
                            return true;
                        }
                    });

                    // 准备请求参数
                    var benginDate = new Date();//从某一天开始
                    var excursionDayNumber = 7;// 向前n天
                    var selectIdArray = new Array();// 获取选中员工id
                    for (var data_index in checkStatus.data) {
                        selectIdArray.push(checkStatus.data[data_index].oid);
                    }
                    var selectIdsStr = selectIdArray.join(',');


                    // 生成横向文字
                    var legendArray = new Array();
                    for (var i = 1; i <= excursionDayNumber; i++) {
                        legendArray.push(getDateString(addDay(benginDate, -i)));
                    }
                    legendArray.reverse();//反转数组元素位置

                    // 发送请求
                    $.post("/record_tongji",
                        {
                            ids: selectIdsStr
                            , benginDateTime: benginDate.getTime()
                            , excursionDayNumber: excursionDayNumber
                        },
                        function (rdata, status) {
                            console.log(rdata);
                            if (rdata != null) {
                                // 获取选中员工name 构建展示数据对象数组
                                var selectNameArray = new Array();
                                var dataArray = new Array();
                                for (var data_index in checkStatus.data) {
                                    var name = checkStatus.data[data_index].name;
                                    selectNameArray.push(name);
                                    var onedata = new Object();
                                    onedata.name = name;
                                    onedata.type = 'line';
                                    // var onedataDataArray = new Array();
                                    // $.each(legendArray, function (item, index) {
                                    //     onedataDataArray.push(Math.floor(Math.random() * 10));
                                    // });
                                    // onedata.data = onedataDataArray;
                                    onedata.data = rdata[checkStatus.data[data_index].oid];
                                    dataArray.push(onedata)
                                }


                                var dom = document.getElementById("container");
                                var myChart = echarts.init(dom);
                                var app = {};
                                option = null;
                                option = {
                                    title: {
                                        text: '折线图堆叠'
                                    },
                                    tooltip: {
                                        trigger: 'axis'
                                    },
                                    legend: {
                                        data: selectNameArray
                                    },
                                    grid: {
                                        left: '3%',
                                        right: '4%',
                                        bottom: '3%',
                                        containLabel: true
                                    },
                                    toolbox: {
                                        feature: {
                                            saveAsImage: {}
                                        }
                                    },
                                    xAxis: {
                                        type: 'category',
                                        boundaryGap: false,
                                        data: legendArray
                                    },
                                    yAxis: {
                                        type: 'value'
                                    },
                                    series: dataArray
                                };
                                if (option && typeof option === "object") {
                                    myChart.setOption(option, true);
                                }
                            }
                        }
                    );
                    break;
            }
        });

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
            } else if (layEvent === 'qrcode') {
                // 获取当前操行的oid
                showId = obj.data.oid;
                // $("#id_qrcode").empty();//清空子元素
                // var qrcode = new QRCode(document.getElementById("id_qrcode"), {
                //     width: 300,
                //     height: 300
                // });
                // qrcode.makeCode("/staff_phone_showQrcode?oid=" + showId);
                $("#id_qrcode").attr("src",'https://cli.im/api/qrcode/code?text=192.168.43.241:8080/staff_phone_showQrcode?oid='+showId+'&mhid=sELPDFnok80gPHovKdI" ')


                // 生成二维码到panel
                // $("#id_qrcode").append("点击模拟扫描二维码");//清空子元素

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
        form.verify({
            username: function (value, item) { //value：表单的值、item：表单的DOM对象
                if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                    return '账户不能有特殊字符';
                }
                if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                    return '用户名首尾不能出现下划线\'_\'';
                }
                if (/^\d+\d+\d$/.test(value)) {
                    return '账户不能全为数字';
                }
            }

            //我们既支持上述函数式的方式，也支持下述数组的形式
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            , password: [
                /^[\S]{3,12}$/
                , '密码必须3到12位，且不能出现空格'
            ]
        });

        // 用于监听提交事件
        form.on('submit(addSubmit)', function (data) {
            $.post("/staff_add",
                data.field,
                function (data, status) {
                    if (data == 1) {
                        layer.msg("添加成功");
                        $("#id_addFrom")[0].reset();
                        layui.table.reload("id_mainTable");
                    } else if (data == 2) {
                        layer.msg("账户已存在");
                    }
                });

            return false; //false阻止表单跳转
        });

        form.on('submit(updateSubmit)', function (data) {
            $.post("/staff_update",
                data.field,
                function (data, status) {
                    if (data == 1) {
                        layer.msg("修改成功");
                        layui.table.reload("id_mainTable");
                    } else if (data == 2) {
                        layer.msg("账户已存在");
                    }
                });
            return false; //false阻止表单跳转
        });

    });

    // 点击模拟扫描二维码
    function showQrcodeInfo(obj) {
        window.open($(obj).attr("title"));
    }

    // 获取date n天后的时间
    function addDay(date, n) {
        return new Date(date.getTime() + (1000 * 60 * 60 * 24 * n))
    }

    // 获取日期字符串，格式年/月/日
    function getDateString(date) {
        return date.toLocaleString().split(" ")[0];
    }

</script>
</body>
</html>