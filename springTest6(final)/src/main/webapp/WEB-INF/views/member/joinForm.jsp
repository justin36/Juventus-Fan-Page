
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member/joinMember.jsp</title>

	<script src="<c:url value = '/resources/js/jquery-3.2.1.js'/>"></script>
	<script type="text/javascript" src='<c:url value = "/resources/js/jquery-ui.js"/>'></script>
	<script type="text/javascript" src='<c:url value = "/resources/js/wickedpicker.js"/>'></script>
	<script type="text/javascript" src='<c:url value = "/resources/js/jquery-2.2.3.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value = "/resources/js/joinForm.js"/>'></script>

	<link rel="stylesheet" href='<c:url value = "/resources/css/styleJoinForm.css"/>'/>
	<link rel="stylesheet" href='<c:url value = "/resources/css/jquery-ui.css"/>'/>
	<link rel="stylesheet" href='<c:url value = "/resources/css/wickedpicker.css"/>'/>	

</head>
<body>

	<h1 class="w3layouts">Registration</h1> <!-- 어떻게 하면 정보들을 보관해서 Join실패했어도 보이게 하지? -->

	<div class="clear"> </div>
		<div class="content-w3ls">
		
		<div class="form_w3layouts">
		
			<form action="join" method="post" class="agile_form" onsubmit="return checkForm()">
				<div align="right" >* Must Enter</div>
			
				<div class="agileits-left" style="display: inline-block; width: 250px"> 
					<input type="text" id="id" name="id" placeholder="*ID" readonly="readonly">
				</div>
			
				<div class="button-w3l" style="display: inline-block;">
					&nbsp;&nbsp;&nbsp;<input type="button" value="idCheck" onclick="idCheck()"> 
				</div>
				
				<div class="agileits-left">
					<input type="text" id="password" name="password" placeholder="*PW"> <br>				
				</div>
				
				<div class="agileits-left">
					<input type="text" id="passwordc" name="passwordc" placeholder="*PW Check"> <br>
				</div>
				
				<div class="agileits-left">
					<input type="text" id="name" name="name" placeholder="*Name"> <br>
				</div>

				<div class="agileits-left">
					<input type="text" id="email" name="email" placeholder="Email">
				</div>					

				<div class="agileits-left"> 
					<input type="text" id="idno" name="idno" placeholder="*ID Number"> <br>
				</div>

				<div class="agileits-left">
					<input type="text" id="address" name="address" placeholder="Address"> <br>
				</div>
					
				<div class="submit-w3l" style="display: inline-block;">
					<input type="submit" value="submit"> 
				</div>
				
				<!-- <div class="submit-w3l" style="display: inline-block;">
						<input type="submit" value="Login"> 
				</div> &nbsp;&nbsp;&nbsp; -->
				
			</form>
		
			</div>
		</div>
</body>
</html>