<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
<style>
	.login{
		margin-left:auto; margin-right:auto; margin-top:70px;
		width: 423px; max-min:423px; height:670px; max-height:670px;
		overflow:auto; padding:10px;
	}
	a{
		text-decoration:none;
		color:black;
	}
</style>
  <head>
    <title>로그인</title>
  </head>
  <body>
        <main class="login">
          <div style="margin-top:120px;">
              <h3>로그인</h3>
          </div>
          
          <p>아이디와 비밀번호를 입력해주세요.</p>
          <form method="post" action="/member/login_ok">
            <div>
              <label for="m_id">아이디</label>
              <input type="text" id="m_id" name="m_id" class="form-control" placeholder="아이디를 입력해주세요." tabindex="1" value="${id}">
            </div>
            <div class="form-group">
              <label for="m_pw">비밀번호</label>
              <input type="password" id="m_pw" name="m_pw" class="form-control" placeholder="비밀번호를 입력해주세요.">
            </div>
            <br>
            <div class="text-center">
	            <button type="submit" class="btn btn-primary" id="loginButton" name="loginButton" style="width:100px; height:30px; font-size:13px; margin-right:10px;" title="지금 로그인 하세요!">로그인</button>
	            <button type="button" class="btn btn-primary" id="join_in_login" name="join_in_login" style="width:100px; height:30px; font-size:13px; border-color:#E28FAD; background-color:#E28FAD" title="아직 회원이 아니세요?">회원가입</button>
	            <br>
	            <label for="remid" style="margin-top:10px;">
	            	<input type="checkbox" id="remid" name="remid"
	            	/>&nbsp;로그인 상태 유지
	            </label>
	            <br>
	            <a href="" id="findId">아이디 찾기</a>&nbsp;|&nbsp;<a href="" id="findPw">비밀번호 찾기</a>
            </div>
          </form>
        </main>
	<script>
		$(document).ready(function(){

			<!-- 로그인 유효성 검사 -->
			$('#loginButton').click(function(){
				if($('#m_id').val() == ''){
					alert('아이디를 입력해주세요.');
					$('#m_id').focus();
					return false;
				}
				if($('#m_pw').val() == ''){
					alert('비밀번호를 입력해주세요.');
					$('#m_pw').focus();
					return false;
				}
			});
			
			<!-- 회원가입페이지 이동 -->
			$('#join_in_login').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/member/userJoin');
				return false;
			});
			
			<!-- 아이디 찾기 -->
			$('#findId').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/member/findId');
				return false;
			});
		
			<!-- 비밀번호 찾기 -->
			$('#findPw').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/member/findPw');
				return false;
			});
		});
	</script>
  </body>
</html>
