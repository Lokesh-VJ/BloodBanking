package net.bloodbanking.dto;

public class BaseDTO {
	private String logginUserName;
	private boolean requestFailed;
	private String responseMessage;
	public String getLogginUserName() {
		return logginUserName;
	}
	public void setLogginUserName(String logginUserName) {
		this.logginUserName = logginUserName;
	}
	public boolean isRequestFailed() {
		return requestFailed;
	}
	public void setRequestFailed(boolean requestFailed) {
		this.requestFailed = requestFailed;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
