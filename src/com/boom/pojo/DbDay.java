package com.boom.pojo;


/**
 * 签到日期基本类
 * @author Administrator
 *
 */
public class DbDay {
	
	private Integer did;
	
	private String dname;
	
	private String imonth;
	
	private Integer sid;
	
	private Integer tid;
	
	private Integer status;
	
	private Integer iid;
	
	private String dtime;
	
	@Override
	public String toString() {
		return "DbDay [did=" + did + ", dname=" + dname + ", imonth=" + imonth
				+ ", sid=" + sid + ", tid=" + tid + ", status=" + status
				+ ", iid=" + iid + "]";
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getImonth() {
		return imonth;
	}

	public void setImonth(String imonth) {
		this.imonth = imonth;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
}
