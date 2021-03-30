<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지도</title>
<link rel="stylesheet" type="text/css" href="/resources/css/review.css"></link>
</head>
<body>
<!-- KakaoMap API 넣기 -->
<div class="location">
	<div id="map" style="width:423px;height:650px; position:absolute; z-index:0;">
		<div class="category">
			<ul>
				<li id="allBob">
					<img src="/resources/image/map_home.png" title="전체 밥차보기" width="50px"/>
				</li>
				<li id="likeBob">
					<img src="/resources/image/map_mylike.png" title="찜한 밥차보기"  width="50px"/>
				</li>
				<li id="createBob">
					<img src="/resources/image/map_myreview.png" title="제보한 밥차보기" width="50px" />
				</li>
			</ul>
		</div>
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
			<input type="hidden" id="dibs_no" value=""/>
			<!-- 리뷰 보기 화면 -->
			<div id="reviewCont" style="display: none;">
				<!-- 상시 감추어 놓음 -->
				<a id="like"><img src="" id="like_img" title="찜하기" style="float:right; margin-top:15px; width:40px; height:auto;"/></a>
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
					<button type="button" id="review_cancel" class="btn btn-primary" style="width: 60px; height: 30px; font-size: 13px;" onclick="reviewClose();">취소</button>
				</div>
				<div style="clear: both"></div>
				<hr>
				
				<div class="form-group">
	          		<h5 id="rvr_count"></h5>
	          		<input type="hidden" id="rvr_replyer" value="${sessionScope.m_id}"/>
	       			<label>리뷰 남기기</label>
	          		<div class="form-group">
						<select class="form-select" id="rvr_rating" name="rvr_rating" style="width:100px; height:33px; margin-bottom:2px; display:inline;">
							<option value="" selected>평점선택</option>
							<option value="1">1점</option>
							<option value="2">2점</option>
							<option value="3">3점</option>
							<option value="4">4점</option>
							<option value="5">5점</option>
						</select>
		          		<input class="form-control" id="rvr_replytext" name="rvr_replytext" style="width:165px; height:33px; display:inline;"></input>
			          	<button type="button" id="rvr_SubmitBtn" class="btn btn-primary" style="float:right; width:50px; height:33px; font-size:13px; ">등록</button>
	          		</div>
				</div>
				<ul id="rvr_replies" style="list-style-type:none; padding:10px;"></ul>
				
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
		
		<%-- 댓글 수정 화면 --%>
		<div id="rvr_edit" style="display:none;"><%-- 수정화면을 안나오게 한다. --%>
		   	<div class="modal-title" style="display:none;"></div>
			<p>리뷰댓글수정</p>
			<div>
				<span id="rvr_edit_id"></span>
				<select class="form-select" id="rvr_rating2" style="width:100px; height:33px; margin-bottom:2px; float:right;">
					<option value="" selected>평점선택</option>
					<option value="1">1점</option>
					<option value="2">2점</option>
					<option value="3">3점</option>
					<option value="4">4점</option>
					<option value="5">5점</option>
				</select>
				<textarea class="form-control" rows="3" cols="30" id="rvr_replytext2" style="resize:none;"></textarea><%-- 내용이 출력되는 부분 --%>
			</div>
			<div style="float:right; padding:10px;">
				<button type="button" id="rvrEditBtn" class="btn btn-primary" style="width:60px; height:30px; font-size:13px;" >수정</button>
				<button type="button" id="rvrDelBtn" class="btn btn-primary"  style="width:60px; height:30px; font-size:13px;">삭제</button>
				<button type="button" id="rvrCloseBtn" class="btn btn-primary" style="width:60px; height:30px; font-size:13px;">닫기</button>
			</div>
		</div>
	</div>
</div>
	<!-- KakaoMaps API -->
	<!-- services와 clusterer, drawing 라이브러리 불러오기 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c77113a5adfb4ed207e26c3c3e09d302&libraries=services,clusterer,drawing"></script>	
	<script type="text/javascript" src="./resources/js/review.js"></script>
	<script>

	//카카오맵 사용
		var container = document.getElementById('map');
		var options = {
			center : new kakao.maps.LatLng(33.450701, 126.570667),
			level : 5
		};
		var map = new kakao.maps.Map(container, options);
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		// 회원의 주소지를 가져옴.
		var myAddr = '${m.m_addr_1}';
		var coords = null;
		
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
				
				coords = new kakao.maps.LatLng(result[0].y,result[0].x);
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
				//맵의 중심을 회원주소지로 잡아줌
				map.setCenter(coords);
			}
		});

		
		//마커를 DB에서 꺼내와서 사용함
		//마커 이미지의 이미지 주소입니다
		var imageSrc = "./resources/image/marker_truck.png";
	    // 마커 이미지의 이미지 크기 입니다
	    var imageSize = new kakao.maps.Size(40, 50); 
	    // 마커 이미지를 생성합니다    
	    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 

		//전체 밥차의 위경도 리스트
		var allPositions = [<c:forEach items='${rvlist}' var='r' varStatus="status">
			new kakao.maps.LatLng('${r.rv_lat}','${r.rv_lng}')<c:if test='${!status.last}'>,</c:if></c:forEach>
		];//status사용으로 마지막 배열이 아닌경우에만  ,를 찍음
		
		//클러스터 마커(투명)
		var clusterMarkerImage = new kakao.maps.MarkerImage('./resources/image/none.png',new kakao.maps.Size(1,1));
		//클러스터링을 위한 마커생성
		var clusterMarkers = [];
		for(var i=0; i<allPositions.length; i++){
			clusterMarkers[i] = new kakao.maps.Marker({
				position : allPositions[i],
				image : clusterMarkerImage
			});
		}
		
		//찜한 밥차의 위경도 리스트
		var likePositions = [<c:forEach items='${myLikeList}' var='ml' varStatus="status">
			new kakao.maps.LatLng('${ml.rv_lat}','${ml.rv_lng}')<c:if test='${!status.last}'>,</c:if></c:forEach>
		];
		//내가 쓴 밥차의 위경도 리스트
		var myCreatePositions = [<c:forEach items='${myCreateList}' var='cl' varStatus="status">
			new kakao.maps.LatLng('${cl.rv_lat}','${cl.rv_lng}')<c:if test='${!status.last}'>,</c:if></c:forEach>
		];
		
		//전체 밥차보기
		<c:forEach items='${rvlist}' var='r'>
		    // DB에 있는 위경도값 꺼내서 새로만들어줌
		    var latlng = new kakao.maps.LatLng('${r.rv_lat}','${r.rv_lng}');
		    //마커의 범위를 설정
		    var bounds = new kakao.maps.LatLngBounds();
		    
		    // 저장된 모든 마커를 생성
		    var markerlist${r.rv_no} = new kakao.maps.Marker({
		        position: latlng, // 마커를 표시할 위치
		        title : '${r.rv_title}', // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
		        image : markerImage, // 마커 이미지 
		        map : map
		    });
			
			//마커 클러스터 생성
			var clusterer = new kakao.maps.MarkerClusterer({
		        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
		        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
		        minLevel: 8, // 클러스터 할 최소 지도 레벨
		        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
		    });
		    
		    //클러스터러에 마커 추가
		    clusterer.addMarkers(clusterMarkers);
		    
		    //클러스터러에 클릭이벤트 등록
		    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster){
		    	//현재 지도 레벨에서 1레벨 확대한 레벨
		    	var level = map.getLevel()-1;
		    	//지도가 클릭된 클러스터의 마커의 위치를 기준으로 확대
		    	map.setLevel(level, {anchor: cluster.getCenter()});
		    });
		    
		    //전체보기 클릭시
		    $('#allBob').click(function(){
				map.setCenter(coords);
				map.setLevel(5);
		    	markerlist${r.rv_no}.setMap(null);
			    markerlist${r.rv_no}.setMap(map);
		    });
		    
		    //찜 클릭시
		    $('#likeBob').click(function(){
		    	for(var i=0; i<likePositions.length; i++){
		    		bounds.extend(likePositions[i]);
		    	}
		    	map.setBounds(bounds);
		    	markerlist${r.rv_no}.setMap(null);
		    	<c:forEach items='${myLikeList}' var='l'>
		    		<c:if test='${l.rv_no eq r.rv_no}'>
				   		markerlist${r.rv_no}.setMap(map);
		    		</c:if>
		    	</c:forEach>
		    });
		    
		    //제보한 밥차 클릭시
		    $('#createBob').click(function(){
		    	for(var i=0; i<myCreatePositions.length; i++){
		    		bounds.extend(myCreatePositions[i]);
		    	}
		    	map.setBounds(bounds);
		    	markerlist${r.rv_no}.setMap(null);
		    	<c:forEach items='${myCreateList}' var='c'>
		    		<c:if test='${c.rv_no eq r.rv_no}'>
				   		markerlist${r.rv_no}.setMap(map);
		    		</c:if>
		    	</c:forEach>
		    });

		    // 마커에 클릭이벤트를 등록함
		    kakao.maps.event.addListener(markerlist${r.rv_no}, 'click', function(){
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

		    	//찜버튼을 누를시
	    		var rv_no = '${r.rv_no}';
	    		var rv_title = '${r.rv_title}';
	    		var m_id = '${sessionScope.m_id}';
	    		var dibs_no = $('#dibs_no').val();
		    	$('#like').off().on('click',function(){
          			$.ajax({
          				type:'put',
          				url:'/dibs',
          				headers:{
          					"Content-Type":"application/json",
          					"X-HTTP-Method-Override":"PUT"
          				},
          				data:JSON.stringify({
          					rv_no:rv_no,
          					rv_title:rv_title,
          					m_id:m_id,
          					dibs_no:dibs_no
          				}),
          				dataType:'text',
          				success:function(data){
          					if(data == 'SUCCESS'){
          					    checkLike();
          					}
          				}
          			});
		    	});

		    	//찜여부 확인
			    checkLike();
		    	
		    	//찜 여부확인
		    	function checkLike(){
				   	$('#like_img').attr('src','/resources/image/like_off.png');
		    		$.getJSON("/dibs/dibsCheck/"+rv_no,function(data){
		    			if(data.dibs_check == '1'){	
						   	$('#like_img').attr('src','/resources/image/like_on.png');
						   	$('#dibs_no').val(data.dibs_no);
		    			}
		    		});
		    	}
		    	
				//리뷰 댓글 불러오기
          		getAllList();
          		
          		//댓글목록
          		function getAllList(){
          			$.getJSON("/reviewReplies/all/"+rv_no,function(data){
          				//비동기식으로 받아온 데이터는 data매개변수에 저장
          				var str = "";
          				var num = 0;
          				$(data).each(function(){//each()함수로 반복
          					num += 1;
          					if(m_id == this.rvr_replyer){
	          					str += "<li data-rvr_no='"+this.rvr_no+"' class='rvrLi'>" //data-r_no는 Ajax 속성값
	          					+ "<span id='nick2'>" +this.rvr_replyer+"</span>" + '[<img src="/resources/image/ratings.png" width="20px;"/>x'+ this.rvr_rating +']'+ " : <span class='com' style='max-width:423px;'>"
	          					+ this.rvr_replytext + "</span>"
	          					+ '<a style="float:right;"><img src="/resources/image/mypage.png" width="12px" alt="댓글수정" title="댓글수정"/></a>'
	          					+ "</li><br>";
          					}else{
	          					str += "<li data-rvr_no='"+this.rvr_no+"' class='rvrLi'>" //data-r_no는 Ajax 속성값
	          					+ "<span id='nick2'>" +this.rvr_replyer + "</span>"+ '[<img src="/resources/image/ratings.png" width="20px;"/>x'+ this.rvr_rating +']'+ " : <span class='com' style='max-width:423px;'>"
	          					+ this.rvr_replytext + "</span>" + "</li><br>";
          					}
          				});
          				$('#rvr_replies').html(str);
        		    	$('#rvr_count').text(num+'개의 리뷰가 있어요!');
          			});
          		}
          		
          		//댓글수정
          		$('#rvr_replies').on('click','.rvrLi a',function(){
          			var rvr_replies = $(this).parent();//부모요소 -> li태그, this는 버튼
          			var rvr_no = rvr_replies.attr('data-rvr_no');//data-rv_no속성값 댓글번호 저장
          			var rvr_replyer = rvr_replies.children('#nick2').text();
          			var rvr_replytext = rvr_replies.children('.com').text();
          			$('.modal-title').html(rvr_no); //댓글번호
          			$('#rvr_edit_id').text(rvr_replyer);//작성자
          			$('#rvr_replytext2').val(rvr_replytext);//댓글내용
          			$('#rvr_edit').show();
          		});
          		
          		//댓글수정창 닫기
          		$('#rvrCloseBtn').click(function(){
          			$('#rvr_edit').hide();
          		});
          		
          		//댓글 수정 완료
          		$('#rvrEditBtn').on('click',function(){
          			var rvr_no = $('.modal-title').html();
          			var rvr_replytext = $('#rvr_replytext2').val();//내용
          			var rvr_rating = $('#rvr_rating2').val();//평점
          			if((rvr_rating=='')||rvr_replytext==''){
          				alert('평점과 내용을 입력해주세요.');
          				return false;
          			}
          			$.ajax({
          				type:'put', 
          				url:'/reviewReplies/'+rvr_no,
          				headers:{
          					"Content-Type":"application/json",
          					"X-HTTP-Method-Override":"PUT"          					
          				},
          				data:JSON.stringify({
          					rvr_replytext:rvr_replytext,
          					rvr_rating:rvr_rating
          				}),
          				dataType:'text',
          				success:function(data){
          					if(data == 'SUCCESS'){
          						alert('댓글이 수정되었어요.');
          						$('#rvr_edit').hide();
          						getAllList();
          					}
          				}
          			});
          		});
          		
          		//댓글삭제
          		$('#rvrDelBtn').on('click',function(){
          			var rvr_no = $('.modal-title').html();
          			$.ajax({
          				type:'delete',
          				url:'/reviewReplies/'+rvr_no,
          				headers:{
          					"Content-Type":"application/json",
          					"X-HTTP-Method-Override":"DELETE"
          				},
          				dataType:'text',
          				success:function(data){
          					if(data == 'SUCCESS'){
          						alert('댓글이 삭제되었어요.');
          						$('#rvr_edit').hide();
          						getAllList();
          					}
          				}
          			});
          		});
          		
          		//댓글 추가
          		$('#rvr_SubmitBtn').on('click',function(){
          			var rvr_replyer = $('#rvr_replyer').val();//작성자
          			var rvr_replytext = $('#rvr_replytext').val();//내용
          			var rvr_rating = $('#rvr_rating').val();//평점
          			if((rvr_rating=='')||rvr_replytext==''){
          				alert('평점과 내용을 입력해주세요.');
          				return false;
          			}else{
		          		$.ajax({
		          			type:'post',
		          			url:'/reviewReplies',
		          			headers:{//http 헤더앞에 붙는 형식
		          				"Content-Type":"application/json",
		          				"X-HTTP-Method-Override":"POST"
		          			},
		          			dataType:'text',
		          			data:JSON.stringify({//보내지는 자료가 JSON형태인 키,밸류
		          				rv_no:rv_no,
		          				rvr_rating:rvr_rating,
		          				rvr_replyer:rvr_replyer,
		          				rvr_replytext:rvr_replytext
		          			}),
		          			success:function(data){
		          				//비동기식 성공시 호출되며 받아온데이터는 data매개변수에 저장
		          				if(data == 'SUCCESS'){
		          					$('#rvr_replytext').val('');
		          					$('#rvr_rating').val('');
		          					alert('댓글이 등록되었어요.');
		          					getAllList();
		          				}
		          			}
		          		});
	          		}
	          	});
				
				//내용삭제
				$('#review_del').click(function(){
					reviewClose();
					alert('${r.rv_writer}님께서 등록하신 밥차가 삭제되었어요.');
				});
				//내용수정
				$('#review_edit').click(function(){
					alert('내용수정');
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
		
		
		//마이페이지에서 특정 버튼을 눌른경우
		<c:if test='${!empty attr}'>
			$(document).ready(function(){
				<c:if test='${attr eq 1}'>
					$('#likeBob').trigger('click');
				</c:if>
				<c:if test='${attr eq 2}'>
					$('#createBob').trigger('click');
				</c:if>
			});
		</c:if>
		
		
	</script>
</body>

</html>