<%@include file="taglib.jsp"%>

<h2 class="loggedUserModuleTitle">Change password</h2>

<form method="post" action="processChangePassword.html" id="moduleForm" name="moduleForm">
	 <div id="moduleDetailDivContainer" class="marginBetweenFields">
		<div class="columnLayoutContainer">
			 <div class="marginBetweenFields loginPageFormContents text-left margin-center columnLayoutContainerCol">
			 	<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Password<span class="fieldMandatory">*</span></label> 
					<input type="password" name="password" id="password" value="" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<label class="label_content">Confirm Password<span class="fieldMandatory">*</span></label>
					 <input type="password" name="confirmPassword" id="confirmPassword" value="" required />
				</div>
				<div class="marginBetweenFields loginPageFormContents_Div">
					<input type="submit" name="submit" id="submit" value="Update" />
				</div>
			</div>
		</div>
	</div>
</form>