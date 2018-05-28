/**
 * 
 */

function checkForm() {
	var id = $('#id').val();
	var password = $('#password').val();
	var passwordc = $('#passwordc').val();
	var name = $('#name').val();
	var email = $('#email').val();
	var idno = $('#idno').val();
	var address = $('#address').val();
	
	if (id == '') {
		alert("Please Enter ID");
		return false;
	}
	
	if (password == '') {
		alert("Please Enter Password");
		return false;
	}
	
	if (passwordc == '') {
		alert("Please Enter Password Check");
		return false;
	}
	
	if (password != passwordc) {
		alert("The Passwords Are Different");
		return false;
	}
	
	if (name == '') {
		alert("Please Enter Name");
		return false;
	}
	
	if (idno == '') {
		alert("Please Enter Identification Number");
		return false;
	}

	return true;
}
	
function idCheck() {
	window.open('idCheck', 'width=300px', 'height=300px');
}

