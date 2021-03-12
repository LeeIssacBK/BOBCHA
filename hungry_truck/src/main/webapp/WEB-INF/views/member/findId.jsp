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
    <title>아이디 찾기</title>
  </head>
  <body>
        <main class="login">
          <div style="margin-top:120px;">
              <h3>아이디 찾기</h3>
          </div>
          <p>회원이름과 가입시 등록한 이메일을 입력해주세요.<br>
		          이메일로 회원 아이디의 앞 3자리를 전송합니다.</p>
          <form method="post" action="/member/findId_ok">
            <div class="form-group">
              <label for="id">이름</label>
              <input type="text" id="m_name" name="m_name" class="form-control" placeholder="이름을 입력해주세요.">
            </div>
            
            <div class="form-group">
              <label for="m_email_id">이메일</label>
              <div>
              	<input class="form-control" style="width:130px; display:inline-block;" type="text" name="m_email_id" id="m_email_id" />
              	<span>&nbsp;@&nbsp;</span>
              	<input class="form-control" style="width:130px; display:inline-block;" type="text" name="m_email_domain" id="m_email_domain" disabled/>
				<select class="form-select" id="selectEmail" name="m_email_domain" style="width:100px; float:right;">
					<option value="none" selected>선택</option>
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="gmail.com">gmail.com</option>
					<option value="self">직접입력</option>
				</select>
              </div>
            </div>
            
            <br>
            <div class="text-center">
            <button type="submit" class="btn btn-primary" id="findIdButton" name="findIdButton"  style="width:100px; height:30px; font-size:13px;">전송</button>
            <br><br>
            <a href="" id="login2">로그인</a>&nbsp;|&nbsp;<a href="" id="findPw">비밀번호 찾기</a>
            </div>
          </form>
        </main>
        
    <!-- 이메일 select -->
    <script>
		$(document).ready(function(){	
			
			<!-- 비밀번호 찾기화면 -->
			$('#findPw').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/member/findPw');
				return false;
			});
			<!-- 로그인화면(main.jsp에 있는 login id값과 충돌이 생겨 login2로 지정함.) -->
			$('#login2').click(function(){
				$('.showMenu').empty();
				$('.showMenu').load('/member/userLogin');
				return false;
			});
		});
	
    	$('#selectEmail').change(function(){
    		$('#selectEmail option:selected').each(function(){
    			if($(this).val() == 'self'){
    				$('#m_email_domain').val('');
    				$('#m_email_domain').attr("disabled",false);
    			}else if($(this).val() == 'none'){
    				$('#m_email_domain').val('');
    				$('#m_email_domain').attr("disabled",true);
    			}
    			else{
    				$('#m_email_domain').val($(this).text());
    				$('#m_email_domain').attr("disable",true);
    			}
    		});
    		
			
			<!-- 유효성 검사 -->
			$('#findIdButton').click(function(){
				if($('#m_name').val() == ''){
					alert('이름을 입력해주세요.');
					$('#m_name').focus();
					return false;
				}
				if($('#m_email_id').val() == '' || $('#m_email_domain').val() == ''){
					alert('이메일을 입력해주세요.');
					$('#m_email_id').focus();
					return false;
				}
			});
			
    	});
    </script>
    
  </body>
</html>
