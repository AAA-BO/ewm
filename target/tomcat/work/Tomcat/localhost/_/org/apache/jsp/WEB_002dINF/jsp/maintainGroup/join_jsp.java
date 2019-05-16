/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-05-04 17:25:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.maintainGroup;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class join_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>加入申请</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"layui/css/layui.css\">\n");
      out.write("</head>\n");
      out.write("<body class=\"layui-layout-body\">\n");
      out.write("\n");
      out.write("<div>\n");
      out.write("    <!--tab内容-->\n");
      out.write("    <table id=\"id_mainTable\" lay-filter=\"mainTable\"></table>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--列工具栏-->\n");
      out.write("<script type=\"text/html\" id=\"mainTool\">\n");
      out.write("    <div class=\"layui-btn-container\">\n");
      out.write("        <button class=\"layui-btn layui-btn-sm\" lay-event=\"sayYes\">同意</button>\n");
      out.write("        <button class=\"layui-btn layui-btn-sm\" lay-event=\"sayNo\">拒绝</button>\n");
      out.write("    </div>\n");
      out.write("</script>\n");
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
      out.write("            , url: '/dictionaries_joinlist'\n");
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
      out.write("                {title: '申请人ID',templet: function (rowData) {\n");
      out.write("                        return rowData.value.split(\",\")[0];\n");
      out.write("                  }}\n");
      out.write("                ,{title: '申请人',templet: function (rowData) {\n");
      out.write("                        return rowData.value.split(\",\")[1];\n");
      out.write("                    }}\n");
      out.write("                ,{title: '维护组ID',templet: function (rowData) {\n");
      out.write("                        return rowData.value.split(\",\")[2];\n");
      out.write("                    }}\n");
      out.write("                ,{title: '维护组',templet: function (rowData) {\n");
      out.write("                        return rowData.value.split(\",\")[3];\n");
      out.write("                    }}\n");
      out.write("                ,{title: '申请时间',templet: function (rowData) {\n");
      out.write("                        return rowData.value.split(\",\")[4];\n");
      out.write("                    }}\n");
      out.write("                , {title: '操作', width: 150, toolbar: '#mainTool', fixed: 'right'}\n");
      out.write("\n");
      out.write("            ]]\n");
      out.write("        });\n");
      out.write("\n");
      out.write("\n");
      out.write("        //监听列工具栏\n");
      out.write("        table.on('tool(mainTable)', function (obj) { //注：tool中是列工具栏所属table的filter\n");
      out.write("            var data = obj.data; //获得当前行数据\n");
      out.write("            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）\n");
      out.write("            var tr = obj.tr; //获得当前行 tr 的DOM对象\n");
      out.write("\n");
      out.write("            if (layEvent === 'sayYes') { //通过\n");
      out.write("                $.post(\"/maintainGroup_join\",\n");
      out.write("                    {\n");
      out.write("                        say:'yes'\n");
      out.write("                        ,oid: data.oid\n");
      out.write("                    },\n");
      out.write("                    function (data, status) {\n");
      out.write("                        if (data != null) {\n");
      out.write("                            if (data == 1) {\n");
      out.write("                                layer.msg(\"操作成功\");\n");
      out.write("                                tableIns.reload();\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("            }else if (layEvent === 'sayNo') { //不通过\n");
      out.write("                $.post(\"/maintainGroup_join\",\n");
      out.write("                    {\n");
      out.write("                        say:'no'\n");
      out.write("                        ,oid: data.oid\n");
      out.write("                    },\n");
      out.write("                    function (data, status) {\n");
      out.write("                        if (data != null) {\n");
      out.write("                            if (data == 1) {\n");
      out.write("                                layer.msg(\"操作成功\");\n");
      out.write("                                tableIns.reload();\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    })\n");
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
