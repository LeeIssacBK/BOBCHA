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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
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
      out.write("    <title>????????????</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"./resources/css/join.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("  <div>\r\n");
      out.write("        \r\n");
      out.write("        <main id=\"join1\" style=\"padding:10px;\">\r\n");
      out.write("          <div style=\"margin-top:10px; margin-bottom:20px;\">\r\n");
      out.write("              <h3>BOBCHA??? ???????????????????</h3>\r\n");
      out.write("          </div>\r\n");
      out.write("          <form class=\"joinForm\" method=\"post\" action=\"/mypage/userDel_ok\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("            \t<input type=\"checkbox\" id=\"mem_del_agree\" name=\"mem_del_agree\"/>\r\n");
      out.write("            \t<label for=\"mem_del_agree\">???????????? ?????? ??? ?????? ??????</label>\r\n");
      out.write("            \t<div style=\" border:1px solid #ddd; background-color:#fff; border-radius:5px; font-size:12px; padding:10px;\">\r\n");
      out.write("            \t\t<p><br>\r\n");
      out.write("            \t\t\t????????? ????????? ???????????? ??????????????? ?????? ??? ????????????, \r\n");
      out.write("            \t\t\t<br>????????? ????????? ???????????? ??????????????? ????????? ????????????.\r\n");
      out.write("            \t\t\t<br><br>\r\n");
      out.write("            \t\t\t1. ?????? ??????: <b>?????? ?????? ??? ????????? ?????? ??????</b>\r\n");
      out.write("            \t\t\t<br><br>\r\n");
      out.write("            \t\t\t2. ?????? ??????: ???????????? ????????? ????????????(CI), ???????????? ????????????(DI)\r\n");
      out.write("            \t\t\t<br><br>\r\n");
      out.write("            \t\t\t3. ?????? ??????: 3??????\r\n");
      out.write("            \t\t\t<br><br>\r\n");
      out.write("            \t\t\t??? ???????????? ?????? ??? ????????? ?????? ????????? ????????? ????????? ?????????, \r\n");
      out.write("            \t\t\t<br>?????? ?????? ????????? ?????? ?????? ????????? ???????????????.            \t\t\r\n");
      out.write("            \t\t</p>\r\n");
      out.write("            \t</div>\r\n");
      out.write("          \t</div>\r\n");
      out.write("          \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"m_del_cont\">????????? ????????? ???????????????.</label>\r\n");
      out.write("              <div>\r\n");
      out.write("              \t<input class=\"form-control\" type=\"text\" name=\"m_del_cont\" id=\"m_del_cont\" placeholder=\"??????????????? ??????????????????.\" disabled style=\"width:310px; display:inline;\"/>\r\n");
      out.write("\t\t\t\t<select class=\"form-select\" id=\"selectRes\" name=\"m_del_cont\" style=\"float:right; width:80px;\">\r\n");
      out.write("\t\t\t\t\t<option value=\"\" selected>??????</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"??? ?????? ???????????? ?????????.\">??? ?????? ???????????? ?????????.</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"????????? ???????????? ?????????.\">????????? ???????????? ?????????.</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"????????? ?????? ????????????.\">????????? ?????? ????????????.</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"self\">????????????</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <label for=\"m_pw\">????????????</label>\r\n");
      out.write("              <input type=\"password\" id=\"m_pw\" name=\"m_pw\" class=\"form-control\" placeholder=\"??????????????? ??????????????????.\">\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"text-center\">\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary\" id=\"del_mem\" style=\"width:100px; height:30px; margin:auto; margin-top:15px; font-size:13px;\">????????????</button>\r\n");
      out.write("          </div>\r\n");
      out.write("          </form>\r\n");
      out.write("        </main>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("    $(function(){\r\n");
      out.write("\t    <!-- ???????????? select -->\r\n");
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
      out.write("\t\t//????????????2\r\n");
      out.write("\t\t$('#del_mem').click(function(){\r\n");
      out.write("\t\t\t<!-- ????????? ?????? -->\r\n");
      out.write("\t\t\tif($('#mem_del_agree').is(':checked')==false){\r\n");
      out.write("\t\t\t\talert('???????????? ?????? ??? ??????????????? ??????????????? ??????????????? ???????????????.');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t    \t<!--????????????-->\r\n");
      out.write("\t    \tif($('#del_cont').val() == ''){\r\n");
      out.write("\t    \t\talert('????????? ????????? ???????????????.');\r\n");
      out.write("\t    \t\treturn false;\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    \tif($('#m_pw').val() == ''){\r\n");
      out.write("\t    \t\talert('??????????????? ??????????????????.');\r\n");
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
