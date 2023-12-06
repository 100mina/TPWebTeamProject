$(document).ready(function() {
	$.ajax({
		url: "../../portBoardList?no=1",  // 요청을 보낼 API 엔드포인트
		method: 'GET',  // HTTP 메소드 (GET, POST 등)
		dataType: 'json',  // 응답 데이터 형식 (JSON, XML 등)
		success: function(data) {
			// 성공적으로 요청이 완료되면 실행되는 함수
			for (var i = 0; i < data.length; i++) {
				var container = $("#containner");
				var item = data[i];
				var html =
					"<div id='containerWraper'><div><a href='../../getPortDetail?port_no=" + item.portNo + "'><img alt='게시물 이미지' src='../../imgLoad?imageNo=" + item.thumbnailImageNo + "' id='portImg'></a></div>" +
					"<div id='proImg'><a href='../../userPage?user_id=" + item.userId + "'><img alt='작성자 프로필' src='../../getProfileImg?user_id=" + item.userId + "' id='profile'>&nbsp&nbsp" + item.userId + "</a>" +
					"<span><img alt='좋아요' src='../../image/favo.png'>" + item.countFav +
					"</span><span><img alt='조회수' src='../../image/eye.png'>" + item.portView + "</span></div></div>";

				container.append(html);
			}

		},
		error: function(status, error) {
			// 요청이 실패하면 실행되는 함수
			console.error(status + ': ' + error);
		}
	});
	$(".port").change(function() {
		var selectedOption = $(this).val();
		$.ajax({
			url: "../../portBoardList?no=" + selectedOption,  // 요청을 보낼 API 엔드포인트
			method: 'GET',  // HTTP 메소드 (GET, POST 등)
			dataType: 'json',  // 응답 데이터 형식 (JSON, XML 등)
			success: function(data) {
				var container = $("#containner");
				 container.empty();
				// 성공적으로 요청이 완료되면 실행되는 함수
				for (var i = 0; i < data.length; i++) {
					
					var item = data[i];
					var html =
						"<div id='containerWraper'><div><a href='../../getPortDetail?port_no=" + item.portNo + "'><img alt='게시물 이미지' src='../../imgLoad?imageNo=" + item.thumbnailImageNo + "' id='portImg'></a></div>" +
						"<div id='proImg'><a href='../../userPage?user_id=" + item.userId + "'><img alt='작성자 프로필' src='../../getProfileImg?user_id=" + item.userId + "' id='profile'>&nbsp&nbsp" + item.userId + "</a>" +
						"<span><img alt='좋아요' src='../../image/favo.png'>" + item.countFav +
						"</span><span><img alt='조회수' src='../../image/eye.png'>" + item.portView + "</span></div></div>";
					
					container.append(html);
				}

			},
			error: function(status, error) {
				// 요청이 실패하면 실행되는 함수
				console.error(status + ': ' + error);
			}
		});


	});




});