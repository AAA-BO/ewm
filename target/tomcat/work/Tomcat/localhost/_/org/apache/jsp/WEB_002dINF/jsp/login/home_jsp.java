/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-14 12:50:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>后台管理</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"layui/css/layui.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"layui-layout-body\">\r\n");
      out.write("<div class=\"layui-layout layui-layout-admin\">\r\n");
      out.write("    <div class=\"layui-header\">\r\n");
      out.write("        <div class=\"layui-logo\">建筑施工管理系统</div>\r\n");
      out.write("        <ul class=\"layui-nav layui-layout-right\">\r\n");
      out.write("            <li class=\"layui-nav-item\">\r\n");
      out.write("                <a href=\"javascript:;\">\r\n");
      out.write("                    <img src=\"images/user.jpg\" class=\"layui-nav-img\">\r\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("                </a>\r\n");
      out.write("                <dl class=\"layui-nav-child\">\r\n");
      out.write("                    <dd><a href=\"\">基本资料</a></dd>\r\n");
      out.write("                    <dd><a href=\"\">安全设置</a></dd>\r\n");
      out.write("                </dl>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"layui-nav-item\"><a href=\"/staff_logout\">退出</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-side layui-bg-black\">\r\n");
      out.write("        <div class=\"layui-side-scroll\">\r\n");
      out.write("            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->\r\n");
      out.write("            <ul id=\"id_leftNav\" class=\"layui-nav layui-nav-tree\" lay-filter=\"leftNav\">\r\n");
      out.write("                <li class=\"layui-nav-item layui-nav-itemed\">\r\n");
      out.write("                    <a class=\"\" href=\"javascript:;\">维护人员</a>\r\n");
      out.write("                    <dl class=\"layui-nav-child\">\r\n");
      out.write("                        <dd><a href=\"/page_staff_list\">人员管理</a></dd>\r\n");
      out.write("                        <dd><a href=\"/page_staff_relevance\">关联设备</a></dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"layui-nav-item\">\r\n");
      out.write("                    <a href=\"javascript:;\">公司设备</a>\r\n");
      out.write("                    <dl class=\"layui-nav-child\">\r\n");
      out.write("                        <dd><a href=\"/page_equipment_list\">设备管理</a></dd>\r\n");
      out.write("                        <dd><a href=\"/page_equipment_list\">设备管理2</a></dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"layui-nav-item\">\r\n");
      out.write("                    <a href=\"javascript:;\">维护记录</a>\r\n");
      out.write("                    <dl class=\"layui-nav-child\">\r\n");
      out.write("                        <dd><a href=\"/page_record_list\">记录管理</a></dd>\r\n");
      out.write("                        <dd><a href=\"/page_record_list\">记录管理2</a></dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-body\">\r\n");
      out.write("        <!-- 内容主体区域 -->\r\n");
      out.write("        <div style=\"padding-left: 8px;\">\r\n");
      out.write("            <div class=\"layui-tab\" lay-allowClose=\"true\" lay-filter=\"tabs\">\r\n");
      out.write("                <ul class=\"layui-tab-title\">\r\n");
      out.write("                </ul>\r\n");
      out.write("                <div class=\"layui-tab-content\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-footer\">\r\n");
      out.write("        <!-- 底部固定区域 -->\r\n");
      out.write("        © layui.com\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"js/jquery.js\"></script>\r\n");
      out.write("<script src=\"layui/layui.all.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    // nav tab 的操作\r\n");
      out.write("    layui.use('element', function () {\r\n");
      out.write("        var innetTabNumber = 0;\r\n");
      out.write("        var opedTabArray = new Array();\r\n");
      out.write("\r\n");
      out.write("        var element = layui.element;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        // 为左侧导航栏的a标签添加click事件，取消a标签的跳转功能\r\n");
      out.write("        $(\"#id_leftNav a\").click(function () {\r\n");
      out.write("            return false;\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        // 监听导航栏点击\r\n");
      out.write("        element.on('nav(leftNav)', function (elem) {\r\n");
      out.write("            console.log(elem); //得到当前点击的DOM对象\r\n");
      out.write("            var href = elem.attr(\"href\");\r\n");
      out.write("\r\n");
      out.write("            // 判断是否为导航分类页\r\n");
      out.write("            if (href == 'javascript:;') {\r\n");
      out.write("                return;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            var text = elem.text();\r\n");
      out.write("\r\n");
      out.write("            //  是否已打开\r\n");
      out.write("            var findFlag = opedTabArray.indexOf(text, 0);\r\n");
      out.write("            if (findFlag != -1) { // 找到\r\n");
      out.write("                element.tabChange(\"tabs\", text);\r\n");
      out.write("                return;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            // 添加新tab\r\n");
      out.write("            element.tabAdd('tabs', {\r\n");
      out.write("                title: text\r\n");
      out.write("                , content: ' <iframe width=\"100%\" height=\"725\"  frameborder=\"0\"  scrolling=\"yes\" src=\"' + href + '\"></iframe>' //支持传入html\r\n");
      out.write("                , id: text\r\n");
      out.write("            });\r\n");
      out.write("            // 选中新增的tab\r\n");
      out.write("            element.tabChange(\"tabs\", text);\r\n");
      out.write("            // 将新增tab id加入 opedTabArray中\r\n");
      out.write("            opedTabArray.push(text);\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        // 监听tab的删除\r\n");
      out.write("        element.on('tabDelete(tabs)', function (data) {\r\n");
      out.write("            // tab删除后从opedTabArray中移除其id\r\n");
      out.write("            opedTabArray.splice(data.index - innetTabNumber, 1);\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
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