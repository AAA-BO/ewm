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
    <%--搜索框--%>
    <div class="search">
        维护人员\账户\手机号：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="search_staff_id" autocomplete="off">
        </div>
        维护设备：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="search_equipment_id" autocomplete="off">
        </div>
        时间范围：
        <div class="layui-inline">
            <input id="begin" type="text" class="layui-input" name="id" id="search_time_begin_id" autocomplete="off">
        </div>
        -
        <div class="layui-inline">
            <input id="end" type="text" class="layui-input" name="id" id="search_time_end_id" autocomplete="off">
        </div>
        维护信息：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="search_info_id" autocomplete="off">
        </div>
        <button class="layui-btn" id="search_btn_id">搜索</button>
    </div>

    <!-- 内容主体区域 -->
    <!--table-->
    <div>
        <!--tab内容-->
        <table id="id_mainTable" lay-filter="mainTable"></table>

        <!--表头工具栏-->
        <script type="text/html" id="mainToolbar">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
            </div>
        </script>
        <!--列工具栏-->
        <script type="text/html" id="mainTool">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm" lay-event="xiangqing">维护详情</button>
            </div>
        </script>
    </div>


<!--add & update 面板，利用绝对定位实现隐藏效果-->
<div style="position: absolute;top: -9999px;left: -9999px;">

    <%--所管理的设备--%>
    <div id="xiangqingPanel" class="layui-card">
        <div class="layui-card-header">维护信息详情</div>
        <div class="layui-card-body">
            <table id="id_xiangqingTable" lay-filter="xiangqingTable" class="layui-table">
                <tbody id="id_xiangqing_body">
                </tbody>
            </table>
        </div>
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
                , {field: 'oid', title: 'ID',  sort: true,hide: true}
                , {title: '维护人员', templet: function(rowData){
                            return rowData.staff.name;
                   }}
                , {title: '账户', templet: function (rowData) {
                        return rowData.staff.username;
                    }}
                , {
                    title: '部门', templet: function (rowData) {
                        if (rowData.staff.department == null || rowData.staff.department == "") {
                            return "未设置";
                        }
                        return rowData.staff.department;
                    }
                }
                , { title: '员工所在工地', templet: function (rowData) {
                        if (rowData.staff.site == null) {
                            return "未设置";
                        }
                        return rowData.staff.site.name;
                    }
                }
                , {title: '手机', templet: function (rowData) {
                        return rowData.staff.phone;
                    }}
                , {title: '维护设备', templet: function(rowData){
                        return rowData.equipment.name;
                   }}
                , { title: '设备所在工地', templet: function (rowData) {
                        if (rowData.equipment.site == null) {
                            return "未设置";
                        }
                        return rowData.equipment.site.name;
                    }
                }
                , { title: '维护时间',width: 200, templet: function(rowData){
                        return new Date(rowData.date.time).toLocaleString();
                    }}
                , {field: 'info',width: 400, title: '概要信息'}
                ,{title: '操作', width: 100, toolbar: '#mainTool' ,fixed: 'right'}
            ]]
        });

        //监听表头工具栏的事件(传入table对象的filter)
        table.on('toolbar(mainTable)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
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

            if (layEvent === 'xiangqing') { //查看所管理的设备
                // id_xiangqing_body
                $.post("/record_xiangqing",
                    {oid: data.oid},
                    function (data, status) {
                        console.log(data);
                        if (data != null) {
                            $.each(data,function(key,value){
                                $("#id_xiangqing_body").append('<tr><td>'+key+'</td><td>'+value+'</td></tr>');
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
                    , content: $('#xiangqingPanel')
                });
            }
        });
    });



    $('#search_btn_id').on('click', function(){
        // 维护人员\账户\手机号：
        // 维护设备：
        // 维护时间：
        // 维护信息：
        var staff = $("#search_staff_id").val();
        var equipment = $("#search_equipment_id").val();
        var time_begin = $("#begin").val();
        var time_end = $("#end").val();
        var info = $("#search_info_id").val();
        layui.table.reload('id_mainTable', {
            url: '/record_search'
            ,where: {
                search_staffData:staff,
                search_equipmentData:equipment,
                search_time_begin:time_begin,
                search_time_end:time_end,
                search_info:info
            }
        });

    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#begin'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#end'
            ,type: 'datetime'
        });
    });



</script>
</body>
</html>