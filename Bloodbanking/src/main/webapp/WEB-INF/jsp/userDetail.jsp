<%@include file="taglib.jsp"%>

<h2 class="loggedUserModuleTitle">User information</h2>
<form method="post" id="moduleForm" name="moduleForm">
	 <div id="moduleDetailDivContainer" class="marginBetweenFields">
		<div class="columnLayoutContainer">
			 <div class="marginBetweenFields loginPageFormContents text-left margin-center columnLayoutContainerCol">
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Registered as<span class="colorSeparator">:</span></label>
					<span class="elementData"><c:out value="${baseDTO.usertypeName}" /></span>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">User Name<span class="colorSeparator">:</span></label>
					<span class="elementData"><c:out value="${baseDTO.userName}" /></span>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Gender<span class="colorSeparator">:</span></label>
					<span class="elementData"><c:out value="${baseDTO.gender}" /></span>
				</div><div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Date of Birth<span class="colorSeparator">:</span></label>
					<span class="elementData"><c:out value="${baseDTO.birthDate}" /></span>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Blood Group<span class="colorSeparator">:</span></label>
					<span class="elementData"><c:out value="${baseDTO.bloodGroupName}" /></span>
				</div>
				<br /><br /><br />
				<div class="marginBetweenFields loginPageFormContents_Div">
					<input type="button" name="backBtn" id="backBtn" value="Back" onclick="goBackModuleFormFunc('viewUser.html')" />
				</div>
			</div>
			<div class="marginBetweenFields loginPageFormContents text-left margin-center columnLayoutContainerCol">
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Name<span class="colorSeparator">:</span></label>
					<span class="elementData"><c:out value="${baseDTO.locationAddressDTO.name}" /></span>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Contact Number<span class="colorSeparator">:</span></label>
					<span class="elementData"><c:out value="${baseDTO.locationAddressDTO.mobileNumber}" /></span>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Email Id<span class="colorSeparator">:</span></label>
					 <span class="elementData"><c:out value="${baseDTO.locationAddressDTO.emailId}" /></span>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Address<span class="colorSeparator">:</span></label>
					<span class="elementData"><c:out value="${baseDTO.locationAddressDTO.address}" /></span>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">City<span class="colorSeparator">:</span></label>
					<span class="elementData"><c:out value="${baseDTO.locationAddressDTO.city}" /></span>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">State<span class="colorSeparator">:</span></label>
					<span class="elementData"><c:out value="${baseDTO.locationAddressDTO.state}" /></span>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Pincode<span class="colorSeparator">:</span></label>
					<span class="elementData"><c:out value="${baseDTO.locationAddressDTO.pincode}" /></span>
				</div>
			</div>
		</div>
	</div>
</form>
<form method="post" id="goBackModuleForm" name="goBackModuleForm">
	<input type="hidden" id="goBackParam" />
</form>