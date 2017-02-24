<%@include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Blood banking</title>
		<link rel="icon" type="image/png" href="resources/image/favicon.png">
		<link rel="stylesheet" type="text/css" href="resources/css/style.css" media="screen" /> 
		<!-- <script src="resources/js/jquery.paginate.js" type="text/javascript"></script> -->
	</head>
	<body>
		<div id="main-layout">
			<div id="container-box">
				<tiles:insertAttribute name="head" /><!-- header page -->
				<tiles:insertAttribute name="body" /><!-- page body -->
				<tiles:insertAttribute name="foot" /><!-- footer page -->
			</div>
		</div>
	</body>
</html>