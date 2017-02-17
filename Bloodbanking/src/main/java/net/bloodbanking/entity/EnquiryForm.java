package net.bloodbanking.entity;

import java.util.Date;

public class EnquiryForm implements java.io.Serializable {

	private static final long serialVersionUID = -6341590577705695023L;
	private long inqId;
	private StatusMst statusMst;
	private String message;
	private Date createdDate;

	public EnquiryForm() {
	}

	public EnquiryForm(long inqId, StatusMst statusMst, String message, Date createdDate) {
		this.inqId = inqId;
		this.statusMst = statusMst;
		this.message = message;
		this.createdDate = createdDate;
	}

	public long getInqId() {
		return this.inqId;
	}

	public void setInqId(long inqId) {
		this.inqId = inqId;
	}

	public StatusMst getStatusMst() {
		return this.statusMst;
	}

	public void setStatusMst(StatusMst statusMst) {
		this.statusMst = statusMst;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
