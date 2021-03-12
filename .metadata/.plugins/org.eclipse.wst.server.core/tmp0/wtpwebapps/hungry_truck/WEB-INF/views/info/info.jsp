<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
  <head>
    <title>문의</title>
    <style>
    .info{
		margin-left:auto; margin-right:auto; margin-top:70px;
		width: 423px; max-min:423px; height:670px; max-height:670px;
		overflow:auto; padding:10px;
	}
    </style>
  </head>
  <body>
       <main class="info">
         <div class="page-header mt-3">
             <h3>문의</h3>
         </div>
          <p>밥차의 궁금증을 풀어드려요.</p>
		<div class="accordion" id="accordionExample">
		  <div class="accordion-item">
		    <h2 class="accordion-header" id="headingOne">
		      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
		        밥차가 뭔가요?
		      </button>
		    </h2>
		    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
		      <div class="accordion-body" style="font-size:15px;">
		        <strong style="font-size:20px;">밥차</strong>&nbsp;&nbsp;란 만나기 힘든 푸드트럭과 포장마차의 위치,가격,리뷰등을 공유하며 사람들과의 커뮤니티 활성화를 목적으로 합니다. 
		        밥차는 먹성좋은 개발자 집 근처에 사 먹을게 없는 작은 "불편함"으로부터  시작되었습니다. 만약 불편함이 없었다면 생기지 않았을것 입니다. 작은 불편함 하나가 우리 생활에 더 큰 편리함으로 다가옵니다. 배고픈 우리... "밥차" 할까요?
		      </div>
		    </div>
		  </div>
		  <div class="accordion-item">
		    <h2 class="accordion-header" id="headingTwo">
		      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
		        이용방법이 궁금해요!
		      </button>
		    </h2>
		    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
		      <div class="accordion-body" style="font-size:15px;">
		        <strong>먼저,</strong>&nbsp;&nbsp;회원가입을 해주세요. <br>
		 		회원가입이 완료되면 홈화면에서 지도를 확인할수 있어요! 지도를 조정하며 유저들이 공유한 푸드트럭 또는 포장마차의 정보를 확인할 수 있습니다. 회원가입하지 않으면 이용할 수 없습니다.
		      </div>
		    </div>
		  </div>
		  <div class="accordion-item">
		    <h2 class="accordion-header" id="headingThree">
		      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
		        무료인가요?
		      </button>
		    </h2>
		    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
		      <div class="accordion-body" style="font-size:15px;">
		        <strong>네!</strong>&nbsp;&nbsp;밥차는 평생 무료서비스 입니다.
		      </div>
		    </div>
		  </div>
		</div>
        <div class="alert alert-warning alert-dismissible mt-3" role="alert" style="font-size:14px;">
		           이외의 사항은 개발자에게 메일주시면 친절히 답해드리겠습니다.
		       문의메일 issac.lee.dev@gmail.com
        </div>
        </main>
  </body>
</html>
