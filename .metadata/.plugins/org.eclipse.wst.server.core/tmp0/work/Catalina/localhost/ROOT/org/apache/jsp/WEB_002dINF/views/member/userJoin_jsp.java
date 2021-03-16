/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.41
 * Generated at: 2021-03-15 07:06:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userJoin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\r\n");
      out.write("<title>약관동의</title>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./resources/css/join.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<main id=\"join1\" class=\"showMenu\">\r\n");
      out.write("\t\t<div style=\"margin-top:10px;\">\r\n");
      out.write("\t\t\t<h3>&nbsp;&nbsp;약관동의</h3>\r\n");
      out.write("\t\t\t<p>&nbsp;&nbsp;&nbsp;회원가입을 위해 약관동의해주세요.</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form id=\"joinForm\">\r\n");
      out.write("\t\t\t<ul class=\"join_box\">\r\n");
      out.write("\t\t\t\t<li class=\"checkBox check01\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<li>이용약관, 개인정보 수집 및 이용, 위치정보 이용약관(선택), 프로모션 안내메일 수신(선택)에 모두\r\n");
      out.write("\t\t\t\t\t\t\t동의합니다.</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"checkAllBtn\"><input type=\"checkbox\" name=\"check2\" id=\"check2\" class=\"chkAll\"></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li class=\"checkBox check02\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<li>이용약관 동의(필수)</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"checkBtn\"><input type=\"checkbox\" name=\"check1\" id=\"chk1\">\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul> <textarea name=\"\" id=\"\" readonly>여러분을 환영합니다. 네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.\r\n");
      out.write("\t\t\t\t\t</textarea>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li class=\"checkBox check03\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<li>개인정보 수집 및 이용에 대한 안내(필수)</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"checkBtn\"><input type=\"checkbox\" name=\"check1\" id=\"chk2\">\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul> <textarea name=\"\" id=\"\" readonly>여러분을 환영합니다. 네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.\r\n");
      out.write("\t\t\t       </textarea>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li class=\"checkBox check03\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<li>위치정보 이용약관 동의(선택)</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"checkBtn\"><input type=\"checkbox\" name=\"check1\">\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul> <textarea name=\"\" id=\"\" readonly>여러분을 환영합니다. 네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.\r\n");
      out.write("       \t\t\t\t</textarea>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li class=\"checkBox check04\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<li>이벤트 등 프로모션 알림 메일 수신(선택)</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"checkBtn\"><input type=\"checkbox\" name=\"check1\">\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<div class=\"text-center\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" id=\"agree\" style=\"width:100px; height:30px; margin:auto; margin-top:10px; font-size:13px;\">동의해요</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</main>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 페이지 이동소스 -->\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t//회원가입2\r\n");
      out.write("\t\t\t$('#agree').click(function(){\r\n");
      out.write("\t\t\t\t<!-- 유효성 검증 -->\r\n");
      out.write("\t\t\t\tvar chk1 = document.getElementById('chk1');\r\n");
      out.write("\t\t\t\tvar chk2 = document.getElementById('chk2');\r\n");
      out.write("\t\t\t\tvar flag = false;\r\n");
      out.write("\t\t\t\tvar num = 0;\r\n");
      out.write("\t\t\t\tif($('#chk1').is(':checked')==true){\r\n");
      out.write("\t\t\t\t\tnum+=1;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif($('#chk2').is(':checked')==true){\r\n");
      out.write("\t\t\t\t\tnum+=1;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(num == 2){\r\n");
      out.write("\t\t\t\t\tflag = true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(flag){\r\n");
      out.write("\t\t\t\t\t$('.showMenu').empty();\r\n");
      out.write("\t\t\t\t\t$('.showMenu').load('/member/userJoin2');\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\talert('필수 약관에 동의해주세요.');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 체크박스 확인 -->\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction allCheck() {\r\n");
      out.write("\t\t\t$(\"[name=check2]\").prop(\"checked\", true);\r\n");
      out.write("\t\t}// 모두 체크하기\r\n");
      out.write("\r\n");
      out.write("\t\tfunction oneCheck(a) {\r\n");
      out.write("\t\t\tvar allChkBox = $(\"[name=check1]\");\r\n");
      out.write("\t\t\tvar chkBoxName = $(a).attr(\"name\");\r\n");
      out.write("\r\n");
      out.write("\t\t\tif ($(a).prop(\"checked\")) {\r\n");
      out.write("\t\t\t\tcheckBoxLength = $(\"[name=\" + chkBoxName + \"]\").length;\r\n");
      out.write("\t\t\t\t//전체체크박스 수(모두동의하기 체크박스 제외)\r\n");
      out.write("\t\t\t\tcheckedLength = $(\"[name=\" + chkBoxName + \"]:checked\").length;\r\n");
      out.write("\t\t\t\t//체크된 체크박스 수 \r\n");
      out.write("\t\t\t\tif (checkBoxLength == checkedLength) {\r\n");
      out.write("\t\t\t\t\tallChkBox.prop(\"checked\", true);\r\n");
      out.write("\t\t\t\t\t//전체체크박스수 == 체크된 체크박스 수 같다면 모두체크\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tallChkBox.prop(\"checked\", false);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tallChkBox.prop(\"checked\", false);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$(\"[name=check1]\").click(function() {\r\n");
      out.write("\t\t\t\tallCheck(this);\r\n");
      out.write("\t\t\t\t//모두동의하기 체크박스 클릭시\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\"[name=check2]\").each(function() {\r\n");
      out.write("\t\t\t\t$(this).click(function() {\r\n");
      out.write("\t\t\t\t\toneCheck(this);\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
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
