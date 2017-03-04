<%@include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Blood banking</title>
		<link rel="icon" type="image/png" href="resources/image/favicon.png">
		<link rel="stylesheet" type="text/css" href="resources/css/style.css" media="screen" /> 
		<c:if test="${not empty sessionScope.userName}">
			<script src="resources/js/jquery.min.js" type="text/javascript"></script>
			<script src="resources/js/jquery.form.min.js" type="text/javascript"></script>
			<script src="resources/js/jquery.blockUI.js" type="text/javascript"></script>
			<script src="resources/js/script.js" type="text/javascript"></script>
		</c:if>
	</head>
	<body>
		<%@include file="messages.jsp"%>
		<div id="main-layout">
			<div id="container-box">
				<tiles:insertAttribute name="head" /><!-- header page -->
				<div ${not empty sessionScope.userName ? 'id="loggedInUserDisplayContainer"':''}>
					<tiles:insertAttribute name="body" /><!-- page body -->
				</div>
				<tiles:insertAttribute name="foot" /><!-- footer page -->
			</div>
		</div>
		<c:if test="${not empty sessionScope.userName}">
			<div id="blockUIContainer" style="display: none;">
				<div class="blockUI" style="display:none"></div>
				<div class="blockUI blockOverlay"></div>
				<div class="blockUI blockMsg blockPage"><h1>Please wait...</h1></div>
			</div>
		</c:if>
	</body>
</html>