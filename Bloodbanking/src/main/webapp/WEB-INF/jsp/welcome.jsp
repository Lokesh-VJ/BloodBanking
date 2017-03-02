<%@include file="taglib.jsp"%>

<c:if test="${empty ajaxContentFlag}">
	<div id="loggedInUserDisplayContainer">
</c:if>
<div id="welcomePageContents">
	
</div>
<c:if test="${empty ajaxContentFlag}">		
	</div>
	<div id="loggedInUserDisplayContainerAjaxDiv" class="hidden"></div>
</c:if>
