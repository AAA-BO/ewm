/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-14 13:05:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class phoneLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005factionerror_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005factionerror_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005factionerror_005fnobody.release();
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
      out.write("    <title>移动端登录</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"layui/css/layui.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"layui-container\" style=\"padding-top: 15px\">\r\n");
      out.write("\r\n");
      out.write("<form class=\"layui-form layui-form-pane\" action=\"/staff_login\" method=\"post\">\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <label class=\"layui-form-label\">账户</label>\r\n");
      out.write("        <div class=\"layui-input-block\">\r\n");
      out.write("            <input type=\"text\" name=\"username\" required lay-verify=\"required\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <label class=\"layui-form-label\">密码</label>\r\n");
      out.write("        <div class=\"layui-input-block\">\r\n");
      out.write("            <input type=\"password\" name=\"password\" required lay-verify=\"required\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"layui-form-item\" hidden>\r\n");
      out.write("        <input type=\"text\" name=\"isPhone\" value=\"true\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <div class=\"layui-input-block\" style=\"text-align: right\">\r\n");
      out.write("            <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("            <button class=\"layui-btn\" lay-submit>登录</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<div hidden id=\"msg\">");
      if (_jspx_meth_s_005factionerror_005f0(_jspx_page_context))
        return;
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/jquery.js\"></script>\r\n");
      out.write("<script src=\"layui/layui.all.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    $(function () {\r\n");
      out.write("        var msg = $(\"#msg\").text();\r\n");
      out.write("        if(msg!=\"\" ) {\r\n");
      out.write("            layer.msg(msg);\r\n");
      out.write("        }\r\n");
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

  private boolean _jspx_meth_s_005factionerror_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:actionerror
    org.apache.struts2.views.jsp.ui.ActionErrorTag _jspx_th_s_005factionerror_005f0 = (org.apache.struts2.views.jsp.ui.ActionErrorTag) _005fjspx_005ftagPool_005fs_005factionerror_005fnobody.get(org.apache.struts2.views.jsp.ui.ActionErrorTag.class);
    _jspx_th_s_005factionerror_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005factionerror_005f0.setParent(null);
    int _jspx_eval_s_005factionerror_005f0 = _jspx_th_s_005factionerror_005f0.doStartTag();
    if (_jspx_th_s_005factionerror_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005factionerror_005fnobody.reuse(_jspx_th_s_005factionerror_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005factionerror_005fnobody.reuse(_jspx_th_s_005factionerror_005f0);
    return false;
  }
}
