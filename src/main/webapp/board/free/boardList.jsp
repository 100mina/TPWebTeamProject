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

<!-- jQuery 추가 -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<script>
    // 클라이언트 측에서 서버로 정렬 요청 보내는 함수
    function sortTable(orderBy) {
        // 서버로 요청을 보냄
        $.get('sortingFreeBoard', { orderBy: orderBy }, function(data) {
            // 서버에서 받은 데이터로 테이블 업데이트
            $('#table-container').html(data);
        });
    }
</script>

</head>
<body>
	
	 <!-- 각 게시물 전체에 대한 링크 -->
        <!-- 게시판 화면 디자인 -->
        <table>
            <tr>
				<th onclick="sortTable('latest')">최신글</th>
	            <th onclick="sortTable('mostComments')">댓글 많은 글</th>
	            <th onclick="sortTable('mostLikes')">인기글</th>           
            </tr>
        </table>
        
            <!-- 게시글 목록이 표시되는 영역 -->
    		<div id="table-container">
            <c:choose>
                <c:when test="${empty freeBoardList}">
                    <tr>
                        <td colspan="5">등록된 글이 없습니다.</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach var="freeBoard" items="${freeBoardList}">
                    
                   <a href="../../freeBoard?free_no=${freeBoard.freeNo}" class="board-link">     
                    <table>
                    	
                        <tr>
                            <td style="padding-top: 30px">${freeBoard.freeCategory}</td>
                        </tr>
                        
                        <tr>
                            <td><h2>${freeBoard.freeTitle}</h2></td>                
                        </tr>
                        
                        <tr id="content">   
                            <td>${freeBoard.freeContent}</td>
                        </tr>
                        
                        <tr>
                            <td>${freeBoard.userNickname}</td>        
                        </tr>
                        
                        <tr>     
                            <td> 
                                <img src="./image/viewicon.png" alt="Comment Icon" style="width: 17px"> <p>${freeBoard.freeView}</p>
                                <img src="./image/comment.png" alt="Comment Icon" class="listicon"> <p>${freeBoard.commentCount}</p>
                                <img src="./image/recommend.png" alt="recommend Icon" class="listicon"> <p>${freeBoard.freeView}</p>
                                <span id="date">${freeBoard.freeDate}</span>
                            </td>
                        </tr>
                        
					   </table>
					  </a>
					  <br>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
			</div>
			
	
	<a href="boardForm.jsp"><div class="message">글쓰기</div></a>
		
	


</body>
</html>