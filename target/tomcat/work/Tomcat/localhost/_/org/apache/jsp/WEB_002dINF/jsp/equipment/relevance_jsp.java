/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-05-06 02:53:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.equipment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class relevance_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>设备关联模板</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"layui/css/layui.css\">\n");
      out.write("</head>\n");
      out.write("<body class=\"layui-layout-body\">\n");
      out.write("\n");
      out.write("<!-- 内容主体区域 -->\n");
      out.write("<!--table-->\n");
      out.write("<div>\n");
      out.write("    <!--tab内容-->\n");
      out.write("    <table id=\"id_mainTable\" lay-filter=\"mainTable\"></table>\n");
      out.write("\n");
      out.write("    <!--表头工具栏-->\n");
      out.write("    <script type=\"text/html\" id=\"mainToolbar\">\n");
      out.write("        <div class=\"layui-btn-container\">\n");
      out.write("            <button class=\"layui-btn layui-btn-sm\" lay-event=\"batch\" disabled>批量关联</button>\n");
      out.write("        </div>\n");
      out.write("    </script>\n");
      out.write("    <!--列工具栏-->\n");
      out.write("    <script type=\"text/html\" id=\"mainTool\">\n");
      out.write("        <div class=\"layui-btn-container\">\n");
      out.write("            <button class=\"layui-btn layui-btn-sm\" lay-event=\"show\">查看模板</button>\n");
      out.write("            <button class=\"layui-btn layui-btn-sm\" lay-event=\"relevance\">关联模板</button>\n");
      out.write("        </div>\n");
      out.write("    </script>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div style=\"position: absolute;top: -9999px;left: -9999px;\">\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    <div id=\"showPanel\" class=\"layui-card\">\n");
      out.write("        <div class=\"layui-card-header\">查看模板</div>\n");
      out.write("        <div class=\"layui-card-body\">\n");
      out.write("            <div class=\"layui-form layui-form-pane\">\n");
      out.write("                <div id=\"id_showMuban\"></div>\n");
      out.write("\n");
      out.write("                <div class=\"layui-form-item\" style=\"text-align: right\">\n");
      out.write("                    <div class=\"layui-input-block\">\n");
      out.write("                        <div class=\"layui-btn layui-btn-primary\" >重置</div>\n");
      out.write("                        <div class=\"layui-btn\" >提交</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    <div id=\"relevancePanel\" class=\"layui-card\">\n");
      out.write("        <div class=\"layui-card-header\">关联模板</div>\n");
      out.write("        <div class=\"layui-card-body\">\n");
      out.write("            <table id=\"id_relevanceTable\" lay-filter=\"relevanceTable\"></table>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!--关联模板 列工具栏-->\n");
      out.write("    <script type=\"text/html\" id=\"relevanceTool\">\n");
      out.write("        <div class=\"layui-btn-container\">\n");
      out.write("            <button class=\"layui-btn layui-btn-sm\" lay-event=\"showMuban\">预览模板</button>\n");
      out.write("            <button class=\"layui-btn layui-btn-sm\" lay-event=\"useMuban\">使用模板</button>\n");
      out.write("        </div>\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<script src=\"js/jquery.js\"></script>\n");
      out.write("<script src=\"layui/layui.all.js\"></script>\n");
      out.write("<script src=\"js/qrcode.js\"></script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    var selectE = 0;\n");
      out.write("\n");
      out.write("    layui.use('layer', function () {\n");
      out.write("        var table = layui.table;\n");
      out.write("        var tableIns = table.render({\n");
      out.write("            elem: '#id_mainTable'\n");
      out.write("            , url: '/equipment_list' //数据接口\n");
      out.write("            , title: '设备关联模板数据'//结合toolbar右侧导出功能\n");
      out.write("            , toolbar: '#mainToolbar'\n");
      out.write("            , initSort: {\n");
      out.write("                field: 'oid'\n");
      out.write("                , type: 'asc'\n");
      out.write("            }\n");
      out.write("            , text: {\n");
      out.write("                none: '暂无相关数据' //默认：无数据。\n");
      out.write("            }\n");
      out.write("            , skin: 'line' //行边框风格\n");
      out.write("            , even: true //开启隔行背景\n");
      out.write("            , size: 'lg' //大尺寸的表格\n");
      out.write("            , page: true //开启分页\n");
      out.write("            , limits: [1, 2, 10, 20]\n");
      out.write("            , cols: [[ //表头\n");
      out.write("                {type: 'checkbox', width: 50, fixed: 'left'}\n");
      out.write("                , {field: 'oid', title: 'ID', sort: true, hide: true}\n");
      out.write("                , {field: 'name', title: '设备名称'}\n");
      out.write("                , {\n");
      out.write("                     title: '工地', templet: function (rowData) {\n");
      out.write("                        if (rowData.site == null) {\n");
      out.write("                            return \"未设置\";\n");
      out.write("                        }\n");
      out.write("                        return rowData.site.name;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                ,{title: '模板名称', templet: function (rowData) {\n");
      out.write("                        if (rowData.mubanName == null || rowData.mubanName == \"\") {\n");
      out.write("                            return \"未设置\";\n");
      out.write("                        }\n");
      out.write("                        return rowData.mubanName;\n");
      out.write("                    }}\n");
      out.write("                , {title: '操作', width: 310, toolbar: '#mainTool', fixed: 'right'}\n");
      out.write("            ]]\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        //监听表头工具栏的事件(传入table对象的filter)\n");
      out.write("        table.on('toolbar(mainTable)', function (obj) {\n");
      out.write("            var checkStatus = table.checkStatus(obj.config.id);\n");
      out.write("            switch (obj.event) {\n");
      out.write("                case 'batch': //批量关联\n");
      out.write("                    break;\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        //监听列工具栏\n");
      out.write("        table.on('tool(mainTable)', function (obj) { //注：tool中是列工具栏所属table的filter\n");
      out.write("            var data = obj.data; //获得当前行数据\n");
      out.write("            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）\n");
      out.write("            var tr = obj.tr; //获得当前行 tr 的DOM对象\n");
      out.write("\n");
      out.write("            if (layEvent === 'show') { //查看模板\n");
      out.write("                // 获取模板数据\n");
      out.write("                $.post(\"/muban_show\",\n");
      out.write("                    {name: data.mubanName},\n");
      out.write("                    function (data, status) {\n");
      out.write("                        if (data != null) {\n");
      out.write("                            // 解析生成相应样式\n");
      out.write("                            data.data.forEach(function (item, i) {\n");
      out.write("                                switch (item.filedType) {\n");
      out.write("                                    case '文本框':\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item\">\\n' +\n");
      out.write("                                            '                        <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                        <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                            <input type=\"text\" placeholder=\"请输入\" autocomplete=\"off\"\\n' +\n");
      out.write("                                            '                                   class=\"layui-input\">\\n' +\n");
      out.write("                                            '                        </div>\\n' +\n");
      out.write("                                            '                    </div>\\n');\n");
      out.write("                                        break;\n");
      out.write("                                    case '文本域':\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item layui-form-text\">\\n' +\n");
      out.write("                                            '                    <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                    <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                        <textarea name=\"info\" placeholder=\"请输入内容\" class=\"layui-textarea\"></textarea>\\n' +\n");
      out.write("                                            '                    </div>\\n' +\n");
      out.write("                                            '                </div>');\n");
      out.write("                                        break;\n");
      out.write("                                    case '数字':\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item\">\\n' +\n");
      out.write("                                            '                        <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                        <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                            <input type=\"number\"  placeholder=\"请输入\" autocomplete=\"off\"\\n' +\n");
      out.write("                                            '                                   class=\"layui-input\">\\n' +\n");
      out.write("                                            '                        </div>\\n' +\n");
      out.write("                                            '                    </div>\\n');\n");
      out.write("                                        break;\n");
      out.write("                                    case '日期时间':\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item\">\\n' +\n");
      out.write("                                            '                        <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                        <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                            <input type=\"datetime-local\" placeholder=\"请输入\" autocomplete=\"off\"\\n' +\n");
      out.write("                                            '                                   class=\"layui-input\">\\n' +\n");
      out.write("                                            '                        </div>\\n' +\n");
      out.write("                                            '                    </div>\\n');\n");
      out.write("                                        break;\n");
      out.write("                                    case '下拉列表':\n");
      out.write("                                        var dom = \"\";\n");
      out.write("                                        item.filedItem.split('|').forEach(function (item, i) {\n");
      out.write("                                            dom += '<option value=\"\">' + item + '</option>\\n'\n");
      out.write("                                        });\n");
      out.write("\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item\">\\n' +\n");
      out.write("                                            '                        <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                        <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                            <select name=\"\">\\n' +\n");
      out.write("                                            '                                <option value=\"\"></option>\\n' + dom +\n");
      out.write("                                            '                            </select>\\n' +\n");
      out.write("                                            '                        </div>\\n' +\n");
      out.write("                                            '                    </div>');\n");
      out.write("                                        layui.form.render();\n");
      out.write("                                        break;\n");
      out.write("                                    case '单选按钮':\n");
      out.write("                                        var dom = \"\";\n");
      out.write("                                        item.filedItem.split('|').forEach(function (item, i) {\n");
      out.write("                                            if (i == 0) {\n");
      out.write("                                                dom += '<input type=\"radio\" name=\"test\" value=\"test'+i+'\" title=\"' + item + '\" checked>'\n");
      out.write("                                            } else {\n");
      out.write("                                                dom += '<input type=\"radio\" name=\"test\" value=\"test'+i+'\" title=\"' + item + '\">'\n");
      out.write("                                            }\n");
      out.write("\n");
      out.write("                                        });\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item\" pane>\\n' +\n");
      out.write("                                            '                        <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                        <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                            ' + dom +\n");
      out.write("                                            '                        </div>\\n' +\n");
      out.write("                                            '                    </div>');\n");
      out.write("                                        layui.form.render();\n");
      out.write("                                        break;\n");
      out.write("                                    case '复选框':\n");
      out.write("                                        var dom = \"\";\n");
      out.write("                                        item.filedItem.split('|').forEach(function (item, i) {\n");
      out.write("                                            dom += '<input type=\"checkbox\" lay-skin=\"primary\" name=\"\" title=\"' + item + '\">'\n");
      out.write("                                        });\n");
      out.write("\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item\" pane>\\n' +\n");
      out.write("                                            '                        <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                        <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                            ' + dom +\n");
      out.write("                                            '                        </div>\\n' +\n");
      out.write("                                            '                    </div>');\n");
      out.write("                                        layui.form.render();\n");
      out.write("                                        break;\n");
      out.write("                                }\n");
      out.write("                            });\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                layer.open({\n");
      out.write("                    type: 1\n");
      out.write("                    , offset: '50px'\n");
      out.write("                    , title: false\n");
      out.write("                    , resize: false\n");
      out.write("                    , area: ['1200px', '600px']\n");
      out.write("                    , shade: [0.8, '#393D49']\n");
      out.write("                    , content: $('#showPanel')\n");
      out.write("                    , cancel: function (index, layero) {\n");
      out.write("                        $(\"#id_showMuban\").empty();\n");
      out.write("                        return true;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                });\n");
      out.write("            } else if (layEvent === 'relevance') { //关联模板\n");
      out.write("                table.render({\n");
      out.write("                    elem: '#id_relevanceTable'\n");
      out.write("                    , height: 'full-210'\n");
      out.write("                    , url: '/muban_listByNameNotWith' //数据接口\n");
      out.write("                    , where: {\n");
      out.write("                        oid: obj.data.oid\n");
      out.write("                        , name:obj.data.mubanName\n");
      out.write("                    }\n");
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
      out.write("                    , cols: [[\n");
      out.write("                         {field: 'name', title: '模板名'}\n");
      out.write("                        , {title: '操作', width: 320, toolbar: '#relevanceTool', fixed: 'right'}\n");
      out.write("                    ]]\n");
      out.write("                });\n");
      out.write("                // 设置当前操作的设备的id\n");
      out.write("                selectE = obj.data.oid;\n");
      out.write("                layer.open({\n");
      out.write("                    type: 1\n");
      out.write("                    , offset: '50px'\n");
      out.write("                    , title: false\n");
      out.write("                    , resize: false\n");
      out.write("                    , area: ['1200px', '600px']\n");
      out.write("                    , shade: [0.8, '#393D49']\n");
      out.write("                    , content: $('#relevancePanel')\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        // 监听关联工具栏\n");
      out.write("        table.on('tool(relevanceTable)', function (obj) {\n");
      out.write("            var data = obj.data;\n");
      out.write("            var layEvent = obj.event;\n");
      out.write("            var tr = obj.tr;\n");
      out.write("\n");
      out.write("            if (layEvent === 'showMuban') { //预览模板\n");
      out.write("                $.post(\"/muban_show\",\n");
      out.write("                    {name: data.name},\n");
      out.write("                    function (data, status) {\n");
      out.write("                        if (data != null) {\n");
      out.write("                            // 解析生成相应样式\n");
      out.write("                            data.data.forEach(function (item, i) {\n");
      out.write("                                switch (item.filedType) {\n");
      out.write("                                    case '文本框':\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item\">\\n' +\n");
      out.write("                                            '                        <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                        <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                            <input type=\"text\" placeholder=\"请输入\" autocomplete=\"off\"\\n' +\n");
      out.write("                                            '                                   class=\"layui-input\">\\n' +\n");
      out.write("                                            '                        </div>\\n' +\n");
      out.write("                                            '                    </div>\\n');\n");
      out.write("                                        break;\n");
      out.write("                                    case '文本域':\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item layui-form-text\">\\n' +\n");
      out.write("                                            '                    <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                    <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                        <textarea name=\"info\" placeholder=\"请输入内容\" class=\"layui-textarea\"></textarea>\\n' +\n");
      out.write("                                            '                    </div>\\n' +\n");
      out.write("                                            '                </div>');\n");
      out.write("                                        break;\n");
      out.write("                                    case '数字':\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item\">\\n' +\n");
      out.write("                                            '                        <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                        <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                            <input type=\"number\"  placeholder=\"请输入\" autocomplete=\"off\"\\n' +\n");
      out.write("                                            '                                   class=\"layui-input\">\\n' +\n");
      out.write("                                            '                        </div>\\n' +\n");
      out.write("                                            '                    </div>\\n');\n");
      out.write("                                        break;\n");
      out.write("                                    case '日期时间':\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item\">\\n' +\n");
      out.write("                                            '                        <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                        <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                            <input type=\"datetime-local\" placeholder=\"请输入\" autocomplete=\"off\"\\n' +\n");
      out.write("                                            '                                   class=\"layui-input\">\\n' +\n");
      out.write("                                            '                        </div>\\n' +\n");
      out.write("                                            '                    </div>\\n');\n");
      out.write("                                        break;\n");
      out.write("                                    case '下拉列表':\n");
      out.write("                                        var dom = \"\";\n");
      out.write("                                        item.filedItem.split('|').forEach(function (item, i) {\n");
      out.write("                                            dom += '<option value=\"\">' + item + '</option>\\n'\n");
      out.write("                                        });\n");
      out.write("\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item\">\\n' +\n");
      out.write("                                            '                        <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                        <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                            <select name=\"\">\\n' +\n");
      out.write("                                            '                                <option value=\"\"></option>\\n' + dom +\n");
      out.write("                                            '                            </select>\\n' +\n");
      out.write("                                            '                        </div>\\n' +\n");
      out.write("                                            '                    </div>');\n");
      out.write("                                        layui.form.render();\n");
      out.write("                                        break;\n");
      out.write("                                    case '单选按钮':\n");
      out.write("                                        var dom = \"\";\n");
      out.write("                                        item.filedItem.split('|').forEach(function (item, i) {\n");
      out.write("                                            if (i == 0) {\n");
      out.write("                                                dom += '<input type=\"radio\" name=\"test\" value=\"test'+i+'\" title=\"' + item + '\" checked>'\n");
      out.write("                                            } else {\n");
      out.write("                                                dom += '<input type=\"radio\" name=\"test\" value=\"test'+i+'\" title=\"' + item + '\">'\n");
      out.write("                                            }\n");
      out.write("\n");
      out.write("                                        });\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item\" pane>\\n' +\n");
      out.write("                                            '                        <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                        <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                            ' + dom +\n");
      out.write("                                            '                        </div>\\n' +\n");
      out.write("                                            '                    </div>');\n");
      out.write("                                        layui.form.render();\n");
      out.write("                                        break;\n");
      out.write("                                    case '复选框':\n");
      out.write("                                        var dom = \"\";\n");
      out.write("                                        item.filedItem.split('|').forEach(function (item, i) {\n");
      out.write("                                            dom += '<input type=\"checkbox\" lay-skin=\"primary\" name=\"\" title=\"' + item + '\">'\n");
      out.write("                                        });\n");
      out.write("\n");
      out.write("                                        $(\"#id_showMuban\").append('<div class=\"layui-form-item\" pane>\\n' +\n");
      out.write("                                            '                        <label class=\"layui-form-label\">' + item.filedName + '</label>\\n' +\n");
      out.write("                                            '                        <div class=\"layui-input-block\">\\n' +\n");
      out.write("                                            '                            ' + dom +\n");
      out.write("                                            '                        </div>\\n' +\n");
      out.write("                                            '                    </div>');\n");
      out.write("                                        layui.form.render();\n");
      out.write("                                        break;\n");
      out.write("                                }\n");
      out.write("                            });\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                layer.open({\n");
      out.write("                    type: 1\n");
      out.write("                    , offset: '50px'\n");
      out.write("                    , title: false\n");
      out.write("                    , resize: false\n");
      out.write("                    , area: ['1200px', '600px']\n");
      out.write("                    , shade: [0.8, '#393D49']\n");
      out.write("                    , content: $('#showPanel')\n");
      out.write("                    , cancel: function (index, layero) {\n");
      out.write("                        $(\"#id_showMuban\").empty();\n");
      out.write("                        return true;\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            } else if (layEvent === 'useMuban') { //设置模板\n");
      out.write("                $.post(\"/equipment_useMuban\",\n");
      out.write("                    {mubanName: data.name\n");
      out.write("                        ,oid:selectE\n");
      out.write("                    },\n");
      out.write("                    function (data, status) {\n");
      out.write("                        if (data == 1) {\n");
      out.write("                            layer.msg(\"设置成功\");\n");
      out.write("                            layui.table.reload(\"id_mainTable\");\n");
      out.write("                            // layui.table.reload(\"id_relevanceTable\");//刷新模板数据\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    // 表单模块\n");
      out.write("    layui.use('form', function () {\n");
      out.write("        var form = layui.form;\n");
      out.write("        form.on('submit(relevanceSubmit)', function (data) { // 关联提交\n");
      out.write("            $.post(\"/equipment_add\",\n");
      out.write("                data.field,\n");
      out.write("                function (data, status) {\n");
      out.write("                    if (data == 1) {\n");
      out.write("                        layer.msg(\"添加成功\");\n");
      out.write("                        $(\"#id_addFrom\")[0].reset();\n");
      out.write("                        layui.table.reload(\"id_mainTable\");\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            return false; //false阻止表单跳转\n");
      out.write("        });\n");
      out.write("    });\n");
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
