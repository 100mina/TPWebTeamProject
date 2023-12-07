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
		
	</header>

	<nav>

		<div class="portp">
			<select class="port">
				<option value="1">최신순</option>
				<option value="2">조회수순</option>
				<option value="3">좋아요순</option>
			</select>
		</div>
		
		<a href="./portUpload.jsp">
			<input type="button" value="글쓰기" id="button">
		</a>
		
	</nav>



	<section style="text-align: center;">
		<div>
			<jsp:include page="../../portList.jsp"></jsp:include>
		</div>
	</section>



</body>
</html>