<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>취업의 신 - 가입을 환영합니다.</title>
		<link href="./css/profile_selectForm.css" rel="stylesheet">
		<script>
			function init() {
				document.getElementById('btn').addEventListener('click', function() {
					document.getElementById('input').click();
			        document.getElementById('input').addEventListener('change', function() {
			            var profileImage = document.getElementById('profile');

			            if (this.files && this.files[0]) {
			                var reader = new FileReader();

			                reader.onload = function (e) {
			                	profileImage.src = e.target.result;
			                };

			                reader.readAsDataURL(this.files[0]);
			            }
			        });
				});
			}	
		</script>
		
		<c:set var="vo" scope="session"/>
	</head>
	<body onload="init()">
	<a href="../index.jsp"><img alt="icon" src="../image/icon.png" id="home"></a>
		<header>
			<div id="text_div">	
				<h2>취업의 신 가입을 환영합니다!</h2>
				<h5 style="color: #888888">활동하면서 보여질 프로필을 선택해 주세요!</h5>
				<h3>프로필 선택</h3>
			
			<img alt="" src="./default_profile/profile.png" id="profile" style="border: 0.3px solid #B09090; border-radius: 50%; height: 150px; width: 150px">
			<button id="btn">이미지 선택</button>
			<hr>
			</div>
			<form action="../updateProfile" method="post" enctype="multipart/form-data">
				<input type="file" value="" accept="image/*" onchange="changeImg()" id="input" style="display: none" name="profileImg">
				<input type="submit" value="설정하기" id="input_next">
			</form>
		</header>
			<hr>
	
		<footer>
			<img alt="" src="./image/bg_profile_selectForm.png" width="100%">
		</footer>
	</body>
</html>