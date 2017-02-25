<%@include file="taglib.jsp"%>

<div class="marginBetweenFields loginPageFormContents text-left margin-center">
	<h4 class="loginPageHeadTitle text-center">Feedback form</h4>
	<form method="post" action="processFeedback.html" id="feedbackForm" name="feedbackForm">
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Name<span class="fieldMandatory">*</span></label>
			<input type="text" name="locationAddressDTO.name" id="locationAddressDTO_name" value="${feedbackDTO.locationAddressDTO.name}" required />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Email<span class="fieldMandatory">*</span></label>
			<input type="email" name="locationAddressDTO.emailId" id="locationAddressDTO_emailId" value="${feedbackDTO.locationAddressDTO.emailId}" maxlength="50" required />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Feedback<span class="fieldMandatory">*</span></label>
			<textarea name="feedback" id="feedback" required >${feedbackDTO.feedback}</textarea>
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<input type="submit" name="submit" id="submit" value="Send" />
		</div>
	</form>
</div>