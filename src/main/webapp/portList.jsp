<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

@font-face{
	font-family: "notosans";
	src: url("../../../font/notosans.ttf");
}

*{ margin: 0px; padding: 0; font-family: "notosans";}

#profile {
	width: 40px;
	height: 40px;
	border: 1px solid lightgray;
	border-radius: 50%;
	position: relative;
	right: 70px;
}

#portImg {
	width: 230px;
	height: 230px;
	border-radius: 10%;
	border: 1px solid lightgray;
	margin-bottom: 10px;
}

#containner {
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
	grid-gap: 100px;
	justify-items: center;
	margin: 50px 80px;
}
#containerWraper {
  	padding: 16px;          /* 내용과 테두리 간의 여백 설정 */
  	border-radius: 10%;
  	color: #888888;
  	border: 1px solid lightgray;
  	position: relative;
  	margin: 0px 30px;
}

#proImg {
	position: relative;
}


#userid{
	display: inline-block;
	position: relative;
	bottom: 15px;
	right: 60px;
}

.favView{
	text-align: right;
}

.countFavView{
	margin-top: 13px;
	margin-left: 8px;
	margin-right: 8px; 
}

#button{
	position: absolute;
	top: 0px;
	right: 80px;
	text-align: center;
	background-color: #88888888;
	padding: 8px;
	border-radius: 12px;
	font-size: 13px;
	color: white;
	font-weight: bold;
	width: 7em;
	border: none;
	margin: 10px, 0, 10px, 0;
}

#button:hover{cursor: pointer; }


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