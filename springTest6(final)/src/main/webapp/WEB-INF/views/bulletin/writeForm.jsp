<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bulletin/writeForm.jsp</title>
	<script type="text/javascript" src='<c:url value = "/resources/js/jquery-3.2.1.js"/>'></script>

	<style type="text/css">
		body {
			margin-left: 30%;
			margin-top: 5%;		
		}
		
		table {
			border-collapse: collapse;	
		}
	</style>
	
</head>
<body>
	<h1>글쓰기</h1>
	
	<form action="write" method="post">
		<table border="1">
			<tr>
				<th> 제목 </th>
				<th> <input type="text" id="title" name="title" placeholder="제목"> </th>
			</tr>
			
			<tr>
				<th> 내용 </th>
				<th> <textarea rows="20" cols="30" id="content" name="content"></textarea> </th>
			</tr> 
		
		</table>
		
		<input type="submit" value="submit">
	</form>

</body>
</html>