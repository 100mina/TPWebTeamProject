<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취업의 신 회원가입</title>
<link rel="stylesheet" href="./css/signupForm.css">
</head>
<body>
<div class="container">
	<div id="item">
		<img alt="" src="./image/loginImg.png" class="aa">
			<h3 id="msg">
			명당이라 불리고..<br>
			취업의 신들이 모이는 이곳..
			</h3>
		<img alt="" src="../image/icon.png" id="icon">
	</div>
	<div id="item2">
		<h2>취업의 神 회원가입</h2>
		<form action="../signup" method="post" enctype="application/x-www-form-urlencoded">
			<p>아이디</p>
			<input type="text" name="id">
			<p>비밀번호</p>
			<input type="password" name="pw">
			<p>닉네임</p>
			<input type="text" name="nickName">
			<input type="submit" value="회원가입" id="submit">
			<div id="bnav">
				<p>
					<a href="">비밀번호 찾기</a>
					<a href="">아이디 찾기</a>
					<a href="">회원가입</a>
				</p>
			</div>
		</form>
	</div>
	<div id="item3"></div>
</div>
</body>
</html>