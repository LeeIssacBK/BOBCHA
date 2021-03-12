/**
 * 네이버 맵
 */

var mapOptions = {
		    center: new naver.maps.LatLng(37.3595704, 127.105399),
		    zoom: 10,
	        zoomControl: true,
	        zoomControlOptions: {
	            style: naver.maps.ZoomControlStyle.SMALL,
	            position: naver.maps.Position.TOP_RIGHT
	        }
		};

		var map = new naver.maps.Map('map', mapOptions);
		
		naver.maps.Event.once(map, 'init_stylemap', function() {
		    //customControl 객체 이용하기
		    var customControl = new naver.maps.CustomControl(locationBtnHtml, {
		        position: naver.maps.Position.TOP_LEFT
		    });

		    customControl.setMap(map);

		    naver.maps.Event.addDOMListener(customControl.getElement(), 'click', function() {
		        map.setCenter(new naver.maps.LatLng(37.3595953, 127.1053971));
		    });

		    //Map 객체의 controls 활용하기
		    var $locationBtn = $(locationBtnHtml),
		        locationBtnEl = $locationBtn[0];

		    map.controls[naver.maps.Position.LEFT_CENTER].push(locationBtnEl);

		    naver.maps.Event.addDOMListener(locationBtnEl, 'click', function() {
		        map.setCenter(new naver.maps.LatLng(37.3595953, 127.1553971));
		    });
		});