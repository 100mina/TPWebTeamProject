<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery를 사용하기 위해 CDN 추가 -->
<link href="<%=request.getContextPath()%>/css/header.css?after"	
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	/* $(document).ready(function() {
	 var userHovered = false;
	 var infoHovered = false;
	 $("#info").hide();
	 $("#container").hide();
	 });
	 $("#profile").hover(function(){
	 userHovered = true;
	 });
	 $("#user").mouseleave(function(){
	 userHovered = false;
	 });
	 if(userHovered){
	 $("#user").show();
	 } 
	 if (!userHovered) {
	 $("#user").hide();
	 } */
</script>
</head>
<body>
	<div id="rootContainer">
		<a id="aicon" href="<%=request.getContextPath()%>"><img alt="icon"
			src="<%=request.getContextPath()%>/image/icon.png" id="icon"> </a>
		<div id="cate">
			<ul class="first">
				<li><a
					href="<%=request.getContextPath()%>/board/port/portlist.jsp">포트폴리오</a></li>
			</ul>
			<ul class="first">
				<li><a href="">취업신</a></li>
			</ul>
			<ul id="info">
				<li><a
					href="<%=request.getContextPath()%>/board/free/boardList.jsp">정보마당</a></li>
			</ul>
			<ul class="second">
				<li><a href="">전체게시판</a></li>
				<li><a href="">자유게시판</a></li>
				<li><a href="">면접/취업</a></li>
				<li><a href="">자기소개서/이력서</a></li>
			</ul>
		</div>
		<c:if test="${empty sessionScope.user }">
			<div id="logintext">
				<a href="<%=request.getContextPath()%>/user/loginForm.jsp">로그인</a>&nbsp;&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/user/signupForm.jsp">회원가입</a>
			</div>
		</c:if>
		<c:if test="${not empty sessionScope.user}">
			<div id="user">
				<a
					href="<%=request.getContextPath()%>/userPage?userId=${sessionScope.user.id}"><img
					alt=""
					src="<%=request.getContextPath()%>/fileLoad?userId=${sessionScope.user.id}"
					id="profile"></a>&nbsp;&nbsp;
				<div id="container">
					<div id="item1">
						<a
							href="<%=request.getContextPath()%>/userPage?user_id=${sessionScope.user.id}"><img
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
				<p>${sessionScope.user.nickName}님</p>
				&nbsp;환영합니다!
			</div>
		</c:if>
	</div>

</body>
</html>

