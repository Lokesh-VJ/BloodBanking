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
							<input type="radio" name="usertypeId" id="usertypeId_${userType.usertypeId}" value="${userType.usertypeId}" ${((empty baseDTO.usertypeId && itr.first) || baseDTO.usertypeId == userType.usertypeId)?'checked':''} onchange="userTypeSignupOnchange()" required />
							<label for="usertypeId_${userType.usertypeId}">${userType.usertypeName}</label>
						</c:forEach>
					</div>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Name<span class="fieldMandatory">*</span></label>
					<input type="text" name="locationAddressDTO.name" id="locationAddressDTO.name" value="${baseDTO.locationAddressDTO.name}" maxlength="50" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Contact Number<span class="fieldMandatory">*</span></label>
					<input type="text" name="locationAddressDTO.mobileNumber" id="locationAddressDTO.mobileNumber" value="${baseDTO.locationAddressDTO.mobileNumber}" required pattern="\d{10,11}" maxlength="11" />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Email Id<span class="fieldMandatory">*</span></label>
					 <input type="email" name="locationAddressDTO.emailId" id="locationAddressDTO.emailId" value="${baseDTO.locationAddressDTO.emailId}" maxlength="50" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div nonBloodBankRegistrationFieldDiv">
					<label class="label_content">Gender<span class="fieldMandatory">*</span></label> <br />
					<div class="formRadioContents"> 
						<input type="radio" name="gender" id="gender_Male" value="Male" ${(empty baseDTO.gender || baseDTO.gender eq 'Male')?'checked':''} class="nonBloodBankRegistrationField" required />
						<label for="gender_Male">Male</label>
						<input type="radio" name="gender" id="gender_Female" value="Female" ${(baseDTO.gender eq 'Female')?'checked':''} class="nonBloodBankRegistrationField" required /> 
						<label for="gender_Female">Female</label> 
						<input type="radio" name="gender" id="gender_Other" value="Other" ${(baseDTO.gender eq 'Other')?'checked':''} class="nonBloodBankRegistrationField" required />
						<label for="gender_Other">Other</label>
					</div>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div nonBloodBankRegistrationFieldDiv">
					<label class="label_content">Date of Birth(DD-MM-YYYY)<span class="fieldMandatory">*</span></label>
					 <input type="text" name="birthDate" id="birthDate" value="${baseDTO.birthDate}" class="nonBloodBankRegistrationField" required pattern="\d{2}[\-]\d{2}[\-]\d{4}" maxlength="10" />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div nonBloodBankRegistrationFieldDiv">
					<label class="label_content">Blood Group<span class="fieldMandatory">*</span></label>
					<select name="bloodGroup" id="bloodGroup" class="nonBloodBankRegistrationField" required >
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
					 <input type="text" name="userName" id="userName" value="${baseDTO.userName}" maxlength="20" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Password<span class="fieldMandatory">*</span></label> 
					<input type="password" name="password" id="password" value="" maxlength="20" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Confirm Password<span class="fieldMandatory">*</span></label>
					 <input type="password" name="confirmPassword" id="confirmPassword" value="" maxlength="20" required />
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
					<input type="text" name="answer" id="answer" value="${baseDTO.answer}" maxlength="50" required />
				</div>
			</div>
			<div class="marginBetweenFields loginPageFormContents text-left margin-center columnLayoutContainerCol">
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Address<span class="fieldMandatory">*</span></label>
					 <textarea name="locationAddressDTO.address" id="locationAddressDTO.address" maxlength="250" required >${baseDTO.locationAddressDTO.address}</textarea>
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">City<span class="fieldMandatory">*</span></label> 
					<input type="text" name="locationAddressDTO.city" id="locationAddressDTO.city" value="${baseDTO.locationAddressDTO.city}" maxlength="50" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">State<span class="fieldMandatory">*</span></label>
					 <input type="text" name="locationAddressDTO.state" id="locationAddressDTO.state" value="${baseDTO.locationAddressDTO.state}" maxlength="50" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Pincode<span class="fieldMandatory">*</span></label>
					 <input type="text" name="locationAddressDTO.pincode" id="locationAddressDTO.pincode" value="${baseDTO.locationAddressDTO.pincode}" maxlength="10" required />
				</div>
			</div>
		</div>
	</div>
</form>