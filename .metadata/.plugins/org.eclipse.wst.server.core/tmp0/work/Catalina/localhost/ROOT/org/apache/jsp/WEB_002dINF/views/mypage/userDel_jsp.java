/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.41
 * Generated at: 2021-03-18 13:24:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.mypage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userDel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/java_web/foodtruck/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/hungry_truck/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1610516075936L));
  }

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
      out.write("  <head>\r\n");
      out.write("    <title>회원탈퇴</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"./resources/css/join.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("  <div>\r\n");
      out.write("        \r\n");
      out.write("        <main id=\"join1\" style=\"padding:10px;\">\r\n");
      out.write("          <div style=\"margin-top:10px; margin-bottom:20px;\">\r\n");
      out.write("              <h3>BOBCHA를 떠나실건가요?</h3>\r\n");
      out.write("          </div>\r\n");
      out.write("          <form class=\"joinForm\" method=\"post\" action=\"/mypage/userDel_ok\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("            \t<input type=\"checkbox\" id=\"mem_del_agree\" name=\"mem_del_agree\"/>\r\n");
      out.write("            \t<label for=\"mem_del_agree\">개인정보 보유 및 이용 동의</label>\r\n");
      out.write("            \t<div style=\" border:1px solid #ddd; background-color:#fff; border-radius:5px; font-size:12px; padding:10px;\">\r\n");
      out.write("            \t\t<p><br>\r\n");
      out.write("            \t\t\t밥차는 아래의 목적으로 개인정보를 보유 및 이용하며, \r\n");
      out.write("            \t\t\t<br>수집된 정보를 안전하게 취급하는데 최선을 다합니다.\r\n");
      out.write("            \t\t\t<br><br>\r\n");
      out.write("            \t\t\t1. 보존 근거: <b>회원 탈퇴 후 재가입 방지 목적</b>\r\n");
      out.write("            \t\t\t<br><br>\r\n");
      out.write("            \t\t\t2. 보존 항목: 암호화된 동일인 식별정보(CI), 중복가입 확인정보(DI)\r\n");
      out.write("            \t\t\t<br><br>\r\n");
      out.write("            \t\t\t3. 보존 기간: 3개월\r\n");
      out.write("            \t\t\t<br><br>\r\n");
      out.write("            \t\t\t위 개인정보 보유 및 이용에 대한 동의를 거부할 권리가 있으나, \r\n");
      out.write("            \t\t\t<br>동의 거부 시에는 회원 탈퇴 진행이 불가합니다.            \t\t\r\n");
      out.write("            \t\t</p>\r\n");
      out.write("            \t</div>\r\n");
      out.write("          \t</div>\r\n");
      out.write("          \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"m_del_cont\">떠나는 이유를 남겨주세요.</label>\r\n");
      out.write("              <div>\r\n");
      out.write("              \t<input class=\"form-control\" type=\"text\" name=\"m_del_cont\" id=\"m_del_cont\" placeholder=\"탈퇴사유를 입력해주세요.\" disabled style=\"width:310px; display:inline;\"/>\r\n");
      out.write("\t\t\t\t<select class=\"form-select\" id=\"selectRes\" name=\"m_del_cont\" style=\"float:right; width:80px;\">\r\n");
      out.write("\t\t\t\t\t<option value=\"\" selected>선택</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"더 이상 이용하지 않아요.\">더 이상 이용하지 않아요.</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"중복된 아이디가 있어요.\">중복된 아이디가 있어요.</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"정보가 너무 부족해요.\">정보가 너무 부족해요.</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"self\">직접입력</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"m_pw\">비밀번호</label>\r\n");
      out.write("              <input type=\"password\" id=\"m_pw\" name=\"m_pw\" class=\"form-control\" placeholder=\"비밀번호를 입력해주세요.\">\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"text-center\">\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary\" id=\"del_mem\" style=\"width:100px; height:30px; margin:auto; margin-top:15px; font-size:13px;\">탈퇴하기</button>\r\n");
      out.write("          </div>\r\n");
      out.write("          </form>\r\n");
      out.write("        </main>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("    $(function(){\r\n");
      out.write("\t    <!-- 탈퇴사유 select -->\r\n");
      out.write("    \t$('#selectRes').change(function(){\r\n");
      out.write("    \t\t$('#selectRes option:selected').each(function(){\r\n");
      out.write("    \t\t\tif($(this).val() == 'self'){\r\n");
      out.write("    \t\t\t\t$('#m_del_cont').val('');\r\n");
      out.write("    \t\t\t\t$('#m_del_cont').attr(\"disabled\",false);\r\n");
      out.write("    \t\t\t}else if($(this).val() == ''){\r\n");
      out.write("    \t\t\t\t$('#m_del_cont').val('');\r\n");
      out.write("    \t\t\t\t$('#m_del_cont').attr(\"disabled\",true);\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t\telse{\r\n");
      out.write("    \t\t\t\t$('#m_del_cont').val($(this).text());\r\n");
      out.write("    \t\t\t\t$('#m_del_cont').attr(\"disable\",true);\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t});\r\n");
      out.write("    \t});\r\n");
      out.write("    });\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t//회원가입2\r\n");
      out.write("\t\t$('#del_mem').click(function(){\r\n");
      out.write("\t\t\t<!-- 유효성 검증 -->\r\n");
      out.write("\t\t\tif($('#mem_del_agree').is(':checked')==false){\r\n");
      out.write("\t\t\t\talert('개인정보 보유 및 이용동의를 하지않으면 탈퇴진행이 불가합니다.');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t    \t<!--공백검사-->\r\n");
      out.write("\t    \tif($('#del_cont').val() == ''){\r\n");
      out.write("\t    \t\talert('떠나는 이유를 남겨주세요.');\r\n");
      out.write("\t    \t\treturn false;\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    \tif($('#m_pw').val() == ''){\r\n");
      out.write("\t    \t\talert('비밀번호를 입력해주세요.');\r\n");
      out.write("\t    \t\t$('#_pw').focus();\r\n");
      out.write("\t    \t\treturn false;\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t</script>\r\n");
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
