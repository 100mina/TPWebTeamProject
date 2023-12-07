<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취업신 ${userPage.nickName }님</title>
<link rel="stylesheet" href="/TPWebTeamProject/user/css/userMyPage.css">
</head>
<body>
<div id="wraper">
<a href="/" id="aicon"><img alt="icon" src="/TPWebTeamProject/image/icon.png" id="icon"></a>

	<header>
			<div id="category">
		    	<ul class="first">
		    		<li><a href="">포트폴리오</a></li>
		    	</ul>
		    	<ul class="first">
		    		<li><a href="">취업신</a></li>
		    	</ul>
		    	<ul id="info">
		    		<li><a href="">정보마당</a></li>
		    	</ul>
		    </div>
		    <ul class="second">
				<li><a href="">전체게시판</a></li>
				<li><a href="">자유게시판</a></li>
				<li><a href="">면접/취업</a></li>
				<li><a href="">자기소개서/이력서</a></li>
			</ul>
			
			<script>
			  	var info = document.querySelector('#info');
			  	var secondUl = document.querySelector('.second');
			
			  	info.addEventListener("mouseover", function() {
			    // 호버되었을 때 컨테이너와 관련 없는 다른 요소의 스타일 변경
			    secondUl.style.display = 'block';			    
			  	});
			
			    secondUl.addEventListener("mouseover", function() {
			    	secondUl.style.display = 'block';			    	
			    });
			    secondUl.addEventListener("mouseout", function() {
				// 호버가 해제되면 스타일을 원래대로 변경
				secondUl.style.display = 'none';
					    
			});
			</script>
	</header>

	<div id="userProfile">
		<img alt="bg" src="/TPWebTeamProject/user/image/bg_myProfile.png" id="bg">
		<div id="profileImg">
			<img alt="" src="/TPWebTeamProject/getProfileImg?user_id=${userPage.id }" id="mid_profile">
		</div>
		
		<span id="nickName">${userPage.nickName } 님</span>
		
		<div id="follFav">
			<!-- <span id="bookMark">즐겨찾기 00 명</span>&nbsp;&nbsp;&middot;&nbsp; -->
			<span id="like">총 좋아요 ${userPage.totalFav } 개</span>	
		</div>
		
	</div>
	<div id="postWraper">
		<div id="port"><strong>포트폴리오</strong></div>
		<div id="port_all_container">
			<c:forEach var="port" items="${userPage.userPort }">
				<div style="text-align: center; margin: 20px 10px;">
					<a href="/TPWebTeamProject/getPortDetail?port_no=${port.portNo} ">
					<img src="/TPWebTeamProject/getImg?img_no=${port.portImg.imgNo}" alt="" class="port_all"></a>
					<br><span id="portTitle">${port.portTitle }</span>
				</div>
			</c:forEach>
		</div>
		<c:if test="${userPage.userPort.size() == 0 }">
			<p id="noPort">아직 작성하신 게시물이 없습니다.</p>
		</c:if>
	</div>
</div>
</body>
</html>
<script type="text/javascript" src="./js/userMyPage.js"></script>


