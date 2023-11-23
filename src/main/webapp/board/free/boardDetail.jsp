<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 태그 라이브러리 함수 replace()의 두번째 파라미터가 바꿀 글씨를 가지고 있을 변수가 필요함 -->
<% pageContext.setAttribute("nl","\n"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>
	뒤로가기 버튼<br>
	<table>
		<tr>
			<td><h1>${freeboard.freeTitle }이직을 준비중입니다</h1></td>
		</tr><br>
		<tr>
			<td>${freeboard.userNickname }고급스러운검정2103</td>
		</tr><br>
		<tr>
			작성날짜 조회수 코멘트수
		</tr><br>
		<hr>
		<tr>
			<td style="padding: 1em; height:20em; vertical-align: top" colspan="3"> ${ fn:replace(freeboard.freeContent, nl,"<br>") }  </td>
		</tr><br>
		<tr>
			좋아요 코멘트수
		</tr><br>
		<hr>
		<tr>
			<td><textarea rows="5" name="free_cmt"></textarea></td>
		</tr>
	</table>
	
		<div class="buttons">
			<input type="submit" value="댓글 등록">
			<input type="reset" value="취소">
		</div>

</body>
</html>