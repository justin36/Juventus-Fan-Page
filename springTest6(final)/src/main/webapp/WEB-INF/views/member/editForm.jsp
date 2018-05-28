
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member/editForm.jsp</title>
</head>
	<script src="<c:url value = '/resources/js/jquery-3.2.1.js'/>"></script>
	<script type="text/javascript" src='<c:url value = "/resources/js/jquery-ui.js"/>'></script>
	<script type="text/javascript" src='<c:url value = "/resources/js/wickedpicker.js"/>'></script>
	<script type="text/javascript" src='<c:url value = "/resources/js/jquery-2.2.3.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value = "/resources/js/editForm"/>'></script>

	<link rel="stylesheet" href='<c:url value = "/resources/css/styleEditForm.css"/>'/>
	<link rel="stylesheet" href='<c:url value = "/resources/css/jquery-ui.css"/>'/>
	<link rel="stylesheet" href='<c:url value = "/resources/css/wickedpicker.css"/>'/>
		
<body>
	
	<h1 class="w3layouts">MyInfo</h1>

	<div class="clear"> </div>
		<div class="content-w3ls">
		
		<div class="form_w3layouts">
		
			<form action="edit" method="post" class="agile_form" onsubmit="return checkForm()">
			
				<div class="agileits-left"> 
					<input type="text" name="id" value="${m.id }" readonly="readonly"> <br>
				</div>
				
				<div class="agileits-left">
					<input type="text" id="password" name="password" placeholder="*PW"> <br>				
				</div>
				
				<div class="agileits-left">
					<input type="text" id="passwordc" name="passwordc" placeholder="*PW Check"> <br>
				</div>
				
				<div class="agileits-left">
					<input type="text" name="name" value="${m.name }" readonly="readonly"> <br>
				</div>

				<div class="agileits-left">
					<input type="text" id="email" name="email" placeholder="Email">
				</div>

				<div class="agileits-left"> 
					<input type="text" name="idno" value="${m.idno }"> <br>
				</div>

				<div class="agileits-left">
					<input type="text" id="address" name="address" placeholder="Address"> <br>
				</div>
					
				<div class="submit-w3l" style="display: inline-block;">
					<input type="submit" value="submit"> 
				</div>
			</form>
		
			</div>
		</div>
	
</body>
</html>