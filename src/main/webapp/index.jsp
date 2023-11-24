<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"
	isELIgnored="false"
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

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
<header style="position: fixed;">
		<div class="wraper">
		<a><img alt="icon" src="./image/icon.png" id="icon"></a>
			<div id="category">
		    	<ul class="first">
		    		<li class="first"><a href="">포트폴리오</a></li>
		    		<li class="first"><a href="">취업신</a></li>
		    		<li class="first">
		    			<a href="">정보마당</a>
		    			<ul class="second">
			    			<li><a href="">전체게시판</a></li>
			    			<li><a href="">자유게시판</a></li>
			    			<li><a href="">면접/취업</a></li>
			    			<li><a href="">자기소개서/이력서</a></li>
		    			</ul>
		    		</li>
		    	</ul>
		    </div>
	    	<div id="login">
		    	<a><img alt="프로필 사진이 로드되지 않았습니다." src="./user/default_profile/profile.png" id="profile"></a>
		    	<a href="user/loginForm.jsp">로그인</a>
		    	<a href="user/signupForm.jsp">회원가입</a>
	    	</div>
    	</div>
</header>
</div>
<div><img alt="" src="./image/bg_main.png" style="width: 1920px; height: 450px;  padding-top: 85px;"></div>

</body>
</html>