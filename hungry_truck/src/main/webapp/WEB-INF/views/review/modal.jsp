<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
				<button type="button" id="review_cancel" class="btn btn-primary" style="width: 60px; height: 30px; font-size: 13px;">취소</button>
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
</body>
</html>