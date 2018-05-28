<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reply/editForm.jsp</title>

	<style type="text/css">
		body {
			background-color: aliceblue;
		}
	
	</style>
</head>
<body>

	<h1 style="margin-left: 30%; margin-top: 5%;">댓글 수정</h1>
	
	${boardnum }
	
	<form action="edit" method="post">
		<div style="margin-left: 30%">
			내용: <input type="text" id="text" name="text" style="width: 300px;">
		</div> <br>
		
		<input type="submit" value="submit" style="margin-left: 30%;">
		<input type="hidden" id="boardnum" name="boardnum" value="${boardnum }">
		<input type="hidden" id="replynum" name="replynum" value="${replynum }">
	</form>
	

</body>
</html>