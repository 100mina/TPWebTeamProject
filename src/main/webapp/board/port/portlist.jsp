<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포트폴리오 목록</title>

<link type="text/css" rel="stylesheet" href="css/portlist.css">
</head>
<body>
	<header>
		<div class="search">
			<input type="text" placeholder="검색어를 입력하세요."> <img alt="이미지"
				src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
		</div>
	</header>

	<nav>

		<div class="portp">
			<select class="port">
				<option value="1">최신순</option>
				<option value="2">조회수순</option>
				<option value="3">좋아요순</option>
			</select>
		</div>
	</nav>



	<section style="text-align: center;">
		<div style="margin: 40px; padding: 10px; overflow: hidden;">
			<jsp:include page="../../portList.jsp"></jsp:include>		
		</div>
	</section>



	<footer style="margin-top: 40px; text-align: center;">
		<div style="margin-top: 40px;">
			<p>
				<input type="button" value="1" onclick="#"> <input
					type="button" value="2" onclick="#"> <input type="button"
					value="3" onclick="#"> <input type="button" value="4"
					onclick="#"> <input type="button" value="5" onclick="#">
				<input type="button" value="6" onclick="#"> <input
					type="button" value="7" onclick="#"> <a
					href="./portUpload.jsp"><input type="button" value="글쓰기"
					onclick="#" style="margin-left: 70px; padding: 0.5em"></a>
			</p>

		</div>
	</footer>


</body>
</html>