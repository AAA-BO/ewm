/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-05-06 14:38:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.phone.site;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>维护组</title>\n");
      out.write("    <meta name=\"viewport\"\n");
      out.write("          content=\"width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/bui/bui.css\">\n");
      out.write("    <script src=\"/bui/zepto.js\"></script>\n");
      out.write("    <script src=\"/bui/bui.js\"></script>\n");
      out.write("    <style></style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\n");
      out.write("    .personal-info {\n");
      out.write("        margin-top: 0;\n");
      out.write("        margin-bottom: .2rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .personal-info .bui-btn {\n");
      out.write("        padding-top: .3rem;\n");
      out.write("        padding-bottom: .3rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .personal-info .icon {\n");
      out.write("        margin-right: 0;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .contact-list {\n");
      out.write("        border-top: none;\n");
      out.write("        margin-bottom: .2rem;\n");
      out.write("        padding: 0 0.2rem;\n");
      out.write("        background-color: #ffffff;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .contact-list .bui-btn {\n");
      out.write("        padding-left: 0;\n");
      out.write("        padding-top: .3rem;\n");
      out.write("        padding-bottom: .3rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .contact-list li:last-child {\n");
      out.write("        border-bottom: none;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .list-photo .photo-title {\n");
      out.write("        margin: .1rem 0;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .list-photo .photo-item {\n");
      out.write("        margin: .1rem 0;\n");
      out.write("        background: #efefef;\n");
      out.write("        min-height: 1.6rem;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<div class=\"bui-page\">\n");
      out.write("    <header class=\"bui-bar\">\n");
      out.write("        <div class=\"bui-bar-left bui-bar-text\">\n");
      out.write("            <a class=\"bui-btn\" onclick=\"bui.back();\"><i class=\"icon-back\"></i>返回</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"bui-bar-main\">列表</div>\n");
      out.write("        <div class=\"bui-bar-right bui-bar-text\">\n");
      out.write("        </div>\n");
      out.write("    </header>\n");
      out.write("    <main>\n");
      out.write("\n");
      out.write("        <ul class=\"bui-list personal-info\">\n");
      out.write("            <li class=\"bui-btn bui-box\">\n");
      out.write("                <div class=\"span1\">\n");
      out.write("                    <h3 class=\"item-title\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h3>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("        <ul class=\"bui-list contact-list\">\n");
      out.write("            <li class=\"bui-btn bui-box clearactive\">\n");
      out.write("                <label class=\"bui-label\">说明信息</label>\n");
      out.write("                <div class=\"span1\">\n");
      out.write("                    <div class=\"bui-value\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${info}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"bui-btn bui-box clearactive\" onclick=\"to('/site_phone_slist');\">\n");
      out.write("                <label class=\"bui-label\">员工数量</label>\n");
      out.write("                <div class=\"span1\">\n");
      out.write("                    <div class=\"bui-value\">共");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${staffNumber}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("位</div>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"bui-btn bui-box clearactive\" onclick=\"to('/site_phone_elist');\">\n");
      out.write("                <label class=\"bui-label\">设备数量</label>\n");
      out.write("                <div class=\"span1\">\n");
      out.write("                    <div class=\"bui-value\">共");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${equipmentNumber}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("台</div>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </main>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</main>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    function to(url,oid) {\n");
      out.write("        if(oid==null) {\n");
      out.write("            window.location.href = url+\"?oid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${oid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\n");
      out.write("        }else {\n");
      out.write("            window.location.href = url+\"?oid=\"+oid;\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    bui.ready(function () {\n");
      out.write("    })\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
