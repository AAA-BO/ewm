/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-17 13:16:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.phone.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>BUI示例</title>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/buijs/lib/latest/bui.css\">\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/buijs/lib/zepto.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/buijs/lib/latest/bui.js\"></script>\r\n");
      out.write("    <style></style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("    .login-page main {\r\n");
      out.write("        background: #fff center bottom no-repeat;\r\n");
      out.write("        background-size: 100% auto;\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-page .logo h1 {\r\n");
      out.write("        font-size: .82rem;\r\n");
      out.write("        padding-left: .3rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .logo {\r\n");
      out.write("        height: 2rem;\r\n");
      out.write("        margin: 1.2rem auto 1rem auto;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .logo img {\r\n");
      out.write("        height: 1rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-form {\r\n");
      out.write("        padding-left: .6rem;\r\n");
      out.write("        padding-right: .6rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-form .bui-list {\r\n");
      out.write("        border-top: none;\r\n");
      out.write("        margin-bottom: .7rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-form > .bui-btn {\r\n");
      out.write("        margin-bottom: .3rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-form .bui-btn-text {\r\n");
      out.write("        margin-bottom: .2rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .bui-list > [class*=bui-btn]:last-child {\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-form .bui-label {\r\n");
      out.write("        width: 0.5rem;\r\n");
      out.write("        margin-right: .2rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-form .icon-face,\r\n");
      out.write("    .login-form .icon-lock {\r\n");
      out.write("        font-size: 0.48rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-form .bui-input {\r\n");
      out.write("        height: .6rem;\r\n");
      out.write("        background: none;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-form .bui-btn-text {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        color: #666666;\r\n");
      out.write("        font-size: 0.2rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .copyright {\r\n");
      out.write("        font-size: 0.17rem;\r\n");
      out.write("        color: #999999;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        background-color: #ffffff;\r\n");
      out.write("        padding-bottom: 0.25rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .icon-eye:before {\r\n");
      out.write("        content: \"\\e680\"\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .icon-eye.active:before {\r\n");
      out.write("        content: \"\\e67f\"\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<div class=\"bui-page login-page\">\r\n");
      out.write("    <main>\r\n");
      out.write("        <form id=\"form\" action=\"/staff_phone_login\">\r\n");
      out.write("            <div class=\"logo bui-box-center\">\r\n");
      out.write("                <img src=\"images/demo/logo.png\" alt=\"\">\r\n");
      out.write("                <h1>EWM</h1>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"login-form\">\r\n");
      out.write("                <ul class=\"bui-list\">\r\n");
      out.write("                    <li class=\"bui-btn bui-box clearactive\">\r\n");
      out.write("                        <label class=\"bui-label\" for=\"user\"><i class=\"icon-face\"></i></label>\r\n");
      out.write("                        <div class=\"span1\">\r\n");
      out.write("                            <div class=\"bui-input user-input\">\r\n");
      out.write("                                <input id=\"user\" name=\"username\" type=\"text\" placeholder=\"用户名\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"bui-btn bui-box clearactive\">\r\n");
      out.write("                        <label class=\"bui-label\" for=\"password\"><i class=\"icon-lock\"></i></label>\r\n");
      out.write("                        <div class=\"span1\">\r\n");
      out.write("                            <div class=\"bui-input password-input\">\r\n");
      out.write("                                <input id=\"password\" name=\"password\" type=\"password\" placeholder=\"密码\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <div class=\"bui-btn round primary\" onclick=\"commit();\">\r\n");
      out.write("                    登录\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"bui-btn-text\" href=\"#\">注册</div>\r\n");
      out.write("                <div class=\"bui-btn-text\">忘记密码</div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </main>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("    function commit() {\r\n");
      out.write("        $(\"#form\").submit();\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    /**\r\n");
      out.write("     * 通用登录模板,包含输入交互,提交需要自己绑定验证\r\n");
      out.write("     * 默认模块名: pages/login/login\r\n");
      out.write("     * @return {[object]}  [ 返回一个对象 ]\r\n");
      out.write("     */\r\n");
      out.write("    bui.ready(function () {\r\n");
      out.write("\r\n");
      out.write("        var pageview = {};\r\n");
      out.write("\r\n");
      out.write("        pageview.bind = function () {\r\n");
      out.write("\r\n");
      out.write("            // 手机号,帐号是同个样式名, 获取值的时候,取的是最后一个focus的值\r\n");
      out.write("            var userInput = bui.input({\r\n");
      out.write("                id: \".user-input\",\r\n");
      out.write("                callback: function (e) {\r\n");
      out.write("                    // 清空数据\r\n");
      out.write("                    this.empty();\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            // 密码显示或者隐藏\r\n");
      out.write("            var password = bui.input({\r\n");
      out.write("                id: \".password-input\",\r\n");
      out.write("                iconClass: \".icon-eye\",\r\n");
      out.write("                onBlur: function (e) {\r\n");
      out.write("                    if (e.target.value == '') {\r\n");
      out.write("                        return false;\r\n");
      out.write("                    }\r\n");
      out.write("                    // 注册的时候校验只能4-18位密码\r\n");
      out.write("                    var rule = /^[a-zA-Z0-9_-]{3,18}$/;\r\n");
      out.write("                    if (!rule.test(e.target.value)) {\r\n");
      out.write("                        bui.hint(\"密码只能由4-18位字母或者数字上下横杠组成\");\r\n");
      out.write("                        return false;\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                    return true;\r\n");
      out.write("                },\r\n");
      out.write("                callback: function (e) {\r\n");
      out.write("                    //切换类型\r\n");
      out.write("                    this.toggleType();\r\n");
      out.write("                    //\r\n");
      out.write("                    $(e.target).toggleClass(\"active\")\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        pageview.init = function () {\r\n");
      out.write("\r\n");
      out.write("            // 绑定事件\r\n");
      out.write("            this.bind();\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        // 初始化\r\n");
      out.write("        pageview.init();\r\n");
      out.write("\r\n");
      out.write("        // 输出模块\r\n");
      out.write("        return pageview;\r\n");
      out.write("    })\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
