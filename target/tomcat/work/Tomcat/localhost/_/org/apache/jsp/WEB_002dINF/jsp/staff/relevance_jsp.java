/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-14 13:22:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.staff;

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
      out.write("                <button class=\"layui-btn layui-btn-sm\" lay-event=\"batch\">批量关联</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </script>\r\n");
      out.write("        <!--列工具栏-->\r\n");
      out.write("        <script type=\"text/html\" id=\"mainTool\">\r\n");
      out.write("            <div class=\"layui-btn-container\">\r\n");
      out.write("                <button class=\"layui-btn layui-btn-sm\" lay-event=\"equipment\">查看管理设备</button>\r\n");
      out.write("                <button class=\"layui-btn layui-btn-sm\" lay-event=\"relevance\">关联设备</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <!--列工具栏(所管理设备)-->\r\n");
      out.write("        <script type=\"text/html\" id=\"glsbTool\">\r\n");
      out.write("            <div class=\"layui-btn-container\">\r\n");
      out.write("                <button class=\"layui-btn layui-btn-sm\" lay-event=\"glsb_delete\">取消关联</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </script>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--add & update 面板，利用绝对定位实现隐藏效果-->\r\n");
      out.write("<div style=\"position: absolute;top: -9999px;left: -9999px;\">\r\n");
      out.write("\r\n");
      out.write("    <!--关联-->\r\n");
      out.write("    <div id=\"relevancePanel\" class=\"layui-card\">\r\n");
      out.write("        <div class=\"layui-card-header\">关联设备</div>\r\n");
      out.write("        <div class=\"layui-card-body\">\r\n");
      out.write("            <form id=\"id_relevanceFrom\" class=\"layui-form layui-form-pane\" lay-filter=\"relevanceFrom\">\r\n");
      out.write("                <table id=\"id_relevanceTable\" lay-filter=\"relevanceTable\"></table>\r\n");
      out.write("                <div class=\"layui-form-item\" style=\"text-align: right\">\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("                        <button class=\"layui-btn\" lay-submit lay-filter=\"relevanceSubmit\">确定</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!--批量关联-->\r\n");
      out.write("    <div id=\"batchPanel\" class=\"layui-card\">\r\n");
      out.write("        <div class=\"layui-card-header\">批量关联</div>\r\n");
      out.write("        <div class=\"layui-card-body\">\r\n");
      out.write("            <form id=\"id_batchFrom\" class=\"layui-form layui-form-pane\" lay-filter=\"batchFrom\">\r\n");
      out.write("                <table id=\"id_batchTable\" lay-filter=\"batchTable\"></table>\r\n");
      out.write("                <div class=\"layui-form-item\" style=\"text-align: right\">\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("                        <button class=\"layui-btn\" lay-submit lay-filter=\"batchSubmit\">确定</button>\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"js/jquery.js\"></script>\r\n");
      out.write("<script src=\"layui/layui.all.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    var beShowId = 0;\r\n");
      out.write("\r\n");
      out.write("    // table操作\r\n");
      out.write("    layui.use('layer', function () {\r\n");
      out.write("        var table = layui.table;\r\n");
      out.write("        //第一个实例\r\n");
      out.write("        var tableIns = table.render({\r\n");
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
      out.write("                , {field: 'name', title: '姓名'}//,edit:'true' width: 80,\r\n");
      out.write("                ,{title: '操作',width: 200, toolbar: '#mainTool' ,fixed: 'right'}\r\n");
      out.write("            ]]\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        //监听表头工具栏的事件(传入table对象的filter)\r\n");
      out.write("        table.on('toolbar(mainTable)', function (obj) {\r\n");
      out.write("            var checkStatus = table.checkStatus(obj.config.id);\r\n");
      out.write("            switch (obj.event) {\r\n");
      out.write("                case 'batch':\r\n");
      out.write("                    // 获取选中条数\r\n");
      out.write("                    var checkStatus = table.checkStatus('id_mainTable');\r\n");
      out.write("                    if (checkStatus.data.length == 0) {\r\n");
      out.write("                        layer.msg(\"请选中要进行关联的人员\", {icon: 7});\r\n");
      out.write("                        return;\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    layui.use('table', function(){\r\n");
      out.write("                        var table = layui.table;\r\n");
      out.write("\r\n");
      out.write("                        //第一个实例\r\n");
      out.write("                        table.render({\r\n");
      out.write("                            elem: '#id_batchTable'\r\n");
      out.write("                            ,height: 460\r\n");
      out.write("                            ,url: '/equipment_getAll' //数据接口\r\n");
      out.write("                            ,page: false //开启分页\r\n");
      out.write("                            ,cols: [[ //表头\r\n");
      out.write("                                 {type: 'checkbox', width: 50, fixed: 'left'}\r\n");
      out.write("                                ,{field: 'oid', title: 'ID', sort: true}\r\n");
      out.write("                                ,{field: 'name', title: '设备名'}\r\n");
      out.write("                            ]]\r\n");
      out.write("                        });\r\n");
      out.write("\r\n");
      out.write("                    });\r\n");
      out.write("                    // 打开批量关联模态框\r\n");
      out.write("                    layer.open({\r\n");
      out.write("                        type: 1\r\n");
      out.write("                        , offset: '50px'\r\n");
      out.write("                        , title: false\r\n");
      out.write("                        , resize: false\r\n");
      out.write("                        , area: ['1200px', '600px']\r\n");
      out.write("                        , shade: [0.8, '#393D49']\r\n");
      out.write("                        , content: $('#batchPanel')\r\n");
      out.write("                    });\r\n");
      out.write("                    break;\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        //监听列工具栏\r\n");
      out.write("        table.on('tool(mainTable)', function (obj) { //注：tool中是列工具栏所属table的filter\r\n");
      out.write("            var data = obj.data; //获得当前行数据\r\n");
      out.write("            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）\r\n");
      out.write("            var tr = obj.tr; //获得当前行 tr 的DOM对象\r\n");
      out.write("\r\n");
      out.write("            if (layEvent === 'equipment') { //查看所管理的设备\r\n");
      out.write("                beShowId = obj.data.oid;\r\n");
      out.write("\r\n");
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
      out.write("                        ,{title: '操作',width: 100, toolbar: '#glsbTool' ,fixed: 'right'}\r\n");
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
      out.write("            } else if(layEvent === 'relevance') { // 点击关联设备按钮\r\n");
      out.write("                beShowId = obj.data.oid;\r\n");
      out.write("\r\n");
      out.write("                // 初始化relevanceTable数据表格，查询当前用户未关联设备\r\n");
      out.write("                layui.use('table', function(){\r\n");
      out.write("                    var table = layui.table;\r\n");
      out.write("\r\n");
      out.write("                    //第一个实例\r\n");
      out.write("                    table.render({\r\n");
      out.write("                        elem: '#id_relevanceTable'\r\n");
      out.write("                        ,where: {oid: obj.data.oid}\r\n");
      out.write("                        ,height: 460\r\n");
      out.write("                        ,url: '/staff_getNotRelevance' //数据接口\r\n");
      out.write("                        ,page: false //开启分页\r\n");
      out.write("                        ,cols: [[ //表头\r\n");
      out.write("                            {type: 'checkbox', width: 50, fixed: 'left'}\r\n");
      out.write("                            ,{field: 'oid', title: 'ID', sort: true}\r\n");
      out.write("                            ,{field: 'name', title: '设备名'}\r\n");
      out.write("                        ]]\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("                });\r\n");
      out.write("                // 打开关联模态框\r\n");
      out.write("                layer.open({\r\n");
      out.write("                    type: 1\r\n");
      out.write("                    , offset: '50px'\r\n");
      out.write("                    , title: false\r\n");
      out.write("                    , resize: false\r\n");
      out.write("                    , area: ['1200px', '600px']\r\n");
      out.write("                    , shade: [0.8, '#393D49']\r\n");
      out.write("                    , content: $('#relevancePanel')\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        //监听列工具栏\r\n");
      out.write("        table.on('tool(equipmentTable)', function (obj) { //注：tool中是列工具栏所属table的filter\r\n");
      out.write("            var data = obj.data; //获得当前行数据\r\n");
      out.write("            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）\r\n");
      out.write("            var tr = obj.tr; //获得当前行 tr 的DOM对象\r\n");
      out.write("\r\n");
      out.write("            if (layEvent === 'glsb_delete') { //查看所管理的设备\r\n");
      out.write("                layer.msg(1);\r\n");
      out.write("                layer.confirm('确认要取消关联吗？', {icon: 3, title: '警告'}, function (index) {\r\n");
      out.write("                    // 获取选中项id\r\n");
      out.write("                    $.post(\"/staff_cancel\",\r\n");
      out.write("                        {oid: beShowId,equipmentId:obj.data.oid},\r\n");
      out.write("                        function (data, status) {\r\n");
      out.write("                            if (data == 1) {\r\n");
      out.write("                                layer.msg(\"取消关联成功\");\r\n");
      out.write("                                // 重载table数据\r\n");
      out.write("                                table.reload(\"id_equipmentTable\");\r\n");
      out.write("                                // 关闭询问框\r\n");
      out.write("                                layer.close(index);\r\n");
      out.write("                            }\r\n");
      out.write("                        });\r\n");
      out.write("\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    // 表单模块\r\n");
      out.write("    layui.use('form', function(){\r\n");
      out.write("        var form = layui.form;\r\n");
      out.write("\r\n");
      out.write("        form.on('submit(batchSubmit)', function(data){\r\n");
      out.write("            // 获取mainTable的选中项\r\n");
      out.write("            var checkStatus_mt = layui.table.checkStatus('id_mainTable');\r\n");
      out.write("            var staffIdArray = new Array();\r\n");
      out.write("            for (data_index in checkStatus_mt.data) {\r\n");
      out.write("                staffIdArray.push(checkStatus_mt.data[data_index].oid);\r\n");
      out.write("            }\r\n");
      out.write("            var staffIdsStr = staffIdArray.join(',');\r\n");
      out.write("\r\n");
      out.write("            // 获取batchTable的选中项\r\n");
      out.write("            var checkStatus_bt = layui.table.checkStatus('id_batchTable');\r\n");
      out.write("            var equipmentIdArray = new Array();\r\n");
      out.write("            for (data_index in checkStatus_bt.data) {\r\n");
      out.write("                equipmentIdArray.push(checkStatus_bt.data[data_index].oid);\r\n");
      out.write("            }\r\n");
      out.write("            var equipmentIdsStr = equipmentIdArray.join(',');\r\n");
      out.write("\r\n");
      out.write("            $.post(\"/staff_batch\",\r\n");
      out.write("                { staffIds:staffIdsStr, equipmentIds:equipmentIdsStr },\r\n");
      out.write("                function (data, status) {\r\n");
      out.write("                    if (data == 1) {\r\n");
      out.write("                        layer.msg(\"关联成功\");\r\n");
      out.write("                        layui.table.reload(\"id_batchTable\");\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            return false; //false阻止表单跳转，不关闭窗口\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        form.on('submit(relevanceSubmit)', function(data){\r\n");
      out.write("            var staffIdsStr = beShowId;\r\n");
      out.write("\r\n");
      out.write("            // 获取relevanceTable的选中项\r\n");
      out.write("            var checkStatus_rt = layui.table.checkStatus('id_relevanceTable');\r\n");
      out.write("            var equipmentIdArray = new Array();\r\n");
      out.write("            for (data_index in checkStatus_rt.data) {\r\n");
      out.write("                equipmentIdArray.push(checkStatus_rt.data[data_index].oid);\r\n");
      out.write("            }\r\n");
      out.write("            var equipmentIdsStr = equipmentIdArray.join(',');\r\n");
      out.write("\r\n");
      out.write("            $.post(\"/staff_batch\",\r\n");
      out.write("                { staffIds:staffIdsStr, equipmentIds:equipmentIdsStr },\r\n");
      out.write("                function (data, status) {\r\n");
      out.write("                    if (data == 1) {\r\n");
      out.write("                        layer.msg(\"关联成功\");\r\n");
      out.write("                        layui.table.reload(\"id_relevanceTable\");\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            return false; //false阻止表单跳转\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
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
