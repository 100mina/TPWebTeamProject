<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userID / 취업의 신</title>
<link rel="stylesheet" href="./css/userMyPage.css">
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
			<script>
				var k;
				function changePage(pageNo) {
					var itemCount = pageNo * 8	
					switch (pageNo) {
					case 1 : k=0;
					break;
					case 2 : k=8;
					break;
					case 3 : k=16;
					break;
					case 4 : k=24;
					break;
					case 5 : k=32;
					break;
					case 6 : k=40;
					break;
					case 7 : k=48;
					break;
					case 8 : k=56;
					break;
					case 9 : k=64;
					break;
					case 10: k=72
					break;
					}
					for (var i = k; i < itemCount-1; i++) {
			</script>
				<div id="postItem">
					<img alt="thumbnailIMG" src="./image/bg_myProfile.png"><br>
					<h5>title</h5>
				</div>						
			<script>															
					}
				}
			</script>
			<script>
				changePage(1)
			</script>
		</div>
		<div id="postFooter">
			<script>
				  var s = ${param.size};
				  var size = s + 1;
				  var maxPageNo = Math.ceil(size / 8); // 3
				  for (var i = 0; i < pageNo ; i++) {
			</script>
				<a onclick="changePage(${i+1})">${i+1}</a>
			<script>
				  }
			</script>
		</div>
	</div>
</div>
</body>
</html>


