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

</head>
<body>
	
		<jsp:include page="../../header.jsp"></jsp:include>		
	

	<div id="nav">
		<select class="port">
			<option value="1">최신순</option>
			<option value="2">조회수순</option>
			<option value="3">좋아요순</option>
		</select>
		
		<a href="./portUpload.jsp">
			<input type="button" value="글쓰기" id="button">
		</a>
	</div>
		
	



	<section style="text-align: center;">
		<div>
			<jsp:include page="../../portList.jsp"></jsp:include>
		</div>
	</section>

</body>
</html>