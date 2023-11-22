<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취업의 신 회원가입</title>
</head>
<body>
	<h2>취업의 神 회원가입</h2>
	<form action="../signup" method="post" enctype="application/x-www-form-urlencoded">
		<input type="text" name="id" placeholder="아이디">
		<input type="password" name="pw" placeholder="비밀번호">
		<input type="text" name="nickName" placeholder="닉네임">
		<input type="submit" value="회원가입">
		<p>
			<a href="">비밀번호 찾기</a>
			<a href="">아이디 찾기</a>
			<a href="">회원가입</a>
		</p>
	</form>

</body>
</html>