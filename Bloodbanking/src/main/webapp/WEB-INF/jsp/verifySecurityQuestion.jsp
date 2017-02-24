<%@include file="taglib.jsp"%>

<div class="marginBetweenFields loginPageFormContents text-left margin-center">
	<h4 class="loginPageHeadTitle text-center">Forgot password</h4>
	<form method="post" action="verifySecurityQuestion.html" id="verifySecurityQuestionForm" name="verifySecurityQuestionForm">
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Username<span class="fieldMandatory">*</span></label>
			<input type="text" name="userName" id="userName" value="" required />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Security Question<span class="fieldMandatory">*</span></label>
			<select name="securityQue" id="securityQue" required >
				<option value="">Select</option>
				<c:forEach items="${securityQuestionList}" var="securityQuestion">
					<option value="${securityQuestion.securityQuestionId}">${securityQuestion.securityQuestion}</option>
				</c:forEach>
			</select>
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<label>Answer<span class="fieldMandatory">*</span></label>
			<input type="text" name="answer" id="answer" value="" required />
		</div>
		<div class="marginBetweenFields loginPageFormContents_Div">
			<input type="submit" name="submit" id="submit" value="Verify" />
		</div>
	</form>
</div>