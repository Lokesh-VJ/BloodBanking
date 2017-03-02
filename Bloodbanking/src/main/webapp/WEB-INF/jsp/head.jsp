<%@include file="taglib.jsp"%>

<!-- Header contents -->
<div id="applicationHeaderSection" class="text-center ${(not empty sessionScope.userName)?'applicationHeaderSectionClass': ''}">
	<div id="applicationHeaderSectionAppName" class="${(not empty sessionScope.userName)?'applicationHeaderSectionAppNameClass': ''}">
		<h2 class="appTitle ${(not empty sessionScope.userName)?'text-left appTitleMargin': ''}">Blood Banking</h2>
		<c:if test="${empty sessionScope.userName}">
			<h3 class="appHelptext">Online Blood Bank Management Software</h3>
		</c:if>
	</div>
	<c:if test="${not empty sessionScope.userName}">
		<div id="headerAdditionalDetails" class="text-right">
			<h4 class="loggedUserDetailClass">Hi, <c:out value="${sessionScope.userName}" />(<c:out value="${sessionScope.userTypeName}" />)</h4>
			<a class="logoutLinkClass" href="javascript:logout()">LOGOUT</a>
		</div>
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
		<c:set var="ctr" value="0" />
		<c:forEach items="${sessionScope.userPrivileges}" var="item">
			<c:if test="${item.subMenuName eq subMenuView}">
				<li><span class="loggedInUserNavigationBarItem ${(ctr == 0)?'active':''}" onclick="loadModuleViewAjaxPage(this, '${item.leftMenuName}')"><c:out value="${item.leftMenuDescription}" /></span></li>
				<c:set var="ctr" value="${ctr+1}" />
			</c:if>
		</c:forEach>
	</ul>
</c:if>