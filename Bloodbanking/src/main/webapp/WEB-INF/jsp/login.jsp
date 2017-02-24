<%@include file="taglib.jsp"%>

<div class="marginBetweenFields loginPageFormContents text-left margin-center">
	<h4 class="loginPageHeadTitle">&nbsp;</h4>
	<form method="post" action="processLogin.html" id="loginForm" name="loginForm">
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Username<span class="fieldMandatory">*</span></label>
			<input type="text" name="userName" id="userName" value="" required/>
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Password<span class="fieldMandatory">*</span></label>
			<input type="password" name="password" id="password" value="" required/>
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