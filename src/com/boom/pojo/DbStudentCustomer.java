package com.boom.pojo;

public class DbStudentCustomer extends DbStudent{
	
	private DbAcademy dbAcademy;
	
	private DbClass dbClass;

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
	
	@Override
	public String toString() {
		return "DbStudentCustomer [dbAcademy=" + dbAcademy + ", dbClass="
				+ dbClass + "]";
	}		
}
