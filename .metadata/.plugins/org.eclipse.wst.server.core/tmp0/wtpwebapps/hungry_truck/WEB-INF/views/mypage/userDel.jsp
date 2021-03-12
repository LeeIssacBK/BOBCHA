<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
  <head>
    <title>회원탈퇴</title>
	<link rel="stylesheet" href="./resources/css/join.css">
  </head>
  <body>
  <div>
        
        <main id="join1" style="padding:10px;">
          <div style="margin-top:10px; margin-bottom:20px;">
              <h3>BOBCHA를 떠나실건가요?</h3>
          </div>
          <form class="joinForm" method="post" action="/mypage/userDel_ok">
            <div class="form-group">
            	<input type="checkbox" id="mem_del_agree" name="mem_del_agree"/>
            	<label for="mem_del_agree">개인정보 보유 및 이용 동의</label>
            	<div style=" border:1px solid #ddd; background-color:#fff; border-radius:5px; font-size:12px; padding:10px;">
            		<p><br>
            			밥차는 아래의 목적으로 개인정보를 보유 및 이용하며, 
            			<br>수집된 정보를 안전하게 취급하는데 최선을 다합니다.
            			<br><br>
            			1. 보존 근거: <b>회원 탈퇴 후 재가입 방지 목적</b>
            			<br><br>
            			2. 보존 항목: 암호화된 동일인 식별정보(CI), 중복가입 확인정보(DI)
            			<br><br>
            			3. 보존 기간: 3개월
            			<br><br>
            			위 개인정보 보유 및 이용에 대한 동의를 거부할 권리가 있으나, 
            			<br>동의 거부 시에는 회원 탈퇴 진행이 불가합니다.            		
            		</p>
            	</div>
          	</div>
          
            <div class="form-group">
              <label for="m_del_cont">떠나는 이유를 남겨주세요.</label>
              <div>
              	<input class="form-control" type="text" name="m_del_cont" id="m_del_cont" placeholder="탈퇴사유를 입력해주세요." disabled style="width:310px; display:inline;"/>
				<select class="form-select" id="selectRes" name="m_del_cont" style="float:right; width:80px;">
					<option value="" selected>선택</option>
					<option value="더 이상 이용하지 않아요.">더 이상 이용하지 않아요.</option>
					<option value="중복된 아이디가 있어요.">중복된 아이디가 있어요.</option>
					<option value="정보가 너무 부족해요.">정보가 너무 부족해요.</option>
					<option value="self">직접입력</option>
				</select>
              </div>
            </div>
            
            <div class="form-group">
              <label for="m_pw">비밀번호</label>
              <input type="password" id="m_pw" name="m_pw" class="form-control" placeholder="비밀번호를 입력해주세요.">
            </div>
            
            <br>
            <div class="text-center">
            <button type="submit" class="btn btn-primary" id="del_mem" style="width:100px; height:30px; margin:auto; margin-top:15px; font-size:13px;">탈퇴하기</button>
          </div>
          </form>
        </main>
      </div>

    <script>
    $(function(){
	    <!-- 탈퇴사유 select -->
    	$('#selectRes').change(function(){
    		$('#selectRes option:selected').each(function(){
    			if($(this).val() == 'self'){
    				$('#m_del_cont').val('');
    				$('#m_del_cont').attr("disabled",false);
    			}else if($(this).val() == ''){
    				$('#m_del_cont').val('');
    				$('#m_del_cont').attr("disabled",true);
    			}
    			else{
    				$('#m_del_cont').val($(this).text());
    				$('#m_del_cont').attr("disable",true);
    			}
    		});
    	});
    });
	$(document).ready(function(){
		//회원가입2
		$('#del_mem').click(function(){
			<!-- 유효성 검증 -->
			if($('#mem_del_agree').is(':checked')==false){
				alert('개인정보 보유 및 이용동의를 하지않으면 탈퇴진행이 불가합니다.');
				return false;
			}
	    	<!--공백검사-->
	    	if($('#del_cont').val() == ''){
	    		alert('떠나는 이유를 남겨주세요.');
	    		return false;
	    	}
	    	if($('#m_pw').val() == ''){
	    		alert('비밀번호를 입력해주세요.');
	    		$('#_pw').focus();
	    		return false;
	    	}
		});
	});
	</script>
  </body>
</html>
