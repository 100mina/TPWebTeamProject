$(document).ready(function(){
    $.ajax({
        url: "../../portBoardList",  // 요청을 보낼 API 엔드포인트
        method: 'GET',  // HTTP 메소드 (GET, POST 등)
        dataType: 'json',  // 응답 데이터 형식 (JSON, XML 등)
        success: function(data){
            // 성공적으로 요청이 완료되면 실행되는 함수
            for(var i = 0 ; i < data.length; i++ ){
				var container = $("#container");
                var item = data[i];
                var html = "<div><img alt='작성자 프로필' src='" +'../../fileLoad?userId='+item.userId+'&imgPath='+item.portWriterProfilePath + "'></div>" +
                "<div><span><a><img alt='게시물 이미지' src='" + '../../fileLoad?userId='+item.userId+'&imgPath='+item.thumbnailImgPath + "'>" + item.userId + "</a>" +
                "<img alt='좋아요' src='../../image/favo.png'>" + item.countFav +
                "<img alt='조회수' src='../../image/eye.png'>" + item.portView + "</span></div>";
                
                container.append(html);
			}
            
        },
        error: function(status, error){
            // 요청이 실패하면 실행되는 함수
            console.error(status + ': ' + error);
        }
    });
});