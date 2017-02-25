<div class="marginBetweenFields loginPageFormContents">
	<h4 class="loginPageHeadTitle">Registration Form</h4>
	<form method="post" action="doLoginCheck.htm" id="loginForm"
		name="loginForm">
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Register as</label> <br>
			<input type="radio" name"usertypeId" id="usertypeId" value="2" checked />Bloodbank<br>
			<input type="radio" name"usertypeId" id="usertypeId" value="3" />Donor<br>
			<input type="radio" name"usertypeId" id="usertypeId" value="4" />Patient
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Name:<span class="fieldMandatory">*</span></label>
			 <input type="text" name="locationAddressDTO.name" id="locationAddressDTO.name"
				value="${registrationDTO.locationAddressDTO.name}" required />

		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Contact NO<span class="fieldMandatory">*</span></label>
			 <input type="text" name="locationAddressDTO.mobileNumber"
				id="locationAddressDTO.mobileNumber" value="" />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Address:<span class="fieldMandatory">*</span></label>
			 <input type="text" name="locationAddressDTO.address"
				id="locationAddressDTO.address" value="" />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>City:<span class="fieldMandatory">*</span></label> 
			<input type="text" name="locationAddressDTO.city" id="locationAddressDTO.city"
				value="" />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>State:<span class="fieldMandatory">*</span></label>
			 <input type="text" name="locationAddressDTO.state" id="locationAddressDTO.state"
				value="" />
		</div>
		
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Email ID:<span class="fieldMandatory">*</span></label>
			 <input type="text" name="locationAddressDTO.emailId" id="locationAddressDTO.emailId" value="" />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Gender:<span class="fieldMandatory">*</span></label> <br>
			<input type="radio" name="gender" value="male" checked>
			Male<br> <input type="radio" name="gender" id="gender"
				value="female"> Female<br> <input type="radio"
				name="gender" id="gender" value="other"> Other
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Blood Type::<span class="fieldMandatory">*</span></label>
			 <input type="text" name="locationAddressDTO.bloodtype"
				id="locationAddressDTO.bloodtype" value="" />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>User Name<span class="fieldMandatory">*</span></label>
			 <input type="text" name="locationAddressDTO.username"
				id="locationAddressDTO.username" value="" />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Password<span class="fieldMandatory">*</span></label> 
			<input type="password" name="locationAddressDTO.password"
				id="locationAddressDTO.password" value="" />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Confirm Password<span class="fieldMandatory">*</span></label>
			 <input type="password"
				name="locationAddressDTO.password" id="locationAddressDTO.password" value="" />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Security Question<span class="fieldMandatory">*</span></label> 
			<input type="text"
				name="locationAddressDTO.securityquestion" id="locationAddressDTO.securityquestion" value="" />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Answer<span class="fieldMandatory">*</span></label> 
			<input type="text" name="locationAddressDTO.Answer" id="locationAddressDTO.Answer"
				value="" />
		</div>


		<div class="marginBetweenFields loginPageFormContents_Div">
			<input type="submit" name="locationAddressDTO.submit" id="locationAddressDTO.submit" value="Regester" />
		</div>
	</form>
</div>