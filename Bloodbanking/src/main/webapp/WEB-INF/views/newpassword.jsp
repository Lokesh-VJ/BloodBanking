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
				width: 150px;
			}
		</style>
	</head>
	<body>
		<center>
			<h2 class="appTitle">Blood Banking</h2>
			<h3 class="appHelptext">Online Blood Bank Management Software</h3>
		
			<br /><br /><br /><br />
			
			<div class="marginBetweenFields loginPageFormContents">
				<h4 class="loginPageHeadTitle">Reset your password</h4>
				<form method="post" action="doLoginCheck.htm" id="loginForm" name="loginForm">
					<div class="marginBetweenFields loginPageFormContents_Div">
						<label>Enter New Password</label>
						<input type="text" name="newpassword" id="newpassword" value="" />
					</div>
					<div class="marginBetweenFields loginPageFormContents_Div">
						<label>Confirm New Password</label>
						<input type="text" name="confirmpassword" id="confirmpassword" value="" />
					</div>
					<div class="marginBetweenFields logicPageFormcontents_div">
                                 <input type="submit" name="submit" id="submit" value="Reset Password">
				</form>
			</div>
		</center>
	</body>
</html>