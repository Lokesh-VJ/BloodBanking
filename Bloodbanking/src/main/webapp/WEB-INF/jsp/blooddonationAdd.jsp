<%@include file="taglib.jsp"%>

<h2 class="loggedUserModuleTitle">Blood donation</h2>
<form method="post" action="processBloodDonation.html" id="moduleForm" name="moduleForm">
	 <div id="moduleDetailDivContainer" class="marginBetweenFields">
		<div class="columnLayoutContainer">
			 <div class="marginBetweenFields loginPageFormContents text-left margin-center columnLayoutContainerCol">
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Blood bank<span class="fieldMandatory">*</span></label> <br /> 
					<select name="bloodBankId" id="bloodBankId" required >
						<option value="">Select</option>
						<c:forEach items="${bloodBankList}" var="bloodBank">
							<option value="${bloodBank.registrationId}" ${(bloodBank.registrationId == baseDTO.bloodBankId)?'selected':''}>${bloodBank.locationAddressDTO.name}</option>
						</c:forEach>
					</select>
				</div>
			 	<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Blood unit(s)<span class="fieldMandatory">*</span></label> 
					<input type="text" name="bloodUnits" id="bloodUnits" value="${baseDTO.bloodUnits}" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<input type="submit" name="submit" id="submit" value="Submit" />
				</div>
			</div>
		</div>
	</div>
</form>