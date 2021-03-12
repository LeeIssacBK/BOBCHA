/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.41
 * Generated at: 2021-03-04 00:43:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userJoin2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("    <title>회원가입</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"./resources/css/join2.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("        <main id=\"join2\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("          <h3>회원가입</h3>\r\n");
      out.write("          <p>가입 후 더 다양한 정보를 얻을 수 있어요!</p>\r\n");
      out.write("        </div>\r\n");
      out.write("          <form name=\"m\" class=\"jform\" method=\"post\" action=\"/member/join_ok\" enctype=\"multipart/form-data\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"m_id\">아이디</label>\r\n");
      out.write("              <div>\r\n");
      out.write("\t              <input type=\"text\" id=\"m_id\" name=\"m_id\" class=\"form-control\" placeholder=\"아이디 (4-12자 이하, 영문,숫자 사용가능)\" maxLength=\"20\" required style=\"width:306px; display:inline;\">\r\n");
      out.write("\t              <button class=\"btn btn-primary\" type=\"button\" id=\"checkId\" style=\"float:right; width:70px; height:38px; position:relative; right:25px;\">체크</button>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"m_pw\">비밀번호</label>\r\n");
      out.write("              <input type=\"password\" id=\"m_pw\" name=\"m_pw\" class=\"form-control\" placeholder=\"비밀번호 (8자 이상, 문자/숫자/기호 사용 가능)\" style=\"width:384px;\">\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"m_pw2\">비밀번호 확인</label>\r\n");
      out.write("              <input type=\"password\" id=\"m_pw2\" name=\"m_pw2\" class=\"form-control\" placeholder=\"위와 같은 비밀번호를 다시 입력해주세요.\" style=\"width:384px;\">\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"m_name\">이름</label><br>\r\n");
      out.write("                <input type=\"text\" id=\"m_name\" name=\"m_name\" class=\"form-control\" placeholder=\"이름을 입력해주세요.\" style=\"width:269px; display:inline; margin-right:5px;\">\r\n");
      out.write("\t           \t<nav>\r\n");
      out.write("\t\t\t\t\t<input id=\"male\" type=\"radio\" name=\"m_gender\" value=\"남자\" checked/><label class=\"male\" for=\"male\">남자</label>\r\n");
      out.write("\t\t\t\t\t<input id=\"female\" type=\"radio\" name=\"m_gender\" value=\"여자\" /><label class=\"female\" for=\"female\">여자</label>\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("            \t<label for=\"m_bir_yy\">생년월일</label>\r\n");
      out.write("            \t<div>\r\n");
      out.write("\t            \t<input type=\"text\" class=\"form-control\" style=\"width:122px; display:inline; margin-right:5px;\" id=\"m_bir_yy\" name=\"m_bir_yy\" maxLength=\"4\" placeholder=\"YYYY\"/>\r\n");
      out.write("\t            \t<input type=\"text\" class=\"form-control\" style=\"width:122px; display:inline; margin-right:5px;\" id=\"m_bir_mm\" name=\"m_bir_mm\" maxLength=\"2\" placeholder=\"MM\"/>\r\n");
      out.write("\t            \t<input type=\"text\" class=\"form-control\" style=\"width:122px; display:inline;\" id=\"m_bir_dd\" maxLength=\"2\" name=\"m_bir_dd\" placeholder=\"DD\"/>\r\n");
      out.write("            \t</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("            \t<label for=\"m_pho_1\">연락처</label>\r\n");
      out.write("            \t<div>\r\n");
      out.write("\t            \t<input type=\"text\" class=\"form-control\" style=\"width:122px; display:inline; margin-right:5px;\" id=\"m_pho_1\" name=\"m_pho_1\" maxLength=\"3\" value=\"010\"/>\r\n");
      out.write("\t            \t<input type=\"text\" class=\"form-control\" style=\"width:122px; display:inline; margin-right:5px;\" id=\"m_pho_2\" name=\"m_pho_2\" maxLength=\"4\"/>\r\n");
      out.write("\t            \t<input type=\"text\" class=\"form-control\" style=\"width:122px; display:inline;\" id=\"m_pho_3\" name=\"m_pho_3\" maxLength=\"4\"/>\r\n");
      out.write("            \t</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("\t            <label for=\"m_post\">주소</label><br>\r\n");
      out.write("\t\t\t\t<input style=\"width:306px; display:inline;\" class=\"form-control\" type=\"text\" id=\"sample6_postcode\" name=\"m_post\" placeholder=\"우편번호\">\r\n");
      out.write("\t\t\t\t<input class=\"btn btn-primary\" type=\"button\" onclick=\"sample6_execDaumPostcode()\" value=\"검색\" style=\"float:right; width:70px; height:38px; position:relative; right:25px;\">\r\n");
      out.write("                <input class=\"form-control\" style=\"margin-top:5px; width:384px;\" type=\"text\" id=\"sample6_address\" name=\"m_addr_1\" placeholder=\"주소\">\r\n");
      out.write("\t\t\t\t<input class=\"form-control\" style=\"margin-top:5px; width:384px;\" type=\"text\" id=\"sample6_extraAddress\" name=\"m_addr_2\" placeholder=\"참고항목\">\r\n");
      out.write("\t\t\t\t<input class=\"form-control\" style=\"margin-top:5px; width:384px;\" type=\"text\" id=\"sample6_detailAddress\" name=\"m_addr_3\" placeholder=\"상세주소\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"m_email_id\">이메일</label>\r\n");
      out.write("              <div>\r\n");
      out.write("              \t<input class=\"form-control\" style=\"width:120px; display:inline-block;\" type=\"text\" name=\"m_email_id\" id=\"m_email_id\" />\r\n");
      out.write("              \t<span>&nbsp;@&nbsp;</span>\r\n");
      out.write("              \t<input class=\"form-control\" style=\"width:120px; display:inline-block;\" type=\"text\" name=\"m_email_domain\" id=\"m_email_domain\" disabled/>\r\n");
      out.write("\t\t\t\t<select class=\"form-select\" id=\"selectEmail\" name=\"m_email_domain\" style=\"width:100px; float:right; position:relative; right:30px;\">\r\n");
      out.write("\t\t\t\t\t<option value=\"\" selected>선택</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"naver.com\">naver.com</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"daum.net\">daum.net</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"gmail.com\">gmail.com</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"self\">직접입력</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("            \t<label>프로필사진</label>\r\n");
      out.write("            \t<div class=\"filebox\">\r\n");
      out.write("\t            \t<div>\r\n");
      out.write("\t            \t\t<input id=\"m_profile\" class=\"form-control\" readonly placeholder=\"이미지 파일만 업로드 해주세요.\" style=\"width:306px; display:inline;\"/>\r\n");
      out.write("\t            \t\t<label for=\"file\" style=\"float:right; position:relative; right:25px; text-align:center; width:70px; height:38px;\">첨부</label>\r\n");
      out.write("\t            \t\t<input type=\"file\" id=\"file\" name=\"m_profile\" accept=\"image/jpeg, image/jpg, image/png\" multiple/>\r\n");
      out.write("\t            \t</div>\r\n");
      out.write("            \t</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"text-center\">\r\n");
      out.write("\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\" value=\"가입하기\" id=\"agree2\" style=\"width:100px; height:30px; margin:auto; margin-top:15px; font-size:13px;\">가입하기</button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br><br>\r\n");
      out.write("          </form>\r\n");
      out.write("          </main>\r\n");
      out.write("  \t\t<script src=\"./resources/js/join.js\"></script>\r\n");
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