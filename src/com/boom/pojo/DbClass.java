package com.boom.pojo;

/**
 * 班级基本类
 * @author Administrator
 *
 */
public class DbClass {
	
	private Integer cid;
	
	private String cname;
	
	private Integer aid;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@Override
	public String toString() {
		return "DbClass [cid=" + cid + ", cname=" + cname + ", aid=" + aid
				+ "]";
	}	
}
