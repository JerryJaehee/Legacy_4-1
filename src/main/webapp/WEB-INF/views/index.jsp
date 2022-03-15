<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="./template/header_css.jsp"></c:import>
	<style type="text/css">
		.hea {
			width:  80%;
			height: 200px;
			margin: 70px auto;
			clear: both;
			overflow: hidden;
		}
		
		.hea img {
			width: 100%;
			height: 100%;
			
		}
	</style>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>


	<h1>Index Page</h1>

	<h3>${member.name} 님 환영합니다 
	<span class="material-icons-outlined">
		account_circle
	</span> 

	</h3>
	
	
	<div>
		<c:if test="${not empty member}">
			<a class="my" href="./member/mypage">MyPage</a>
			<a href="./member/logout">Logout</a>
		</c:if>
		
		<c:if test="${empty member}">
			<a href="./member/login">Login</a>
			<a href="./member/join">Join</a>
		</c:if>
	
	</div>
	
	<img alt="" src="./resources/upload/notice/ea238b70-982e-4ede-aa3a-272303936a34_IMG_9169.jpg">
	
</body>
</html>