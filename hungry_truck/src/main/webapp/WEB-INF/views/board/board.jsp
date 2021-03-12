<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
  <head>
    <title>게시판</title>
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
         <div>
             <h3>자유게시판</h3>
         </div>
         <p style="float:left;">누구나! 아무거나! 말할 수 있다!</p>
         <p style="float:right;">게시글 수 : ${totalCount}</p>
         <table class="table table-striped">
           <thead>
             <tr style="height:20px;">
               <th scope="col" class="mobile" style="width:55px; text-align:center;">번호</th>
               <th scope="col" class="mobile" style="text-align:center;">제목</th>
               <th scope="col" class="mobile" style="width:80px; text-align:center;">작성자</th>
               <th scope="col" class="mobile" style="width:120px; text-align:center;">날짜</th>
             </tr>
           </thead>
           
           <tbody style="font-size:13px;">
	           <c:if test="${!empty list}">
	           		<c:forEach var="b" items="${list}">
	           			<tr style="height:20px;">
	           				<th scope="row" class="mobile" style="text-align:center;">${b.b_no}</th>
			                <td><a href="" id="b_title${b.b_no}" style="color: #000000;">${b.b_title}
			                	<c:if test="${b.reply_cnt != 0}">&nbsp;&nbsp;<strong>[${b.reply_cnt}]</strong></c:if>
			                </a></td>
			                <td class="mobile" style="text-align:center;">${b.b_writer}</td>
               				<td class="mobile" style="text-align:center;">${b.regdate}</td>
	           			</tr>
	           		</c:forEach>
	           </c:if>
           </tbody>
         </table>
          <ul class="pagination">
          	<%--이전 페이징 --%>
          	<c:if test="${page <= 1}"><%-- 현재 페이지가 1보다 같거나 작은경우 --%>
	            <li class="page-item">
	              <span class="page-link">&laquo;</span> <%-- 앵커태그 비활성화 --%>
	            </li>
            </c:if>
          	<c:if test="${page > 1}">
	            <li class="page-item">
	              <a href="" id="previousPage"><span class="page-link">&laquo;</span></a>
	            </li>
            </c:if>
            
            <%-- 쪽번호 --%>
            <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
            	<c:if test="${a == page}"><%--현재 쪽번호 --%>
		            <li class="page-item active"><span class="page-link mobile">${a}</span></li>    	
            	</c:if>
            	<c:if test="${a != page}"><%--다른 쪽번호 --%>
		            <li class="page-item"><a class="page-link mobile" href="" id="page${a}">${a}</a></li>
            	</c:if>
            </c:forEach>
            
            <%-- 다음 페이징 --%>
            <c:if test="${page >= maxpage}"><%-- 현재 페이지가 마지막페이지보다 같거나 큰경우 앵커태그 비활성화 --%>
	            <li class="page-item">
	              <span class="page-link">&raquo;</span>
	            </li>
            </c:if>
            <c:if test="${page < maxpage}">            
	            <li class="page-item">
	              <a class="page-link" id="forwardPage" href="">&raquo;</a>
	            </li>
            </c:if>
          </ul>
           <a href="" id="boardWrite" class="btn btn-primary" style="width:60px; height:30px; font-size:13px; margin-top:20px; float:right;">글쓰기</a>
        </main>
     <script> 
     
		$(document).ready(function(){
			
			<!-- 글 보기 -->
			<c:forEach var="b" items="${list}">
				$('#b_title${b.b_no}').click(function(){
					$('.showMenu').empty();
					$('.showMenu').load('/board/boardView?b_no=${b.b_no}&page=${page}');
					return false;
				});
			</c:forEach>
				
			<!-- 페이지 이동 -->
			<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
				$('#page${a}').click(function(){
					$('.showMenu').empty();
					$('.showMenu').load('/board/board?page=${a}');
					return false;
				});
			</c:forEach>
				
			$('#forwardPage').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/board/board?page=${page+1}');
				return false;
			});
			
			$('#previousPage').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/board/board?page=${page-1}');
				return false;
			});
			
			<!-- 글 쓰기 -->
			$('#boardWrite').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/board/boardWrite');
				return false;
			});

		});
	</script>
  </body>
</html>
