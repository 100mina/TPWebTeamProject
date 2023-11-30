<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>취업의 신</title>

<link href="./css/index.css" rel="stylesheet">
</head>
<body>
	<div>
		<a id="aicon" href="./index.jsp"><img alt="icon"
			src="./image/icon.png" id="icon"></a>
		<header>

			<div id="category">
				<ul class="first">
					<li><a href="portBoardList">포트폴리오</a></li>
				</ul>
				<ul class="first">
					<li><a href="">취업신</a></li>
				</ul>
				<ul id="info">
					<li><a href="./board/free/boardList.jsp">정보마당</a></li>
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
			<div id="logintext">
				<a href="user/loginForm.jsp">로그인</a>&nbsp;&nbsp;&nbsp; <a
					href="user/signupForm.jsp">회원가입</a>
			</div>
			<c:if test="${not empty sessionScope.user}">
				<div id="user">
					<a href="userPage?userId=${sessionScope.user.id}"><img alt=""
						src="./fileLoad" id="profile"></a>&nbsp;&nbsp;
					<p>${sessionScope.user.nickName}님</p>
					&nbsp;환영합니다!

					<script type="text/javascript">
						var loginText = document.getElementById("logintext");
						loginText.style.display = "none";
					</script>
				</div>
			</c:if>
		</header>
	</div>
	</body>
</html>
	
	
		