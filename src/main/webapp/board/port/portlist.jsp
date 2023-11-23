<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포트폴리오 목록</title>

 <link type="text/css" rel="stylesheet" href="css/portlist.css">
</head>
<body>
	<header>
		<div class="search">
			<input type="text" placeholder="검색어를 입력하세요.">
			<img alt="" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
		</div>
	</header>
	
	<nav>
		<div>
				<select class="port">
					<option value="1">최신순</option>
					<option value="2">조회수순</option>
					<option value="3">좋아요순</option>
				</select>
		</div>
	
	</nav>

	<aside class="left" >
	
	</aside>   
	
	<section>
		<a href="#" class="product">
        	<img alt="이미지" src="../../image/portimage1.png" width="350">
  		</a>
    
    	<div>
    		<a href="#" class="user_id">
    			<img class="user_image" alt="이미지" src="../../image/portimage1.png" width="25">
    		userId	
    		</a>
    			<img alt="이미지" src="../../image/eye.png">
    		
    			<img alt="이미지" src="../../image/favo.png">
    		
    	</div>
    	
	
	</section>
	
	<aside class="right">
	
	</aside> 
    
	<footer>
	
	</footer>
	
	
</body>
</html>