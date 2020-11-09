$(function(){

//	var error_name = false;
	var error_password = false;
	var error_check_password = false;
	var error_check = false;


//	$('#uname').blur(function() {
//		check_uname();
//	});

	$('#upwd').blur(function() {
		check_upwd();
	});

	$('#cpwd').blur(function() {
		check_cpwd();
	});


	$('#allow').click(function() {
		if($(this).is(':checked'))
		{
			error_check = false;
			$(this).siblings('span').hide();
		}
		else
		{
			error_check = true;
			$(this).siblings('span').html('请勾选同意');
			$(this).siblings('span').show();
		}
	});


//	function check_uname(){
//		var len = $('#uname').val().length;
//		if(len<2||len>20)
//		{
//			$('#uname').next().jsp('请输入2-20个字符的用户名');
//			$('#uname').next().show();
//			error_name = true;
//		}
//		else
//		{
//			$('#uname').next().hide();
//			error_name = false;
//		}
//	}

	function check_upwd(){
		var len = $('#upwd').val().length;
		if(len<8||len>20)
		{
			$('#upwd').next().html('密码最少8位，最长20位');
			$('#upwd').next().show();
			error_password = true;
		}
		else
		{
			$('#upwd').next().hide();
			error_password = false;
		}		
	}


	function check_cpwd(){
		var pass = $('#upwd').val();
		var cpass = $('#cpwd').val();

		if(pass!==cpass)
		{
			$('#cpwd').next().html('两次输入的密码不一致');
			$('#cpwd').next().show();
			error_check_password = true;
		}
		else
		{
			$('#cpwd').next().hide();
			error_check_password = false;
		}		
		
	}


	$('#reg_form').submit(function() {
//		check_uname();
		check_upwd();
		check_cpwd();

                

		if(error_password ===false && error_check_password === false  && error_check === false)
		{
			return true;
		}
		else
		{
			return false;
		}

	});



});