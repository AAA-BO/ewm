/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-05-07 02:01:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.record;

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
      out.write("    <title>维护记录管理</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"layui/css/layui.css\">\n");
      out.write("</head>\n");
      out.write("<body class=\"layui-layout-body\">\n");
      out.write("    ");
      out.write("\n");
      out.write("    <div class=\"search\">\n");
      out.write("        维护人员\\账户\\手机号：\n");
      out.write("        <div class=\"layui-inline\">\n");
      out.write("            <input class=\"layui-input\" name=\"id\" id=\"search_staff_id\" autocomplete=\"off\">\n");
      out.write("        </div>\n");
      out.write("        维护设备：\n");
      out.write("        <div class=\"layui-inline\">\n");
      out.write("            <input class=\"layui-input\" name=\"id\" id=\"search_equipment_id\" autocomplete=\"off\">\n");
      out.write("        </div>\n");
      out.write("        时间范围：\n");
      out.write("        <div class=\"layui-inline\">\n");
      out.write("            <input id=\"begin\" type=\"text\" class=\"layui-input\" name=\"id\" id=\"search_time_begin_id\" autocomplete=\"off\">\n");
      out.write("        </div>\n");
      out.write("        -\n");
      out.write("        <div class=\"layui-inline\">\n");
      out.write("            <input id=\"end\" type=\"text\" class=\"layui-input\" name=\"id\" id=\"search_time_end_id\" autocomplete=\"off\">\n");
      out.write("        </div>\n");
      out.write("        维护信息：\n");
      out.write("        <div class=\"layui-inline\">\n");
      out.write("            <input class=\"layui-input\" name=\"id\" id=\"search_info_id\" autocomplete=\"off\">\n");
      out.write("        </div>\n");
      out.write("        <button class=\"layui-btn\" id=\"search_btn_id\">搜索</button>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- 内容主体区域 -->\n");
      out.write("    <!--table-->\n");
      out.write("    <div>\n");
      out.write("        <!--tab内容-->\n");
      out.write("        <table id=\"id_mainTable\" lay-filter=\"mainTable\"></table>\n");
      out.write("\n");
      out.write("        <!--表头工具栏-->\n");
      out.write("        <script type=\"text/html\" id=\"mainToolbar\">\n");
      out.write("            <div class=\"layui-btn-container\">\n");
      out.write("                <button class=\"layui-btn layui-btn-sm\" lay-event=\"delete\">删除</button>\n");
      out.write("            </div>\n");
      out.write("        </script>\n");
      out.write("        <!--列工具栏-->\n");
      out.write("        <script type=\"text/html\" id=\"mainTool\">\n");
      out.write("            <div class=\"layui-btn-container\">\n");
      out.write("                <button class=\"layui-btn layui-btn-sm\" lay-event=\"xiangqing\">维护详情</button>\n");
      out.write("            </div>\n");
      out.write("        </script>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--add & update 面板，利用绝对定位实现隐藏效果-->\n");
      out.write("<div style=\"position: absolute;top: -9999px;left: -9999px;\">\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    <div id=\"xiangqingPanel\" class=\"layui-card\">\n");
      out.write("        <div class=\"layui-card-header\">维护信息详情</div>\n");
      out.write("        <div class=\"layui-card-body\">\n");
      out.write("            <table id=\"id_xiangqingTable\" lay-filter=\"xiangqingTable\" class=\"layui-table\">\n");
      out.write("                <tbody id=\"id_xiangqing_body\">\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<script src=\"js/jquery.js\"></script>\n");
      out.write("<script src=\"layui/layui.all.js\"></script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    // table操作\n");
      out.write("    layui.use('layer', function () {\n");
      out.write("        var table = layui.table;\n");
      out.write("        //第一个实例\n");
      out.write("        var tableIns = table.render({\n");
      out.write("            // id:'maintable'\n");
      out.write("            elem: '#id_mainTable'\n");
      out.write("            ,url: '/record_list' //数据接口\n");
      out.write("            , title: '维护记录数据'//结合toolbar右侧导出功能\n");
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
      out.write("            ,limits:[1,2,10,20]\n");
      out.write("            , cols: [[ //表头\n");
      out.write("                {type: 'checkbox', width: 30}\n");
      out.write("                , {field: 'oid', title: 'ID',  sort: true,hide: true}\n");
      out.write("                , {title: '维护人员', templet: function(rowData){\n");
      out.write("                            return rowData.staff.name;\n");
      out.write("                   }}\n");
      out.write("                , {title: '账户', templet: function (rowData) {\n");
      out.write("                        return rowData.staff.username;\n");
      out.write("                    }}\n");
      out.write("                , {\n");
      out.write("                    title: '部门', templet: function (rowData) {\n");
      out.write("                        if (rowData.staff.department == null || rowData.staff.department == \"\") {\n");
      out.write("                            return \"未设置\";\n");
      out.write("                        }\n");
      out.write("                        return rowData.staff.department;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                , { title: '员工所在工地', templet: function (rowData) {\n");
      out.write("                        if (rowData.staff.site == null) {\n");
      out.write("                            return \"未设置\";\n");
      out.write("                        }\n");
      out.write("                        return rowData.staff.site.name;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                , {title: '手机', templet: function (rowData) {\n");
      out.write("                        return rowData.staff.phone;\n");
      out.write("                    }}\n");
      out.write("                , {title: '维护设备', templet: function(rowData){\n");
      out.write("                        return rowData.equipment.name;\n");
      out.write("                   }}\n");
      out.write("                , { title: '设备所在工地', templet: function (rowData) {\n");
      out.write("                        if (rowData.equipment.site == null) {\n");
      out.write("                            return \"未设置\";\n");
      out.write("                        }\n");
      out.write("                        return rowData.equipment.site.name;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                , { title: '维护时间',width: 200, templet: function(rowData){\n");
      out.write("                        return new Date(rowData.date.time).toLocaleString();\n");
      out.write("                    }}\n");
      out.write("                , {field: 'info',width: 400, title: '概要信息'}\n");
      out.write("                ,{title: '操作', width: 100, toolbar: '#mainTool' ,fixed: 'right'}\n");
      out.write("            ]]\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        //监听表头工具栏的事件(传入table对象的filter)\n");
      out.write("        table.on('toolbar(mainTable)', function (obj) {\n");
      out.write("            var checkStatus = table.checkStatus(obj.config.id);\n");
      out.write("            switch (obj.event) {\n");
      out.write("                case 'delete':\n");
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
      out.write("                        for (var data_index in checkStatus.data) {\n");
      out.write("                            deleteIds.push(checkStatus.data[data_index].oid);\n");
      out.write("                        }\n");
      out.write("                        var deleteIdsStr = deleteIds.join(',');\n");
      out.write("\n");
      out.write("                        $.post(\"/record_delete\",\n");
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
      out.write("                case 'update':\n");
      out.write("                    break;\n");
      out.write("            }\n");
      out.write("            ;\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        //监听列工具栏\n");
      out.write("        table.on('tool(mainTable)', function (obj) { //注：tool中是列工具栏所属table的filter\n");
      out.write("            var data = obj.data; //获得当前行数据\n");
      out.write("            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）\n");
      out.write("            var tr = obj.tr; //获得当前行 tr 的DOM对象\n");
      out.write("\n");
      out.write("            if (layEvent === 'xiangqing') { //查看所管理的设备\n");
      out.write("                // id_xiangqing_body\n");
      out.write("                $.post(\"/record_xiangqing\",\n");
      out.write("                    {oid: data.oid},\n");
      out.write("                    function (data, status) {\n");
      out.write("                        console.log(data);\n");
      out.write("                        if (data != null) {\n");
      out.write("                            $.each(data,function(key,value){\n");
      out.write("                                $(\"#id_xiangqing_body\").append('<tr><td>'+key+'</td><td>'+value+'</td></tr>');\n");
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
      out.write("                    , content: $('#xiangqingPanel')\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    $('#search_btn_id').on('click', function(){\n");
      out.write("        // 维护人员\\账户\\手机号：\n");
      out.write("        // 维护设备：\n");
      out.write("        // 维护时间：\n");
      out.write("        // 维护信息：\n");
      out.write("        var staff = $(\"#search_staff_id\").val();\n");
      out.write("        var equipment = $(\"#search_equipment_id\").val();\n");
      out.write("        var time_begin = $(\"#begin\").val();\n");
      out.write("        var time_end = $(\"#end\").val();\n");
      out.write("        var info = $(\"#search_info_id\").val();\n");
      out.write("        layui.table.reload('id_mainTable', {\n");
      out.write("            url: '/record_search'\n");
      out.write("            ,where: {\n");
      out.write("                search_staffData:staff,\n");
      out.write("                search_equipmentData:equipment,\n");
      out.write("                search_time_begin:time_begin,\n");
      out.write("                search_time_end:time_end,\n");
      out.write("                search_info:info\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    layui.use('laydate', function(){\n");
      out.write("        var laydate = layui.laydate;\n");
      out.write("\n");
      out.write("        laydate.render({\n");
      out.write("            elem: '#begin'\n");
      out.write("            ,type: 'datetime'\n");
      out.write("        });\n");
      out.write("        laydate.render({\n");
      out.write("            elem: '#end'\n");
      out.write("            ,type: 'datetime'\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("\n");
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
