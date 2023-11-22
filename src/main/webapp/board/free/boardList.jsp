<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL을 위한 디렉티브 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>
	
	<!-- 게시판 화면 디자인 -->
	<table>
		<tr>
			<td>카테고리</td><br>
			<td>제목</td><br>
			<td>글내용</td><br>
			<td>닉네임</td><br>
			<td>조회수 코멘트수 좋아요수</td>
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
						<td>${board.freeCategory }</td>
						<td><a href=".../freeBoard?board_no=${board.freeNo }">${board.freeTitle }</a></td>
						<td>${board.freeContent }</td>
						<td>${board.userNickname }</td>
						<td>${board.freeView } </td>
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