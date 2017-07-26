package org.as.hbsamples.vo;

import java.io.Serializable;

public class Department implements Serializable{
	private int deptNo;

	private String deptName;

	private String deptLoc;

	public Department(int deptNo, String deptName, String deptLoc) {
		super();
		// TODO Auto-generated constructor stub
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}
	
	public Department() {
	}
	public Department(String deptName, String deptLoc) {
		super();
		// TODO Auto-generated constructor stub
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}

	public String getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
}
