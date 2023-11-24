<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
 	int totalCount = 30;

	java.util.List<java.util.Map> portList = new ArrayList<>();
	for (int i = 1; i < totalCount; i++) {
		java.util.Map<String, Object> toMap = new java.util.HashMap<String, Object>();
		toMap.put("user_id", "userId_" + i);
		toMap.put("view_count", i);
		toMap.put("like_count", i * 2);
		portList.add(toMap);
	}
%>
<c:set var="portList" value="<%= portList %>" />



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
			<input type="text" placeholder="검색어를 입력하세요.">
			<img alt="" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
		</div>
	</header>
	
	<nav>
	
		<div class="portp">		
				<select class="port" >
					<option value="1">최신순</option>
					<option value="2">조회수순</option>
					<option value="3">좋아요순</option>
				</select>
		</div>

	
	</nav>
	

	
	<section style="text-align: center;">
	<div style="margin: 40px; padding: 10px; overflow: hidden;">
	<c:forEach var="port" items="${portList}">
		
		<div style="margin: 10px; float: left;">
		
		<a href="#" class="product">
        	<img alt="이미지" src="../../image/portimage1.png" width="230">
  		</a>
  		
    
     
    	<div>
    		<a href="#" class="user_id">
    		
    			<img class="user_image" alt="이미지" src="../../image/portimage1.png" width="25">
    			${port.user_id}	
    		</a>
    			<img alt="이미지" src="../../image/eye.png" style="margin-left: 20px">${port.view_count}
    		
    			<img alt="이미지" src="../../image/favo.png" style="margin-left: 10px">${port.like_count}
    		
    	</div>
    	
    	
    	</div>
    	</c:forEach>
    	</div>
    	
	
	</section>
	
    
	<!-- <aside class="right">
	
	</aside> -->
    
	<footer style="margin-top: 40px; text-align: center;">
	<div style="margin-top: 40px;">
	<p>
    		<input type="button" value="1" onclick="#">
    		<input type="button" value="2" onclick="#">
    		<input type="button" value="3" onclick="#">
    		<input type="button" value="4" onclick="#">
    		<input type="button" value="5" onclick="#">
    		<input type="button" value="6" onclick="#">
    		<input type="button" value="7" onclick="#">
    		<input type="button" value="글쓰기" onclick="#" style="margin-left: 70px;">
    </p>
	
		</div>
	</footer>
	
	
</body>
</html>