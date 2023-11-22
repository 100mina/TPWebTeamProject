<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 쓰기</h1><br>
	<h4>게시글은 커뮤니티에서 사용중인 닉네임으로 등록됩니다.</h4><br>
	<table>
		<tr>
			카테고리 선택
		</tr>
		<tr>
			<input type="text" placeholder="제목을 입력해주세요" name="free_title" >
		</tr>
		<tr>
			<td><textarea rows="20" name="free_content"></textarea></td>
		</tr>
	</table>
	
	
	<input type="submit" value="등록하기">
	

</body>
</html>