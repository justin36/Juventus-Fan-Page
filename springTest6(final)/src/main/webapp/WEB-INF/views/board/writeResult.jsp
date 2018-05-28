
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board/writeResult.jsp</title>
	
	<script type="text/javascript">
		
		function edit(boardnum, replynum) {
			
			location.href = "../reply/edit?boardnum=" + boardnum + "&replynum=" + replynum;
		}
		
		function del(boardnum, replynum) {
			
			location.href = "../reply/delete?boardnum=" + boardnum + "&replynum=" + replynum;
		}
	
	</script>
	
	<style type="text/css">
		body {
			background-color: aliceblue;
		}
		
		table {
			border: 1px solid black;
			border-collapse: collapse;
		}
	</style>

</head>
<body>

	<h1> ${b.boardnum }번째 글 </h1>

	<table border="1">
		<tr>
			<th style="width: 80px"> 제목 </th>
			<th style="width: 300px;"> ${b.title } </th>
		</tr>
		
		<tr>
			<th style="height: 400px"> 내용 </th>
			<td> ${b.content } </td>
		</tr>
					
		<c:if test="${b.originalfile != null }">		
		<tr>
			<th> 파일 </th>
			<td> <a href="download?boardnum=${b.boardnum }"> ${b.originalfile } </a> </td>
		</tr>
		</c:if>
		
	</table> <br>
	
	<input type="button" value="back" onclick="location.href='./list'"> &nbsp; 
		
	<c:if test="${sessionScope.loginId == b.id }"> <!-- 이것을 submit이 아닌 button으로도 해보자 -->
	<form action="edit" style="display: inline-block;">
		<input type="hidden" id="boardnum" name="boardnum" value="${b.boardnum }">
		<input type="submit" value="edit">
	</form>
	
	<form action="delete" style="display: inline-block;">
		<input type="hidden" id="boardnum" name="boardnum" value="${b.boardnum }">
		<input type="submit" value="delete">
	</form>
	</c:if> <br> <br>
	 
	<!-- 댓글 등록 -->
	${sessionScope.loginId } <br>
	
	<form action="../reply/insert" method="post">
		댓글: <input type="text" id="text" name="text" placeholder="댓글">
		
		<input type="submit" value="등록">
		<input type="hidden" id="boardnum" name="boardnum" value="${b.boardnum }">
	</form> <br>

	<table border="1">
		<tr>
			<th> 아이디 </th>
			<th style="width: 200px;"> 내용 </th>
			<th> 수정 </th>
			<th> 삭제 </th>
		</tr>
	
	<c:forEach var="vo" items="${rList }">
		<tr>
			<td> ${vo.id } </td>
			<td> ${vo.text } </td>
			
			<c:if test="${sessionScope.loginId == vo.id }">
			<td> <input type="button" value="수정" onclick="edit(${vo.boardnum}, ${vo.replynum})"> </td>
			<td> <input type="button" value="삭제" onclick="del(${vo.boardnum}, ${vo.replynum})"> </td>
			</c:if>
		</tr>		
	
	</c:forEach>
		
	</table>
	
	
</body>
</html>