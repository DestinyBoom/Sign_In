package com.boom.pojo;

import java.util.List;



public class DbInSignCustomer extends DbInSign{
	
	
	
	@Override
	public String toString() {
		return "DbInSignCustomer [day=" + day + ", dbDay=" + dbDay
				+ ", dbAcademy=" + dbAcademy + ", dbClass=" + dbClass
				+ ", dbTeacher=" + dbTeacher + "]";
	}

	private DbDay day;
	
	private List<DbDay> dbDay;
	
	public List<DbDay> getDbDay() {
		return dbDay;
	}

	public void setDbDay(List<DbDay> dbDay) {
		this.dbDay = dbDay;
	}

	private DbAcademy dbAcademy;
	
	private DbClass dbClass;
	
	private DbTeacher dbTeacher;
	
	

	public DbAcademy getDbAcademy() {
		return dbAcademy;
	}

	public void setDbAcademy(DbAcademy dbAcademy) {
		this.dbAcademy = dbAcademy;
	}

	public DbClass getDbClass() {
		return dbClass;
	}

	public void setDbClass(DbClass dbClass) {
		this.dbClass = dbClass;
	}

	public DbTeacher getDbTeacher() {
		return dbTeacher;
	}

	public void setDbTeacher(DbTeacher dbTeacher) {
		this.dbTeacher = dbTeacher;
	}

	public DbDay getDay() {
		return day;
	}

	public void setDay(DbDay day) {
		this.day = day;
	}
	
	
}
