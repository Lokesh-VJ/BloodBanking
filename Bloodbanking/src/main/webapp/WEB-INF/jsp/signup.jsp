 <%@include file="taglib.jsp"%>
<form method="post" action="processSignup.html" id="signupForm" name="signupForm">
	 <div class="marginBetweenFields text-center margin-center">
		<h4 class="loginPageHeadTitle">Registration Form</h4>
		<div class="columnLayoutContainer margin-center">
			 <div class="marginBetweenFields loginPageFormContents text-left margin-center columnLayoutContainerCol">
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Register as<span class="fieldMandatory">*</span></label> <br />
					<div class="formRadioContents"> 
						<c:forEach items="${userTypeList}" var="userType" varStatus="itr">
							<input type="radio" name="usertypeId" id="usertypeId_${userType.usertypeId}" value="${userType.usertypeId}" ${((empty baseDTO.usertypeId && itr.first) || baseDTO.usertypeId == userType.usertypeId)?'checked':''} required />
							<label for="usertypeId_${userType.usertypeId}">${userType.usertypeName}</label>
						</c:forEach>
					</div>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Name<span class="fieldMandatory">*</span></label>
					<input type="text" name="locationAddressDTO.name" id="locationAddressDTO.name" value="${baseDTO.locationAddressDTO.name}" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Contact Number<span class="fieldMandatory">*</span></label>
					<input type="text" name="locationAddressDTO.mobileNumber" id="locationAddressDTO.mobileNumber" value="${baseDTO.locationAddressDTO.mobileNumber}" required pattern="\d{10,11}" maxlength="11" />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Email Id<span class="fieldMandatory">*</span></label>
					 <input type="email" name="locationAddressDTO.emailId" id="locationAddressDTO.emailId" value="${baseDTO.locationAddressDTO.emailId}" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Gender<span class="fieldMandatory">*</span></label> <br />
					<div class="formRadioContents"> 
						<input type="radio" name="gender" id="gender_Male" value="Male" ${(empty baseDTO.gender || baseDTO.gender eq 'Male')?'checked':''} required />
						<label for="gender_Male">Male</label>
						<input type="radio" name="gender" id="gender_Female" value="Female" ${(baseDTO.gender eq 'Female')?'checked':''} required /> 
						<label for="gender_Female">Female</label> 
						<input type="radio" name="gender" id="gender_Other" value="Other" ${(baseDTO.gender eq 'Other')?'checked':''} required />
						<label for="gender_Other">Other</label>
					</div>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Date of Birth(DD-MM-YYYY)<span class="fieldMandatory">*</span></label>
					 <input type="text" name="birthDate" id="birthDate" value="${baseDTO.birthDate}" required pattern="\d{2}[\-]\d{2}[\-]\d{4}" maxlength="10" />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Blood Group<span class="fieldMandatory">*</span></label>
					<select name="bloodGroup" id="bloodGroup" required >
						<option value="">Select</option>
						<c:forEach items="${bloodGroupList}" var="bloodGroup">
							<option value="${bloodGroup.bloodGroupId}">${bloodGroup.bloodGroupName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<input type="submit" name="submit" id="submit" value="Register" />
				</div>
			</div>
			<div class="marginBetweenFields loginPageFormContents text-left margin-center columnLayoutContainerCol">
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">User Name<span class="fieldMandatory">*</span></label>
					 <input type="text" name="userName" id="userName" value="${baseDTO.userName}" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Password<span class="fieldMandatory">*</span></label> 
					<input type="password" name="password" id="password" value="" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Confirm Password<span class="fieldMandatory">*</span></label>
					 <input type="password" name="confirmPassword" id="confirmPassword" value="" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Security Question<span class="fieldMandatory">*</span></label> 
					<select name="securityQue" id="securityQue" required >
						<option value="">Select</option>
						<c:forEach items="${securityQuestionList}" var="securityQuestion">
							<option value="${securityQuestion.securityQuestionId}" ${(securityQuestion.securityQuestionId == baseDTO.securityQue)?'selected':''}>${securityQuestion.securityQuestion}</option>
						</c:forEach>
					</select>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Answer<span class="fieldMandatory">*</span></label> 
					<input type="text" name="answer" id="answer" value="${baseDTO.answer}" required />
				</div>
			</div>
			<div class="marginBetweenFields loginPageFormContents text-left margin-center columnLayoutContainerCol">
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Address<span class="fieldMandatory">*</span></label>
					 <input type="text" name="locationAddressDTO.address" id="locationAddressDTO.address" value="${baseDTO.locationAddressDTO.address}" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">City<span class="fieldMandatory">*</span></label> 
					<input type="text" name="locationAddressDTO.city" id="locationAddressDTO.city" value="${baseDTO.locationAddressDTO.city}" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">State<span class="fieldMandatory">*</span></label>
					 <input type="text" name="locationAddressDTO.state" id="locationAddressDTO.state" value="${baseDTO.locationAddressDTO.state}" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Pincode<span class="fieldMandatory">*</span></label>
					 <input type="text" name="locationAddressDTO.pincode" id="locationAddressDTO.pincode" value="${baseDTO.locationAddressDTO.pincode}" required />
				</div>
			</div>
		</div>
	</div>
</form>

<script>
	var password = document.getElementById("password");
	var confirmPassword = document.getElementById("confirmPassword");
	
	function validatePassword(){
		if(password.value != confirmPassword.value) {
			confirmPassword.setCustomValidity("Passwords Don't Match");
		} else {
			confirmPassword.setCustomValidity('');
		}
	}
	password.onchange = validatePassword;
	confirmPassword.onkeyup = validatePassword;
</script>