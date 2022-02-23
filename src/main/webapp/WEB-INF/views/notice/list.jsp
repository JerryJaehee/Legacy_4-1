<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>Notice List page</h1>
	
	<table>
		<tr>
			<td>Num</td><td>Titel</td><td>Writer</td><td>Date</td><td>Hit</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.num}</td>
			<td><a href="./detail?num=${dto.num}">${dto.title}</a></td>
			<td>${dto.writer}</td>
			<td>${dto.regDate}</td>
			<td>${dto.hit}</td>
		</tr>
		
		</c:forEach>
		
		<a href="./add">ADD</a>
	</table>

</body>
</html>