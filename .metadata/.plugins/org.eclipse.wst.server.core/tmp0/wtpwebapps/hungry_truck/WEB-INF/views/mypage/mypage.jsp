<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>마이페이지</title>
    <style>
    .mypage{
		margin-left:auto; margin-right:auto; margin-top:70px;
		width: 423px; max-min:423px; height:644px; max-height:644px;
		overflow:auto; padding:10px;
	}
    </style>
  </head>
  <body>
        <main class="mypage">
         <div>
              <h3>마이페이지</h3>
          </div>
          <div class="pt-4">
	         <h5 style="display:inline;">정보수정</h5>
	         <span style="text-decoration:underline; font-size:12px;">회원정보를 수정할 수 있어요!</span>
	         <input type="button" class="btn btn-primary" value="수정하기" id="userEdit" style="float:right; font-size:12px;  height:30px; width:70px;"/>
          	<hr>
          	<div style="display:inline;">
          		<c:if test="${!empty m.m_profile}">
	          		<img src="/resources/upload${m.m_profile}" style="margin-right:80px; float:left; border-radius:100px; position:relative; left:20px; max-width:120px; max-height:120px;">
          		</c:if>
          		<c:if test="${empty m.m_profile}">
	          		<img src="/resources/image/profile.jpg" style="margin-right:80px; float:left; border-radius:100px; position:relative; left:20px; max-width:120px; max-height:120px;">
          		</c:if>
	          	<ul style="font-size:14px; position:relative; top:10px;">
	          		<li><b>${m_name}</b> 님</li>
	          		<c:if test="${!empty myLikeCount}">
		          		<li>내가 찜한 밥차 <b>${myLikeCount}</b> 개</li>
	          		</c:if>
	          		<c:if test="${empty myLikeCount}">
		          		<li>내가 찜한 밥차 <b>0</b> 개</li>
	          		</c:if>
	          		<c:if test="${!empty myReviewCount}">
	          			<li>내가 제보한 밥차 <b>${myReviewCount}</b> 개</li>
	          		</c:if>
	          		<c:if test="${empty myReviewCount}">
	          			<li>내가 제보한 밥차 <b>0</b> 개</li>
	          		</c:if>
	          		
	          		<c:if test="${!empty mySize}">
		          		<li>내가 쓴 글 <b>${mySize}</b> 개</li>
	          		</c:if>
	          		<c:if test="${empty mySize}">
	          			<li>내가 쓴 글 <b>0</b> 개</li>
	          		</c:if>
	          	</ul>
          	</div>
          </div>
          
          <div class="pt-4">
	         <h5 style="display:inline;">내가 찜한 밥차</h5>
	         <span style="text-decoration:underline; font-size:12px;">찜해놓은 밥차를 한눈에 볼수있어요!</span>
	         <input type="button" id="myLibsButton" class="btn btn-primary" value="더보기" style="float:right; font-size:13px;  height:30px; width:70px;"/>
          	<hr>
          	<div>
          	    <c:if test="${!empty myLikeList}">
	              	<c:forEach var="d" items="${myLikeList}" varStatus="status" end="3">
	              		<c:if test="${empty d.rv_image_file}">
		          			<img src="/resources/image/bobcha_icon.png" title="${d.rv_title}" width="83px" style="margin-left:5px; margin-right:5px;">
	              		</c:if>
	              		<c:if test="${!empty d.rv_image_file}">
		          			<img src="/resources/upload${d.rv_image_file}" id="bob${d.rv_no}" title="${d.rv_title}" width="83px" style="margin-left:5px; margin-right:5px;">
	          			</c:if>
	          		</c:forEach>
          		</c:if>
          	    <c:if test="${empty myLikeList}">
	              	<p align="center"><b>아직 찜한 밥차가 없어요.</b></p>
          		</c:if>
          	</div>
          </div>
          
          <div class="pt-4">
            <h5 style="display:inline;">내가 제보한 밥차</h5>
            <span style="text-decoration:underline; font-size:12px;">제보한 밥차를 모아볼 수 있어요!</span>
            <input type="button" id="myCreateButton" class="btn btn-primary" value="더보기" onclick="" style="float:right; font-size:13px;  height:30px; width:70px;"/>
            <hr>
            <table class="table table-striped" style="position:relative; bottom:20px;">
              <thead>
                <tr style="height:20px;">
                  <th style="width:55px; text-align:center;">번호</th>
                  <th style="text-align:center;">제목</th>
                  <th style="width:120px; text-align:center;">날짜</th>
                </tr>
              </thead>
              <tbody>
              <c:if test="${!empty myReviewList}">
              	<c:forEach var="r" items="${myReviewList}" varStatus="status" end="2">
	                <tr style="height:20px;">
	                	<th style="text-align:center;">${r.rv_no}</th>
	                	<td>${r.rv_title}</td>
	                	<td style="text-align:center;">${r.rv_date}</td>
	                </tr>
                </c:forEach>
              </c:if>
              <c:if test='${empty myReviewList}'>
                <tr style="height:20px;">
                  <th style="text-align:center;" colspan="3">제보한 밥차가 없어요.</th>
                </tr>
              </c:if>
              </tbody>
            </table>
          </div>
          
          <div class="pt-4" style="position:relative; bottom:30px;">
            <h5 style="display:inline;">내가 쓴 글</h5>
            <span style="text-decoration:underline; font-size:12px;">내가 쓴 글을 모아볼 수 있어요!</span>
            <input type="button" class="btn btn-primary" value="더보기" id="myWrite" style="float:right; font-size:13px;  height:30px; width:70px;"/>
            <hr>
            <table class="table table-striped" style="position:relative; bottom:20px;">
              <thead>
                <tr style="height:20px;">
                  <th style="width:55px; text-align:center;">번호</th>
                  <th style="text-align:center;">제목</th>
                  <th style="width:120px; text-align:center;">날짜</th>
                </tr>
              </thead>
              <tbody>
              <c:if test="${!empty myList}">
              	<c:forEach var="b" items="${myList}" varStatus="status" end="2">
	                <tr style="height:20px;">
	                	<th style="text-align:center;">${b.b_no}</th>
	                	<td>${b.b_title}</td>
	                	<td style="text-align:center;">${b.regdate}</td>
	                </tr>
                </c:forEach>
              </c:if>
              <c:if test='${empty myList}'>
                <tr style="height:20px;">
                  <th style="text-align:center;" colspan="3">작성한 글이 없어요.</th>
                </tr>
              </c:if>
              </tbody>
            </table>
          </div>
          
          <div class="pt-4" style="position:relative; bottom:60px;">
	         <h5 style="display:inline;">회원탈퇴</h5>
	         <span style="text-decoration:underline; font-size:12px;">정말 떠나실건가요?</span>
	         <input type="button" class="btn btn-primary" value="탈퇴하기" id="userDel" style="float:right; font-size:13px; height:30px; width:70px;"/>
          </div>
          </main>
          
    <script>
		$(document).ready(function(){		
			<!-- 회원정보 수정화면 -->
			$('#userEdit').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/mypage/userEdit');
				return false;
			});
			
			<!-- 회원탈퇴화면 -->
			$('#userDel').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/mypage/userDel');
				return false;
			});
			
			<!-- 내가 쓴 글 화면-->
			$('#myWrite').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/board/board?pv=board&b_writer=${sessionScope.m_id}');
				return false;
			});
			
			<!-- 내가 찜한밥차 더보기 버튼 -->
			$('#myLibsButton').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/review/map?pv=map&attr=1');
				return false;
			});
			
			<!-- 내가 제보한 밥차 더보기 버튼 -->
			$('#myCreateButton').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/review/map?pv=map&attr=2');
				return false;
			});
		});
	</script>
  </body>
</html>
