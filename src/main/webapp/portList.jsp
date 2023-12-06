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
}

#portImg {
	width: 220px;
	height: 220px;
}

#containner {
	display: grid;
	grid-template-columns: repeat(5, 1fr); /* 5개의 열을 가진 그리드 */
	grid-template-rows: repeat(6, 1fr); /* 6개의 행을 가진 그리드 */
	gap: 10px;
}
#containerWraper {
	border-radius: 16px;
	border: 1px solid #333; /* 각 아이템에 테두리 추가 */
  	padding: 16px;          /* 내용과 테두리 간의 여백 설정 */
}

#containerWraper>div:nth-child(2)>div {
	
}
#proImg:hover :first-child{
	
}
</style>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"
		integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="../../js/portList.js"></script>
	<div id="containner"></div>
</body>
</html>