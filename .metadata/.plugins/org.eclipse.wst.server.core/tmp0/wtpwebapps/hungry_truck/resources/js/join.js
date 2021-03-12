//표현식 모음
var getMail = RegExp(/^[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/); //이메일 도메인 표현식
var getCheck= RegExp(/^[a-zA-Z0-9]{4,12}$/); //아이디 표현식
var getName = RegExp(/^[가-힣a-zA-Z]+$/); //이름 표현식
var getPass = RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/); //비밀번호 표현식 최소8자, 최소하나의 문자, 하나의 숫자 및 하나의 특수문자
var getYY = RegExp(/^(19[0-9][0-9])|(20\d{2})$/);//생년
var getMM = RegExp(/^(0[1-9])|(1[0-2])$/);//생월
var getDD = RegExp(/^(0[1-9])|([1-2][0-9])|(3[0-2])$/);//생일
var getPhone1 = RegExp(/^[0-9]{3}$/);//연락처1
var getPhone2 = RegExp(/^[0-9]{4}$/);//연락처2
var getPhone3 = RegExp(/^[0-9]{4}$/);//연락처3

$(function(){    	
   	<!-- jQuery + Ajax를 통한 아이디 중복체크 -->
   	$(document).ready(function(){
   		$('#agree2').click(function(){
   	   		//아이디 공백검사
   	   		if($('#m_id').val() == ''){
   	   	   		alert('아이디를 입력해주세요.');
   	   	   		$('#id').focus();
   	   	   		return false;
   	   		}
   	   	        	
   	   		//아이디 유효성 검사
   	   		if(!getCheck.test($('#m_id').val())){
   	   	        alert('아이디는 최소 4자 이상 최대 12자 이하 영문,숫자만 가능합니다.');
   	   	        $('#m_id').val('');
   	   	        $('#m_id').focus();
   	   	        return false;
   	   		}
   	   	       	
   	   	    //비밀번호 공백 확인
   	   	    if($('#m_pw').val() == ''){
   	   	    	alert('비밀번호를 입력해주세요.');
   	   	    	$('#m_pw').focus();
   	   	    	return false;
   	   	    }
   	   	    
   	   	    //아이디와 비밀번호가 같은경우 확인
   	   	    if($('#m_id').val() == $('m_pw').val()){
   	   	    	alert('아이디와 비밀번호가 같습니다.');
   	   	        	$('#m_pw').val('');
   	   	        	$('#m_pw').focus();
   	   	        	return false;
   	   	        }
   	   	        
   	   	        //비밀번호 유효성 검사
   	   	        if(!getPass.test($('#m_pw').val())){
   	   	        	alert('비밀번호는 최소 8자 이상의 문자/숫자/특수문자만 가능합니다');
   	   	        	$('#m_pw').val('');
   	   	        	$('#m_pw2').val('');
   	   	        	$('#m_pw').focus('');
   	   	        	return false;
   	   	        }
   	   	        
   	   	        //비밀번호 확인란 공백 확인
   	   	        if($('#m_pw2').val() == ''){
   	   	        	alert('비밀번호 확인을 입력해주세요.');
   	   	        	$('#m_pw2').focus();
   	   	        	return false;
   	   	        }
   	   	        
   	   	        //비밀번호 서로확인
   	   	        if($('#m_pw').val() != $('#m_pw2').val()){
   	   	        	alert('비밀번호 확인이 같게 입력되었는지 다시 확인해주세요.');
   	   	        	$('#m_pw').val('');
   	   	        	$('#m_pw2').val('');
   	   	        	$('#m_pw').focus();
   	   	        	return false;
   	   	        }
   	   	        
   	   	        //이메일 id 검사
   	   	        if(!getCheck.test($('#m_email_id').val())){
   	   	        	alert('이메일 아이디가 잘못되었습니다.');
   	   	        	$('#m_email_id').val('');
   	   	        	$('#m_email_id').val('');
   	   	        	return false;
   	   	        }   	   	        
   	   	        
   	   	        //이메일 유효성 검사       	
   	   	        if(!getMail.test($('#m_email_domain').val())){
   	   	        	alert('이메일 도메인 주소가 잘못되었습니다.');
   	   	        	$('#m_email_domain').val('');
   	   	        	$('#m_email_domain').val('');
   	   	        	return false;
   	   	        }
   	   	        
   	   	        //이름 공백
   	   	        if($('#m_name').val() == ''){
   	   	        	alert('이름을 입력해주세요.');
   	   	        	$('#m_name').focus();
   	   	        	return false;
   	   	        }
   	   	        
   	   	        //이름 유효성 검사
   	   	        if(!getName.test($('#m_name').val())){
   	   	        	alert('이름을 다시 확인해주세요.');
   	   	        	$('#m_name').val('');
   	   	        	$('#m_name').focus();
   	   	        	return false;
   	   	        }
   	   	        
   	   	        //생년월일 공백검사
   	   	        if($('#m_bir_yy').val() == '' || $('#m_bir_mm').val() == '' || $('#m_bir_dd').val() == ''){
   	   	        	alert('생년월일을 입력해주세요.');
   	   	        	$('#m_bir_yy').val('');
   	   	        	$('#m_bir_mm').val('');
   	   	        	$('#m_bir_dd').val('');
   	   	        	$('#m_bir_yy').focus();
   	   	        	return false;
   	   	        }
   	   	        
   	   	        //생년월일 유효성 검사
   	   	        if(!getYY.test($('#m_bir_yy').val())){
   	   	        	alert('태어난 연도를 다시 확인해주세요.');
   	   	        	$('#m_bir_yy').val('');
   	   	        	$('#m_bir_yy').focus();
   	   	        	return false;
   	   	        }else if(!getMM.test($('#m_bir_mm').val())){
   	   	        	alert('태어난 월을 다시 확인해주세요.');
   	   	        	$('#m_bir_mm').val('');
   	   	        	$('#m_bir_mm').focus();
   	   	        	return false;
   	   	        }else if(!getDD.test($('#m_bir_dd').val())){
   	   	        	alert('태어난 일을 다시 확인해주세요.');
   	   	        	$('#m_bir_dd').val('');
   	   	        	$('#m_bir_dd').focus();
   	   	        	return false;
   	   	        }
   	   	        
   	   	        //휴대폰 번호 공백 검사
   	   	        if($('#m_pho_1').val() == '' || $('#m_pho_2').val() == '' || $('#m_pho_3').val() == ''){
   	   	        	alert('연락처를 입력해주세요.');
   	   	        	$('#m_pho_1').val('');
   	   	        	$('#m_pho_2').val('');
   	   	        	$('#m_pho_3').val('');
   	   	        	$('#m_pho_1').focus();
   	   	        	return false;
   	   	        }
   	   	        
   	   	        //휴대폰 번호 유효성 검사
   	   	        if(!getPhone1.test($('#m_pho_1').val())){
   	   	        	alert('연락처를 확인해주세요.');
   	   	        	$('#m_pho_1').val('');
   	   	        	$('#m_pho_1').focus();
   	   	        	return false;
   	   	        }else if(!getPhone2.test($('#m_pho_2').val())){
   	   	        	alert('연락처를 확인해주세요.');
   	   	        	$('#m_pho_2').val('');
   	   	        	$('#m_pho_2').focus();
   	   	        	return false;
   	   	        }else if(!getPhone3.test($('#m_pho_3').val())){
   	   	        	alert('연락처를 확인해주세요.');
   	   	        	$('#m_pho_3').val('');
   	   	        	$('#m_pho_3').focus();
   	   	        	return false;
   	   	        }
   	   	        
   	   	        
   			});
   		
   		$('#checkId').click(function(){
           	//아이디 공백검사
           	if($('#m_id').val() == ''){
           		alert('아이디를 입력해주세요.');
           		$('#id').focus();
           		return false;
           	}
            	
           	//아이디 유효성 검사
           	if(!getCheck.test($('#m_id').val())){
           		alert('아이디는 최소 4자 이상 최대 12자 이하 영문,숫자만 가능합니다.');
           		$('#m_id').val('');
           		$('#m_id').focus();
           		return false;
           	}
   			
   			id = $('#m_id').val();
   			$.ajax({
   				url:'/member/id_check',
   				type:'POST',
   				dataType:'text',
   				contentType:'text/plain; charset=utf-8;',
   				data:id,
   				
   				success: function(data){
   					if(data == 0){
   						console.log('아이디 없음');
   						alert('사용가능한 아이디 입니다.');    								
   					}else{
   						console.log('아이디 있음');
   						alert('중복된 아이디가 존재합니다.');
   					}
   				}
   			});
   			
   		});
   	});
   	
    <!-- 이메일 select -->
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
   	});
   	
   	<!-- 파일첨부 -->
   	$(document).ready(function(){
   		var fileTarget = $('#file');
   		fileTarget.on('change', function(){
   			var cur = $(".filebox input[type='file']").val();
   			$("#m_profile").val(cur);
   		});
   	});
   	
});
   	




