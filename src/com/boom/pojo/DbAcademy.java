package com.boom.pojo;

/**
 * 学院基本类
 * @author Administrator
 *
 */
public class DbAcademy {
	
	private Integer aid;
	
	private String aname;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	@Override
	public String toString() {
		return "DbAcademy [aid=" + aid + ", aname=" + aname + "]";
	}		
}
