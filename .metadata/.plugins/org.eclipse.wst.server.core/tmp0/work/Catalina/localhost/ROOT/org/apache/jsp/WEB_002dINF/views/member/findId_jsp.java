/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.41
 * Generated at: 2021-03-23 06:50:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class findId_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("<style>\r\n");
      out.write("\t.login{\r\n");
      out.write("\t\tmargin-left:auto; margin-right:auto; margin-top:70px;\r\n");
      out.write("\t\twidth: 423px; max-min:423px; height:670px; max-height:670px;\r\n");
      out.write("\t\toverflow:auto; padding:10px;\r\n");
      out.write("\t}\r\n");
      out.write("\ta{\r\n");
      out.write("\t\ttext-decoration:none;\r\n");
      out.write("\t\tcolor:black;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>아이디 찾기</title>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("        <main class=\"login\">\r\n");
      out.write("          <div style=\"margin-top:120px;\">\r\n");
      out.write("              <h3>아이디 찾기</h3>\r\n");
      out.write("          </div>\r\n");
      out.write("          <p>회원이름과 가입시 등록한 이메일을 입력해주세요.<br>\r\n");
      out.write("\t\t          이메일로 회원 아이디의 앞 3자리를 전송합니다.</p>\r\n");
      out.write("          <form method=\"post\" action=\"/member/findId_ok\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"id\">이름</label>\r\n");
      out.write("              <input type=\"text\" id=\"m_name\" name=\"m_name\" class=\"form-control\" placeholder=\"이름을 입력해주세요.\">\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"m_email_id\">이메일</label>\r\n");
      out.write("              <div>\r\n");
      out.write("              \t<input class=\"form-control\" style=\"width:130px; display:inline-block;\" type=\"text\" name=\"m_email_id\" id=\"m_email_id\" />\r\n");
      out.write("              \t<span>&nbsp;@&nbsp;</span>\r\n");
      out.write("              \t<input class=\"form-control\" style=\"width:130px; display:inline-block;\" type=\"text\" name=\"m_email_domain\" id=\"m_email_domain\" disabled/>\r\n");
      out.write("\t\t\t\t<select class=\"form-select\" id=\"selectEmail\" name=\"m_email_domain\" style=\"width:100px; float:right;\">\r\n");
      out.write("\t\t\t\t\t<option value=\"none\" selected>선택</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"naver.com\">naver.com</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"daum.net\">daum.net</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"gmail.com\">gmail.com</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"self\">직접입력</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"text-center\">\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary\" id=\"findIdButton\" name=\"findIdButton\"  style=\"width:100px; height:30px; font-size:13px;\">전송</button>\r\n");
      out.write("            <br><br>\r\n");
      out.write("            <a href=\"\" id=\"login2\">로그인</a>&nbsp;|&nbsp;<a href=\"\" id=\"findPw\">비밀번호 찾기</a>\r\n");
      out.write("            </div>\r\n");
      out.write("          </form>\r\n");
      out.write("        </main>\r\n");
      out.write("        \r\n");
      out.write("    <!-- 이메일 select -->\r\n");
      out.write("    <script>\r\n");
      out.write("\t\t$(document).ready(function(){\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 비밀번호 찾기화면 -->\r\n");
      out.write("\t\t\t$('#findPw').click(function(){\r\n");
      out.write("\t\t\t\t$('.showMenu').empty();\r\n");
      out.write("\t\t\t\t$('.showMenu').load('/member/findPw');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t<!-- 로그인화면(main.jsp에 있는 login id값과 충돌이 생겨 login2로 지정함.) -->\r\n");
      out.write("\t\t\t$('#login2').click(function(){\r\n");
      out.write("\t\t\t\t$('.showMenu').empty();\r\n");
      out.write("\t\t\t\t$('.showMenu').load('/member/userLogin');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\r\n");
      out.write("    \t$('#selectEmail').change(function(){\r\n");
      out.write("    \t\t$('#selectEmail option:selected').each(function(){\r\n");
      out.write("    \t\t\tif($(this).val() == 'self'){\r\n");
      out.write("    \t\t\t\t$('#m_email_domain').val('');\r\n");
      out.write("    \t\t\t\t$('#m_email_domain').attr(\"disabled\",false);\r\n");
      out.write("    \t\t\t}else if($(this).val() == 'none'){\r\n");
      out.write("    \t\t\t\t$('#m_email_domain').val('');\r\n");
      out.write("    \t\t\t\t$('#m_email_domain').attr(\"disabled\",true);\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t\telse{\r\n");
      out.write("    \t\t\t\t$('#m_email_domain').val($(this).text());\r\n");
      out.write("    \t\t\t\t$('#m_email_domain').attr(\"disable\",true);\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t});\r\n");
      out.write("    \t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 유효성 검사 -->\r\n");
      out.write("\t\t\t$('#findIdButton').click(function(){\r\n");
      out.write("\t\t\t\tif($('#m_name').val() == ''){\r\n");
      out.write("\t\t\t\t\talert('이름을 입력해주세요.');\r\n");
      out.write("\t\t\t\t\t$('#m_name').focus();\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif($('#m_email_id').val() == '' || $('#m_email_domain').val() == ''){\r\n");
      out.write("\t\t\t\t\talert('이메일을 입력해주세요.');\r\n");
      out.write("\t\t\t\t\t$('#m_email_id').focus();\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("    \t});\r\n");
      out.write("    </script>\r\n");
      out.write("    \r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
