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
        
        <table class="head">
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
                       
                    <table id="freelist">
                    	
                        <tr>
                            <td id="category">${freeBoard.freeCategory}</td>
                        </tr>
                        
                        <tr>
                            <td><h2>${freeBoard.freeTitle}</h2></td>                
                        </tr>
                        
                        <tr id="content">   
                            <td>${freeBoard.freeContent}</td>
                        </tr>
                        
                        <tr>
                            <td>${freeBoard.freeNickname}</td>        
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
			
			<div class="pagination">
			    <c:forEach var="i" begin="1" end="${totalPages}">
        			<a href="#" onclick="changePage(${i})">${i}</a>
			    </c:forEach>
			</div>
			
			<table class="index">
			
				<tr>
			      <th><a href=../../><p>홈</p></a></th>
			    </tr>
			    
			    <tr>
			      <th><a href="../../portBoardList"><p>포트폴리오</p></a></th>
			    </tr>
			
				<tr class="category" id="community">
        			<th><p>커뮤니티</p></th>
		    	</tr>
		    	
			    <tr class="content" id="allPosts">
			        <td><a href="../../freeBoard"><p>전체게시판</p></a></td>
			    </tr>
			    
			    <tr class="content" id="freePosts">
			        <td><a href="#" onclick="selectCategory('자유게시판')"><p>자유게시판</p></a></td>
			    </tr>
			    
			    <tr class="content" id="resume">
			        <td><a href="#" onclick="selectCategory('자기소개서/이력서')"><p>이력서/자기소개서</p></a></td>
			    </tr>
			    
			    <tr class="content" id="interview">
			        <td><a href="#" onclick="selectCategory('면접/취업')"><p>면접/취업</p></a></td>
			    </tr>
							
			</table>
			
	<!-- 로그인 여부 확인 -->
	<div class="message">
    <c:if test="${empty user}">
        <!-- 로그인이 안 된 경우 -->
        <a href="../../user/loginForm.jsp">로그인</a>
    </c:if>

    <c:if test="${not empty user}">
        <!-- 로그인이 된 경우 -->
        <a href="boardForm.jsp">글쓰기</a>
    </c:if>		
	</div>
	</body>
			
			
	<script type="text/javascript">
	
	    var selectedCategory = "";
		
		document.addEventListener('DOMContentLoaded', function () {
		  const categoryRow = document.getElementById('community');
		  categoryRow.addEventListener('click', function () {
		    // Toggle the display of content rows
		    const contentRows = document.getElementsByClassName('content');
		    for (const row of contentRows) {
		      row.style.display = row.style.display === 'none' ? 'table-row' : 'none';
		    }
		  });
		});
		
	    function selectCategory(category) {
			 
        // 선택한 카테고리 설정
        selectedCategory = category;
        
        // 서버에 선택한 카테고리에 대한 글 요청
        $.get('../../getFreeBoardByCategory', { category: encodeURIComponent(category) }, function(data) {
        	
        	// 포워딩하기 전에 기존 테이블 삭제
            $('.head').remove();  
    		$('.message').remove();

            // 서버에서 받은 데이터로 테이블 업데이트
            $('#table-container').html(data);
        });
    }
	    
	    //페이지 클릭했을때 리스트 바뀌게 하기
	    function changePage(pageNo) {
	    	
	        console.log("FreeBoardChangePage Servlet Called - PageNo: " + pageNo);

	        // 서버로 요청을 보냄
	        $.get('../../changePage', { pageNo: pageNo }, function(data) {
	        	
	        	// 포워딩하기 전에 기존 테이블 삭제
	            $('.head').remove();  
	    		$('.message').remove();
	    		
	            // 서버에서 받은 데이터로 테이블 업데이트
	            $('#table-container').html(data);
	        });
	    }
	    
	</script>

</html>