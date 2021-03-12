<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
  <head>
    <title>회원정보수정</title>
	<link rel="stylesheet" href="./resources/css/join2.css">
  </head>
  <body>
    <div>
    
        <main id="join2">
		<div>
          <h3>회원정보수정</h3>
          <p>회원정보를 수정할 수 있어요!</p>
        </div>
          <form class="jform" method="post" action="/mypage/userEdit_ok"  enctype="multipart/form-data">
            <div class="form-group">
              <label for="userID">아이디</label>
              <div>
	              <input type="text" id="m_id" name="m_id" value="${m.m_id}" class="form-control" maxLength="20" readonly style="width:384px;" >
             </div>
            </div>
            
            <div class="form-group">
              <label for="userPW">수정 할 비밀번호</label>
              <input type="password" id="m_pw" name="m_pw" class="form-control" placeholder="비밀번호 (8자 이상, 문자/숫자/기호 사용 가능)" style="width:384px;">
            </div>
            
            <div class="form-group">
              <label for="userPW2">수정 할 비밀번호 확인</label>
              <input type="password" id="m_pw2" name="m_pw2" class="form-control" placeholder="위와 같은 비밀번호를 다시 입력해주세요." style="width:384px;">
            </div>
            
            <div class="form-group">
                <label for="userName">이름</label>
                <input type="text" id="m_name" name="m_name" value="${m.m_name}" readonly class="form-control" placeholder="이름을 입력하세요." value="기존이름" style="width:384px;">
            </div>
            
            <div class="form-group">
            	<label for="phone1">연락처</label>
            	<div>
	            	<input type="text" class="form-control" value="${m.m_pho_1}" style="width:122px; display:inline; margin-right:5px;" id="m_pho_1" name="m_pho_1"  maxLength="3" value="010"/>
	            	<input type="text" class="form-control" value="${m.m_pho_2}" style="width:122px; display:inline; margin-right:5px;" id="m_pho_2" name="m_pho_2" maxLength="4"/>
	            	<input type="text" class="form-control" value="${m.m_pho_3}" style="width:122px; display:inline;" id="m_pho_3" name="m_pho_3" maxLength="4"/>
            	</div>
            </div>
            
            <div class="form-group">
	            <label for="addr">주소</label><br>
				<input style="width:306px; display:inline;" class="form-control" type="text" id="sample6_postcode" name="m_post" value="${m.m_post}"  placeholder="우편번호">
				<input class="btn btn-primary" type="button" onclick="sample6_execDaumPostcode()" value="검색" style="float:right; width:70px; height:38px; position:relative; right:25px;">
                <input class="form-control" style="margin-top:5px; width:384px;" type="text" id="sample6_address" id="sample6_address" name="m_addr_1" value="${m.m_addr_1}"  placeholder="주소">
				<input class="form-control" style="margin-top:5px; width:384px;" type="text" id="sample6_extraAddress" name="m_addr_2" value="${m.m_addr_2}" placeholder="참고항목">
				<input class="form-control" style="margin-top:5px; width:384px;" type="text" id="sample6_detailAddress" name="m_addr_3" value="${m.m_addr_3}" placeholder="상세주소">
			</div>
			
            <div class="form-group">
              <label for="m_email_id">이메일</label>
              <div>
              	<input class="form-control" style="width:120px; display:inline-block;" type="text" name="m_email_id" id="m_email_id" value="${m.m_email_id}" />
              	<span>&nbsp;@&nbsp;</span>
              	<input class="form-control" style="width:120px; display:inline-block;" type="text" name="m_email_domain" id="m_email_domain" value="${m.m_email_domain}" disabled/>
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
	            		<input id="m_profile" class="form-control" readonly placeholder="이미지 파일만 업로드 해주세요." value="${m.m_profile}" style="width:306px; display:inline;"/>
	            		<label for="file" style="float:right; position:relative; right:25px; text-align:center; width:70px; height:38px;">첨부</label>
	            		<input type="file" id="file" name="m_profile" accept="image/jpeg, image/jpg, image/png" multiple/>
	            	</div>
            	</div>
            </div>
            <br>
            <div class="text-center">
				<input type="submit" class="btn btn-primary" id="edit_member" value="수정하기" style="width:100px; height:30px; margin:auto; margin-top:15px; font-size:13px;" />
            </div>
            <br><br>
          </form>
        </main>
      </div>
  		<script src="./resources/js/edit.js"></script>
  </body>
</html>
