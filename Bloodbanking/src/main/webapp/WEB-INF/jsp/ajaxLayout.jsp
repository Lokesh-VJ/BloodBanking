<%@include file="taglib.jsp"%>

<c:if test="${not empty sessionScope.userName}">
	<input type="hidden" id="sessionTimeoutCheckFlag" value="1" />
</c:if>

<!-- page body start-->
	<tiles:insertAttribute name="body" />
<!-- page body end-->

<%@include file="messages.jsp"%>
