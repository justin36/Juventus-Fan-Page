
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board/bulletin.jsp</title>
	<style type="text/css">
		body {
			margin-left: 30%;
			margin-top: 5%;			
		}
		
		table {
			border-collapse: collapse;	
			width: 500px;
		}
	
	</style>

</head>
<body>

	<h1>정기모임</h1>
	
	<input type="button" value="글쓰기" onclick="location.href='write'"> <br><br>
	
	<table border="1">
		<tr>
			<th> 번호 </th>
			<th width="150px;"> 제목 </th>
			<th> 조회수 </th>
			<th> 등록일자 </th>
		</tr>
		
		<c:forEach var="vo" items="${bulletinList }">		
		<tr>
			<th> ${vo.bulletinnum } </th>
			<th> <a href="read?bulletinnum=${vo.bulletinnum }"> ${vo.title } </a> </th>
			<th> ${vo.hits } </th>
			<th> ${vo.inputdate } </th>
		</tr>
		</c:forEach>
	</table>
	
	
	

</body>
</html>