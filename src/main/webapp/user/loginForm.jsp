<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취업의 신 로그인</title>
<link rel="stylesheet" href="./css/loginForm.css">
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
				<h2>취업의 神 로그인</h2>
				<form action="../login" enctype="application/x-www-form-urlencoded" method="post">
					<p>아이디 또는 이메일</p>
					<input type="text" name="id">
					<p>비밀번호</p>
					<input type="password" name="pw">
					<input type="submit" value="로그인" id="submit">
				</form>
					<span>
						<a href="">비밀번호 찾기</a>
						<a href="">아이디 찾기</a>
						<a href="">회원가입</a>
					</span>
			</div>
		<div id="item3"></div>
</div>

</body>
</html>