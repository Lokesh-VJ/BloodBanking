<%@include file="taglib.jsp"%>

<!-- Header contents -->
<div id="applicationHeaderSection" class="text-center">
	<h2 class="appTitle">Blood Banking</h2>
	<h3 class="appHelptext">Online Blood Bank Management Software</h3>
</div>

<!-- show non-login menu... -->
<c:if test="${empty sessionScope.loginUserInfo}">
	<ul id="nonLoggedInUserNavigationBar">
		<li><a class="${loginPageActive}" href="login.html">Login</a></li>
		<li><a class="${signupPageActive}" href="signup.html">Signup</a></li>
		<li><a class="${enquiryPageActive}" href="enquiry.html">Enquiry</a></li>
		<li><a class="${feedbackPageActive}" href="feedback.html">Feedback</a></li>
	</ul>
</c:if>
