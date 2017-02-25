package net.bloodbanking.dto;

public class BaseDTO {
	private String logginUserName;
	private boolean isRequestFailed;
	private String responseMessage;
	public String getLogginUserName() {
		return logginUserName;
	}
	public void setLogginUserName(String logginUserName) {
		this.logginUserName = logginUserName;
	}
	public boolean isRequestFailed() {
		return isRequestFailed;
	}
	public void setRequestFailed(boolean isRequestFailed) {
		this.isRequestFailed = isRequestFailed;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}	
}
