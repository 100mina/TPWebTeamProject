<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포트폴리오 업로드</title>
<link type="text/css" rel="stylesheet" href="css/portUpload.css">
</head>
<body>

	<h2>포트폴리오 업로드</h2><br>
	<p>자신의 포트폴리오를 업로드해서 자랑하거나, 다른 사람의 의견을 구할 수 있습니다!</p>
	
	<br><br>
	
	<form action="../../insertPortBoard" method="post" enctype="multipart/form-data">
	
		<input class="input" id="input_title" type="text" placeholder="제목을 입력하세요." required="required" maxlength="100" name="port_title"><br>
		
		<textarea rows="15" id="input_content" placeholder="내용을 입력하세요." class="input" maxlength="4000" name="port_content"></textarea><br>
		
		<input type="file" id="input_file" accept="image/*" multiple name="imgs" required="required" >
		<div id="previewContainer"></div>
		<br><br>
		<div id="button_container">
			<input class="button" type="reset" value="다시작성">
			<input class="button" type="submit" value="작성완료">
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
	        img.alt = '미리보기 이미지';
	        
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