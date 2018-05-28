<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bulletin/read.jsp</title>
	
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

	<h1>글 읽기</h1>
	
	<table border="1">
		<tr>
			<th width="80px;"> 제목 </th>
			<th> ${b.title } </th>
		</tr>
		
		<tr>
			<th> 내용 </th>
			<td> <textarea rows="20" cols="30"> ${b.content } </textarea> </td>
		</tr>	
	</table> <br>
	
	<input type="button" value="Back" onclick="location.href='./list'">

</body>
</html>