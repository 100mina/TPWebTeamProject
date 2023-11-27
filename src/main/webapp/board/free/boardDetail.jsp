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

<!-- 외부스티일시트 -->
<link type="text/css" rel="stylesheet" href="css/freeDetail.css">

</head>

<body>
	<h4 class="message"><a href="../../freeBoard">게시판으로 돌아가기</a></h4>
	<table>
		<tr>
			<td><h1>${freeBoard.freeTitle }</h1></td>
		</tr>
		<tr>
			<td>${freeBoard.userNickname }</td>
		</tr>
		<tr>
			<td> 
                <img src="./image/viewicon.png" alt="Comment Icon" style="width: 16px"> <p>${freeBoard.freeView}</p>
                <img src="./image/comment.png" alt="Comment Icon" class="listicon"> <p>${freeBoard.freeView}</p>
                <img src="./image/recommend.png" alt="recommend Icon" class="listicon"> <p>${freeBoard.freeView}</p>
                <span id="date">${board.freeDate}</span>
            </td>
		</tr>
		<tr>
			<td style="padding: 1em; height:20em; vertical-align: top" colspan="3">${ fn:replace(freeboard.freeContent, nl,"<br>") }</td>
		</tr>
		
		<tr>
			<td>
			    <img src="./image/recommend.png" alt="recommend Icon" class="middleicon"> <p class="p2">추천</p>&nbsp;&nbsp;
				<img src="./image/comment.png" alt="Comment Icon" class="middleicon"> <p class="p2">${board.freeView}0<p>
			</td>
		</tr>
		
	</table><br>
		
			<c:choose>
                <c:when test="${empty freeCmtList}">
                    <tr>
                        <td colspan="5">등록된 댓글이 없습니다.</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach var="comment" items="${freeCmtList}">
                    
                    <table>
                    	        
                        <tr>
                            <td>${comment.userNickname }</td>                
                        </tr>
                        
                        <tr id="content">   
                            <td>${comment.freeCmtContent }</td>
                        </tr>
                        
                        <
                        <tr>     
                            <td> 
                                <img src="./image/comment.png" alt="Comment Icon" class="listicon"> <p>${comment.freeCmtDate}</p>
                                <img src="./image/recommend.png" alt="recommend Icon" class="listicon"> <p>${board.freeView}좋아요</p>
                            </td>
                        </tr>
                        
					   </table>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            
            <br>
	
		<textarea rows="5" name="free_cmt" placeholder="함께 이야기를 나눠보세요"></textarea>
	
			<input type="submit" value="댓글등록" class="buttons">
			<input type="reset" value="다시작성" class="buttons">

</body>
</html>