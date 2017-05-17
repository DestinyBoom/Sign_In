package com.boom.pojo;

/**
 * 签到基本类
 * @author Administrator
 *
 */
public class DbInSign {
	
	private Integer iid;
	
	private String imonth;
	
	private Integer aid;
	
	private Integer cid;
	
	private Integer sid;
	
	private Integer state;
	
	@Override
	public String toString() {
		return "DbInSign [iid=" + iid + ", imonth=" + imonth + ", aid=" + aid
				+ ", cid=" + cid + ", sid=" + sid + ", tid=" + tid
				+ ", ishouldSign=" + ishouldSign + ", irealitySign="
				+ irealitySign + ", ileaveDaysSign=" + ileaveDaysSign + "]";
	}

	private Integer tid;
	
	private Integer ishouldSign;
	
	private Integer irealitySign;
	
	private Integer ileaveDaysSign;

	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public String getImonth() {
		return imonth;
	}

	public void setImonth(String imonth) {
		this.imonth = imonth;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getIshouldSign() {
		return ishouldSign;
	}

	public void setIshouldSign(Integer ishouldSign) {
		this.ishouldSign = ishouldSign;
	}

	public Integer getIrealitySign() {
		return irealitySign;
	}

	public void setIrealitySign(Integer irealitySign) {
		this.irealitySign = irealitySign;
	}

	public Integer getIleaveDaysSign() {
		return ileaveDaysSign;
	}

	public void setIleaveDaysSign(Integer ileaveDaysSign) {
		this.ileaveDaysSign = ileaveDaysSign;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
