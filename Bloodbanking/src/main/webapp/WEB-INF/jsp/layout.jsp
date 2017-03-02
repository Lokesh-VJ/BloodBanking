<%@include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Blood banking</title>
		<link rel="icon" type="image/png" href="resources/image/favicon.png">
		<link rel="stylesheet" type="text/css" href="resources/css/style.css" media="screen" /> 
		<c:if test="${not empty sessionScope.userName}">
			<script src="resources/js/script.js" type="text/javascript"></script>
		</c:if>
	</head>
	<body>
		<div id="main-layout">
			<div id="container-box">
				<tiles:insertAttribute name="head" /><!-- header page -->
				<tiles:insertAttribute name="body" /><!-- page body -->
				<tiles:insertAttribute name="foot" /><!-- footer page -->
			</div>
		</div>
		<%@include file="messages.jsp"%>
	</body>
</html>