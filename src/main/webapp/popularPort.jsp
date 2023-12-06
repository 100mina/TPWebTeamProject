<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

#profile {
	width: 40px;
	height: 40px;
	border: 1px solid lightgray;
	border-radius: 50%; 
}

#portImg {
	width: 230px;
	height: 230px;
	border-radius: 10%;
	border: 1px solid lightgray; 
}

#containner {
	display: flex;
	overflow: auto;
	animation: slide 5s linear infinite; /* 애니메이션 지속 시간과 반복 설정 */
	
}
#containerWraper {
  	padding: 16px;          /* 내용과 테두리 간의 여백 설정 */
  	border-radius: 10%;
  	color: #888888;
}
img {
    overflow-clip-margin: content-box;
    overflow: clip;
}

#containerWraper>div:nth-child(2)>div {
	
}
#proImg {
	display: flex;
	 
}
#proImg>a{
	f1ex:3;
	margin-right:4.5em; 
}
#proImg>span{
	flex:none;
	margin-left: 1em;
	margin-top: 1em;
}



</style>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"
		integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="./js/popularPort.js"></script>
	<div id="containner"></div>
</body>
</html>