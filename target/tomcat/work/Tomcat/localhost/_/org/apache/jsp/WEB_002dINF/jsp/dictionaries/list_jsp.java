/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-05-06 01:59:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.dictionaries;

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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("    <title>数据字典</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"layui/css/layui.css\">\n");
      out.write("</head>\n");
      out.write("<body class=\"layui-layout-body\">\n");
      out.write("\n");
      out.write("<div>\n");
      out.write("    ");
      out.write("\n");
      out.write("    <div class=\"search\">\n");
      out.write("        类型：\n");
      out.write("        <div class=\"layui-inline\">\n");
      out.write("            <input class=\"layui-input\" name=\"id\" id=\"search_type_id\" autocomplete=\"off\">\n");
      out.write("        </div>\n");
      out.write("        数据：\n");
      out.write("        <div class=\"layui-inline\">\n");
      out.write("            <input class=\"layui-input\" name=\"id\" id=\"search_value_id\" autocomplete=\"off\">\n");
      out.write("        </div>\n");
      out.write("        <button class=\"layui-btn\" id=\"search_btn_id\">搜索</button>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!--tab内容-->\n");
      out.write("    <table id=\"id_mainTable\" lay-filter=\"mainTable\"></table>\n");
      out.write("\n");
      out.write("    <!--表头工具栏-->\n");
      out.write("    <script type=\"text/html\" id=\"mainToolbar\">\n");
      out.write("        <div class=\"layui-btn-container\">\n");
      out.write("            <button class=\"layui-btn layui-btn-sm\" lay-event=\"add\">添加</button>\n");
      out.write("            <button class=\"layui-btn layui-btn-sm\" lay-event=\"update\">编辑</button>\n");
      out.write("            <button class=\"layui-btn layui-btn-sm\" lay-event=\"delete\">删除</button>\n");
      out.write("        </div>\n");
      out.write("    </script>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--add&update面板-->\n");
      out.write("<div style=\"position: absolute;top: -9999px;left: -9999px;\">\n");
      out.write("\n");
      out.write("    <!--add-->\n");
      out.write("    <div id=\"addPanel\" class=\"layui-card\">\n");
      out.write("        <div class=\"layui-card-header\">添加</div>\n");
      out.write("        <div class=\"layui-card-body\">\n");
      out.write("            <form id=\"id_addFrom\" class=\"layui-form layui-form-pane\">\n");
      out.write("                <div class=\"layui-form-item\">\n");
      out.write("                    <label class=\"layui-form-label\">类型</label>\n");
      out.write("                    <div class=\"layui-input-block\">\n");
      out.write("                        <select name=\"group\" id=\"group_select_add_id\" lay-filter=\"group_add\">\n");
      out.write("                            <option value=\"\">新增类型</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"layui-form-item\" id=\"type_add_id\">\n");
      out.write("                    <label class=\"layui-form-label\">类型</label>\n");
      out.write("                    <div class=\"layui-input-block\">\n");
      out.write("                        <input type=\"text\" name=\"type\" placeholder=\"请输入\" autocomplete=\"off\"\n");
      out.write("                               class=\"layui-input\" lay-verify=\"required\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"layui-form-item\">\n");
      out.write("                    <label class=\"layui-form-label\">数据</label>\n");
      out.write("                    <div class=\"layui-input-block\">\n");
      out.write("                        <input type=\"text\" name=\"value\" placeholder=\"请输入\" autocomplete=\"off\"\n");
      out.write("                               class=\"layui-input\" lay-verify=\"required\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"layui-form-item\" style=\"text-align: right\">\n");
      out.write("                    <div class=\"layui-input-block\">\n");
      out.write("                        <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\n");
      out.write("                        <button class=\"layui-btn\" lay-submit lay-filter=\"addSubmit\">确定</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!--update-->\n");
      out.write("    <div id=\"updatePanel\" class=\"layui-card\">\n");
      out.write("        <div class=\"layui-card-header\">更新</div>\n");
      out.write("        <div class=\"layui-card-body\">\n");
      out.write("            <form id=\"id_updateFrom\" class=\"layui-form layui-form-pane\" lay-filter=\"updateFrom\">\n");
      out.write("                <div class=\"layui-form-item\" hidden>\n");
      out.write("                    <label class=\"layui-form-label\">ID</label>\n");
      out.write("                    <div class=\"layui-input-block\">\n");
      out.write("                        <input type=\"text\" name=\"oid\" autocomplete=\"off\" class=\"layui-input\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"layui-form-item\">\n");
      out.write("                    <label class=\"layui-form-label\">类型</label>\n");
      out.write("                    <div class=\"layui-input-block\">\n");
      out.write("                        <input type=\"text\" name=\"type\" placeholder=\"请输入\" autocomplete=\"off\"\n");
      out.write("                               class=\"layui-input\" lay-verify=\"required\" disabled>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"layui-form-item\">\n");
      out.write("                    <label class=\"layui-form-label\">数据</label>\n");
      out.write("                    <div class=\"layui-input-block\">\n");
      out.write("                        <input type=\"text\" name=\"value\" placeholder=\"请输入\" autocomplete=\"off\"\n");
      out.write("                               class=\"layui-input\" lay-verify=\"required\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"layui-form-item\" style=\"text-align: right\">\n");
      out.write("                    <div class=\"layui-input-block\">\n");
      out.write("                        ");
      out.write("\n");
      out.write("                        <button class=\"layui-btn\" lay-submit lay-filter=\"updateSubmit\">确定</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script src=\"js/jquery.js\"></script>\n");
      out.write("<script src=\"layui/layui.all.js\"></script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    var showId = 0;\n");
      out.write("\n");
      out.write("    layui.use('layer', function () {\n");
      out.write("        var table = layui.table;\n");
      out.write("        var tableIns = table.render({\n");
      out.write("            elem: '#id_mainTable'\n");
      out.write("            , url: '/dictionaries_list' //数据接口\n");
      out.write("            , title: '数据字典'//结合toolbar右侧导出功能\n");
      out.write("            , toolbar: '#mainToolbar'\n");
      out.write("            , initSort: {\n");
      out.write("                field: 'oid'\n");
      out.write("                , type: 'asc'\n");
      out.write("            }\n");
      out.write("            , text: {\n");
      out.write("                none: '无数据'\n");
      out.write("            }\n");
      out.write("            , skin: 'line' //行边框风格\n");
      out.write("            , even: true //开启隔行背景\n");
      out.write("            , size: 'lg' //大尺寸的表格\n");
      out.write("            , page: true //开启分页\n");
      out.write("            , limits: [1, 2, 10, 20]\n");
      out.write("            , cols: [[\n");
      out.write("                {type: 'checkbox', width: 50, fixed: 'left'}\n");
      out.write("                , {field: 'oid', title: 'ID', sort: true, hide: true}\n");
      out.write("                , {field: 'type', title: '类型'}\n");
      out.write("                , {field: 'value', title: '数据'}\n");
      out.write("            ]]\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        //监听表头工具栏按钮\n");
      out.write("        table.on('toolbar(mainTable)', function (obj) {\n");
      out.write("            var checkStatus = table.checkStatus(obj.config.id);\n");
      out.write("            switch (obj.event) {\n");
      out.write("                case 'add':\n");
      out.write("                    // 获取类型分类数据\n");
      out.write("                    $.post(\"/dictionaries_getTypeGroup\",\n");
      out.write("                        function (data, status) {\n");
      out.write("                            console.log(data);\n");
      out.write("                            if (data != null) {\n");
      out.write("                                data.forEach(function (item, i) {\n");
      out.write("                                    // 将工地数据加入\n");
      out.write("                                    $(\"#group_select_add_id\").append('<option value=\"' + item + '\">' + item + '</option>');\n");
      out.write("                                });\n");
      out.write("                            }\n");
      out.write("                            // 重新渲染表单\n");
      out.write("                            layui.form.render();\n");
      out.write("                        });\n");
      out.write("                    // 打开添加模态框\n");
      out.write("                    layer.open({\n");
      out.write("                        type: 1\n");
      out.write("                        , offset: '25px'\n");
      out.write("                        , title: false\n");
      out.write("                        , resize: false\n");
      out.write("                        , shade: [0.8, '#393D49']\n");
      out.write("                        , content: $('#addPanel')\n");
      out.write("                        , cancel: function (index, layero) {\n");
      out.write("                            $(\"#group_select_add_id\").html('<option value=\"\">新增类型</option>');\n");
      out.write("                            $(\"#id_addFrom\")[0].reset();\n");
      out.write("                            return true;\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                    break;\n");
      out.write("                case\n");
      out.write("                'update' :\n");
      out.write("                    // 判断是否只选中一行\n");
      out.write("                    var checkStatus = table.checkStatus('id_mainTable');\n");
      out.write("                    if (checkStatus.data.length != 1) {\n");
      out.write("                        layer.msg(\"请选中一行数据\", {icon: 7});\n");
      out.write("                        return;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    layui.use('form', function () {\n");
      out.write("                        var form = layui.form;\n");
      out.write("                        // 数据回显\n");
      out.write("                        form.val(\"updateFrom\", checkStatus.data[0]);\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                    // 显示模态框\n");
      out.write("                    layer.open({\n");
      out.write("                        type: 1\n");
      out.write("                        , offset: '25px'\n");
      out.write("                        , title: false\n");
      out.write("                        , resize: false\n");
      out.write("                        , shade: [0.8, '#393D49']\n");
      out.write("                        , content: $('#updatePanel')\n");
      out.write("                        , cancel: function (index, layero) {\n");
      out.write("                            $(\"#id_updateFrom\")[0].reset();\n");
      out.write("                            return true;\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                    break;\n");
      out.write("                case\n");
      out.write("                'delete'\n");
      out.write("                :\n");
      out.write("                    // 获取选中条数\n");
      out.write("                    var checkStatus = table.checkStatus('id_mainTable');\n");
      out.write("                    if (checkStatus.data.length == 0) {\n");
      out.write("                        layer.msg(\"请选中要删除的行\", {icon: 7});\n");
      out.write("                        return;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    layer.confirm('确认要删除选中的行吗？', {icon: 3, title: '警告'}, function (index) {\n");
      out.write("                        // 获取选中项id\n");
      out.write("                        var deleteIds = new Array();\n");
      out.write("                        for (data_index in checkStatus.data) {\n");
      out.write("                            deleteIds.push(checkStatus.data[data_index].oid);\n");
      out.write("                        }\n");
      out.write("                        var deleteIdsStr = deleteIds.join(',');\n");
      out.write("\n");
      out.write("                        $.post(\"/dictionaries_delete\",\n");
      out.write("                            {ids: deleteIdsStr},\n");
      out.write("                            function (data, status) {\n");
      out.write("                                if (data == 1) {\n");
      out.write("                                    layer.msg(\"删除成功\");\n");
      out.write("                                    // 重载table数据\n");
      out.write("                                    tableIns.reload();\n");
      out.write("                                    // 关闭询问框\n");
      out.write("                                    layer.close(index);\n");
      out.write("                                }\n");
      out.write("                            });\n");
      out.write("                    });\n");
      out.write("                    break;\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("\n");
      out.write("        //监听列工具栏\n");
      out.write("        table.on('tool(mainTable)', function (obj) { //注：tool中是列工具栏所属table的filter\n");
      out.write("            var data = obj.data; //获得当前行数据\n");
      out.write("            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）\n");
      out.write("            var tr = obj.tr; //获得当前行 tr 的DOM对象\n");
      out.write("\n");
      out.write("            if (layEvent === 'equipment') { //查看所管理的设备\n");
      out.write("                table.render({\n");
      out.write("                    elem: '#id_equipmentTable'\n");
      out.write("                    , height: 'full-210'\n");
      out.write("                    , url: '/staff_showEquipment' //数据接口\n");
      out.write("                    , where: {oid: obj.data.oid}\n");
      out.write("                    , initSort: {\n");
      out.write("                        field: 'oid'\n");
      out.write("                        , type: 'asc'\n");
      out.write("                    }\n");
      out.write("                    , text: {\n");
      out.write("                        none: '暂无相关数据' //默认：无数据。\n");
      out.write("                    }\n");
      out.write("                    , skin: 'line' //行边框风格\n");
      out.write("                    , even: true //开启隔行背景\n");
      out.write("                    , size: 'lg' //大尺寸的表格\n");
      out.write("                    , page: true //开启分页\n");
      out.write("                    , limits: [1, 2, 10, 20]\n");
      out.write("                    , cols: [[ //表头\n");
      out.write("                        {field: 'oid', title: 'ID', sort: true}\n");
      out.write("                        , {field: 'name', title: '名称'}\n");
      out.write("                    ]]\n");
      out.write("                });\n");
      out.write("                layer.open({\n");
      out.write("                    type: 1\n");
      out.write("                    , offset: '50px'\n");
      out.write("                    , title: false\n");
      out.write("                    , resize: false\n");
      out.write("                    , area: ['1200px', '600px']\n");
      out.write("                    , shade: [0.8, '#393D49']\n");
      out.write("                    , content: $('#equipmentPanel')\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            } else if (layEvent === 'record') { //查看维护记录\n");
      out.write("                table.render({\n");
      out.write("                    elem: '#id_recordTable'\n");
      out.write("                    , height: 'full-210'\n");
      out.write("                    , url: '/staff_showRecord' //数据接口\n");
      out.write("                    , where: {oid: obj.data.oid}\n");
      out.write("                    , initSort: {\n");
      out.write("                        field: 'oid'\n");
      out.write("                        , type: 'asc'\n");
      out.write("                    }\n");
      out.write("                    , text: {\n");
      out.write("                        none: '暂无相关数据' //默认：无数据。\n");
      out.write("                    }\n");
      out.write("                    , skin: 'line' //行边框风格\n");
      out.write("                    , even: true //开启隔行背景\n");
      out.write("                    , size: 'lg' //大尺寸的表格\n");
      out.write("                    , page: true //开启分页\n");
      out.write("                    , limits: [1, 2, 10, 20]\n");
      out.write("                    , cols: [[ //表头\n");
      out.write("                        {field: 'oid', title: 'ID'}\n");
      out.write("                        , {\n");
      out.write("                            title: '维护设备', templet: function (rowData) {\n");
      out.write("                                return rowData.equipment.name;\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                        , {\n");
      out.write("                            field: 'date', title: '维护时间', templet: function (rowData) {\n");
      out.write("                                return new Date(rowData.date.time).toLocaleString();\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                        , {field: 'info', title: '维护信息'}\n");
      out.write("                    ]]\n");
      out.write("                });\n");
      out.write("                layer.open({\n");
      out.write("                    type: 1\n");
      out.write("                    , offset: '50px'\n");
      out.write("                    , title: false\n");
      out.write("                    , resize: false\n");
      out.write("                    , area: ['1200px', '600px']\n");
      out.write("                    , shade: [0.8, '#393D49']\n");
      out.write("                    , content: $('#recordPanel')\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    })\n");
      out.write("    ;\n");
      out.write("\n");
      out.write("    // 表单模块\n");
      out.write("    layui.use('form', function () {\n");
      out.write("        var form = layui.form;\n");
      out.write("\n");
      out.write("        // 用于监听表单的提交\n");
      out.write("        form.on('submit(addSubmit)', function (data) {\n");
      out.write("            $.post(\"/dictionaries_add\",\n");
      out.write("                data.field,\n");
      out.write("                function (data, status) {\n");
      out.write("                    if (data == 1) {\n");
      out.write("                        layer.msg(\"添加成功\");\n");
      out.write("                        // TODO\n");
      out.write("                        // 重新加载下拉框数据\n");
      out.write("                        $(\"#group_select_add_id\").html('<option value=\"\">新增类型</option>');\n");
      out.write("                        $.post(\"/dictionaries_getTypeGroup\",\n");
      out.write("                            function (data, status) {\n");
      out.write("                                if (data != null) {\n");
      out.write("                                    data.forEach(function (item, i) {\n");
      out.write("                                        // 将工地数据加入\n");
      out.write("                                        $(\"#group_select_add_id\").append('<option value=\"' + item + '\">' + item + '</option>');\n");
      out.write("                                    });\n");
      out.write("                                }\n");
      out.write("                                // 重新渲染表单\n");
      out.write("                                layui.form.render();\n");
      out.write("                            });\n");
      out.write("                        // 展示中间类型框\n");
      out.write("                        $(\"#type_add_id input[name='type']\").val(\"\");\n");
      out.write("                        $(\"#type_add_id\").removeAttr(\"hidden\");\n");
      out.write("                        $(\"#id_addFrom\")[0].reset();\n");
      out.write("                        layui.table.reload(\"id_mainTable\");\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            return false; //false阻止表单跳转\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        form.on('submit(updateSubmit)', function (data) {\n");
      out.write("            $.post(\"/dictionaries_update\",\n");
      out.write("                data.field,\n");
      out.write("                function (data, status) {\n");
      out.write("                    if (data == 1) {\n");
      out.write("                        layer.msg(\"修改成功\");\n");
      out.write("                        layui.table.reload(\"id_mainTable\");\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            return false; //false阻止表单跳转\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        // 表单onselect事件\n");
      out.write("        form.on('select(group_add)', function (data) {\n");
      out.write("            if (data.value == \"\") {\n");
      out.write("                $(\"#type_add_id input[name='type']\").val(\"\");\n");
      out.write("                $(\"#type_add_id\").removeAttr(\"hidden\");\n");
      out.write("            } else {\n");
      out.write("                $(\"#type_add_id input[name='type']\").val(data.value);\n");
      out.write("                $(\"#type_add_id\").attr(\"hidden\", \"hidden\");\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $('#search_btn_id').on('click', function(){\n");
      out.write("        var type = $(\"#search_type_id\").val();\n");
      out.write("        var value = $(\"#search_value_id\").val();\n");
      out.write("\n");
      out.write("        // $.post(\"/dictionaries_search\",\n");
      out.write("        //     { type:type,value:value},\n");
      out.write("        //     function (data, status) {\n");
      out.write("        //         layui.table.reload('id_mainTable',data.data);\n");
      out.write("        //     });\n");
      out.write("        layui.table.reload('id_mainTable', {\n");
      out.write("            url: '/dictionaries_search'\n");
      out.write("            ,where: {\n");
      out.write("                type:type,\n");
      out.write("                value:value\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    });\n");
      out.write("\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("</body>\n");
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
