<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"
	isELIgnored="false"
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>취업의 신</title>
    <link href="./css/index.css" rel="stylesheet">
</head>
<body>
<div>
	<a id="aicon" href="./index.jsp"><img alt="icon" src="./image/icon.png" id="icon"></a>
<header>
			
			<div id="category">
		    	<ul class="first">
		    		<li><a href="">포트폴리오</a></li>
		    	</ul>
		    	<ul class="first">
		    		<li><a href="">취업신</a></li>
		    	</ul>
		    	<ul id="info">
		    		<li><a href="">정보마당</a></li>
		    	</ul>
		    </div>
		    <ul class="second">
				<li><a href="">전체게시판</a></li>
				<li><a href="">자유게시판</a></li>
				<li><a href="">면접/취업</a></li>
				<li><a href="">자기소개서/이력서</a></li>
			</ul>
			
			<script>
			  	var info = document.querySelector('#info');
			  	var secondUl = document.querySelector('.second');
			
			  	info.addEventListener("mouseover", function() {
			    // 호버되었을 때 컨테이너와 관련 없는 다른 요소의 스타일 변경
			    secondUl.style.display = 'block';			    
			  	});
			
			    secondUl.addEventListener("mouseover", function() {
			    	
			    	secondUl.style.display = 'block';			    	
			    });
			    secondUl.addEventListener("mouseout", function() {
				// 호버가 해제되면 스타일을 원래대로 변경
				secondUl.style.display = 'none';
					    
			});
			</script>
	    	<div id="logintext">
		    	<a href="user/loginForm.jsp">로그인</a>&nbsp;&nbsp;&nbsp;
		    	<a href="user/signupForm.jsp">회원가입</a>
	    	</div>
	    <c:if test="${not empty sessionScope.user}">
	    	<div id="user">
	    		<a href="/user"><img alt="" src="./fileLoad" id="profile"></a>&nbsp;&nbsp;
	    		  <p>${sessionScope.user.nickName}님</p>&nbsp;환영합니다!
	    		  
	    		  <script type="text/javascript">
	    		  	var loginText = document.getElementById("logintext");
	    		  	loginText.style.display = "none";
	    		  </script>
	    	</div>
		</c:if>  
</header>
</div>
<div id="mainImg">
	<img alt="" src="./image/bg_main.png">
</div>
<p id="mainText">
	취업의 명당 취업의 신<br>
	<br>
	취업의 신은... 취준생 끼리 모여 정보를 공유하고 의견을 주고 받을 수 있는 사이트 입니다.<br>
	여러분이 추천하고 따르는 취준생은 순위의 오르게 되며 취업신 이라는 등급이 부여됩니다.<br>
	적극적으로 활동하고 취업신에 도전해 보세요.
</p>	
<h2>인기 포트폴리오 게시물</h2>
<div class="portWraper">
	<a href="#" class="user_id">
	<img class="user_image" alt="이미지" src="../../image/portimage1.png" width="25">id
	</a>
	<img alt="이미지" src="../../image/eye.png" style="margin-left: 20px">view count
	<img alt="이미지" src="../../image/favo.png" style="margin-left: 10px">like count
</div>

<h2>인기 취업신 랭킹</h2>
<div class="sinWraper">
	<a href="#" class="user_id">
	<img class="user_image" alt="이미지" src="../../image/portimage1.png" width="25">id
	</a>
	<img alt="이미지" src="../../image/eye.png" style="margin-left: 20px">view count
	<img alt="이미지" src="../../image/favo.png" style="margin-left: 10px">like count
</div>
<div id="bg">
	<h1>지금 취업의神의 가입 하고<br>
	인기 취업신에 도전해 보세요!
	</h1>
	<span>
		<a href=""><button class="btn">인기 포트폴리오 둘러보기</button></a>
		<a href="./user/signupForm.jsp"><button class="btn">취업의 신 가입하기</button></a>
	</span>
</div>
<div class="postWraper">
	<a href="#" class="user_id">
	<img class="user_image" alt="이미지" src="../../image/portimage1.png" width="25">id
	</a>
	<img alt="이미지" src="../../image/eye.png" style="margin-left: 20px">view count
	<img alt="이미지" src="../../image/favo.png" style="margin-left: 10px">like count
</div>
<footer>
</footer>


</body>
</html>