package net.bloodbanking.dto;

public class BaseDTO {
	private String logginUserName;
	private boolean requestFailed;
	private String responseMessage;
	private Integer totalSize;
	private Integer pageNumber;
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
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public Integer getPageNumber() {
		if(null == pageNumber) return 1;
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getQueryPageNumber() {
		if(null == pageNumber) return 0;
		return pageNumber - 1;
	}
}
