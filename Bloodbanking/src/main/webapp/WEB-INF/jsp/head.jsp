<%@include file="taglib.jsp"%>

<!-- Header contents -->
<div id="applicationHeaderSection" class="text-center">
	<h2 class="appTitle ${(not empty sessionScope.userName)?'text-left': ''}">Blood Banking</h2>
	<c:if test="${empty sessionScope.userName}">
		<h3 class="appHelptext">Online Blood Bank Management Software</h3>
	</c:if>
</div>

<!-- show non-login menu... -->
<c:if test="${empty sessionScope.userName}">
	<ul id="nonLoggedInUserNavigationBar">
		<li><a class="${loginPageActive}" href="login.html">Login</a></li>
		<li><a class="${signupPageActive}" href="signup.html">Signup</a></li>
		<li><a class="${enquiryPageActive}" href="enquiry.html">Enquiry</a></li>
		<li><a class="${feedbackPageActive}" href="feedback.html">Feedback</a></li>
	</ul>
</c:if>
<!-- show login menu... -->
<c:if test="${not empty sessionScope.userName}">
	<ul id="loggedInUserNavigationBar">
		<li><a class="active" href="#home">Home</a></li>
		<li><a href="#news">News</a></li>
		<li><a href="#contact">Contact</a></li>
		<li><a href="#about">About</a></li>
	</ul>
</c:if>