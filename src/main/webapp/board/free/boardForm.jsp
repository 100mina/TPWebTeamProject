<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="css/freeForm.css">

</head>
<body>
	<h4 class="message">자유롭게 글을 작성하실 수 있습니다. &nbsp;&nbsp; <a href="../../freeBoard">게시판으로 돌아가기</a></h4>
	
	<form action="../../freeBoard" method="post" enctype="application/x-www-form-urlencoded">	
		<input type="hidden" name="method" value="POST">
	
	<table>
		<tr>
			<td>
				<h1 class="align-left"><b>게시글 쓰기</b></h1>
				<h4 class="align-left">게시글은 커뮤니티에서 사용중인 닉네임으로 등록됩니다.</h4>
			</td>
			
		</tr>
			
		<tr>
			<td class="align-left">
        	   <p>카테고리 선택 (필수)</p>
        	   <select name="category" required="required" name="free_category">
            	  <option value="자유">자유게시판</option>
            	  <option value="취업">면접/취업</option>
            	  <option value="자기소개서">자기소개서/이력서</option>
       		   </select>
    		</td>
		</tr>
		<tr>
			<td><input type="text" placeholder="제목을 입력해주세요" id="title" name="free_title" required="required"></td>
		</tr>
		<tr>
			<td><textarea rows="30" cols="100" id="content" placeholder="내용을 입력해 주세요" name="free_content" required="required"></textarea></td>
		</tr>
	</table>
	
	<input type="submit" value="작성완료" class="buttons">
	<input type="reset" value="다시작성" class="buttons">
	
	</form>
	

</body>
</html>