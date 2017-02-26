<%@include file="taglib.jsp"%>

<script>
	document.addEventListener('DOMContentLoaded', function () {
        if(document.getElementById("successMessageDiv") != null){
        	alert(document.getElementById("successMessageDiv").innerHTML);
        }
        if(document.getElementById("failureMessageDiv") != null){
        	alert(document.getElementById("failureMessageDiv").innerHTML);
        }
    });
</script>

<c:if test="${null ne baseDTO && baseDTO.requestFailed eq false && not empty baseDTO.responseMessage}">
	<div id="successMessageDiv" class="hidden">${baseDTO.responseMessage}</div>
</c:if>
<c:if test="${null ne baseDTO && baseDTO.requestFailed eq true && not empty baseDTO.responseMessage}">
	<div id="failureMessageDiv" class="hidden">${baseDTO.responseMessage}</div>
</c:if>