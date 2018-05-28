/**
 *  ID 체크
 */
$(document).ready(function(){		// 페이지가 로딩되면 실행
	$('#id').on('keyup', idCheck);
});

// 가입

/* function join(){
	$.ajax({
		url: '../customer/join'
		, type: 'post'
		, data: $('#joinForm')		// 폼 그대로 전송, 데이터 직렬화
		, success: function(s) {				
				alert('가입 완료');
				location.href="../";
		}
		, error: function(err) {
			console.log(err);
		}
	});			
} */

/* function join(){
	var custid = $('#custid').val();
	var password = $('#password').val();
	var name = $('#name').val();
	var phone = $('#phone').val();
	var address = $('#address').val();
	var email = $('#email').val();

	var data = {
		custid : custid
		, password : password
		, name : name
		, phone : phone
		, address : address
		, email : email				
	};

	// 데이터 전송
	$.ajax({
		url: '../customer/join'
		, type: 'post'
		, contentType: 'application/json;charset=utf-8'	// 전송할 데이터가 JSON임을 알려주는것
		, data: JSON.stringify(data)		//data를 JSON으로 스트링화 시킨다.
		, success: function(data) {
			if(data == 1){
				alert('가입 완료');
			}
			
		}
		, error: function() {
			console.log(err);
		}		
	});		
} */
	

// ID 중복체크
function idCheck(){			
	var custid = $('#id').val();
	$.ajax({
		url: '../member/idCheck'
		, type: 'post'
		, data: {id: id}				
		, success: function(data){					
			if(($.trim(data) == 0) & (custid.length > 4) & (custid.length < 13)){
				$('#idCheckResult').html('<p style="color:blue">사용 가능한 ID입니다.</p>');
			}else if(($.trim(data) == 0) & (custid.length <= 4)){
				$('#idCheckResult').html('<p style="color:red">5글자 이상 입력해주세요.</p>');
			}else if(($.trim(data) == 0) & (custid.length >= 13)){
				$('#idCheckResult').html('<p style="color:red">&nbsp12글자 이하로 입력하세요.</p>');
			}else{
				$('#idCheckResult').html('<p style="color:red">동일한 ID가 존재합니다.</p>');
			}					
		}
		, error: function(){
			console.log(err);
		}
	});			
}