<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board/writeForm.jsp</title>
	
	<script type="text/javascript" src='<c:url value = "/resources/js/boardWrite.js"/>'></script>
	
	<style type="text/css">
		table {
			border: 1px solid black;
			border-collapse: collapse;
		}
	</style>

</head>
<body>

	<h1>글쓰기</h1>
	
	<form action="write" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th style="width: 80px"> 제목 </th>
				<td> <textarea rows="2" cols="35" id="title" name="title"></textarea> </td>
			</tr>
			
			<tr>
				<th> 내용 </th>
				<td> <textarea rows="20" cols="35" id="content" name="content"></textarea> </td>
			</tr>
			
			<tr>
				<th> 파일 </th>
				<td> <input type="file" name="upload"> </td>
			</tr>
			
		</table> <br>
		
		<input type="submit" value="submit">
	</form>

</body>
</html>