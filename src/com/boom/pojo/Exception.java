package com.boom.pojo;

public class Exception {
	
	private Integer eid;
	
	private String date;
	
	private String text;
	
	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Exception [eid=" + eid + ", date=" + date + ", text=" + text
				+ "]";
	}
	
}
