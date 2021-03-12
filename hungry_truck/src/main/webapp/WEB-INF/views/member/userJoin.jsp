<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<title>약관동의</title>
<meta charset="utf-8">
<link rel="stylesheet" href="./resources/css/join.css">
</head>
<body>
	<main id="join1" class="showMenu">
		<div style="margin-top:10px;">
			<h3>&nbsp;&nbsp;약관동의</h3>
			<p>&nbsp;&nbsp;&nbsp;회원가입을 위해 약관동의해주세요.</p>
		</div>
		<form id="joinForm">
			<ul class="join_box">
				<li class="checkBox check01">
					<ul class="clearfix">
						<li>이용약관, 개인정보 수집 및 이용, 위치정보 이용약관(선택), 프로모션 안내메일 수신(선택)에 모두
							동의합니다.</li>
						<li class="checkAllBtn"><input type="checkbox" name="check2" id="check2" class="chkAll"></li>
					</ul>
				</li>
				<li class="checkBox check02">
					<ul class="clearfix">
						<li>이용약관 동의(필수)</li>
						<li class="checkBtn"><input type="checkbox" name="check1" id="chk1">
						</li>
					</ul> <textarea name="" id="" readonly>여러분을 환영합니다. 네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
					</textarea>
				</li>
				<li class="checkBox check03">
					<ul class="clearfix">
						<li>개인정보 수집 및 이용에 대한 안내(필수)</li>
						<li class="checkBtn"><input type="checkbox" name="check1" id="chk2">
						</li>
					</ul> <textarea name="" id="" readonly>여러분을 환영합니다. 네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
			       </textarea>
				</li>
				<li class="checkBox check03">
					<ul class="clearfix">
						<li>위치정보 이용약관 동의(선택)</li>
						<li class="checkBtn"><input type="checkbox" name="check1">
						</li>
					</ul> <textarea name="" id="" readonly>여러분을 환영합니다. 네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
       				</textarea>
				</li>
				<li class="checkBox check04">
					<ul class="clearfix">
						<li>이벤트 등 프로모션 알림 메일 수신(선택)</li>
						<li class="checkBtn"><input type="checkbox" name="check1">
						</li>
					</ul>
				</li>
			</ul>
			<div class="text-center">
				<button type="button" class="btn btn-primary" id="agree" style="width:100px; height:30px; margin:auto; margin-top:10px; font-size:13px;">동의해요</button>
			</div>
		</form>
	</main>
	
	<!-- 페이지 이동소스 -->
	<script>
		$(document).ready(function(){
			//회원가입2
			$('#agree').click(function(){
				<!-- 유효성 검증 -->
				var chk1 = document.getElementById('chk1');
				var chk2 = document.getElementById('chk2');
				var flag = false;
				var num = 0;
				if($('#chk1').is(':checked')==true){
					num+=1;
				}
				if($('#chk2').is(':checked')==true){
					num+=1;
				}
				if(num == 2){
					flag = true;
				}
				if(flag){
					$('.showMenu').empty();
					$('.showMenu').load('/member/userJoin2');
					return false;
				}else{
					alert('필수 약관에 동의해주세요.');
				}
				
				
			});
		});
	</script>
	
	<!-- 체크박스 확인 -->
	<script>
		function allCheck() {
			$("[name=check2]").prop("checked", true);
		}// 모두 체크하기

		function oneCheck(a) {
			var allChkBox = $("[name=check1]");
			var chkBoxName = $(a).attr("name");

			if ($(a).prop("checked")) {
				checkBoxLength = $("[name=" + chkBoxName + "]").length;
				//전체체크박스 수(모두동의하기 체크박스 제외)
				checkedLength = $("[name=" + chkBoxName + "]:checked").length;
				//체크된 체크박스 수 
				if (checkBoxLength == checkedLength) {
					allChkBox.prop("checked", true);
					//전체체크박스수 == 체크된 체크박스 수 같다면 모두체크
				} else {
					allChkBox.prop("checked", false);
				}
			} else {
				allChkBox.prop("checked", false);
			}
		}

		$(function() {
			$("[name=check1]").click(function() {
				allCheck(this);
				//모두동의하기 체크박스 클릭시
			});
			
			$("[name=check2]").each(function() {
				$(this).click(function() {
					oneCheck(this);
				});
			});
		});

	</script>
</body>
</html>
