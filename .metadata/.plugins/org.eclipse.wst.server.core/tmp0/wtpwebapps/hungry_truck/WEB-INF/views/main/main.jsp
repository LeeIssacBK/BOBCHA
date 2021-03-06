<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
<!-- jQuery -->
<script src="/resources/js/jquery-3.2.1.min.js"></script>
<!-- 메인 CSS -->
<link rel="stylesheet" type="text/css" href="/resources/css/main.css"></link>
<!-- 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<!--다음 주소 활용 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="./resources/js/postcode.js"></script>

<!-- NaverMaps API 
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=853s8g0fk9&callback=CALLBACK_FUNCTION"></script>
-->


</head>
<body style="background-color:#a6b9c0; font-family:'Hanna', sans-serif;">
	
		<c:choose>
			<c:when test="${sessionScope.m_id eq null}">
			<div style="margin-top:60px;"></div>
			</c:when>
			<c:otherwise>
			<div class="profile" align="center">
				<c:if test="${empty m.m_profile}">
					<img src="/resources/image/profile.jpg" style="border-radius:100px; max-width:30px; max-height:30px; margin-right:10px;">
				</c:if>
				<c:if test="${!empty m.m_profile}">
					<img src="/resources/upload/${m.m_profile}" style="border-radius:100px; max-width:30px; max-height:30px; margin-right:10px;">
				</c:if>
				<b>${m_name} 님</b>
			</div>
			</c:otherwise>
		</c:choose>
				
		<c:choose>
			<c:when test="${sessionScope.m_id eq null}">
				<div class="menu" style="height:200px;">
					<br>
					<a href="" id="home"><img src="/resources/image/home.png" alt="홈" title="홈"/></a><br><br>
					<a href="" id="join"><img src="/resources/image/join.png" alt="회원가입" title="회원가입"/></a><br><br>
					<a href="" id="info"><img src="/resources/image/info.png" alt="문의" title="문의"/></a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="menu">
					<br>
					<a href="" id="home"><img src="/resources/image/home.png" alt="홈" title="홈"/></a><br><br>
					<a href="" id="mypage"><img src="/resources/image/mypage.png" alt="마이페이지" title="마이페이지"/></a><br><br>
					<a href="" id="board"><img src="/resources/image/community.png" alt="자유게시판" title="자유게시판"/></a><br><br>
					<a href="" id="info"><img src="/resources/image/info.png" alt="문의" title="문의"/></a><br><br>
					<a href="" id="logout"><img src="/resources/image/logout.png" alt="로그아웃" title="로그아웃"/></a>
				</div>
			</c:otherwise>
		</c:choose>
	
		<div class="main">
			<!-- 좌측 화면 -->
			<div class="left">
				<img id="logo" src="/resources/image/logo.png" width="100%"/>
				<br><hr>
				<div style="padding:20px;">
					<p>${sessionScope.todayCount}명이 오늘 방문하셨어요.</p>
					<p>${bobchaCount}개의 밥차가 여러분을 기다리고 있어요!</p>
				</div>
				<div class="border rounded overflow-hidden mb-4 shadow-sm position-relative">
					<div class="col p-4 d-flex flex-column position-static">
						<strong class="d-inline-block mb-2 text-primary">What is BOBCHA?</strong>
						<p class="card-text mb-auto">
						밥차는 좀처럼 만나기 힘든 푸드트럭의 <br>
						위치와 리뷰를 나누는 커뮤니티 웹 어플리케이션 입니다. <br>
						우측의 지도를 통해서 다양한 정보를 유저들과 공유하세요!
						</p>
					</div>
				</div>
				<div class="border rounded overflow-hidden mb-4 shadow-sm position-relative">
					<div class="col p-4 d-flex flex-column position-static">
						<strong class="d-inline-block mb-2 text-primary" style="color:#E28FAD;">Why did you make it?</strong>
						<p class="card-text mb-auto">
							내 집근처에 먹을게 없어요. <br>
							푸드트럭이 언제나타나는지 알수가 없어요. <br>
							가격,운영시간,서비스,평점을 나누고 싶어요. 
						</p>
					</div>
				</div>
				
				<br><hr><br>
				<p align="center">Copyright by <b>issac</b></p>
			</div>
			
			<!-- 우측 화면 -->
			<div class="right">
				<div class="right" id="background">
					<div class="showMenu">
						<!-- 네이버지도 API 넣기 
						<div class="location">
							<div id="map" style="width:100%;height:670px;"></div>
						</div>
						-->
						<%@ include file="/WEB-INF/views/review/map.jsp" %>
				</div>
			</div>
			
		</div>
	</div>
	
<!-- <script src="/resources/js/naver_map.js"></script>-->
	
	<!-- 메뉴페이지 이동소스 -->
	<script>
		$(document).ready(function(){
						
			//홈화면
			$('#home').click(function(){
				location.href('/');
				return false;
			});
			
			//회원가입1
			$('#join').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/member/userJoin');
				return false;
			});
			
			//로그인
			$('#login').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/member/userLogin');
				return false;
			});
			
			//마이페이지
			$('#mypage').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/mypage/mypage');
				return false;
			});
			
			//게시판
			$('#board').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/board/board');
				return false;
			});
			
			//인포
			$('#info').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/info/info');
				return false;
			});
			
			//로그아웃
			$('#logout').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/logout');
				return false;
			});
			
			//페이지 get방식 확인후 넘겨줌
			function Request(valuename){
				var rtnval = "";
				var nowAddress = unescape(location.href);
				var parameters = (nowAddress.slice(nowAddress.indexOf("?")+1,nowAddress.length)).split("&");
				for(var i = 0 ; i < parameters.length ; i++){
					var varName = parameters[i].split("=")[0];
					if(varName.toUpperCase() == valuename.toUpperCase()){
						rtnval = parameters[i].split("=")[1];
						break;
					}
				}
				return rtnval;
			}
			var value = Request("pv");
			
			if(value == 'board'){
				history.replaceState({}, null, location.pathname);
				$('.showMenu').empty();
				$('.showMenu').load('/board/board');
				return false;
			}
			if(value == 'mypage'){
				history.replaceState({}, null, location.pathname);
				$('.showMenu').empty();
				$('.showMenu').load('/mypage/mypage');
				return false;
			}
			
			if(value == 'map'){
				history.replaceState({}, null, location.pathname);
				$('.showMenu').empty();
				$('.showMenu').load('/review/map');
				return false;
			}
			
			//세션값 확인
			var session = '${sessionScope.m_id}';
			
			if(session == ""){
				$('.showMenu').empty();
				$('.showMenu').load('/member/userLogin');
			}else{
				$('.showMenu').empty();
				$('.showMenu').load('/review/map');				
			}
		});
	</script>
	

</body>
</html>