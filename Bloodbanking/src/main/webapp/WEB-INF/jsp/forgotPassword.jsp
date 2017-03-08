<%@include file="taglib.jsp"%>

<div class="marginBetweenFields loginPageFormContents text-left margin-center">
	<h4 class="loginPageHeadTitle text-center">Reset password</h4>
	<form method="post" action="processForgotPassword.html" id="forgotPasswordForm" name="forgotPasswordForm">
		<input type="hidden" name="userName" id="userName" value="${baseDTO.userName}" />
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label class="label_content">New password<span class="fieldMandatory">*</span></label>
			<input type="password" name="password" id="password" value="" required />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label class="label_content">Confirm password<span class="fieldMandatory">*</span></label>
			<input type="password" name="confirmPassword" id="confirmPassword" value="" required />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<input type="submit" name="submit" id="submit" value="Submit" />
		</div>
	</form>
</div>