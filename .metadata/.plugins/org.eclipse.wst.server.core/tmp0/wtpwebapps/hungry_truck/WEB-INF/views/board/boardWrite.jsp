<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
  <head>
    <title>글쓰기</title>
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
              <h3>글 쓰기</h3>
          </div>
          <form class="pt-3 md-3" method="post" action="/board/boardWrite_ok">
            <div class="form-group">
              <label>작성자</label>
              <input type="text" class="form-control" id="b_writer" name="b_writer" readonly value="${sessionScope.m_id}">
            </div>
            <div class="form-group">
              <label>제목</label>
              <input type="text" class="form-control" id="b_title" name="b_title" placeholder="제목을 입력해주세요.">
            </div>
            <div class="form-group">
              <label>내용</label>
              <textarea class="form-control" placeholder="내용을 입력해주세요." id="b_cont" name="b_cont" style="height: 320px;"></textarea>
            </div>
            <button type="submit" id="writeButton" class="btn btn-primary" style="width:60px; height:30px; font-size:13px; margin-top:20px; float:right;">글쓰기</button>
          </form>
        </main>
  </body>
  <script>
	$(document).ready(function(){		
		<!-- 회원정보 수정화면 -->
		$('#writeButton').click(function(){
			if($('#b_title').val() == ''){
				alert('제목을 입력하세요.');
				$('#b_title').focus();
				return false;
			}
			if($('#b_cont').val() == ''){
				alert('제목을 입력하세요.');
				$('#b_cont').focus();
				return false;
			}
		});
	});
  </script>
</html>
