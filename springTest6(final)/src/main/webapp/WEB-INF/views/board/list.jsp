<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board/list.jsp</title>

	<style type="text/css">
		table {
			border: 1px solid black;
			border-collapse: collapse;
			width: 650px;	
		}
		
		img {
			position: fixed;
			width: 700px;
			margin-left: 800px;	
		}
	</style>

</head>
<body>
	
	<h1>Juventus Board</h1>
	
	<img src="../resources/images/Pirlo.jpg">
	
	<div style="margin-left: 470px;"> 
		<input type="button" value="글쓰기" onclick="location.href='write'"> &nbsp;
		<input type="button" value="메인 페이지" onclick="location.href='../'">
	</div> <br>
	
	<table border="1">
		<tr>
			<th> 번호 </th>
			<th style="width: 180px"> 제목 </th>
			<th> 작성자 </th>
			<th> 조회수 </th>
			<th> 등록일 </th>
			<th> 파일유무 </th>
		</tr>
		<c:forEach var="vo" items="${bList }">
		<tr>
			<th> ${vo.boardnum } </th>
			<th> <a href="read?boardnum=${vo.boardnum }"> ${vo.title } </a> </th>
			<th> ${vo.id } </th>
			<th> ${vo.hits } </th>
			<th> ${vo.inputDate } </th>
			<th> <c:if test="${vo.originalfile != null }"> * </c:if> </th>
		</tr>
		</c:forEach>
	</table>

</body>
</html>