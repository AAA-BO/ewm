/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-14 12:50:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("    <title>员工管理</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"layui/css/layui.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"layui-layout-body\">\r\n");
      out.write("\r\n");
      out.write("    <!-- 内容主体区域 -->\r\n");
      out.write("    <!--table-->\r\n");
      out.write("    <div>\r\n");
      out.write("        <!--tab内容-->\r\n");
      out.write("        <table id=\"id_mainTable\" lay-filter=\"mainTable\"></table>\r\n");
      out.write("\r\n");
      out.write("        <!--表头工具栏-->\r\n");
      out.write("        <script type=\"text/html\" id=\"mainToolbar\">\r\n");
      out.write("            <div class=\"layui-btn-container\">\r\n");
      out.write("                <button class=\"layui-btn layui-btn-sm\" lay-event=\"add\">添加</button>\r\n");
      out.write("                <button class=\"layui-btn layui-btn-sm\" lay-event=\"update\">编辑</button>\r\n");
      out.write("                <button class=\"layui-btn layui-btn-sm\" lay-event=\"delete\">删除</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </script>\r\n");
      out.write("        <!--列工具栏-->\r\n");
      out.write("        <script type=\"text/html\" id=\"mainTool\">\r\n");
      out.write("            <div class=\"layui-btn-container\">\r\n");
      out.write("                <button class=\"layui-btn layui-btn-sm\" lay-event=\"equipment\">查看管理设备</button>\r\n");
      out.write("                <button class=\"layui-btn layui-btn-sm\" lay-event=\"record\">查看维护记录</button>\r\n");
      out.write("                <button class=\"layui-btn layui-btn-sm\" lay-event=\"qrcode\">生成二维码</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </script>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--add & update 面板，利用绝对定位实现隐藏效果-->\r\n");
      out.write("<div style=\"position: absolute;top: -9999px;left: -9999px;\">\r\n");
      out.write("\r\n");
      out.write("    <!--add-->\r\n");
      out.write("    <div id=\"addPanel\" class=\"layui-card\">\r\n");
      out.write("        <div class=\"layui-card-header\">添加</div>\r\n");
      out.write("        <div class=\"layui-card-body\">\r\n");
      out.write("            <form id=\"id_addFrom\" class=\"layui-form layui-form-pane\"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">账户</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"text\" name=\"username\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">密码</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"text\" name=\"password\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">姓名</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"text\" name=\"name\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-form-item\" style=\"text-align: right\">\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("                        <button class=\"layui-btn\" lay-submit lay-filter=\"addSubmit\">确定</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!--update-->\r\n");
      out.write("    <div id=\"updatePanel\" class=\"layui-card\">\r\n");
      out.write("        <div class=\"layui-card-header\">更新</div>\r\n");
      out.write("        <div class=\"layui-card-body\">\r\n");
      out.write("            <form id=\"id_updateFrom\" class=\"layui-form layui-form-pane\" lay-filter=\"updateFrom\"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->\r\n");
      out.write("                <div class=\"layui-form-item\" hidden>\r\n");
      out.write("                    <label class=\"layui-form-label\">ID</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"text\" name=\"oid\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">账户</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"text\" name=\"username\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">密码</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"text\" name=\"password\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">姓名</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"text\" name=\"name\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-form-item\" style=\"text-align: right\">\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("                        <button class=\"layui-btn\" lay-submit lay-filter=\"updateSubmit\">确定</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <div id=\"equipmentPanel\" class=\"layui-card\">\r\n");
      out.write("        <div class=\"layui-card-header\">所管理设备</div>\r\n");
      out.write("        <div class=\"layui-card-body\">\r\n");
      out.write("            <table id=\"id_equipmentTable\" lay-filter=\"equipmentTable\"></table>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <div id=\"recordPanel\" class=\"layui-card\">\r\n");
      out.write("        <div class=\"layui-card-header\">维护记录</div>\r\n");
      out.write("        <div class=\"layui-card-body\">\r\n");
      out.write("            <table id=\"id_recordTable\" lay-filter=\"recordTable\"></table>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <div id=\"qrcodePanel\" class=\"layui-card\">\r\n");
      out.write("        <div class=\"layui-card-header\">二维码</div>\r\n");
      out.write("        <div class=\"layui-card-body\">\r\n");
      out.write("            <div id=\"id_qrcode\" onclick=\"showQrcodeInfo(this);\" style=\"text-align: center\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"js/jquery.js\"></script>\r\n");
      out.write("<script src=\"layui/layui.all.js\"></script>\r\n");
      out.write("<script src=\"js/qrcode.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    var showId = 0;\r\n");
      out.write("\r\n");
      out.write("    // table操作\r\n");
      out.write("    layui.use('layer', function () {\r\n");
      out.write("        var table = layui.table;\r\n");
      out.write("        //第一个实例\r\n");
      out.write("        var tableIns = table.render({\r\n");
      out.write("            // id:'maintable'\r\n");
      out.write("            elem: '#id_mainTable'\r\n");
      out.write("            ,url: '/staff_list' //数据接口\r\n");
      out.write("            , title: '员工数据'//结合toolbar右侧导出功能\r\n");
      out.write("            , toolbar: '#mainToolbar'\r\n");
      out.write("            , initSort: {\r\n");
      out.write("                field: 'oid'\r\n");
      out.write("                , type: 'asc'\r\n");
      out.write("            }\r\n");
      out.write("            , text: {\r\n");
      out.write("                none: '暂无相关数据' //默认：无数据。\r\n");
      out.write("            }\r\n");
      out.write("            , skin: 'line' //行边框风格\r\n");
      out.write("            , even: true //开启隔行背景\r\n");
      out.write("            , size: 'lg' //大尺寸的表格\r\n");
      out.write("            , page: true //开启分页\r\n");
      out.write("            ,limits:[1,2,10,20]\r\n");
      out.write("            , cols: [[ //表头\r\n");
      out.write("                {type: 'checkbox', width: 50, fixed: 'left'}// 全选： LAY_CHECKED: true , fixed: 'left'\r\n");
      out.write("                , {field: 'oid', title: 'ID',  sort: true}//, fixed: 'left'  width: 80,\r\n");
      out.write("                , {field: 'username', title: '账户'}\r\n");
      out.write("                , {field: 'password', title: '密码'}\r\n");
      out.write("                , {field: 'name', title: '姓名'}\r\n");
      out.write("                ,{title: '操作',width: 320, toolbar: '#mainTool' ,fixed: 'right'}\r\n");
      out.write("            ]]\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        //监听表头工具栏的事件(传入table对象的filter)\r\n");
      out.write("        table.on('toolbar(mainTable)', function (obj) {\r\n");
      out.write("            var checkStatus = table.checkStatus(obj.config.id);\r\n");
      out.write("            switch (obj.event) {\r\n");
      out.write("                case 'add':\r\n");
      out.write("                    // 初始化form模块\r\n");
      out.write("                    layui.use('form', function () {\r\n");
      out.write("                        var form = layui.form;\r\n");
      out.write("\r\n");
      out.write("                        //各种基于事件的操作，下面会有进一步介绍\r\n");
      out.write("                    });\r\n");
      out.write("                    // 打开添加模态框\r\n");
      out.write("                    layer.open({\r\n");
      out.write("                        type: 1\r\n");
      out.write("                        , offset: '50px'\r\n");
      out.write("                        , title: false\r\n");
      out.write("                        , resize: false\r\n");
      out.write("                        // , area: ['800px', '600px']\r\n");
      out.write("                        , shade: [0.8, '#393D49']\r\n");
      out.write("                        , content: $('#addPanel')\r\n");
      out.write("                        ,cancel: function(index, layero){// 点击关闭按钮后回调\r\n");
      out.write("                            $(\"#id_addFrom\")[0].reset();\r\n");
      out.write("                            return true;\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("                    break;\r\n");
      out.write("                case 'delete':\r\n");
      out.write("                    // 获取选中条数\r\n");
      out.write("                    var checkStatus = table.checkStatus('id_mainTable');\r\n");
      out.write("                    if (checkStatus.data.length == 0) {\r\n");
      out.write("                        layer.msg(\"请选中要删除的行\", {icon: 7});\r\n");
      out.write("                        return;\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                    layer.confirm('确认要删除选中的行吗？', {icon: 3, title: '警告'}, function (index) {\r\n");
      out.write("                        // 获取选中项id\r\n");
      out.write("                        var deleteIds = new Array();\r\n");
      out.write("                        for (data_index in checkStatus.data) {\r\n");
      out.write("                            deleteIds.push(checkStatus.data[data_index].oid);\r\n");
      out.write("                        }\r\n");
      out.write("                        var deleteIdsStr = deleteIds.join(',');\r\n");
      out.write("\r\n");
      out.write("                        $.post(\"/staff_delete\",\r\n");
      out.write("                            {ids: deleteIdsStr},\r\n");
      out.write("                            function (data, status) {\r\n");
      out.write("                                if (data == 1) {\r\n");
      out.write("                                    layer.msg(\"删除成功\");\r\n");
      out.write("                                    // 重载table数据\r\n");
      out.write("                                    tableIns.reload();\r\n");
      out.write("                                    // 关闭询问框\r\n");
      out.write("                                    layer.close(index);\r\n");
      out.write("                                }\r\n");
      out.write("                            });\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    break;\r\n");
      out.write("                case 'update':\r\n");
      out.write("                    // 获取选中行数据\r\n");
      out.write("                    var checkStatus = table.checkStatus('id_mainTable');\r\n");
      out.write("                    if (checkStatus.data.length != 1) {\r\n");
      out.write("                        layer.msg(\"请选中一行数据\", {icon: 7});\r\n");
      out.write("                        return;\r\n");
      out.write("                    }\r\n");
      out.write("                    // 获取选中行的数据，填充数据到模态框 form.val\r\n");
      out.write("                    layui.use('form', function() {\r\n");
      out.write("                        var form = layui.form;\r\n");
      out.write("                        form.val(\"updateFrom\",checkStatus.data[0]);\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("                    // 显示模态框\r\n");
      out.write("                    layer.open({\r\n");
      out.write("                        type: 1\r\n");
      out.write("                        , offset: '50px'\r\n");
      out.write("                        , title: false\r\n");
      out.write("                        , resize: false\r\n");
      out.write("                        // , area: ['800px', '600px']\r\n");
      out.write("                        , shade: [0.8, '#393D49']\r\n");
      out.write("                        , content: $('#updatePanel')\r\n");
      out.write("                    });\r\n");
      out.write("                    break;\r\n");
      out.write("            }\r\n");
      out.write("            ;\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        //监听列工具栏\r\n");
      out.write("        table.on('tool(mainTable)', function (obj) { //注：tool中是列工具栏所属table的filter\r\n");
      out.write("            var data = obj.data; //获得当前行数据\r\n");
      out.write("            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）\r\n");
      out.write("            var tr = obj.tr; //获得当前行 tr 的DOM对象\r\n");
      out.write("\r\n");
      out.write("            if (layEvent === 'equipment') { //查看所管理的设备\r\n");
      out.write("                table.render({\r\n");
      out.write("                    elem: '#id_equipmentTable'\r\n");
      out.write("                    ,height: 'full-210'\r\n");
      out.write("                    ,url: '/staff_showEquipment' //数据接口\r\n");
      out.write("                    ,where: {oid: obj.data.oid}\r\n");
      out.write("                    , initSort: {\r\n");
      out.write("                        field: 'oid'\r\n");
      out.write("                        , type: 'asc'\r\n");
      out.write("                    }\r\n");
      out.write("                    , text: {\r\n");
      out.write("                        none: '暂无相关数据' //默认：无数据。\r\n");
      out.write("                    }\r\n");
      out.write("                    , skin: 'line' //行边框风格\r\n");
      out.write("                    , even: true //开启隔行背景\r\n");
      out.write("                    , size: 'lg' //大尺寸的表格\r\n");
      out.write("                    , page: true //开启分页\r\n");
      out.write("                    ,limits:[1,2,10,20]\r\n");
      out.write("                    ,cols: [[ //表头\r\n");
      out.write("                        {field: 'oid', title: 'ID',  sort: true}\r\n");
      out.write("                        , {field: 'name', title: '名称'}\r\n");
      out.write("                    ]]\r\n");
      out.write("                });\r\n");
      out.write("                layer.open({\r\n");
      out.write("                    type: 1\r\n");
      out.write("                    , offset: '50px'\r\n");
      out.write("                    , title: false\r\n");
      out.write("                    , resize: false\r\n");
      out.write("                    ,area: ['1200px', '600px']\r\n");
      out.write("                    , shade: [0.8, '#393D49']\r\n");
      out.write("                    , content: $('#equipmentPanel')\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("            }else if (layEvent === 'record') { //查看维护记录\r\n");
      out.write("                table.render({\r\n");
      out.write("                    elem: '#id_recordTable'\r\n");
      out.write("                    ,height: 'full-210'\r\n");
      out.write("                    ,url: '/staff_showRecord' //数据接口\r\n");
      out.write("                    ,where: {oid: obj.data.oid}\r\n");
      out.write("                    , initSort: {\r\n");
      out.write("                        field: 'oid'\r\n");
      out.write("                        , type: 'asc'\r\n");
      out.write("                    }\r\n");
      out.write("                    , text: {\r\n");
      out.write("                        none: '暂无相关数据' //默认：无数据。\r\n");
      out.write("                    }\r\n");
      out.write("                    , skin: 'line' //行边框风格\r\n");
      out.write("                    , even: true //开启隔行背景\r\n");
      out.write("                    , size: 'lg' //大尺寸的表格\r\n");
      out.write("                    , page: true //开启分页\r\n");
      out.write("                    ,limits:[1,2,10,20]\r\n");
      out.write("                    ,cols: [[ //表头\r\n");
      out.write("                        {field: 'oid', title: 'ID'}\r\n");
      out.write("                        , {title: '维护设备', templet: function(rowData){\r\n");
      out.write("                                return rowData.equipment.name;\r\n");
      out.write("                            }}\r\n");
      out.write("                        , {field: 'date', title: '维护时间', templet: function(rowData){\r\n");
      out.write("                                return new Date(rowData.date.time).toLocaleString();\r\n");
      out.write("                            }}\r\n");
      out.write("                        , {field: 'info', title: '维护信息'}\r\n");
      out.write("                    ]]\r\n");
      out.write("                });\r\n");
      out.write("                layer.open({\r\n");
      out.write("                    type: 1\r\n");
      out.write("                    , offset: '50px'\r\n");
      out.write("                    , title: false\r\n");
      out.write("                    , resize: false\r\n");
      out.write("                    ,area: ['1200px', '600px']\r\n");
      out.write("                    , shade: [0.8, '#393D49']\r\n");
      out.write("                    , content: $('#recordPanel')\r\n");
      out.write("                });\r\n");
      out.write("            }else if (layEvent === 'qrcode') {\r\n");
      out.write("                // 获取当前操行的oid\r\n");
      out.write("                showId = obj.data.oid;\r\n");
      out.write("                $(\"#id_qrcode\").empty();//清空子元素\r\n");
      out.write("                var qrcode = new QRCode(document.getElementById(\"id_qrcode\"), {\r\n");
      out.write("                    width : 300,\r\n");
      out.write("                    height : 300\r\n");
      out.write("                });\r\n");
      out.write("                qrcode.makeCode(\"/staff_showQrcode?oid=\"+showId);\r\n");
      out.write("                // 生成二维码到panel\r\n");
      out.write("                $(\"#id_qrcode\").append(\"点击模拟扫描二维码\");//清空子元素\r\n");
      out.write("\r\n");
      out.write("                layer.open({\r\n");
      out.write("                    type: 1\r\n");
      out.write("                    , offset: '50px'\r\n");
      out.write("                    , title: false\r\n");
      out.write("                    , resize: false\r\n");
      out.write("                    ,area: ['330px', '400px']\r\n");
      out.write("                    , shade: [0.8, '#393D49']\r\n");
      out.write("                    , content: $('#qrcodePanel')\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    // 表单模块\r\n");
      out.write("    layui.use('form', function(){\r\n");
      out.write("        var form = layui.form;\r\n");
      out.write("        // 用于监听提交事件\r\n");
      out.write("        form.on('submit(addSubmit)', function(data){\r\n");
      out.write("            $.post(\"/staff_add\",\r\n");
      out.write("                data.field,\r\n");
      out.write("                function (data, status) {\r\n");
      out.write("                    if (data == 1) {\r\n");
      out.write("                        layer.msg(\"添加成功\");\r\n");
      out.write("                        $(\"#id_addFrom\")[0].reset();\r\n");
      out.write("                        layui.table.reload(\"id_mainTable\");\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("            return false; //false阻止表单跳转\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        form.on('submit(updateSubmit)', function(data){\r\n");
      out.write("            $.post(\"/staff_update\",\r\n");
      out.write("                data.field,\r\n");
      out.write("                function (data, status) {\r\n");
      out.write("                    if (data == 1) {\r\n");
      out.write("                        layer.msg(\"修改成功\");\r\n");
      out.write("                        layui.table.reload(\"id_mainTable\");\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            return false; //false阻止表单跳转\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    // 点击模拟扫描二维码\r\n");
      out.write("    function showQrcodeInfo(obj) {\r\n");
      out.write("        window.open($(obj).attr(\"title\"));\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
