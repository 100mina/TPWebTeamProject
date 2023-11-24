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
			<p class="aa">
				명당이라불리고..<br>
				취업의 신들이 모이는 이곳
			</p>
			<img alt="" src="../image/icon.png" class="aa">
		</div>
			<div id="item2">	
				<h2>취업의 神 로그인</h2>
				<form action="../login" enctype="application/x-www-form-urlencoded" method="post">
					<input type="text" name="id" placeholder="아이디">
					<input type="password" name="pw" placeholder="비밀번호">
					<input type="submit" value="로그인">
				</form>
					<p>
						<a href="">비밀번호 찾기</a>
						<a href="">아이디 찾기</a>
						<a href="">회원가입</a>
					</p>
			</div>
		<div id="item3"></div>
</div>

</body>
</html>