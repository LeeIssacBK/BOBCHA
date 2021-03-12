<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
    <title>회원가입</title>
	<link rel="stylesheet" href="./resources/css/join2.css">
  </head>
  <body>
        <main id="join2">
		<div>
          <h3>회원가입</h3>
          <p>가입 후 더 다양한 정보를 얻을 수 있어요!</p>
        </div>
          <form name="m" class="jform" method="post" action="/member/join_ok" enctype="multipart/form-data">
            <div class="form-group">
              <label for="m_id">아이디</label>
              <div>
	              <input type="text" id="m_id" name="m_id" class="form-control" placeholder="아이디 (4-12자 이하, 영문,숫자 사용가능)" maxLength="20" required style="width:306px; display:inline;">
	              <button class="btn btn-primary" type="button" id="checkId" style="float:right; width:70px; height:38px; position:relative; right:25px;">체크</button>
              </div>
            </div>
            
            <div class="form-group">
              <label for="m_pw">비밀번호</label>
              <input type="password" id="m_pw" name="m_pw" class="form-control" placeholder="비밀번호 (8자 이상, 문자/숫자/기호 사용 가능)" style="width:384px;">
            </div>
            
            <div class="form-group">
              <label for="m_pw2">비밀번호 확인</label>
              <input type="password" id="m_pw2" name="m_pw2" class="form-control" placeholder="위와 같은 비밀번호를 다시 입력해주세요." style="width:384px;">
            </div>
            
            <div class="form-group">
                <label for="m_name">이름</label><br>
                <input type="text" id="m_name" name="m_name" class="form-control" placeholder="이름을 입력해주세요." style="width:269px; display:inline; margin-right:5px;">
	           	<nav>
					<input id="male" type="radio" name="m_gender" value="남자" checked/><label class="male" for="male">남자</label>
					<input id="female" type="radio" name="m_gender" value="여자" /><label class="female" for="female">여자</label>
				</nav>
            </div>
            
            <div class="form-group">
            	<label for="m_bir_yy">생년월일</label>
            	<div>
	            	<input type="text" class="form-control" style="width:122px; display:inline; margin-right:5px;" id="m_bir_yy" name="m_bir_yy" maxLength="4" placeholder="YYYY"/>
	            	<input type="text" class="form-control" style="width:122px; display:inline; margin-right:5px;" id="m_bir_mm" name="m_bir_mm" maxLength="2" placeholder="MM"/>
	            	<input type="text" class="form-control" style="width:122px; display:inline;" id="m_bir_dd" maxLength="2" name="m_bir_dd" placeholder="DD"/>
            	</div>
            </div>
            
            <div class="form-group">
            	<label for="m_pho_1">연락처</label>
            	<div>
	            	<input type="text" class="form-control" style="width:122px; display:inline; margin-right:5px;" id="m_pho_1" name="m_pho_1" maxLength="3" value="010"/>
	            	<input type="text" class="form-control" style="width:122px; display:inline; margin-right:5px;" id="m_pho_2" name="m_pho_2" maxLength="4"/>
	            	<input type="text" class="form-control" style="width:122px; display:inline;" id="m_pho_3" name="m_pho_3" maxLength="4"/>
            	</div>
            </div>
            
            <div class="form-group">
	            <label for="m_post">주소</label><br>
				<input style="width:306px; display:inline;" class="form-control" type="text" id="sample6_postcode" name="m_post" placeholder="우편번호">
				<input class="btn btn-primary" type="button" onclick="sample6_execDaumPostcode()" value="검색" style="float:right; width:70px; height:38px; position:relative; right:25px;">
                <input class="form-control" style="margin-top:5px; width:384px;" type="text" id="sample6_address" name="m_addr_1" placeholder="주소">
				<input class="form-control" style="margin-top:5px; width:384px;" type="text" id="sample6_extraAddress" name="m_addr_2" placeholder="참고항목">
				<input class="form-control" style="margin-top:5px; width:384px;" type="text" id="sample6_detailAddress" name="m_addr_3" placeholder="상세주소">
			</div>
			
            <div class="form-group">
              <label for="m_email_id">이메일</label>
              <div>
              	<input class="form-control" style="width:120px; display:inline-block;" type="text" name="m_email_id" id="m_email_id" />
              	<span>&nbsp;@&nbsp;</span>
              	<input class="form-control" style="width:120px; display:inline-block;" type="text" name="m_email_domain" id="m_email_domain" disabled/>
				<select class="form-select" id="selectEmail" name="m_email_domain" style="width:100px; float:right; position:relative; right:30px;">
					<option value="" selected>선택</option>
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="gmail.com">gmail.com</option>
					<option value="self">직접입력</option>
				</select>
              </div>
            </div>
            
            <div class="form-group">
            	<label>프로필사진</label>
            	<div class="filebox">
	            	<div>
	            		<input id="m_profile" class="form-control" readonly placeholder="이미지 파일만 업로드 해주세요." style="width:306px; display:inline;"/>
	            		<label for="file" style="float:right; position:relative; right:25px; text-align:center; width:70px; height:38px;">첨부</label>
	            		<input type="file" id="file" name="m_profile" accept="image/jpeg, image/jpg, image/png" multiple/>
	            	</div>
            	</div>
            </div>
            <br>
            <div class="text-center">
				<button type="submit" class="btn btn-primary" value="가입하기" id="agree2" style="width:100px; height:30px; margin:auto; margin-top:15px; font-size:13px;">가입하기</button>
            </div>
            <br><br>
          </form>
          </main>
  		<script src="./resources/js/join.js"></script>
  </body>
</html>
