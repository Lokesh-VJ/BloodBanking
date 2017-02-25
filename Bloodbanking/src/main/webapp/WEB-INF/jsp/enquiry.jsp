<%@include file="taglib.jsp"%>

<div class="marginBetweenFields loginPageFormContents text-left margin-center">
	<h4 class="loginPageHeadTitle text-center">Enquiry form</h4>
	<form method="post" action="processEnquiry.html" id="enquiryForm" name="enquiryForm">
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Name<span class="fieldMandatory">*</span></label>
			<input type="text" name="locationAddressDTO.name" id="locationAddressDTO_name" value="${enquiryFormDTO.locationAddressDTO.name}" required />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Email<span class="fieldMandatory">*</span></label>
			<input type="email" name="locationAddressDTO.emailId" id="locationAddressDTO_emailId" value="${enquiryFormDTO.locationAddressDTO.emailId}" maxlength="50" required />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Contact no.<span class="fieldMandatory">*</span></label>
			<input type="text" name="locationAddressDTO.mobileNumber" id="locationAddressDTO_mobileNumber" value="${enquiryFormDTO.locationAddressDTO.mobileNumber}" minlength="10" maxlength="11" required />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Message<span class="fieldMandatory">*</span></label>
			<textarea name="message" id="message" required >${enquiryFormDTO.message}</textarea>
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<input type="submit" name="submit" id="submit" value="Send" />
		</div>
	</form>
</div>