<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
  <head>
    <title>글 수정</title>
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
              <h3>글 수정</h3>
          </div>
          <form class="pt-3 md-3" style="max-width: 920px" method="post" action="/board/boardEdit_ok">
          	<input type="hidden" id="b_no" name="b_no" value="${b.b_no}"/>
          	<input type="hidden" id="page" name="page" value="${page}"/>
            <div class="form-group">
              <label>작성자</label>
              <input type="text" class="form-control" readonly value="${sessionScope.m_id}">
            </div>
            <div class="form-group">
              <label>제목</label>
              <input type="text" class="form-control" id="b_title" name="b_title" value="${b.b_title}" placeholder="제목을 입력하세요.">
            </div>
            <div class="form-group">
              <label>내용</label>
              <textarea class="form-control" id="b_cont" name="b_cont" placeholder="내용을 입력하세요." style="height: 320px;">${b.b_cont}</textarea>
            </div>
            <button type="submit" class="btn btn-primary" id="editButton" style="width:60px; height:30px; font-size:13px; margin-top:20px; margin-left:10px; float:right;">수정</button>
            <button type="button" class="btn btn-primary" id="boardView3" style="width:60px; height:30px; font-size:13px; margin-top:20px; float:right;">취소</button>
 
          </form>

        </main>
     <script>
  		$(document).ready(function(){
  			<c:set var="b" value="${b}"/>
			<!-- 글 보기 -->
			$('#boardView3').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/board/boardView?b_no=${b.b_no}&page=${page}');
				return false;
			});
			<!--유효성검사-->
			$('#editButton').click(function(){
				if($('#b_title').val() == ''){
					alert('제목을 입력해주세요.');
					$('#b_title').focus();
					return false;
				}				
				if($('#b_cont').val() == ''){
					alert('내용을 입력해주세요.');
					$('#b_cont').focus();
					return false;
				}
			});
		});
	</script>
  </body>
</html>
