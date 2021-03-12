<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
  <head>
    <title>글 삭제</title>
    <style>
    .board{
		margin-left:auto; margin-right:auto; margin-top:70px;
		width: 423px; max-min:423px; height:670px; max-height:670px;
		overflow:auto; padding:10px;
	}
    </style>
  </head>
  <body>
        <main class="board">
          <div class="page-header mt-3">
              <h3>글 삭제</h3>
          </div>
          <form class="pt-3 md-3" style="max-width: 920px" method="post" action="/board/boardDel_ok">
          	<input type="hidden" name="page" value="${page}"/>
          	<input type="hidden" id="b_no" name="b_no" value="${b.b_no}"/>
            <div class="form-group">
              <label>비밀번호</label>
              <input type="password" class="form-control" id="m_pw" name="m_pw" placeholder="비밀번호를 입력해주세요.">
            </div>
            <button type="submit" class="btn btn-primary" style="width:60px; height:30px; font-size:13px; margin-top:20px; margin-left:10px; float:right;">삭제</button>
            <button type="button" class="btn btn-primary" id="boardView2" style="width:60px; height:30px; font-size:13px; margin-top:20px; float:right;">취소</button>
            
          </form>

        </main>
     <script>
  		$(document).ready(function(){
  			<c:set var="b" value="${b}"/>
			<!-- 글 보기 -->
			$('#boardView2').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/board/boardView?b_no=${b.b_no}&page=${page}');
				return false;
			});
		});
	</script>
  </body>
</html>
