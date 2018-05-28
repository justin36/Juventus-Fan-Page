/**
 * 
 */

function checkForm() {
	var password = $('#password').val();
	var passwordc = $('#passwordc').val();
	
	if (password == '') {
		alert('Please Enter Password');
		return false;
	}
	
	if (passwordc == '') {
		alert('Please Enter Password Check');
		return false;
	}
	
	return true;
}