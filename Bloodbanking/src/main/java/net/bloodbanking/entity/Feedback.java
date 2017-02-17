package net.bloodbanking.entity;

public class Feedback implements java.io.Serializable {

	private static final long serialVersionUID = -3995873444383150305L;
	private long fid;
	private String feedback;

	public Feedback() {
	}

	public Feedback(long fid, String feedback) {
		this.fid = fid;
		this.feedback = feedback;
	}

	public long getFid() {
		return this.fid;
	}

	public void setFid(long fid) {
		this.fid = fid;
	}

	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}
