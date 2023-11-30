<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> ${ userPostList.userId } / 취업의 신</title>
<link rel="stylesheet" href="./css/userMyPage.css">
	<c:set var="userPostList" value="${ requestScope.userPostList }"></c:set>
	<c:set var="pageSize" value="8"></c:set>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	
	
</head>
<body>
<div id="wraper">
<a id="aicon"><img alt="icon" src="../image/icon.png" id="icon"></a>

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
		<img alt="bg" src="./image/bg_myProfile.png" id="bg">
		<img alt="" src="./default_profile/profile.png" id="mid_profile">
		<span id="nickName">${requestScope.pbvos.userNickName}님</span>
		<span id="bookMark">즐겨찾기 00 명</span>
		<span id="like">총 좋아요 00 개</span>	
	</div>
	<div id="postWraper">
		<span id="posthead"><h2>포트폴리오</h2></span>
		<div id="postBody">
		
		
			<c:forEach var="i" begin="0" end="${(fn:length(userPostList)/8)+1 }">
				<input type="button" value="${i+1}" style="margin-left: 0.5em; margin-right: 0.5em" id="pageBtn" onclick="changPage()">
			</c:forEach>
		</div>
	</div>
</div>
</body>
</html>
<script type="text/javascript" src="./js/userMyPage.js"></script>


