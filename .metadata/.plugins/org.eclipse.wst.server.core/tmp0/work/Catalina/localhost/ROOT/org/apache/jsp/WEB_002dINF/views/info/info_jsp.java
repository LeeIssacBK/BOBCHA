/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.41
 * Generated at: 2021-03-18 07:03:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.info;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class info_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <head>\r\n");
      out.write("    <title>문의</title>\r\n");
      out.write("    <style>\r\n");
      out.write("    .info{\r\n");
      out.write("\t\tmargin-left:auto; margin-right:auto; margin-top:70px;\r\n");
      out.write("\t\twidth: 423px; max-min:423px; height:670px; max-height:670px;\r\n");
      out.write("\t\toverflow:auto; padding:10px;\r\n");
      out.write("\t}\r\n");
      out.write("    </style>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("       <main class=\"info\">\r\n");
      out.write("         <div class=\"page-header mt-3\">\r\n");
      out.write("             <h3>문의</h3>\r\n");
      out.write("         </div>\r\n");
      out.write("          <p>밥차의 궁금증을 풀어드려요.</p>\r\n");
      out.write("\t\t<div class=\"accordion\" id=\"accordionExample\">\r\n");
      out.write("\t\t  <div class=\"accordion-item\">\r\n");
      out.write("\t\t    <h2 class=\"accordion-header\" id=\"headingOne\">\r\n");
      out.write("\t\t      <button class=\"accordion-button\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseOne\" aria-expanded=\"true\" aria-controls=\"collapseOne\">\r\n");
      out.write("\t\t        밥차가 뭔가요?\r\n");
      out.write("\t\t      </button>\r\n");
      out.write("\t\t    </h2>\r\n");
      out.write("\t\t    <div id=\"collapseOne\" class=\"accordion-collapse collapse show\" aria-labelledby=\"headingOne\" data-bs-parent=\"#accordionExample\">\r\n");
      out.write("\t\t      <div class=\"accordion-body\" style=\"font-size:15px;\">\r\n");
      out.write("\t\t        <strong style=\"font-size:20px;\">밥차</strong>&nbsp;&nbsp;란 만나기 힘든 푸드트럭과 포장마차의 위치,가격,리뷰등을 공유하며 사람들과의 커뮤니티 활성화를 목적으로 합니다. \r\n");
      out.write("\t\t        밥차는 먹성좋은 개발자 집 근처에 사 먹을게 없는 작은 \"불편함\"으로부터  시작되었습니다. 만약 불편함이 없었다면 생기지 않았을것 입니다. 작은 불편함 하나가 우리 생활에 더 큰 편리함으로 다가옵니다. 배고픈 우리... \"밥차\" 할까요?\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"accordion-item\">\r\n");
      out.write("\t\t    <h2 class=\"accordion-header\" id=\"headingTwo\">\r\n");
      out.write("\t\t      <button class=\"accordion-button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseTwo\" aria-expanded=\"false\" aria-controls=\"collapseTwo\">\r\n");
      out.write("\t\t        이용방법이 궁금해요!\r\n");
      out.write("\t\t      </button>\r\n");
      out.write("\t\t    </h2>\r\n");
      out.write("\t\t    <div id=\"collapseTwo\" class=\"accordion-collapse collapse\" aria-labelledby=\"headingTwo\" data-bs-parent=\"#accordionExample\">\r\n");
      out.write("\t\t      <div class=\"accordion-body\" style=\"font-size:15px;\">\r\n");
      out.write("\t\t        <strong>먼저,</strong>&nbsp;&nbsp;회원가입을 해주세요. <br>\r\n");
      out.write("\t\t \t\t회원가입이 완료되면 홈화면에서 지도를 확인할수 있어요! 지도를 조정하며 유저들이 공유한 푸드트럭 또는 포장마차의 정보를 확인할 수 있습니다. 회원가입하지 않으면 이용할 수 없습니다.\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"accordion-item\">\r\n");
      out.write("\t\t    <h2 class=\"accordion-header\" id=\"headingThree\">\r\n");
      out.write("\t\t      <button class=\"accordion-button collapsed\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapseThree\" aria-expanded=\"false\" aria-controls=\"collapseThree\">\r\n");
      out.write("\t\t        무료인가요?\r\n");
      out.write("\t\t      </button>\r\n");
      out.write("\t\t    </h2>\r\n");
      out.write("\t\t    <div id=\"collapseThree\" class=\"accordion-collapse collapse\" aria-labelledby=\"headingThree\" data-bs-parent=\"#accordionExample\">\r\n");
      out.write("\t\t      <div class=\"accordion-body\" style=\"font-size:15px;\">\r\n");
      out.write("\t\t        <strong>네!</strong>&nbsp;&nbsp;밥차는 평생 무료서비스 입니다.\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("        <div class=\"alert alert-warning alert-dismissible mt-3\" role=\"alert\" style=\"font-size:14px;\">\r\n");
      out.write("\t\t           이외의 사항은 개발자에게 메일주시면 친절히 답해드리겠습니다.\r\n");
      out.write("\t\t       문의메일 issac.lee.dev@gmail.com\r\n");
      out.write("        </div>\r\n");
      out.write("        </main>\r\n");
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
