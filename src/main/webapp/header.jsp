<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery를 사용하기 위해 CDN 추가 -->
<link href="./css/index.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/header.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	$(document).ready(function() {
		$("#user").hover(function() {
			$("#container").show();
		}, function() {
			$("#container").hide();
		});
	});
</script>
</head>
<body>
	<div id="rootContainer">
		<a id="aicon" href="<%=request.getContextPath()%>"><img alt="icon"
			src="<%=request.getContextPath()%>/image/icon.png" id="icon">
		</a>
		<div id="category">
			<ul class="first">
				<li><a href="<%=request.getContextPath()%>/board/port/portlist.jsp">포트폴리오</a></li>
			</ul>
			<ul class="first">
				<li><a href="">취업신</a></li>
			</ul>
			<ul id="info">
				<li><a href="<%=request.getContextPath()%>/board/free/boardList.jsp">정보마당</a></li>
			</ul>
		</div>

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
		<div id="logintext">
			<a href="<%=request.getContextPath()%>/user/loginForm.jsp">로그인</a>&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/user/signupForm.jsp">회원가입</a>
		</div>
		<c:if test="${not empty sessionScope.user}">
			<div id="user">
				<a
					href="<%=request.getContextPath()%>/userPage?userId=${sessionScope.user.id}"><img
					alt=""
					src="<%=request.getContextPath()%>/fileLoad?userId=${sessionScope.user.id}"
					id="profile"></a>&nbsp;&nbsp;
				<p>${sessionScope.user.nickName}님</p>
				&nbsp;환영합니다!

				<script type="text/javascript">
					var loginText = document.getElementById("logintext");
					loginText.style.display = "none";
				</script>
			</div>
		</c:if>
	</div>
	<div id="container">
		<div id="item1">
			<a
				href="<%=request.getContextPath()%>/userPage?userId=${sessionScope.user.id}"><img
				alt=""
				src="<%=request.getContextPath()%>/fileLoad?userId=${sessionScope.user.id}"
				id="profile"></a>
			<p>${sessionScope.user.id}</p>
		</div>
		<div id="item2">
			<a href="#">설정</a>
			<hr>
			<a href="<%=request.getContextPath()%>/logout">로그아웃</a>
		</div>
	</div>
	<ul class="second">
		<li><a href="">전체게시판</a></li>
		<li><a href="">자유게시판</a></li>
		<li><a href="">면접/취업</a></li>
		<li><a href="">자기소개서/이력서</a></li>
	</ul>
</body>
</html>