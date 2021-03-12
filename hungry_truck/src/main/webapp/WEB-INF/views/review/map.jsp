<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<!-- 리뷰 등록 화면 -->
	<form method="post" action="/review/review_ok" enctype="multipart/form-data" onclick="return checkReview()">
		<input type="hidden" id="rv_lat" name="rv_lat" value=""/>
		<input type="hidden" id="rv_lng" name="rv_lng" value=""/>
		<input type="hidden" id="rv_writer" name="rv_writer" value="${sessionScope.m_id}"/>
		<div id="reviewMod" style="display:none;">
			<!-- 상시 감추어 놓음 -->
			<h4 style="margin-top: 10px;">밥차등록</h4>
			<div class="form-group">
				<label for="reviewText">가게명</label>
				<input class="form-control" id="rv_title" name="rv_title" style="height: 30px;" placeholder="가게이름을 써주세요." />
			</div>
			<div class="form-group">
				<label>가격정보</label>
				<input class="form-control" id="rv_price" name="rv_price" style="height: 30px;" placeholder="1인분에 3000원 / 개당 1000원 과 같이 남겨주세요." />
			</div>
			<div class="form-group">
				<label>출몰날짜</label>
				<ul class="r_days">
					<li><label for="mon">월</label> <input type="checkbox" id="mon" name="rv_days" value="월" /></li>
					<li><label for="tue">화</label> <input type="checkbox" id="tue" name="rv_days" value="화" /></li>
					<li><label for="wed">수</label> <input type="checkbox" id="wed" name="rv_days" value="수" /></li>
					<li><label for="thu">목</label> <input type="checkbox" id="thu" name="rv_days" value="목" /></li>
					<li><label for="fri">금</label> <input type="checkbox" id="fri" name="rv_days" value="금" /></li>
					<li><label for="sat">토</label> <input type="checkbox" id="sat" name="rv_days" value="토" /></li>
					<li><label for="sun">일</label> <input type="checkbox" id="sun" name="rv_days" value="일" /></li>
				</ul>
			</div>
			<div class="form-group">
				<label>출몰시간</label> 
				<select class="form-select" id="rv_times" name="rv_times" style="width: 230px; height: 33px; float: right; position: relative;">
					<option value="" selected>밥차의 출몰시간을 알려주세요.</option>
					<option value="00:00 ~ 06:00">00:00 ~ 06:00</option>
					<option value="06:00 ~ 12:00">06:00 ~ 12:00</option>
					<option value="12:00 ~ 18:00">12:00 ~ 18:00</option>
					<option value="18:00 ~ 24:00">18:00 ~ 24:00</option>
				</select>
			</div>
			<div class="form-group">
				<label for="reviewText">제보자 리뷰</label>
				<textarea class="form-control" rows="3" cols="30" id="rv_content" name="rv_content" style="resize: none;"></textarea>
				<!-- 내용이 출력되는 부분 -->
			</div>
			<div class="review_rating form-group">
				<p style="float: left; margin-top: 10px;">평점</p>
				<div class="rating" style="float: right; margin-top: 10px;">
					<!-- 해당 별점을 클릭하면 해당 별과 그 왼쪽의 모든 별의 체크박스에 checked 적용 -->
					<input type="checkbox" name="rv_rating" id="rating1" value="1"
						class="rate_radio" title="1점"> <label for="rating1"></label>
					<input type="checkbox" name="rv_rating" id="rating2" value="2"
						class="rate_radio" title="2점"> <label for="rating2"></label>
					<input type="checkbox" name="rv_rating" id="rating3" value="3"
						class="rate_radio" title="3점"> <label for="rating3"></label>
					<input type="checkbox" name="rv_rating" id="rating4" value="4"
						class="rate_radio" title="4점"> <label for="rating4"></label>
					<input type="checkbox" name="rv_rating" id="rating5" value="5"
						class="rate_radio" title="5점"> <label for="rating5"></label>
				</div>
			</div>
			<div class="form-group" style="clear: both;">
				<label>가게사진</label>
				<div class="filebox">
					<div>
						<input id="rv_image_file" class="form-control" readonly
							placeholder="이미지 파일만 업로드 해주세요."
							style="width: 277px; height: 30px; display: inline;" /> <label
							for="file"
							style="float: right; position: relative; text-align: center; width: 60px; height: 30px;">첨부</label>
						<input type="file" id="file" name="rv_image_file"
							accept="image/jpeg, image/jpg, image/png" multiple />
					</div>
				</div>
			</div>
			<div class="form-group" style="float: right; margin-top: 30px;">
				<button type="submit" id="reviewSubBtn" class="btn btn-primary"
					style="width: 60px; height: 30px; font-size: 13px;">등록</button>
				<button type="button" id="reviewCloseBtn" class="btn btn-primary"
					style="width: 60px; height: 30px; font-size: 13px;"
					onclick="reviewClose();">취소</button>
			</div>
		</div>
	</form>
	
	<form method="post" action="/review/review_del">
		<input type="hidden" id="rv_no" name="rv_no" value=""/>
		<!-- 리뷰 보기 화면 -->
		<div id="reviewCont" style="display: none;">
			<!-- 상시 감추어 놓음 -->
			<a href="" id="like"><img src="/resources/image/like_off.png" id="shop_like" title="찜하기" style="float:right; margin-top:15px; width:40px; height:auto;"/></a>
			<h4 style="margin-top:10px;" id="shop_name">가게명</h4>
			<div class="form-group">
				<span id="rv_writer_read"></span>님 께서 제보해주셨어요!
			</div>
			<div class="form-group">
				<img src="" id="shop_img" style="width:100%; height:auto; border-radius:10px;"/>
			</div>
			<div class="form-group">
				<label>가격정보</label> 
				<p id="shop_price"></p>
			</div>
			<div class="form-group">
				<label>출몰날짜</label>
				<p id="shop_days"></p>
			</div>
			<div class="form-group">
				<label>출몰시간</label>
				<p id="shop_times"></p>
			</div>
			<div class="form-group">
				<label for="reviewText">제보자 리뷰</label>
				<p id="shop_review"></p>
			</div>
			<div class="form-group">
				<p style="float: left; ">평점</p>
				<span id="shop_ratings2"></span>
				<div class="rating" id="shop_ratings" style="float: right;"></div>
			</div>
			<div style="clear: both;"></div>
			<div class="form-group" style="float: right; margin-top: 30px;">
				<button type="submit" id="review_del" class="btn btn-primary" style="width: 60px; height: 30px; font-size: 13px;">삭제</button>
				<button type="button" id="review_edit" class="btn btn-primary" style="width: 60px; height: 30px; font-size: 13px;">수정</button>
				<button type="button" class="btn btn-primary" style="width: 60px; height: 30px; font-size: 13px;" onclick="reviewClose();">취소</button>
			</div>
			<div style="clear: both"></div>
			<hr>
			
			<div class="form-group">
          		<h5>0개의 리뷰</h5>
          		<input type="hidden" id="rvr_reply_writer" value="${sessionScope.m_id}"/>
       			<label>리뷰 남기기</label>
          		<div class="form-group">
					<select class="form-select" id="rvr_rating" name="rv_reply" style="width:100px; height:33px; margin-bottom:2px; display:inline;">
						<option value="" selected>평점선택</option>
						<option value="1">1점</option>
						<option value="2">2점</option>
						<option value="3">3점</option>
						<option value="4">4점</option>
						<option value="5">5점</option>
					</select>
	          		<input class="form-control" id="rvr_reply" style="width:165px; height:33px; display:inline;"></input>
		          	<button type="button" id="rvr_SubmitBtn" class="btn btn-primary" style="float:right; width:50px; height:33px; font-size:13px; ">등록</button>
          		</div>
			</div>
			<ul id="rvr_replies" style="list-style-type:none; padding:10px;"></ul>
			<script>
          		var rvr_no = "";
          		var m_id = '${sessionScope.m_id}';
          		getAllList();
          		
          		//댓글목록
          		function getAllList(){
          			$.getJSON("/reviewReplies/all/"+rvr_no,function(data){
          				//비동기식으로 받아온 데이터는 data매개변수에 저장
          				var str = "";
          				$(data).each(function(){//each()함수로 반복
          					if(m_id == this.replyer){
	          					str += "<li data-r_no='"+this.r_no+"' class='replyLi'>" //data-r_no는 Ajax 속성값
	          					+ "<span id='nick'>" +this.replyer + "</span>"+ " : <span class='com' style='max-width:423px;'>"
	          					+ this.replytext + "</span>" 
	          					+ '<a style="float:right;"><img src="/resources/image/mypage.png" width="12px" alt="댓글수정" title="댓글수정"/></a>'
	          					+ "</li><br>";
          					}else{
	          					str += "<li data-r_no='"+this.r_no+"' class='replyLi'>" //data-r_no는 Ajax 속성값
	          					+ "<span id='nick'>" +this.replyer + "</span>"+ " : <span class='com' style='max-width:423px;'>"
	          					+ this.replytext + "</span>" + "</li><br>";
          					}
          				});
          				$('#replies').html(str);
          			});
          		}
          		
          		//댓글수정
          		$('#replies').on('click','.replyLi a',function(){
          			var reply = $(this).parent();//부모요소 -> li태그, this는 버튼
          			var r_no = reply.attr('data-r_no');//data-r_no속성값 댓글번호 저장
          			var replyer = reply.children('#nick').text();
          			var replytext = reply.children('.com').text();
          			
          			$('.modal-title').html(r_no); //댓글번호
          			$('#replyer').val(replyer);
          			$('#replytext').val(replytext);//댓글내용
          			$('#modDiv').show();
          		});
          		
          		//댓글 수정 완료
          		$('#replyModBtn').on('click',function(){
          			var r_no = $('.modal-title').html();
          			var replytext = $('#replytext').val();
          			
          			$.ajax({
          				type:'put', 
          				url:'/replies/'+r_no,
          				headers:{
          					"Content-Type":"application/json",
          					"X-HTTP-Method-Override":"PUT"          					
          				},
          				data:JSON.stringify({
          					replytext:replytext
          				}),
          				dataType:'text',
          				success:function(data){
          					if(data == 'SUCCESS'){
          						alert('댓글이 수정되었어요.');
          						$('#modDiv').hide();
          						$('.showMenu').empty();
          						$('.showMenu').load('/board/boardView?b_no=${b.b_no}&page=${page}');
          						getAllList();
          					}
          				}
          			});
          		});
          		
          		//댓글삭제
          		$('#replyDelBtn').on('click',function(){
          			var r_no = $('.modal-title').html();
          			
          			$.ajax({
          				type:'delete',
          				url:'/replies/'+r_no,
          				headers:{
          					"Content-Type":"application/json",
          					"X-HTTP-Method-Override":"DELETE"
          				},
          				dataType:'text',
          				success:function(data){
          					if(data == 'SUCCESS'){
          						alert('댓글이 삭제되었어요.');
          						$('#modDiv').hide();
          						$('.showMenu').empty();
          						$('.showMenu').load('/board/boardView?b_no=${b.b_no}&page=${page}');
          						getAllList();
          					}
          				}
          			});
          		});
          		
          		//댓글 수정화면 닫기
          		function modDivClose(){
          			$('#modDiv').hide();
          		}
          		
          		//댓글 추가
          		$('#replyAddBtn').on('click',function(){
          			var replyer = $('#newReplyWriter').val();//작성자
          			var replytext = $('#newReplyText').val();//내용
          			
          			$.ajax({
          				type:'post',
          				url:'/replies',
          				headers:{//http 헤더앞에 붙는 형식
          					"Content-Type":"application/json",
          					"X-HTTP-Method-Override":"POST"
          				},
          				dataType:'text',
          				data:JSON.stringify({//보내지는 자료가 JSON형태인 키,밸류
          					b_no:b_no,
          					replyer:replyer,
          					replytext:replytext
          				}),
          				success:function(data){
          					//비동기식 성공시 호출되며 받아온데이터는 data매개변수에 저장
          					if(data == 'SUCCESS'){
          						alert('댓글이 등록되었어요.');
          						$('.showMenu').empty();
          						$('.showMenu').load('/board/boardView?b_no=${b.b_no}&page=${page}');
          						getAllList();
          					}
          				}
          			});
          		});
			</script>
			
		</div>
	</form>
	
	<!-- 리뷰 수정 화면 -->
	<form method="post" action="/review/review_edit" enctype="multipart/form-data">
		<!-- 상시 감추어 놓음 -->
		<input type="hidden" id="rv_no2" name="rv_no" value=""/>
		<div id="reviewEdit" style="display:none;">
			<h4 style="margin-top: 10px;">밥차수정</h4>
			<div class="form-group">
				<label for="reviewText">가게명</label>
				<input class="form-control" id="rv_title2" name="rv_title" style="height: 30px;" placeholder="가게이름을 써주세요." />
			</div>
			<div class="form-group">
				<label>가격정보</label> 
				<input class="form-control" id="rv_price2" name="rv_price" style="height: 30px;" placeholder="1인분에 3000원 / 개당 1000원 과 같이 남겨주세요." />
			</div>
			<div class="form-group">
				<label>출몰날짜</label>
				<ul class="r_days">
					<li><label for="mon">월</label> <input type="checkbox" id="mon2" name="rv_days" value="월" /></li>
					<li><label for="tue">화</label> <input type="checkbox" id="tue2" name="rv_days" value="화" /></li>
					<li><label for="wed">수</label> <input type="checkbox" id="wed2" name="rv_days" value="수" /></li>
					<li><label for="thu">목</label> <input type="checkbox" id="thu2" name="rv_days" value="목" /></li>
					<li><label for="fri">금</label> <input type="checkbox" id="fri2" name="rv_days" value="금" /></li>
					<li><label for="sat">토</label> <input type="checkbox" id="sat2" name="rv_days" value="토" /></li>
					<li><label for="sun">일</label> <input type="checkbox" id="sun2" name="rv_days" value="일" /></li>
				</ul>
			</div>
			<div class="form-group">
				<label>출몰시간</label> 
				<select class="form-select" id="rv_times2" name="rv_times" style="width: 230px; height: 33px; float: right; position: relative;">
					<option value="" selected>밥차의 출몰시간을 알려주세요.</option>
					<option value="00:00 ~ 06:00">00:00 ~ 06:00</option>
					<option value="06:00 ~ 12:00">06:00 ~ 12:00</option>
					<option value="12:00 ~ 18:00">12:00 ~ 18:00</option>
					<option value="18:00 ~ 24:00">18:00 ~ 24:00</option>
				</select>
			</div>
			<div class="form-group" style="clear: both;">
				<label>가게사진</label>
				<div class="filebox2">
					<div>
						<input id="rv_image_file2" class="form-control" readonly placeholder="이미지 파일만 업로드 해주세요." style="width: 277px; height: 30px; display: inline;" /> 
						<label for="file2" style="float: right; position: relative; text-align: center; width: 60px; height: 30px;">첨부</label>
						<input type="file" id="file2" name="rv_image_file" accept="image/jpeg, image/jpg, image/png" multiple />
					</div>
				</div>
			</div>
			<div class="form-group" style="float: right; margin-top: 30px;">
				<button type="submit" id="review_update" class="btn btn-primary" style="width: 60px; height: 30px; font-size: 13px;">수정</button>
				<button type="button" class="btn btn-primary" style="width: 60px; height: 30px; font-size: 13px;" onclick="reviewClose();">취소</button>
			</div>
		</div>
	</form>

	<script>
	//카카오맵 사용
		var container = document.getElementById('map');
		var options = {
			center : new kakao.maps.LatLng(33.450701, 126.570667),
			level : 3
		};
		var map = new kakao.maps.Map(container, options);

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		// 회원의 주소지를 가져옴.
		var myAddr = '${m.m_addr_1}';

		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(myAddr,function(result, status) {
			// 정상적으로 검색이 완료됐으면 
			if (status === kakao.maps.services.Status.OK) {
				// 마커 이미지 경로
				var imageSrc = "./resources/image/mylocation.png";
			    // 마커 이미지의 이미지 크기 입니다
			    var imageSize = new kakao.maps.Size(40, 50); 
			    // 마커 이미지를 생성합니다    
			    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
				
				var coords = new kakao.maps.LatLng(result[0].y,result[0].x);
				// 결과값으로 받은 위치를 마커로 표시합니다
				var marker = new kakao.maps.Marker({
						map : map,
						position : coords,
						image : markerImage
					});
				var iwContent = '<div style="width:150px;text-align:center;padding:10px 0;font-size:12px;">${m.m_name}님의 주변에 밥차를 등록해 보세요!</div>', 
				iwRemoveable = true;
				// 인포윈도우로 장소에 대한 설명을 표시합니다
				var infowindow = new kakao.maps.InfoWindow({
						content : iwContent,
						removable : iwRemoveable
					});
				//클릭시 인포윈도우가 표시되게함
				kakao.maps.event.addListener(marker, 'click', function(){
					infowindow.open(map, marker);
				});
				// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				map.setCenter(coords);
			}
		});
		
		//마커를 DB에서 꺼내와서 사용함
		//마커 이미지의 이미지 주소입니다
		var imageSrc = "./resources/image/marker_truck.png";
		var rvlatlng = '${rvlatlng}'; //위경도+title
		<c:forEach items='${rvlist}' var='r'>
		    // 마커 이미지의 이미지 크기 입니다
		    var imageSize = new kakao.maps.Size(40, 50); 
		    // 마커 이미지를 생성합니다    
		    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
		    // DB에 있는 위경도값 꺼내서 새로만들어줌
		    var latlng = new kakao.maps.LatLng('${r.rv_lat}','${r.rv_lng}');
		    // 마커를 생성합니다
		    var markerlist = new kakao.maps.Marker({
		        map: map, // 마커를 표시할 지도
		        position: latlng, // 마커를 표시할 위치
		        title : '${r.rv_title}', // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
		        image : markerImage // 마커 이미지 
		    });
		    // 마커에 클릭이벤트를 등록함
		    kakao.maps.event.addListener(markerlist, 'click', function(){
		    	//내용보기
			    $('#reviewCont').show();
		    	$('#rv_no').val('${r.rv_no}');
		    	$('#rv_writer_read').text('${r.rv_writer}');
		    	if('${sessionScope.m_id}'!='${r.rv_writer}'){
		    		$('#review_del').hide();
		    	}
				$('#shop_name').text('${r.rv_title}');//가게이름
				if('${r.rv_image_file}'==''){
					$('#shop_img').attr('src','/resources/image/bobcha_icon.png');
				}else{
					$('#shop_img').attr('src','/resources/upload${r.rv_image_file}');//가게사진
				}
				$('#shop_review').text('${r.rv_content}');//내용
				$('#shop_price').text('${r.rv_price}');//가격
				$('#shop_days').text('${r.rv_days}');//출몰일
				$('#shop_times').text('${r.rv_times}');//시간
				$('#shop_ratings').html('');
				for(var i=0; i<${r.rv_rating}; i++){
					$('#shop_ratings').append('<img src="/resources/image/ratings.png" width="40px;"/>');//평점
				}
				//내용삭제
				$('#review_del').click(function(){
					reviewClose();
					alert('${r.rv_writer}님께서 등록하신 밥차가 삭제되었어요.');
				});
				//내용수정
				$('#review_edit').click(function(){
					$('#reviewCont').hide();
					$('#reviewEdit').show();
			    	$('#rv_no2').val('${r.rv_no}');
					$('#rv_title2').val('${r.rv_title}');
					$('#rv_content2').text('${r.rv_content}');
					$('#rv_price2').val('${r.rv_price}');
					if(checkReview()){
						reviewClose();
					}
				});
		    });
		</c:forEach>
		
		// 지도에 클릭 이벤트를 등록하여 리뷰를 등록함
		// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
		kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
			// 클릭한 위도, 경도 정보를 가져옵니다 
			var latlng = mouseEvent.latLng;
			//form태그 내의 hidden값으로 위경도 값을 넘겨줌.
			$('#rv_lat').val(latlng.getLat());
			$('#rv_lng').val(latlng.getLng());
			var createMarker = new kakao.maps.Marker({
				position : latlng
			});
			if (confirm('이곳에 밥차를 등록하시겠습니까?') == true) {
				$('#reviewMod').show();
				if(checkReview()){
					createMarker.setMap(map);
					reviewClose();
				}
			}
		});
	</script>
	<script src="./resources/js/review.js"></script>

</body>

</html>