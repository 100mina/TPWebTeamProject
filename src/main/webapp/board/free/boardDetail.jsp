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

<!-- jQuery 및 jQuery UI 라이브러리 추가 -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


</head>

<body>
	<h4 class="message"><a href="../../freeBoard">게시판으로 돌아가기</a></h4>
	<table>
		<tr>
			<td>
				<h1>${freeBoard.freeTitle }</h1>
			</td>
				
		</tr>
		<tr>
			<td>${freeBoard.userNickname }</td>
		</tr>
		<tr>
			<td> 
                <img src="./image/viewicon.png" alt="Comment Icon" style="width: 16px"> <p>${freeBoard.freeView}</p>
                <img src="./image/comment.png" alt="Comment Icon" class="listicon"> <p>${fn:length(freeCmtList)}</p>
                <img src="./image/recommend.png" alt="recommend Icon" class="listicon"> <p>${freeBoard.freeView}</p>
                <span id="date">${freeBoard.freeDate}</span>
            </td>
		</tr>
		<tr>
			<td style="padding: 1em; height:20em; vertical-align: top" colspan="3">${ fn:replace(freeBoard.freeContent, nl,"<br>") }</td>
		</tr>
		
		<tr>
			<td>
			    <img src="./image/recommend.png" alt="recommend Icon" class="middleicon"> <p class="p2">추천</p>&nbsp;&nbsp;
				<img src="./image/comment.png" alt="Comment Icon" class="middleicon"> <p class="p2">${fn:length(freeCmtList)}<p>
				
				<%-- <c:if test="${member.userId == board.userId }"> --%>
				 	<p class="list-buttons">
						<span class="update list-button" onclick="mod()">수정</span>
						<span class="delete list-button" onclick="del(${freeBoard.freeNo})">삭제</span>
				 	</p>
				<%-- </c:if> --%>
				
			</td>
		</tr>
		
	</table>
			
			<br>
			<c:choose>
                <c:when test="${empty freeCmtList}">
                
                    <div id="container">
                    
                        <p id="empty">등록된 댓글이 없습니다.</p>
                        
                    </div>
                    
                </c:when>
                
                
                <c:otherwise>
                    <c:forEach var="comment" items="${freeCmtList}">
					    <div class="comment-item">
					        <table class="cmt">
					            <tr>
					                <td class="comment-info">
					                    <b>${comment.userNickname }</b>
					                    <p class="cmt-buttons">
					                        <span class="update cmt-button" onclick="updateCmt('${comment.freeCmtNo}', '${comment.freeCmtContent}')">수정</span>
                        					<span class="delete cmt-button" onclick="deleteComment(${comment.freeCmtNo})">삭제</span>					                    
                        				</p>
					                </td>
					                					
					            </tr>
					            <tr>
					                <td class="content">${comment.freeCmtContent }</td>
					            </tr>
					            <tr>
					                <td class="comment-date">
					                    <img src="./image/comment.png" alt="Comment Icon" class="listicon">
					                    <p>${comment.freeCmtDate.toString().replace('.0', '')}</p>
					                </td>
					            </tr>
					            <tr>
					                <td>
					                     <div class="updateCmtDialog" id="updateCmtDialog_${comment.freeCmtNo}" style="display: none;">
					                          <p id="cmt_title"><strong>댓글 수정</strong></p>
					                          <textarea rows="5" placeholder="댓글 수정" maxlength="630px" name="free_cmt_content" class="updateCmtContent"></textarea><br>
					                          <button class="updateCmtSubmit input_button">확인</button>&nbsp;&nbsp;&nbsp;
					                          <button class="updateCmtCancel input_button">취소</button>
					                     </div>
					                </td>
					            </tr>
					        </table>
					    </div>
					</c:forEach>
                </c:otherwise>
                	
                
            </c:choose>
            
            <br>
	
		<form action="../../addFreeCmt" method="post">
        <input type="hidden" name="free_no" value="${freeBoard.freeNo}">
        <input type="hidden" name="user_nickname" value="EXNICKNAME">
        <textarea rows="5" name="free_cmt_content" placeholder="함께 이야기를 나눠보세요" id="cmtarea"></textarea>
        <input type="submit" value="댓글등록" class="buttons">
        <input type="reset" value="다시작성" class="buttons">
        
    </form>
    
    	
    
    <script type="text/javascript">
    function mod() {
        location.href = "modifyForm.jsp";
    }

    function del(freeNo) {
        var answer = confirm("정말로 삭제하시겠습니까?");
        if (answer) location.href = "../../freeBoard?method=DELETE&free_no=" + freeNo;
    }

 	//댓글 수정 함수
    function updateCmt(freeCmtNo, freeCmtContent) {
        // 다이얼로그 요소 가져오기
        var dialog = document.getElementById("updateCmtDialog_" + freeCmtNo);
        var textarea = dialog.querySelector(".updateCmtContent");
        var submit = dialog.querySelector(".updateCmtSubmit");
        var cancel = dialog.querySelector(".updateCmtCancel");

        textarea.value = freeCmtContent;

        // 다이얼로그 표시
        dialog.style.display = "block";

        // 확인 버튼 클릭
        submit.onclick = function () {
        	 var content = textarea.value;
             var cmtNo = freeCmtNo;
 			
             // 현재 시간을 얻어오기
             var currentDate = new Date();
             var cmtDate = currentDate.toISOString(); // ISO 형식의 문자열로 변환

             // AJAX를 통해 서버로 데이터 전송
             $.ajax({
                 type: "POST",
                 url: "/TPWebTeamProject/modifyFreeCmt",
                 data: {
                     free_cmt_no: cmtNo,
                     free_cmt_content: content,
                     free_cmt_date: cmtDate // 필요하다면 날짜 정보도 추가
                 },
                 success: function (response) {
                     // 서버에서 처리한 결과(response)를 확인
                     if (response === "Success") {
                         // 성공적으로 수정되었을 때의 처리
                         console.log("댓글이 성공적으로 수정되었습니다.");
							 
                         // 여기서 화면을 갱신하거나 필요한 작업을 수행
                         
                      	 // 업데이트된 댓글 내용을 가져오는 코드
                         var updatedContent = content;

                         // 현재 댓글 엘리먼트를 가져오는 코드
                         var commentElement = $("#updateCmtDialog_" + cmtNo).closest(".comment-item");

                         // 댓글 내용 업데이트
                         commentElement.find(".content").text(updatedContent);
                         
                     } else {
                         // 수정에 실패했을 때의 처리
                         console.log("댓글 수정에 실패했습니다.");
                     }
                 }
             });

             dialog.style.display = "none";
        };

        // 취소 버튼 클릭
        cancel.onclick = function () {
            dialog.style.display = "none";
        };
    }
 	
    function deleteComment(freeCmtNo) {
        var answer = confirm("정말로 삭제하시겠습니까?");
        if (answer) {
            // AJAX를 통해 댓글 삭제 요청
            $.ajax({
                type: "POST",
                url: "/TPWebTeamProject/deleteFreeCmt",
                data: {
                    free_cmt_no: freeCmtNo
                },
                success: function (response) {
                    // 서버에서의 처리 결과(response)를 확인
                    if (response === "Success") {
                        // 성공적으로 삭제되었을 때의 처리
                        console.log("댓글이 성공적으로 삭제되었습니다.");

                        // 여기서 화면을 갱신하거나 필요한 작업을 수행
                         $("#updateCmtDialog_" + freeCmtNo).closest(".comment-item").remove();

	                    // 남은 댓글이 없다면 메시지 표시
	                     if ($(".comment-item").length === 0) {
	                         $("#empty").show();
	                     }
                    
                    } else {
                        // 삭제에 실패했을 때의 처리
                        console.log("댓글 삭제에 실패했습니다.");
                    }
                }
            });
        }
    }
 
 	
</script>

</body>
</html>