<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL을 위한 디렉티브 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>

<!-- 외부스티일시트 -->
<link type="text/css" rel="stylesheet" href="css/freeList.css">

</head>
<body>
	
	<!-- 게시판 화면 디자인 -->
	<table>
		<tr>
			<th>&nbsp; 최신글 &nbsp; | &nbsp; 댓글 많은 글 &nbsp; | &nbsp; 인기글 </th>
		</tr>
		
		
		<c:choose>
		
    		<c:when test="${empty freeBoardList }">
				<tr>
					<td colspan="5">등록된 글이 없습니다.</td>
				</tr>
			</c:when>
    		
   			 <c:otherwise>
    				<c:forEach var="board" items="${freeBoardList }">
					<tr>
						<td style="padding-top: 30px">${board.freeCategory }</td>
					</tr>
					<tr>
						<td><h2>${board.freeTitle }</h2></td>				
					</tr>
					<tr id="content">	
						<td>${board.freeContent }</td>
					</tr>
					<tr>
						<td>${board.userNickname }</td>		
					</tr>
					<tr>	 
						 	<td> 
						 		<img src="./image/viewicon.png" alt="Comment Icon" style="width: 17px"> ${board.freeView }
						 		<img src="./image/comment.png" alt="Comment Icon" class="listicon"> ${board.freeView }
						 		<img src="./image/recommend.png" alt="recommend Icon" class="listicon"> ${board.freeView }
						 		<span id="date">${board.freeDate }</span>
						 		
						 	</td>
					</tr>
        		</c:forEach>
    		 </c:otherwise>
    		
		</c:choose>
		
		
		
	</table>
	
	<div class="message">
		<a href="boardForm.jsp">글쓰기</a>
	</div>
	


</body>
</html>