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
document.addEventListener('DOMContentLoaded', function () {
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
});