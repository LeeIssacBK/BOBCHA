/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.41
 * Generated at: 2021-03-08 01:41:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class boardView_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>글 보기</title>\r\n");
      out.write("    <style>\r\n");
      out.write("    .board{\r\n");
      out.write("\t\tmargin-left:auto; margin-right:auto; margin-top:70px;\r\n");
      out.write("\t\twidth: 423px; max-min:423px; height:670px; max-height:645px;\r\n");
      out.write("\t\toverflow:auto; padding:10px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.boardTitle{\r\n");
      out.write("\t\tfont-size:30px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#modDiv{\r\n");
      out.write("\t\twidth:300px;\r\n");
      out.write("\t\theight:200px;\r\n");
      out.write("\t\tborder-radius:20px;\r\n");
      out.write("\t\tbackground-color:#d6dee2;\r\n");
      out.write("\t\tposition:absolute;\r\n");
      out.write("\t\ttop:400px;\r\n");
      out.write("\t\tleft:1025px;\r\n");
      out.write("\t\tmargin-top:-50px;\r\n");
      out.write("\t\tmargin-left:-150px;\r\n");
      out.write("\t\tpadding:10px;\r\n");
      out.write("\t\tz-index:1000; /* position 속성이 absolute 이거나 fixed 이면 요소가 겹쳐지는 순서를 제어할 수 있다. 갑싱 큰것이 먼저 나온다.*/\r\n");
      out.write("\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>  \r\n");
      out.write("        <main class=\"board\">\r\n");
      out.write("          <div class=\"page-header mt-3\">\r\n");
      out.write("              <h3>글 보기</h3>\r\n");
      out.write("          </div>\r\n");
      out.write("          <form class=\"pt-3 md-3\" style=\"max-width: 920px\">\r\n");
      out.write("          <input type=\"hidden\" id=\"b_no\" name=\"b_no\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b.b_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("          \t<input type=\"hidden\" id=\"page\" name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <p class=\"boardTitle\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b.b_title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b.b_writer}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("              <span style=\"float:right;\">조회수&nbsp;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b.viewcnt}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <hr>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <p class=\"boardContent\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b.b_cont}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-top:20px;\">\r\n");
      out.write("\t            ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t            <a href=\"\" id=\"board2\" class=\"btn btn-primary\" style=\"width:60px; height:30px; font-size:13px; margin-top:20px; margin-left:10px; float:right;\">목록</a>\r\n");
      out.write("            </div>\r\n");
      out.write("          </form>\r\n");
      out.write("\t      <br><br><hr>\r\n");
      out.write("\t      \r\n");
      out.write("          <div>\r\n");
      out.write("          \t<h5>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b.reply_cnt}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("개의 댓글</h5>\r\n");
      out.write("          \t<div><input type=\"hidden\" id=\"newReplyWriter\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.m_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/></div>\r\n");
      out.write("          \t<div>\r\n");
      out.write("          \t\t<input class=\"form-control\" id=\"newReplyText\" style=\"width:82%; height:30px; display:inline;\"></input>\r\n");
      out.write("\t          \t<button type=\"button\" id=\"replyAddBtn\" class=\"btn btn-primary\" style=\"float:right; width:15%; height:30px; font-size:13px; \">등록</button>\r\n");
      out.write("          \t</div>\r\n");
      out.write("          </div>\r\n");
      out.write("\t\t          ");
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"modDiv\" style=\"display:none;\">");
      out.write("\r\n");
      out.write("\t\t        \t<div class=\"modal-title\" style=\"display:none;\"></div>\r\n");
      out.write("\t\t\t\t\t<p>댓글수정</p>\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<textarea class=\"form-control\" rows=\"3\" cols=\"30\" id=\"replytext\"  style=\"resize:none;\"></textarea>");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div style=\"float:right; padding:10px;\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" id=\"replyModBtn\" class=\"btn btn-primary\" style=\"width:60px; height:30px; font-size:13px;\" >수정</button>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" id=\"replyDelBtn\" class=\"btn btn-primary\"  style=\"width:60px; height:30px; font-size:13px;\">삭제</button>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" id=\"closeBtn\" class=\"btn btn-primary\"  style=\"width:60px; height:30px; font-size:13px;\"onclick=\"modDivClose();\">닫기</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("          <ul id=\"replies\" style=\"list-style-type:none; padding:10px;\"></ul>\r\n");
      out.write("          \t<script>\r\n");
      out.write("          \t\tvar b_no = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b.b_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(";\r\n");
      out.write("          \t\tvar m_id = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.m_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("          \t\tgetAllList();\r\n");
      out.write("          \t\t\r\n");
      out.write("          \t\t//댓글목록\r\n");
      out.write("          \t\tfunction getAllList(){\r\n");
      out.write("          \t\t\t$.getJSON(\"/replies/all/\"+b_no,function(data){\r\n");
      out.write("          \t\t\t\t//비동기식으로 받아온 데이터는 data매개변수에 저장\r\n");
      out.write("          \t\t\t\tvar str = \"\";\r\n");
      out.write("          \t\t\t\t$(data).each(function(){//each()함수로 반복\r\n");
      out.write("          \t\t\t\t\tif(m_id == this.replyer){\r\n");
      out.write("\t          \t\t\t\t\tstr += \"<li data-r_no='\"+this.r_no+\"' class='replyLi'>\" //data-r_no는 Ajax 속성값\r\n");
      out.write("\t          \t\t\t\t\t+ \"<span id='nick'>\" +this.replyer + \"</span>\"+ \" : <span class='com' style='max-width:423px;'>\"\r\n");
      out.write("\t          \t\t\t\t\t+ this.replytext + \"</span>\" \r\n");
      out.write("\t          \t\t\t\t\t+ '<a style=\"float:right;\"><img src=\"/resources/image/mypage.png\" width=\"12px\" alt=\"댓글수정\" title=\"댓글수정\"/></a>'\r\n");
      out.write("\t          \t\t\t\t\t+ \"</li><br>\";\r\n");
      out.write("          \t\t\t\t\t}else{\r\n");
      out.write("\t          \t\t\t\t\tstr += \"<li data-r_no='\"+this.r_no+\"' class='replyLi'>\" //data-r_no는 Ajax 속성값\r\n");
      out.write("\t          \t\t\t\t\t+ \"<span id='nick'>\" +this.replyer + \"</span>\"+ \" : <span class='com' style='max-width:423px;'>\"\r\n");
      out.write("\t          \t\t\t\t\t+ this.replytext + \"</span>\" + \"</li><br>\";\r\n");
      out.write("          \t\t\t\t\t}\r\n");
      out.write("          \t\t\t\t});\r\n");
      out.write("          \t\t\t\t$('#replies').html(str);\r\n");
      out.write("          \t\t\t});\r\n");
      out.write("          \t\t}\r\n");
      out.write("          \t\t\r\n");
      out.write("          \t\t//댓글수정\r\n");
      out.write("          \t\t$('#replies').on('click','.replyLi a',function(){\r\n");
      out.write("          \t\t\tvar reply = $(this).parent();//부모요소 -> li태그, this는 버튼\r\n");
      out.write("          \t\t\tvar r_no = reply.attr('data-r_no');//data-r_no속성값 댓글번호 저장\r\n");
      out.write("          \t\t\tvar replyer = reply.children('#nick').text();\r\n");
      out.write("          \t\t\tvar replytext = reply.children('.com').text();\r\n");
      out.write("          \t\t\t\r\n");
      out.write("          \t\t\t$('.modal-title').html(r_no); //댓글번호\r\n");
      out.write("          \t\t\t$('#replyer').val(replyer);\r\n");
      out.write("          \t\t\t$('#replytext').val(replytext);//댓글내용\r\n");
      out.write("          \t\t\t$('#modDiv').show();\r\n");
      out.write("          \t\t});\r\n");
      out.write("          \t\t\r\n");
      out.write("          \t\t//댓글 수정 완료\r\n");
      out.write("          \t\t$('#replyModBtn').on('click',function(){\r\n");
      out.write("          \t\t\tvar r_no = $('.modal-title').html();\r\n");
      out.write("          \t\t\tvar replytext = $('#replytext').val();\r\n");
      out.write("          \t\t\t\r\n");
      out.write("          \t\t\t$.ajax({\r\n");
      out.write("          \t\t\t\ttype:'put', \r\n");
      out.write("          \t\t\t\turl:'/replies/'+r_no,\r\n");
      out.write("          \t\t\t\theaders:{\r\n");
      out.write("          \t\t\t\t\t\"Content-Type\":\"application/json\",\r\n");
      out.write("          \t\t\t\t\t\"X-HTTP-Method-Override\":\"PUT\"          \t\t\t\t\t\r\n");
      out.write("          \t\t\t\t},\r\n");
      out.write("          \t\t\t\tdata:JSON.stringify({\r\n");
      out.write("          \t\t\t\t\treplytext:replytext\r\n");
      out.write("          \t\t\t\t}),\r\n");
      out.write("          \t\t\t\tdataType:'text',\r\n");
      out.write("          \t\t\t\tsuccess:function(data){\r\n");
      out.write("          \t\t\t\t\tif(data == 'SUCCESS'){\r\n");
      out.write("          \t\t\t\t\t\talert('댓글이 수정되었어요.');\r\n");
      out.write("          \t\t\t\t\t\t$('#modDiv').hide();\r\n");
      out.write("          \t\t\t\t\t\t$('.showMenu').empty();\r\n");
      out.write("          \t\t\t\t\t\t$('.showMenu').load('/board/boardView?b_no=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b.b_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("');\r\n");
      out.write("          \t\t\t\t\t\tgetAllList();\r\n");
      out.write("          \t\t\t\t\t}\r\n");
      out.write("          \t\t\t\t}\r\n");
      out.write("          \t\t\t});\r\n");
      out.write("          \t\t});\r\n");
      out.write("          \t\t\r\n");
      out.write("          \t\t//댓글삭제\r\n");
      out.write("          \t\t$('#replyDelBtn').on('click',function(){\r\n");
      out.write("          \t\t\tvar r_no = $('.modal-title').html();\r\n");
      out.write("          \t\t\t\r\n");
      out.write("          \t\t\t$.ajax({\r\n");
      out.write("          \t\t\t\ttype:'delete',\r\n");
      out.write("          \t\t\t\turl:'/replies/'+r_no,\r\n");
      out.write("          \t\t\t\theaders:{\r\n");
      out.write("          \t\t\t\t\t\"Content-Type\":\"application/json\",\r\n");
      out.write("          \t\t\t\t\t\"X-HTTP-Method-Override\":\"DELETE\"\r\n");
      out.write("          \t\t\t\t},\r\n");
      out.write("          \t\t\t\tdataType:'text',\r\n");
      out.write("          \t\t\t\tsuccess:function(data){\r\n");
      out.write("          \t\t\t\t\tif(data == 'SUCCESS'){\r\n");
      out.write("          \t\t\t\t\t\talert('댓글이 삭제되었어요.');\r\n");
      out.write("          \t\t\t\t\t\t$('#modDiv').hide();\r\n");
      out.write("          \t\t\t\t\t\t$('.showMenu').empty();\r\n");
      out.write("          \t\t\t\t\t\t$('.showMenu').load('/board/boardView?b_no=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b.b_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("');\r\n");
      out.write("          \t\t\t\t\t\tgetAllList();\r\n");
      out.write("          \t\t\t\t\t}\r\n");
      out.write("          \t\t\t\t}\r\n");
      out.write("          \t\t\t});\r\n");
      out.write("          \t\t});\r\n");
      out.write("          \t\t\r\n");
      out.write("          \t\t//댓글 수정화면 닫기\r\n");
      out.write("          \t\tfunction modDivClose(){\r\n");
      out.write("          \t\t\t$('#modDiv').hide();\r\n");
      out.write("          \t\t}\r\n");
      out.write("          \t\t\r\n");
      out.write("          \t\t//댓글 추가\r\n");
      out.write("          \t\t$('#replyAddBtn').on('click',function(){\r\n");
      out.write("          \t\t\tvar replyer = $('#newReplyWriter').val();//작성자\r\n");
      out.write("          \t\t\tvar replytext = $('#newReplyText').val();//내용\r\n");
      out.write("          \t\t\t\r\n");
      out.write("          \t\t\t$.ajax({\r\n");
      out.write("          \t\t\t\ttype:'post',\r\n");
      out.write("          \t\t\t\turl:'/replies',\r\n");
      out.write("          \t\t\t\theaders:{//http 헤더앞에 붙는 형식\r\n");
      out.write("          \t\t\t\t\t\"Content-Type\":\"application/json\",\r\n");
      out.write("          \t\t\t\t\t\"X-HTTP-Method-Override\":\"POST\"\r\n");
      out.write("          \t\t\t\t},\r\n");
      out.write("          \t\t\t\tdataType:'text',\r\n");
      out.write("          \t\t\t\tdata:JSON.stringify({//보내지는 자료가 JSON형태인 키,밸류\r\n");
      out.write("          \t\t\t\t\tb_no:b_no,\r\n");
      out.write("          \t\t\t\t\treplyer:replyer,\r\n");
      out.write("          \t\t\t\t\treplytext:replytext\r\n");
      out.write("          \t\t\t\t}),\r\n");
      out.write("          \t\t\t\tsuccess:function(data){\r\n");
      out.write("          \t\t\t\t\t//비동기식 성공시 호출되며 받아온데이터는 data매개변수에 저장\r\n");
      out.write("          \t\t\t\t\tif(data == 'SUCCESS'){\r\n");
      out.write("          \t\t\t\t\t\talert('댓글이 등록되었어요.');\r\n");
      out.write("          \t\t\t\t\t\t$('.showMenu').empty();\r\n");
      out.write("          \t\t\t\t\t\t$('.showMenu').load('/board/boardView?b_no=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b.b_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("');\r\n");
      out.write("          \t\t\t\t\t\tgetAllList();\r\n");
      out.write("          \t\t\t\t\t}\r\n");
      out.write("          \t\t\t\t}\r\n");
      out.write("          \t\t\t});\r\n");
      out.write("          \t\t});\r\n");
      out.write("          \t</script>\r\n");
      out.write("          \r\n");
      out.write("        </main>\r\n");
      out.write("        <script>\r\n");
      out.write("  \t\t$(document).ready(function(){\r\n");
      out.write("  \t\t\t\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t<!-- 글 수정 -->\r\n");
      out.write("\t\t\t$('#boardEdit').click(function(){\r\n");
      out.write("\t\t\t\t$('.showMenu').empty();\r\n");
      out.write("\t\t\t\t$('.showMenu').load('/board/boardEdit?b_no=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b.b_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 글 삭제 -->\r\n");
      out.write("\t\t\t$('#boardDel').click(function(){\r\n");
      out.write("\t\t\t\tlocation.href = './board/boardDel_ok?b_no=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b.b_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 글 목록 -->\r\n");
      out.write("\t\t\t$('#board2').click(function(){\r\n");
      out.write("\t\t\t\t$('.showMenu').empty();\r\n");
      out.write("\t\t\t\t$('.showMenu').load('/board/board?page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("');\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("  \t\t});\r\n");
      out.write("        </script>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/board/boardView.jsp(53,13) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b.b_writer eq sessionScope.m_id}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t            <a href=\"\" id=\"boardEdit\" class=\"btn btn-primary\" style=\"width:60px; height:30px; font-size:13px; margin-top:20px;  margin-left:10px; float:right;\">수정</a>\r\n");
          out.write("\t\t            <a href=\"\" id=\"boardDel\" class=\"btn btn-primary\" style=\"width:60px; height:30px; font-size:13px; margin-top:20px; margin-left:10px; float:right;\">삭제</a>\r\n");
          out.write("\t            ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/views/board/boardView.jsp(217,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("b");
      // /WEB-INF/views/board/boardView.jsp(217,3) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/board/boardView.jsp(217,3) '${b}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${b}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }
}