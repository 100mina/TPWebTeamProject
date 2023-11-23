<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포트폴리오</title>

<link type="text/css" rel="stylesheet" href="css/portDetail.css">
</head>
<body>
	
	<!-- 사용자 정보? 칸? -->
	<div id="top">
		<div id="user">
			<img alt="img" src="img/profile.png" id="profile">
			<h3>사용자 닉네임</h3>
			<a href="" >사용자 아이디</a>
		</div>
	
		<div id="buttons" >
			<div class="image-container">
  				<img alt="img" src="img/follow_off.png" class="button"><br>
  				<span id="follow_text" class="button_text">0000명</span>
			</div>
			<div class="image-container">
  				<img alt="img" src="img/like_off.png" class="button"><br>
  				<span id="like_text" class="button_text">00개</span>
			</div>
			<div class="image-container">
  				<img alt="img" src="img/cmt.png" class="button" id="comment_button"><br>
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
		<p> 글 내용 칸.. <br> Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nisi natus labore laudantium voluptate cum reprehenderit, ea deleniti corporis! Corrupti ea consequatur, molestiae incidunt dolor rem aliquam! Dolorum, magni? Laudantium, explicabo?Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nisi natus labore laudantium voluptate cum reprehenderit, ea deleniti corporis! Corrupti ea consequatur, molestiae incidunt dolor rem aliquam! Dolorum, magni? Laudantium, explicabo?Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nisi natus labore laudantium voluptate cum reprehenderit, ea deleniti corporis! Corrupti ea consequatur, molestiae incidunt dolor rem aliquam! Dolorum, magni? Laudantium, explicabo? </p>
		
		<!-- 디비에서 이미지 -->
		<c:forEach  var="i" begin="0" end="2" step="1" >
				<img alt="" src="img/bgimg.png" class="content_img">
		</c:forEach>
	
	
	</div>
	
	
	
	<!-- 하단부분 사용자 정보 칸.. -->
	<div id="bottom">
		<p><strong>모든 포트폴리오</strong></p>
		
		<div id="port_all_container">
		
			<c:forEach  var="i" begin="0" end="5" step="1" >
				<img src="img/bgimg.png" alt="Image 1" class="port_all">
			</c:forEach>
			
		</div>
	</div>
	
	
	
	<!-- 댓글 창 -->
	<div id="comment_container">
		
		<c:forEach  var="i" begin="0" end="5" step="1" >
			<div id="comment_item">
				<img alt="img" src="img/profile.png" id="comment_profile">
				<h5>사용자 닉네임</h5>
				<span id="date">2020.20.20 20:20:22</span>
				<p id="comment">댓글내용 Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nisi natus labore laudantium voluptate cum reprehend</p>
			</div>
		</c:forEach>
		
		<div id="input_container">
			<form action="" method="post" enctype="application/x-www-form-urlencoded" style="margin: 20px 40px;">
				<textarea rows="5" placeholder="댓글 남기기" maxlength="1000"></textarea><br>
				<input type="submit" value="완료" class="input_button">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소" class="input_button">
			</form>
		</div>
		
		
		
	</div>
	
	
	

</body>
</html>