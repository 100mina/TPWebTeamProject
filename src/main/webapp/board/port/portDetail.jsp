<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% pageContext.setAttribute("nl","\n"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포트폴리오</title>

<link type="text/css" rel="stylesheet" href="/TPWebTeamProject/board/port/css/portDetail.css">
</head>
<body>

	
	
	<!-- 사용자 정보? 칸? TODO: 회원정보VO 받으면 이미지, 닉네임 넣기-->
	<div id="top">
		<div id="user">
			<a href=""><img alt="img" src="/TPWebTeamProject/board/port/img/profile.png" id="profile"></a>
			<h3>사용자 닉네임</h3>
			<a href="" >${port.userId }</a>
		</div>
	
		<div id="buttons" >
			<div class="image-container">
  				<img alt="img" src="/TPWebTeamProject/board/port/img/follow_off.png" class="button"><br>
  				<span id="follow_text" class="button_text">0000명</span>
			</div>
			<div class="image-container">
  				<img alt="img" src="/TPWebTeamProject/board/port/img/like_off.png" class="button"><br>
  				<span id="like_text" class="button_text">00개</span>
			</div>
			<div class="image-container">
  				<img alt="img" src="/TPWebTeamProject/board/port/img/cmt.png" class="button" id="comment_button"><br>
  				<span id="comment_text" class="button_text">000개</span>
			</div>
		</div>
	
	</div>
	
	<script>
    // 이미지를 클릭하면 스크롤을 가장 아래로 내리는 함수
    function scrollToBottom() {
      window.scrollTo(0, document.body.scrollHeight);
    }
    // 이미지에 클릭 이벤트 리스너 등록
    document.getElementById('comment_button').addEventListener('click', scrollToBottom);
  </script>
	
	

	
	<!-- 콘텐츠 시작 -->
	<div id="content">
		<p id="content_text">${fn:replace(port.portContent, nl, "<br>") }</p>
		
		<!-- 디비에서 이미지 -->
		<c:forEach  var="img" items="${port.portImgList }" >
			<img alt="img" src="/TPWebTeamProject/getImg?img_no=${img.imgNo}" class="content_img">
		</c:forEach>
	
	
	</div>

	
	
	<!-- 하단부분 사용자 정보 칸.. -->
	<div id="bottom">
		<p id="bottom_title"><strong>모든 포트폴리오</strong></p>
		<div id="port_all_container">
        	<c:forEach  var="port" items="${port.userPort }" >
				<div style="text-align: center; margin: 20px 10px;">
					<a href="/TPWebTeamProject/getPortDetail?port_no=${port.portNo} "><img src="/TPWebTeamProject/getImg?img_no=${port.portImg.imgNo}" alt="" class="port_all"></a><br>
					${port.portTitle }
				</div>
			</c:forEach>
		</div>
	</div>


	<!-- 댓글 창 -->
	<p id="cmt_title"><strong>댓글</strong></p>
	<div id="comment_container">
		
		<c:forEach  var="cmt" items="${port.portCmtList }" >
			<!-- TODO: 회원정보VO 받으면 이미지, 닉네임 넣기 -->
			<div id="comment_item">
				<a href=""><img alt="img" src="/TPWebTeamProject/board/port/img/profile.png" id="comment_profile"></a>
				<h5>${cmt.userId }</h5>
        		<span id="date">${cmt.portCmtDate }</span>
        		
        		<!-- 본인일 경우 수정 / 삭제 기능 -->
        		<div id="cmt_button">
        			<a href="/TPWebTeamProject/updatePortCmt">수정</a>&nbsp;&nbsp;&nbsp;
        			<a class="deleteLink" href="/TPWebTeamProject/deletePortCmt?port_cmt_no=${cmt.portCmtNo }&port_no=${cmt.portNo }">삭제</a>
        		</div>
        		
				<p id="comment">${fn:replace(cmt.portCmtContent, nl, "<br>") }</p>
			</div>
		</c:forEach>
		
		<div id="input_container">
			<form action="/TPWebTeamProject/insertPortCmt" method="post" enctype="application/x-www-form-urlencoded" style="margin: 20px 40px;">
				<textarea rows="5" placeholder="댓글 남기기" maxlength="1000" name="port_cmt_content"></textarea><br>
				<input type="hidden" name="port_no" value="${port.portNo}">
				<input type="submit" value="완료" class="input_button" id="scrollTarget">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소" class="input_button">
			</form>
		</div>
		
		<script>
    	// 삭제 링크 클릭 시 다이얼로그 표시
   		var deleteLinks = document.querySelectorAll('.deleteLink');
    	deleteLinks.forEach(function (deleteLink) {
        	deleteLink.addEventListener('click', function (event) {
            	event.preventDefault(); // 링크의 기본 동작(페이지 이동)을 막음
            	console.log('링크 클릭됨');
            	// 다이얼로그 표시
            	var result = confirm('정말 삭제하시겠습니까?');

            	// 확인 버튼을 눌렀을 때 링크 실행
            	if (result) {
                	window.location.href = this.href;
            	}
        	});
    	});
		</script>
		
	
	
	

</body>
</html>