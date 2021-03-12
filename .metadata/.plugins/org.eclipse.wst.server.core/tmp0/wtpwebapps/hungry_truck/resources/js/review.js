/**
 * 밥차 모달 창 닫기
 * 밥차 등록 수정시 유효성 검사
 * json변환
 * 별 평점
 * 사진업로드
 */

	var positions = fn_javaListToJson(rvlatlng);//json변환
	
	//모달 닫기
	function reviewClose() {
		$('#reviewMod').hide();
		$('#reviewCont').hide();
		$('#reviewEdit').hide();
		
		//취소버튼을 눌렀을때 입력된 값을 모두 제거해줌
		$('#rv_title').val('');
		$('#rv_price').val('');
		$('#rv_content').val('');
		$('#rv_times').val('');
		$('#mon').prop("checked",false);
		$('#tue').prop("checked",false);
		$('#wed').prop("checked",false);
		$('#thu').prop("checked",false);
		$('#fri').prop("checked",false);
		$('#sat').prop("checked",false);
		$('#sun').prop("checked",false);
		$('#rating1').prop("checked",false);
		$('#rating2').prop("checked",false);
		$('#rating3').prop("checked",false);
		$('#rating4').prop("checked",false);
		$('#rating5').prop("checked",false);
		$('#rv_image_file').val('');
	}
	
	//등록, 수정시 유효성 검사
	function checkReview(){
		
		$('#reviewSubBtn').off('click').click(function(){//버튼 클릭이벤트 발생시마다 이벤트 바인딩이 계속되어 1번만 할수있게만들어줌. 
			if($('#rv_title').val()==''){
				alert('가게명을 입력해주세요.');
				$('#rv_title').focus();
				return false;
			}
			if($('#rv_price').val()==''){
				alert('가격정보를 입력해주세요.');
				$('#rv_price').focus();
				return false;
			}
			if($('#rv_content').val()==''){
				alert('제보자 리뷰를 남겨주세요.');
				$('#rv_content').focus();
				return false;
			}
			var chk = 0;
			if($('#mon').is(':checked')==true){
				chk += 1;
			}else if($('#tue').is(':checked')==true){
				chk += 1;
			}else if($('#wed').is(':checked')==true){
				chk += 1;
			}else if($('#thu').is(':checked')==true){
				chk += 1;
			}else if($('#fri').is(':checked')==true){
				chk += 1;
			}else if($('#sat').is(':checked')==true){
				chk += 1;
			}else if($('#sun').is(':checked')==true){
				chk += 1;
			}
			if(chk < 1){
				alert('출몰날짜를 선택해주세요.');
				return false;
			}
			if($('#rv_times').val()==''){
				alert('출몰시간을 선택해주세요.');
				$('#rv_times').focus();
				return false;
			}
			var chk2 = 0;
			if($('#rating1').is(':checked')==true){
				chk2 += 1;
			}else if($('#rating2').is(':checked')==true){
				chk2 += 1;
			}else if($('#rating3').is(':checked')==true){
				chk2 += 1;
			}else if($('#rating4').is(':checked')==true){
				chk2 += 1;
			}else if($('#rating5').is(':checked')==true){
				chk2 += 1;
			}
			if(chk2 < 1){
				alert('평점을 선택해주세요.');
				return false;
			}
			alert('밥차가 등록되었어요!');
			return true;
		});
		
		$('#review_update').off('click').click(function(){//버튼 클릭이벤트 발생시마다 이벤트 바인딩이 계속되어 1번만 할수있게만들어줌. 
			if($('#rv_title2').val()==''){
				alert('가게명을 입력해주세요.');
				$('#rv_title2').focus();
				return false;
			}
			if($('#rv_price2').val()==''){
				alert('가격정보를 입력해주세요.');
				$('#rv_price2').focus();
				return false;
			}
			var chk = 0;
			if($('#mon2').is(':checked')==true){
				chk += 1;
			}else if($('#tue2').is(':checked')==true){
				chk += 1;
			}else if($('#wed2').is(':checked')==true){
				chk += 1;
			}else if($('#thu2').is(':checked')==true){
				chk += 1;
			}else if($('#fri2').is(':checked')==true){
				chk += 1;
			}else if($('#sat2').is(':checked')==true){
				chk += 1;
			}else if($('#sun2').is(':checked')==true){
				chk += 1;
			}
			if(chk < 1){
				alert('출몰날짜를 선택해주세요.');
				return false;
			}
			if($('#rv_times2').val()==''){
				alert('출몰시간을 선택해주세요.');
				$('#rv_times').focus();
				return false;
			}
			alert('밥차가 수정되었어요!');
			return true;
		});
		
	}
	
	
	//json으로 변환
	console.log("fn_javaListToJson : ",positions);
	function fn_javaListToJson(obj){ 
		var resultJson = []; 
		var str = obj.split('[{').join('').split('}]').join(''); //양끝 문자열 제거 
		var rows = str.split('}, {'); //str는 배열 
		for(var i = 0; rows.length > i; i++){ // rows 배열만큼 for돌림 
			var cols = rows[i].split(', '); 
		var rowData = {}; 
		for(var j = 0; cols.length > j; j++){ 
			var colData = cols[j]; 
			colData = colData.trim(); 
			var key = colData.substring(0, colData.indexOf("=")); 
			var val = colData.substring(colData.indexOf("=") +1); 
			rowData[key] = val; } 
		resultJson.push(rowData); 
		} 
		return resultJson; 
	}
		
	//사진 업로드
   	$(document).ready(function(){
   		var fileTarget = $('#file');
   		fileTarget.on('change', function(){
   			var cur = $(".filebox input[type='file']").val();
   			$("#rv_image_file").val(cur);
   		});
   	});
	
	//사진 업로드2
   	$(document).ready(function(){
   		var fileTarget2 = $('#file2');
   		fileTarget2.on('change', function(){
   			var cur2 = $(".filebox2 input[type='file']").val();
   			$("#rv_image_file2").val(cur2);
   		});
   	});
	
	//별평점주기
	//별점 마킹 모듈 프로토타입으로 생성
	function Rating(){};
	Rating.prototype.rate = 0;
	Rating.prototype.setRate = function(newrate){
	    //별점 마킹 - 클릭한 별 이하 모든 별 체크 처리
	    this.rate = newrate;
	    let items = document.querySelectorAll('.rate_radio');
	    items.forEach(function(item, idx){
	        if(idx < newrate){
	            item.checked = true;
	        }else{
	            item.checked = false;
	        }
	    });
	}
	let rating = new Rating();//별점 인스턴스 생성
	
	document.addEventListener('DOMContentLoaded', function(){
	    //별점선택 이벤트 리스너
	    document.querySelector('.rating').addEventListener('click',function(e){
	        let elem = e.target;
	        if(elem.classList.contains('rate_radio')){
	            rating.setRate(parseInt(elem.value));
	        }
	    })
	});