package com.boom.pojo;

import javax.persistence.criteria.CriteriaBuilder.In;

/**
 * 教师基本类
 * @author Administrator
 *
 */
public class DbTeacher {
	
	@Override
	public String toString() {
		return "DbTeacher [tid=" + tid + ", tname=" + tname + ", tnumber="
				+ tnumber + ", tpass=" + tpass + ", tuuid=" + tuuid + ", tsex="
				+ tsex + ", tage=" + tage + ", aid=" + aid + "]";
	}

	private Integer tid;
	
	private String tname;
	
	private String tnumber;
	
	private String tpass;
	
	private String tuuid;
	
	private String tsex;
	
	private Integer tage;
	
	private Integer aid;
	
	private Boolean isUnbundling;
	
	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTnumber() {
		return tnumber;
	}

	public void setTnumber(String tnumber) {
		this.tnumber = tnumber;
	}

	public String getTpass() {
		return tpass;
	}

	public void setTpass(String tpass) {
		this.tpass = tpass;
	}

	public String getTuuid() {
		return tuuid;
	}

	public void setTuuid(String tuuid) {
		this.tuuid = tuuid;
	}

	public String getTsex() {
		return tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex;
	}

	public Integer getTage() {
		return tage;
	}

	public void setTage(Integer tage) {
		this.tage = tage;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Boolean getIsUnbundling() {
		return isUnbundling;
	}

	public void setIsUnbundling(Boolean isUnbundling) {
		this.isUnbundling = isUnbundling;
	}

	
	
}
