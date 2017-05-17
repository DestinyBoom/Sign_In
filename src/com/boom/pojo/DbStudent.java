package com.boom.pojo;

/**
 * 学生基本类
 * @author Administrator
 *
 */
public class DbStudent {
	
	private Integer sid;
	
	private String sname;
	
	private String snumber;
	
	private String spass;
	
	private String ssex;
	
	private Integer sage;
	
	private String sdate;
	
	private Integer cid;
	
	private Integer aid;
	
	private Integer isSchool;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSnumber() {
		return snumber;
	}

	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}

	public String getSpass() {
		return spass;
	}

	public void setSpass(String spass) {
		this.spass = spass;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getIsSchool() {
		return isSchool;
	}

	public void setIsSchool(Integer isSchool) {
		this.isSchool = isSchool;
	}

	@Override
	public String toString() {
		return "DbStudent [sid=" + sid + ", sname=" + sname + ", snumber="
				+ snumber + ", spass=" + spass + ", ssex=" + ssex + ", sage="
				+ sage + ", sdate=" + sdate + ", cid=" + cid + ", aid=" + aid
				+ ", isSchool=" + isSchool + "]";
	}
	
}
