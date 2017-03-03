<%@include file="taglib.jsp"%>

<c:set var="showScriptMessageFlag" value="" />
<c:if test="${null ne baseDTO && baseDTO.requestFailed eq false && not empty baseDTO.responseMessage}">
	<c:set var="showScriptMessageFlag" value="1" />
	<div id="successMessageDiv" class="hidden">${baseDTO.responseMessage}</div>
</c:if>
<c:if test="${null ne baseDTO && baseDTO.requestFailed eq true && not empty baseDTO.responseMessage}">
	<c:set var="showScriptMessageFlag" value="1" />
	<div id="failureMessageDiv" class="hidden">${baseDTO.responseMessage}</div>
</c:if>

<c:if test="${not empty showScriptMessageFlag}">
	<script>
		document.addEventListener('DOMContentLoaded', function () {
	        if(document.getElementById("successMessageDiv") != null){
	        	alert(document.getElementById("successMessageDiv").innerHTML);
				document.getElementById("successMessageDiv").remove();
	        }
	        if(document.getElementById("failureMessageDiv") != null){
	        	alert(document.getElementById("failureMessageDiv").innerHTML);
				document.getElementById("failureMessageDiv").remove();
	        }
	    });
	</script>
</c:if>