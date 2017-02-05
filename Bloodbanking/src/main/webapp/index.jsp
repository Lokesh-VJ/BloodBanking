<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Blood Banking</title>
		<style>
			body{
				font-family: Arial, sans-serif;
				font-size: 12px;
				background: url('resources/image/app_background.png');
			}
			.appTitle{
				color: red;
				font-size: 24px;
			}
			.appHelptext{
				color: red;
				font-size: 20px;
			}
			.loginPageHeadTitle{
				font-size: 16px;
			}
			.marginBetweenFields{
				margin: 10px;
			}
			.loginPageFormContents{
				width: 300px;
				height: 300px; 
			}
			.loginPageFormContents label{
				width: 30%;
			}
			.loginPageFormContents input{
				width: 70%;
			}
			.loginPageFormContents_Div {
				text-align: right;
			}
			.loginPageFormContents_Div #submit{
				width: 100px;
			}
			.signUp, .forgotPassword{
				margin-right: 10px; 
			}
		</style>
	</head>
	<body>
		<center>
			<h2 class="appTitle">Blood Banking</h2>
			<h3 class="appHelptext">Online Blood Bank Management Software</h3>
		
			<br /><br /><br /><br />
			
			<div class="marginBetweenFields loginPageFormContents">
				<h4 class="loginPageHeadTitle">Login</h4>
				<form method="post" action="doLoginCheck.htm" id="loginForm" name="loginForm">
					<div class="marginBetweenFields loginPageFormContents_Div">
						<label>Email Id</label>
						<input type="text" name="emailId" id="emailId" value="" />
					</div>
					<div class="marginBetweenFields loginPageFormContents_Div">
						<label>Password</label>
						<input type="password" name="password" id="password" value="" />
					</div>
					<div class="marginBetweenFields loginPageFormContents_Div">
						<a href="signUp.htm" class="signUp">Sign up</a>
						<a href="forgotPassword.htm" class="forgotPassword">Forgot password?</a>
						<input type="submit" name="submit" id="submit" value="Login" />
					</div>
				</form>
			</div>
		</center>
	</body>
</html>