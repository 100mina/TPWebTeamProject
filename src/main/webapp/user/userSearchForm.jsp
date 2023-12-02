<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
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
	<div>
		<form action="" method="get" enctype="application/x-www-form-urlencoded">
			<input type="text">
		</form>
	</div>
	<div>
		<c:forEach var="i" begin="1" end="8">
			<h5>title</h5>	
			<img alt="" src="./image/bg_myProfile.png">
		</c:forEach>
	</div>
	</body>
</html>