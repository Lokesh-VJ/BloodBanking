function logout(){
	if(confirm("Do you want to logout?")){
		blockAppUI(true);
		window.location.href = logoutLink();
	}
}
function logoutLink(){
	return "logout.html";
}
function blockAppUI(flag){
	if(flag){
		// TODO, block ui...
	} else {
		// TODO, unblock ui...
	}
}
function getChildElementFromParent(parentId, childId){
	if(null == document.getElementById(parentId) || document.getElementById(parentId).children.length == 0){
		return null;
	}
	var childElement = null;
	for(var i = 0; i < document.getElementById("loggedInUserDisplayContainerAjaxDiv").children.length; i++){
		var elem = document.getElementById("loggedInUserDisplayContainerAjaxDiv").children[i];
		if(elem.getAttribute("id") == childId){
			childElement = elem;		
		}
	}
	return childElement;
}
function makeAjaxCall(url, postData, type, destElement, callback) {
	blockAppUI(true);
	var xhttp;
	if (window.XMLHttpRequest) {
		xhttp = new XMLHttpRequest();
	} else {
		xhttp = new ActiveXObject("Microsoft.XMLHTTP"); // code for IE6, IE5
	}
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4) {
			if(this.status == 200){
				document.getElementById("loggedInUserDisplayContainerAjaxDiv").innerHTML = this.responseText;
				if(null == getChildElementFromParent("loggedInUserDisplayContainerAjaxDiv", "sessionTimeoutCheckFlag")){
					alert("Session timeout");
					window.location.href = logoutLink();
				}
				document.getElementById(destElement).innerHTML = document.getElementById("loggedInUserDisplayContainerAjaxDiv").innerHTML;
				document.getElementById("loggedInUserDisplayContainerAjaxDiv").innerHTML = "";
				if(typeof callback === "function"){
					callback();
				}
				blockAppUI();
			} else {
				alert("Server responded with error");
				window.location.href = logoutLink();
			}
		}
	};
	xhttp.open(type, url);
	xhttp.send(postData);
}
function loadModuleViewAjaxPage(curLink, menuName){
	if(!/\bactive\b/.test(curLink.className)){
		for(var i = 0; i < document.getElementsByClassName("loggedInUserNavigationBarItem").length; i++){
			if(/\bactive\b/.test(document.getElementsByClassName("loggedInUserNavigationBarItem")[i].className)){
				document.getElementsByClassName("loggedInUserNavigationBarItem")[i].classList.remove("active");
			}
		}
		curLink.classList.add("active");
		makeAjaxCall("view"+menuName+".html", null, "POST", "loggedInUserDisplayContainer", loadModuleViewAjaxPageCallback);
	}
}
function loadModuleViewAjaxPageCallback() {
	
}