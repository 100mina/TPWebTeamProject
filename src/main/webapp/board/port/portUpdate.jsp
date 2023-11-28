<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포트폴리오 수정</title>
<link type="text/css" rel="stylesheet" href="css/portUpload.css">
</head>
<body>

	<h2 id="title">포트폴리오 수정&nbsp;&nbsp;&nbsp;</h2>
	<a href="javascript:history.back()">이전으로 돌아가기</a><br><br>
	
	<br>
	
	<form action="../../updatePortBoard" method="post" enctype="multipart/form-data">
	
		<input class="input" id="input_title" type="text" placeholder="제목을 입력하세요." required="required" maxlength="100" name="port_title" value="${port.portTitle }"><br>
		
		<textarea rows="15" id="input_content" placeholder="내용을 입력하세요." class="input" maxlength="4000" name="port_content" >${port.portContent }</textarea><br>
		
		<input type="file" id="input_file" accept="image/*" multiple name="imgs" >
		
		<h6>*파일 재선택 시 이전 이미지들은 사라지고, 새로 선택한 파일들로 업로드됩니다.*</h6>
		
		<div id="previewContainer">
			<c:forEach  var="img" items="${port.portImgList }" >
				<img src="/TPWebTeamProject/getImg?img_no=${img.imgNo}" alt="" id="img">
			</c:forEach>
		</div>
		<br><br>
		<div id="button_container">
			<input class="button" type="reset" value="다시작성">
			<input class="button" type="submit" value="작성완료">
			<input type="hidden" name="port_no" value="${port.portNo }">
		</div>

	</form>
	
	
	
	
	<script type="text/javascript">
	
	const fileInput = document.getElementById('input_file');
	const previewContainer = document.getElementById('previewContainer');

	fileInput.addEventListener('change', handleFileSelect);

	function handleFileSelect(event) {
	  const selectedFiles = event.target.files;

	  // 기존 미리보기 삭제
	  previewContainer.innerHTML = '';

	  // 각 파일에 대한 미리보기 생성
	  for (const file of selectedFiles) {
	    if (file.type.startsWith('image/')) {
	      const reader = new FileReader();

	      reader.onload = function (e) {
	        const img = document.createElement('img');
	        img.src = e.target.result;
	        
	     	// 이미지 크기를 고정
	        img.style.height = '250px';
	        img.style.marginTop = '20px';
	        img.style.marginBottom = '20px';
	        img.style.marginLeft = '20px';
	        img.style.marginRight = '20px';
	        
	        img.style.border = '1px solid lightgray';

	        // 미리보기를 포함한 요소를 컨테이너에 추가
	        previewContainer.appendChild(img);
	      };

	      reader.readAsDataURL(file);
	    } else {
	      // 이미지가 아닌 파일에 대한 처리 (예: 에러 메시지 표시)
	      const errorMessage = document.createElement('p');
	      errorMessage.textContent = `${file.name}은(는) 이미지 파일이 아닙니다.`;
	      previewContainer.appendChild(errorMessage);
	    }
	  }
	}
	</script>

</body>
</html>