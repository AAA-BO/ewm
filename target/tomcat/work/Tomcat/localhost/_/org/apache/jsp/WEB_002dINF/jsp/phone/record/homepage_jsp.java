/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-05-04 17:45:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.phone.record;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fdate_0026_005fname_005fformat_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fdate_0026_005fname_005fformat_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fdate_0026_005fname_005fformat_005fnobody.release();
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
      out.write("    <title>BUI示例</title>\n");
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
      out.write("    .list-photo .photo-item {\n");
      out.write("        margin: .1rem 0;\n");
      out.write("        background: #efefef;\n");
      out.write("        min-height: 1.6rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .list-photo .photo-item img {\n");
      out.write("        width: 100%;\n");
      out.write("        height: auto;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<div class=\"bui-page\">\n");
      out.write("    <header class=\"bui-bar\">\n");
      out.write("        <div class=\"bui-bar-left bui-bar-text\">\n");
      out.write("            <a class=\"bui-btn\" onclick=\"bui.back();\"><i class=\"icon-back\"></i>返回</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"bui-bar-main\">维护信息</div>\n");
      out.write("        <div class=\"bui-bar-right bui-bar-text\">\n");
      out.write("        </div>\n");
      out.write("    </header>\n");
      out.write("    <main>\n");
      out.write("        <ul class=\"bui-list personal-info\">\n");
      out.write("            <li class=\"bui-btn bui-box\" onclick=\"to('/staff_phone_showQrcode','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${staff.oid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("');\">\n");
      out.write("                <div class=\"thumbnail ring\"><img src=\"demo/tx");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${staff.oid%5}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(".jpg\" alt=\"\"></div>\n");
      out.write("                <div class=\"span1\">\n");
      out.write("                    <h3 class=\"item-title\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${staff.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h3>\n");
      out.write("                    <p class=\"item-text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${staff.department}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${staff.phone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("        <ul class=\"bui-list personal-info\">\n");
      out.write("            <li class=\"bui-btn bui-box\" onclick=\"to('/equipment_phone_home','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${equipment.oid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("');\">\n");
      out.write("                <div class=\"thumbnail ring\"><img src=\"demo/sb");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${equipment.oid%4}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(".jpg\" alt=\"\"></div>\n");
      out.write("                <div class=\"span1\">\n");
      out.write("                    <h3 class=\"item-title\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${equipment.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h3>\n");
      out.write("                    <p class=\"item-text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${equipment.site.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("        <ul class=\"bui-list contact-list\">\n");
      out.write("            <li class=\"bui-btn bui-box clearactive\">\n");
      out.write("                <label class=\"bui-label\">维护时间</label>\n");
      out.write("                <div class=\"span1\">\n");
      out.write("                    <div class=\"bui-value\">");
      if (_jspx_meth_s_005fdate_005f0(_jspx_page_context))
        return;
      out.write("</div>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            <li class=\"bui-btn bui-box clearactive\">\n");
      out.write("                <label class=\"bui-label\">概要信息</label>\n");
      out.write("                <div class=\"span1\">\n");
      out.write("                    <div class=\"bui-value\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${info}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("        ");
      out.write("\n");
      out.write("        <div class=\"container-xy\" id=\"btnTop\">\n");
      out.write("            <a href=\"#\">\n");
      out.write("                <div class=\"bui-btn round primary\">\n");
      out.write("                    详细信息\n");
      out.write("                </div>\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("    </main>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    bui.ready(function () {\n");
      out.write("    })\n");
      out.write("\n");
      out.write("    function to(url, oid) {\n");
      out.write("        window.location.href = url + \"?oid=\" + oid;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    // 文字提醒\n");
      out.write("    $('#btnTop').on(\"click\", function () {\n");
      out.write("        window.location.href = \"/record_phone_xiangqing?oid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${oid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\n");
      out.write("    })\n");
      out.write("\n");
      out.write("\n");
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

  private boolean _jspx_meth_s_005fdate_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:date
    org.apache.struts2.views.jsp.DateTag _jspx_th_s_005fdate_005f0 = (org.apache.struts2.views.jsp.DateTag) _005fjspx_005ftagPool_005fs_005fdate_0026_005fname_005fformat_005fnobody.get(org.apache.struts2.views.jsp.DateTag.class);
    _jspx_th_s_005fdate_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fdate_005f0.setParent(null);
    // /WEB-INF/jsp/phone/record/homepage.jsp(94,43) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fdate_005f0.setName("date");
    // /WEB-INF/jsp/phone/record/homepage.jsp(94,43) name = format type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fdate_005f0.setFormat("yyyy年MM月dd日hh点mm分ss秒");
    int _jspx_eval_s_005fdate_005f0 = _jspx_th_s_005fdate_005f0.doStartTag();
    if (_jspx_th_s_005fdate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fdate_0026_005fname_005fformat_005fnobody.reuse(_jspx_th_s_005fdate_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fdate_0026_005fname_005fformat_005fnobody.reuse(_jspx_th_s_005fdate_005f0);
    return false;
  }
}
