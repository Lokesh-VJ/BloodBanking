<%@include file="taglib.jsp"%>

<div class="marginBetweenFields loginPageFormContents text-left margin-center">
	<h4 class="loginPageHeadTitle">&nbsp;</h4>
	<form method="post" action="preProcessLogin.html" id="loginForm" name="loginForm" >
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label class="label_content">Username<span class="fieldMandatory">*</span></label>
			<input type="text" name="j_username" id="j_username" value="" required readonly onfocus="this.removeAttribute('readonly')" />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label class="label_content">Password<span class="fieldMandatory">*</span></label>
			<input type="password" name="j_password" id="j_password" value="" required readonly onfocus="this.removeAttribute('readonly')" />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<input type="submit" name="submit" id="submit" value="Login" />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<a href="signup.html" class="signUp">New user?</a>
			<a href="forgotPassword.html" class="forgotPassword pull-right">Forgot your password?</a>
		</div>
	</form>
</div>