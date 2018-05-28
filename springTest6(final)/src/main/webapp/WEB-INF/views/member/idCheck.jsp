
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member/idCheck.jsp</title>

	<script type="text/javascript">
		function idCheck(id) {
			opener.document.getElementById('id').value = id;
			window.close();
		}
	
	</script>

</head>
<body>

	<h1>아이디 체크</h1>
	
	<form action="idCheck" method="post">
			
		<input type="text" id="id" name="id" placeholder="ID" value="${id }"> &nbsp;
		
		<input type="submit" value="ID 확인">
	
	</form>
		
	<c:if test="${idCheck == '가능'}">
		사용 가능합니다 <br><br> 
		
		<input type="button" value="사용하기" onclick="idCheck(${id})"> 
	</c:if>	

	<c:if test="${idCheck == ''}">
		다른 아이디를 입력 바랍니다.
		
	</c:if>

</body>
</html>