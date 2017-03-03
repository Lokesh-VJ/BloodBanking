<%@include file="taglib.jsp"%>

<h2 class="loggedUserModuleTitle">Update profile information</h2>

<form method="post" action="processEditProfile.html" id="moduleForm" name="moduleForm">
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
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Date of Birth<span class="colorSeparator">:</span></label>
					<span class="elementData"><c:out value="${baseDTO.birthDate}" /></span>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Blood Group<span class="colorSeparator">:</span></label>
					<span class="elementData"><c:out value="${baseDTO.bloodGroupName}" /></span>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<input type="submit" name="submit" id="submit" value="Update" />
				</div>
			</div>
			<div class="marginBetweenFields loginPageFormContents text-left margin-center columnLayoutContainerCol">
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Name<span class="colorSeparator">:</span></label>
					<input type="text" name="locationAddressDTO.name" id="locationAddressDTO.name" value="${baseDTO.locationAddressDTO.name}" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Contact Number<span class="colorSeparator">:</span></label>
					<input type="text" name="locationAddressDTO.mobileNumber" id="locationAddressDTO.mobileNumber" value="${baseDTO.locationAddressDTO.mobileNumber}" required pattern="\d{10,11}" maxlength="11" />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Email Id<span class="colorSeparator">:</span></label>
					<input type="email" name="locationAddressDTO.emailId" id="locationAddressDTO.emailId" value="${baseDTO.locationAddressDTO.emailId}" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Address<span class="colorSeparator">:</span></label>
					<input type="text" name="locationAddressDTO.address" id="locationAddressDTO.address" value="${baseDTO.locationAddressDTO.address}" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">City<span class="colorSeparator">:</span></label>
					<input type="text" name="locationAddressDTO.city" id="locationAddressDTO.city" value="${baseDTO.locationAddressDTO.city}" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">State<span class="colorSeparator">:</span></label>
					<input type="text" name="locationAddressDTO.state" id="locationAddressDTO.state" value="${baseDTO.locationAddressDTO.state}" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Pincode<span class="colorSeparator">:</span></label>
					<input type="text" name="locationAddressDTO.pincode" id="locationAddressDTO.pincode" value="${baseDTO.locationAddressDTO.pincode}" required />
				</div>
			</div>
		</div>
	</div>
</form>