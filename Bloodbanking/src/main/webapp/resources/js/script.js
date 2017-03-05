function logout(){
	if(confirm("Do you want to logout?")){
		blockAppUI();
		window.location.href = logoutLink();
	}
}
function logoutLink(){
	return "logout.html";
}
function blockAppUI(){
	document.getElementById("blockUIContainer").style.display = "block";
}
function setPageNumber(pageNumber){
	document.getElementById("pageNumber").value = pageNumber;
	document.getElementById("moduleForm").submit();
}
function doModuleAction(url, pKId, pKValue){
	document.getElementById("additionalModuleForm").setAttribute("action", url);
	if(document.getElementById(pKId) != null){
		document.getElementById(pKId).value = pKValue;
	}
	document.getElementById("additionalModuleForm").submit();
}
function doModuleActionWithConfirmation(url, confirmMessage, pKId, pKValue){
	if(confirm(confirmMessage)){
		document.getElementById("additionalModuleForm").setAttribute("action", url);
		if(document.getElementById(pKId) != null){
			document.getElementById(pKId).value = pKValue;
		}
		document.getElementById("additionalModuleForm").submit();
	}
}
function goBackModuleFormFunc(url, pKName, pKValue){
	document.getElementById("goBackModuleForm").setAttribute("action", url);
	if(document.getElementById("goBackParam") != null){
		document.getElementById("goBackParam").setAttribute("name", pKName);
		document.getElementById("goBackParam").value = pKValue;
	}
	document.getElementById("goBackModuleForm").submit();
}
function onPageLoadFunction(){
	// messages section...
    if(document.getElementById("successMessageDiv") != null){
    	alert(document.getElementById("successMessageDiv").innerHTML);
		document.getElementById("successMessageDiv").remove();
    }
    if(document.getElementById("failureMessageDiv") != null){
    	alert(document.getElementById("failureMessageDiv").innerHTML);
		document.getElementById("failureMessageDiv").remove();
    }
    // module form on submit... 
    if(document.getElementById("moduleForm") != null){
    	document.getElementById("moduleForm").onsubmit = function(){
    		if(document.getElementById("moduleForm").checkValidity()){
    			blockAppUI();
    			return true;
    		}
    	};
    }
    
    // password mismatch validation
    if(document.getElementById("password") != null && document.getElementById("confirmPassword") != null){
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
    }
}
document.addEventListener( "DOMContentLoaded", onPageLoadFunction, false );