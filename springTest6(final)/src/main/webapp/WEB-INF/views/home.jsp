
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Project</title>
		
	<script type="text/javascript" src='<c:url value = "/resources/js/jquery-ui.js"/>'></script>
	<script type="text/javascript" src='<c:url value = "/resources/js/wickedpicker.js"/>'></script>
	<script type="text/javascript" src='<c:url value = "/resources/js/jquery-2.2.3.min.js"/>'></script>

	<link rel="stylesheet" href='<c:url value = "/resources/css/style.css"/>'/>
	<link rel="stylesheet" href='<c:url value = "/resources/css/jquery-ui.css"/>'/>
	<link rel="stylesheet" href='<c:url value = "/resources/css/wickedpicker.css"/>'/>

</head>
<body>
	<h1 class="w3layouts"> Juventus Fan Page </h1>
	
 	<c:if test="${param.errorMessage != null }">
		<div style="position: fixed; margin-left: 900px; margin-top: 170px;">
			<b>Login Failed</b>
		</div>
	</c:if>
	
	<c:if test="${loginId == null }">
	<div class="clear"> </div>
		<div class="content-w3ls">
			<div class="form_w3layouts">
				
				
				<form action="login/login" method="post" class="agile_form">
					<div class="agileits-left">
						<input type="text" id="id" name="id" placeholder="ID" required>
					</div>
					
					<div class="agileits-left">
						<input type="text" id="password" name="password" placeholder="Password" required>
					</div>
					
					<div class="submit-w3l" style="display: inline-block;">
						<input type="submit" value="Login"> 
					</div> &nbsp;&nbsp;&nbsp;
					
					<div class="button-w3l" style="display: inline-block;">
						<input type="button" value="Join" onclick="location.href='member/join'"> 
					</div>

				</form>
			</div>
		</div>
	</c:if>
	
	<c:if test="${loginId != null }">
		<div class="clear"> </div>
		<div class="content-w3ls">
			<div class="form_w3layouts">
				<form action="#" method="post" class="agile_form">
					<div class="agileits-left">
						<input type="text" value="${loginId } 님 환영합니다." style="width: 370px;" readonly="readonly">
					</div>
									
					<div class="button-w3l" style="display: inline-block;">
						<input type="button" value="Board" onclick="location.href='board/list'"> 
					</div> &nbsp;
					
					<div class="button-w3l" style="display: inline-block;">
						<input type="button" value="Bulletin" onclick="location.href='bulletin/list'"> 
					</div> &nbsp;
					
					<div class="button-w3l" style="display: inline-block;">
						<input type="button" value="회원정보 수정" style="background: aqua;" onclick="location.href='member/edit'"> 
					</div> &nbsp;
					
					<div class="button-w3l" style="display: inline-block;">
						<input type="button" value="LogOut" style="background: aquamarine;" onclick="location.href='login/logout'"> 
					</div> &nbsp;
				
					<div class="button-w3l" style="display: inline-block;">
						<input type="button" value="탈퇴" style="background: lightskyblue;" onclick="location.href='member/delete'"> 
					</div>
	
				</form>
			</div>
		</div>
	</c:if>
	
</body>
</html>
