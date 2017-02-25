<%@include file="taglib.jsp"%>

<div class="marginBetweenFields loginPageFormContents text-left margin-center">
	<h4 class="loginPageHeadTitle text-center">Reset password</h4>
	<form method="post" action="processForgotPassword.html" id="forgotPasswordForm" name="forgotPasswordForm">
		<input type="hidden" name="userName" id="userName" value="${registrationDTO.userName}" />
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>New password<span class="fieldMandatory">*</span></label>
			<input type="password" name="password" id="password" value="" required />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Confirm password<span class="fieldMandatory">*</span></label>
			<input type="password" name="confirmPassword" id="confirmPassword" value="" required />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<input type="submit" name="submit" id="submit" value="Submit" />
		</div>
	</form>
</div>

<script>
	var password = document.getElementById("password");
	var confirmPassword = document.getElementById("confirmPassword");
	
	function validatePassword(){
		if(password.value != confirm_password.value) {
	  		confirm_password.setCustomValidity("Passwords Don't Match");
		} else {
	  		confirm_password.setCustomValidity('');
		}
	}
	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
</script>