<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>글 보기</title>
    <style>
    .board{
		margin-left:auto; margin-right:auto; margin-top:70px;
		width: 423px; max-min:423px; height:670px; max-height:645px;
		overflow:auto; padding:10px;
	}
	.boardTitle{
		font-size:30px;
	}
	#modDiv{
		width:300px;
		height:200px;
		border-radius:20px;
		background-color:#d6dee2;
		position:absolute;
		top:400px;
		left:1025px;
		margin-top:-50px;
		margin-left:-150px;
		padding:10px;
		z-index:1000; /* position 속성이 absolute 이거나 fixed 이면 요소가 겹쳐지는 순서를 제어할 수 있다. 갑싱 큰것이 먼저 나온다.*/
	}
	</style>
  </head>
  <body>  
        <main class="board">
          <div class="page-header mt-3">
              <h3>글 보기</h3>
          </div>
          <form class="pt-3 md-3" style="max-width: 920px">
          <input type="hidden" id="b_no" name="b_no" value="${b.b_no}"/>
          	<input type="hidden" id="page" name="page" value="${page}"/>
            <div class="form-group">
              <p class="boardTitle">${b.b_title}</p>
            </div>
            <div class="form-group">
              <span>${b.b_writer}</span>
              <span style="float:right;">조회수&nbsp;${b.viewcnt}</span>
            </div>
            <hr>
            <div class="form-group">
              <p class="boardContent">${b.b_cont}</p>
            </div>
            <div style="margin-top:20px;">
	            <c:if test="${b.b_writer eq sessionScope.m_id}">
		            <a href="" id="boardEdit" class="btn btn-primary" style="width:60px; height:30px; font-size:13px; margin-top:20px;  margin-left:10px; float:right;">수정</a>
		            <a href="" id="boardDel" class="btn btn-primary" style="width:60px; height:30px; font-size:13px; margin-top:20px; margin-left:10px; float:right;">삭제</a>
	            </c:if>
	            <a href="" id="board2" class="btn btn-primary" style="width:60px; height:30px; font-size:13px; margin-top:20px; margin-left:10px; float:right;">목록</a>
            </div>
          </form>
	      <br><br><hr>
	      
          <div>
          	<h5>${b.reply_cnt}개의 댓글</h5>
          	<div><input type="hidden" id="newReplyWriter" value="${sessionScope.m_id}"/></div>
          	<div>
          		<input class="form-control" id="newReplyText" style="width:82%; height:30px; display:inline;"></input>
	          	<button type="button" id="replyAddBtn" class="btn btn-primary" style="float:right; width:15%; height:30px; font-size:13px; ">등록</button>
          	</div>
          </div>
		          <%-- 댓글 수정 화면 --%>
				<div id="modDiv" style="display:none;"><%-- 수정화면을 안나오게 한다. --%>
		        	<div class="modal-title" style="display:none;"></div>
					<p>댓글수정</p>
					<div>
						<textarea class="form-control" rows="3" cols="30" id="replytext"  style="resize:none;"></textarea><%-- 내용이 출력되는 부분 --%>
					</div>
					<div style="float:right; padding:10px;">
						<button type="button" id="replyModBtn" class="btn btn-primary" style="width:60px; height:30px; font-size:13px;" >수정</button>
						<button type="button" id="replyDelBtn" class="btn btn-primary"  style="width:60px; height:30px; font-size:13px;">삭제</button>
						<button type="button" id="closeBtn" class="btn btn-primary"  style="width:60px; height:30px; font-size:13px;"onclick="modDivClose();">닫기</button>
					</div>
				</div>

          <ul id="replies" style="list-style-type:none; padding:10px;"></ul>
          	<script>
          		var b_no = ${b.b_no};
          		var m_id = '${sessionScope.m_id}';
          		getAllList();
          		
          		//댓글목록
          		function getAllList(){
          			$.getJSON("/replies/all/"+b_no,function(data){
          				//비동기식으로 받아온 데이터는 data매개변수에 저장
          				var str = "";
          				$(data).each(function(){//each()함수로 반복
          					if(m_id == this.replyer){
	          					str += "<li data-r_no='"+this.r_no+"' class='replyLi'>" //data-r_no는 Ajax 속성값
	          					+ "<span id='nick'>" +this.replyer + "</span>"+ " : <span class='com' style='max-width:423px;'>"
	          					+ this.replytext + "</span>" 
	          					+ '<a style="float:right;"><img src="/resources/image/mypage.png" width="12px" alt="댓글수정" title="댓글수정"/></a>'
	          					+ "</li><br>";
          					}else{
	          					str += "<li data-r_no='"+this.r_no+"' class='replyLi'>" //data-r_no는 Ajax 속성값
	          					+ "<span id='nick'>" +this.replyer + "</span>"+ " : <span class='com' style='max-width:423px;'>"
	          					+ this.replytext + "</span>" + "</li><br>";
          					}
          				});
          				$('#replies').html(str);
          			});
          		}
          		
          		//댓글수정
          		$('#replies').on('click','.replyLi a',function(){
          			var reply = $(this).parent();//부모요소 -> li태그, this는 버튼
          			var r_no = reply.attr('data-r_no');//data-r_no속성값 댓글번호 저장
          			var replyer = reply.children('#nick').text();
          			var replytext = reply.children('.com').text();
          			
          			$('.modal-title').html(r_no); //댓글번호
          			$('#replyer').val(replyer);
          			$('#replytext').val(replytext);//댓글내용
          			$('#modDiv').show();
          		});
          		
          		//댓글 수정 완료
          		$('#replyModBtn').on('click',function(){
          			var r_no = $('.modal-title').html();
          			var replytext = $('#replytext').val();
          			
          			$.ajax({
          				type:'put', 
          				url:'/replies/'+r_no,
          				headers:{
          					"Content-Type":"application/json",
          					"X-HTTP-Method-Override":"PUT"          					
          				},
          				data:JSON.stringify({
          					replytext:replytext
          				}),
          				dataType:'text',
          				success:function(data){
          					if(data == 'SUCCESS'){
          						alert('댓글이 수정되었어요.');
          						$('#modDiv').hide();
          						$('.showMenu').empty();
          						$('.showMenu').load('/board/boardView?b_no=${b.b_no}&page=${page}');
          						getAllList();
          					}
          				}
          			});
          		});
          		
          		//댓글삭제
          		$('#replyDelBtn').on('click',function(){
          			var r_no = $('.modal-title').html();
          			
          			$.ajax({
          				type:'delete',
          				url:'/replies/'+r_no,
          				headers:{
          					"Content-Type":"application/json",
          					"X-HTTP-Method-Override":"DELETE"
          				},
          				dataType:'text',
          				success:function(data){
          					if(data == 'SUCCESS'){
          						alert('댓글이 삭제되었어요.');
          						$('#modDiv').hide();
          						$('.showMenu').empty();
          						$('.showMenu').load('/board/boardView?b_no=${b.b_no}&page=${page}');
          						getAllList();
          					}
          				}
          			});
          		});
          		
          		//댓글 수정화면 닫기
          		function modDivClose(){
          			$('#modDiv').hide();
          		}
          		
          		//댓글 추가
          		$('#replyAddBtn').on('click',function(){
          			var replyer = $('#newReplyWriter').val();//작성자
          			var replytext = $('#newReplyText').val();//내용
          			
          			$.ajax({
          				type:'post',
          				url:'/replies',
          				headers:{//http 헤더앞에 붙는 형식
          					"Content-Type":"application/json",
          					"X-HTTP-Method-Override":"POST"
          				},
          				dataType:'text',
          				data:JSON.stringify({//보내지는 자료가 JSON형태인 키,밸류
          					b_no:b_no,
          					replyer:replyer,
          					replytext:replytext
          				}),
          				success:function(data){
          					//비동기식 성공시 호출되며 받아온데이터는 data매개변수에 저장
          					if(data == 'SUCCESS'){
          						alert('댓글이 등록되었어요.');
          						$('.showMenu').empty();
          						$('.showMenu').load('/board/boardView?b_no=${b.b_no}&page=${page}');
          						getAllList();
          					}
          				}
          			});
          		});
          	</script>
          
        </main>
        <script>
  		$(document).ready(function(){
  			
			<c:set var="b" value="${b}"/>
			<!-- 글 수정 -->
			$('#boardEdit').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/board/boardEdit?b_no=${b.b_no}&page=${page}');
				return false;
			});
			
			<!-- 글 삭제 -->
			$('#boardDel').click(function(){
				location.href = './board/boardDel_ok?b_no=${b.b_no}&page=${page}';
				return false;
			});
			
			<!-- 글 목록 -->
			$('#board2').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/board/board?page=${page}');
				return false;
			});
			
  		});
        </script>
  </body>
</html>
