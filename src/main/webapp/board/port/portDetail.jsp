<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
pageContext.setAttribute("nl", "\n");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포트폴리오 - ${port.portTitle }</title>

<link type="text/css" rel="stylesheet"
	href="/TPWebTeamProject/board/port/css/portDetail.css">

	<script type="text/javascript">
		
		//회원 비회원 여부 확인 함수
		function checkuser() {
			console.log('${user.id}');
			if ( '${user}' == '') alert("로그인 후 이용해주세요.");
		}
	
	</script>

	<script type="text/javascript">
		//댓글 수정 함수
		function updateCmt(portCmtNo, cmtUserId, portCmtContent, portNo, userId) {
			
			if(userId == cmtUserId){
		    	
				// 다이얼로그 요소 가져오기
				var dialog= document.getElementById("updateCmtDialog");
				var textarea= document.getElementById("updateCmtContent");
				var submit= document.getElementById("updateCmtSubmit");
				var cancel= document.getElementById("updateCmtCancel");

				textarea.value= portCmtContent.replace(/<br>/g, '\r\n');
					
				// 다이얼로그 표시
				dialog.style.display= "block";

				// 확인 버튼 클릭
				submit.onclick = function() {
					var content = textarea.value;
					console.log(content);
					//입력받은 데이터 서버로 전송 -> 디비작업
					var xhr = new XMLHttpRequest();
					xhr.open("POST", "updatePortCmt", true);
					xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
					
					xhr.onreadystatechange= function(){
		                if(xhr.readyState==4 && xhr.status==200){
		                    location.reload();
		                }
		            }

					// 서버로 보낼 데이터
					var data = "port_cmt_no=" + portCmtNo + "&port_cmt_content=" + content + "&port_no=" + portNo;

					// 데이터 전송
					xhr.send(data);	
					dialog.style.display= "none";
				};

				// 취소 버튼 클릭
				cancel.onclick = function() {
					dialog.style.display= "none";
				};
				
		    }else {
		        alert("댓글 작성자만 수정할 수 있습니다.");
		    }
		}
	</script>
	
	<script>
		//댓글 삭제 함수
		function deleteCmt(userId, portCmtNo, portNo, cmtUserId) {
		console.log(userId + "/" + cmtUserId);
			
		if(userId == cmtUserId){
			var result = confirm('정말 삭제하시겠습니까?');
		
			if (result) {
				window.location.href = '/TPWebTeamProject/deletePortCmt?port_cmt_no=' + portCmtNo + '&port_no=' + portNo;
				}
			}else {
				alert("댓글 작성자만 삭제할 수 있습니다.");
			}
		}
	</script>
	

	<script type="text/javascript">
		// 이미지 클릭 시 좋아요 기능
		function isLike() {
			if ( '${user}' == '') {
				alert("로그인 후 이용해주세요.");
				return;
			}
        	var xhr = new XMLHttpRequest();
        	xhr.open("GET", "portIsLike?user_id=${user.id}&port_no=${port.portNo}&is_like=${port.isLike}", true);
        	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        	xhr.onreadystatechange = function () {
            	if (xhr.readyState == 4 && xhr.status == 200) {
            		location.reload();
            	}
        	}

        	// 데이터 전송
        	xhr.send();
    	}
	</script>



</head>
<body>



	<!-- 사용자 정보? 칸?-->
	<div id="top">
		<a href="/TPWebTeamProject/board/port/portlist.jsp" id="x"><img id="xx" alt="x" src="/TPWebTeamProject/board/port/img/xx.png"></a>
		<div id="user">
			<a href="/TPWebTeamProject/userPage?user_id=${port.userId }"><img alt="img" src="/TPWebTeamProject/getProfileImg?user_id=${port.userId }" id="profile"></a>
			<h3>${port.userNickname }</h3>
			<a href="">${port.userId }</a>
		</div>

		<div id="buttons">
			<!-- <div class="image-container">
				<img alt="img" src="/TPWebTeamProject/board/port/img/follow_off.png" class="button" onclick="javascript:checkuser()"><br> 
				<span id="follow_text" class="button_text">0명</span>
			</div> -->
			<div class="image-container">
				<c:if test="${port.isLike }">
					<img alt="img" src="/TPWebTeamProject/board/port/img/like_on.png" class="button" id="like_button_on" onclick="isLike();"><br>
				</c:if>
				<c:if test="${not port.isLike }">
					<img alt="img" src="/TPWebTeamProject/board/port/img/like_off.png" class="button" id="like_button_off" onclick="isLike();"><br>
				</c:if>
				<span id="like_text" class="button_text" >${port.countFav}개</span>
			</div>
			<div class="image-container">
				<img alt="img" src="/TPWebTeamProject/board/port/img/cmt.png" class="button" id="comment_button"><br> 
				<span id="comment_text" class="button_text">${port.countCmt}개</span>
			</div>

			<div id="btn">
				<a href="#" id="btn_update" onclick="updatePort('${port.portNo}', '${port.userId}', '${user.id}')">수정</a>
    			<a href="#" id="btn_delete" onclick="deletePort('${port.portNo}', '${port.userId}', '${user.id}')">삭제</a>
			</div>
		</div>

	</div>
	
	<script type="text/javascript">
    function updatePort(portNo, portUserId, userId) {
        if (userId == portUserId) {
            window.location.href = '/TPWebTeamProject/board/port/portUpdate.jsp';
        } else {
            alert("게시물 작성자만 수정할 수 있습니다.");
        }
    }

    function deletePort(portNo, portUserId, userId) {
        if (userId == portUserId) {
            var result = confirm('정말 삭제하시겠습니까?');
            if (result) {
                window.location.href = '/TPWebTeamProject/deletePortBoard?port_no=' + portNo;
            }
        } else {
            alert("게시물 작성자만 삭제할 수 있습니다.");
        }
    }
	</script>

	<script>
		// 이미지를 클릭하면 스크롤을 가장 아래로 내리는 함수
    	function scrollToBottom() {
     		window.scrollTo(0, document.body.scrollHeight);
    	}
    	// 이미지에 클릭 이벤트 리스너 등록
    	document.getElementById('comment_button').addEventListener('click', scrollToBottom);
	</script>

	<!-- 콘텐츠 시작 -->
	<div id="content">
		<p id="content_text">${fn:replace(port.portContent, nl, "<br>") }</p>

		<!-- 디비에서 이미지 -->
		<c:forEach var="img" items="${port.portImgList }">
			<img alt="img" src="/TPWebTeamProject/getImg?img_no=${img.imgNo}"
				class="content_img">
		</c:forEach>
	</div>
	
	<br><br><br>



	<!-- 하단부분 사용자 정보 칸.. -->
	<div id="bottom">
		<p id="bottom_title">
			<strong>${port.userNickname } 님의 모든 포트폴리오</strong>
		</p>
		<div id="port_all_container">
			<c:forEach var="port" items="${port.userPort }">
				<div style="text-align: center; margin: 20px 10px;">
					<a href="/TPWebTeamProject/getPortDetail?port_no=${port.portNo} ">
					<img src="/TPWebTeamProject/getImg?img_no=${port.portImg.imgNo}" alt="" class="port_all"></a><br> ${port.portTitle }
				</div>
			</c:forEach>
		</div>
	</div>

	<br>

	<!-- 댓글 창 -->
	<p id="cmt_title">
		<strong>댓글</strong>
	</p>
	<div id="comment_container">

		<c:forEach var="cmt" items="${port.portCmtList }">
			<div id="comment_item">
				<a href="/TPWebTeamProject/userPage?user_id=${cmt.userId }"><img alt="img" src="/TPWebTeamProject/getProfileImg?user_id=${cmt.userId }" id="comment_profile"></a>
				<h5>${cmt.userNickname }</h5>
				<span id="date">${cmt.portCmtDate }</span>

				<!-- 콘텐츠 내용 줄바꿈 치환 -->
				<c:set var="formattedCmtContent"
					value="${fn:replace(cmt.portCmtContent, nl, '<br>')}" />

				<!-- 본인일 경우 수정 / 삭제 기능 -->
				<div id="cmt_button">
					<a href="javascript:updateCmt('${cmt.portCmtNo }','${cmt.userId }','${formattedCmtContent}',${cmt.portNo }, '${user.id }')">수정</a>&nbsp;&nbsp;&nbsp;
					<a class="deleteLink" href="javascript:deleteCmt('${user.id }','${cmt.portCmtNo }','${cmt.portNo }','${cmt.userId }')">삭제</a>
				</div>

				<p id="comment">${formattedCmtContent}</p>
			</div>
		</c:forEach>

		<div id="input_container">
			<form action="/TPWebTeamProject/insertPortCmt" method="post" enctype="application/x-www-form-urlencoded" style="margin: 20px 40px;">
				<textarea rows="5" placeholder="댓글 남기기" maxlength="1000" name="port_cmt_content" onclick="javascript:checkuser()" required></textarea><br> 
				<input type="hidden" name="port_no" value="${port.portNo}">
				<input type="hidden" name="user_id" value="${user.id }">
				<input type="submit" value="완료" class="input_button" id="scrollTarget" onclick="javascript:checkuser()">&nbsp;&nbsp;&nbsp; 
				<input type="reset" value="취소" class="input_button" onclick="javascript:checkuser()">
			</form>
		</div>

		

		<!-- 댓글 수정 다이얼로그 모양 -->
		<div id="updateCmtDialog" style="display: none;">
			<p id="cmt_title">
				<strong>댓글 수정</strong>
			</p>
			<textarea rows="5" placeholder="댓글 수정" maxlength="1000"
				name="port_cmt_content" id="updateCmtContent"></textarea>
			<br>
			<button id="updateCmtSubmit" class="input_button">확인</button>
			&nbsp;&nbsp;&nbsp;
			<button id="updateCmtCancel" class="input_button">취소</button>
		</div>
	</div>




</body>
</html>