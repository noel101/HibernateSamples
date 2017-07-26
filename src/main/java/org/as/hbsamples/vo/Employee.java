package org.as.hbsamples.vo;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{
	private int empNo;

	private String empName;

	private String empJob;

	private int empMgr;

	private Date empHireDate;

	private double empSal;

	private double empComm;
	
	//private int deptNo;

	private Department empDept = new Department();

	public double getEmpComm() {
		return empComm;
	}

	public void setEmpComm(double empComm) {
		this.empComm = empComm;
	}

	public Department getEmpDept() {
		return empDept;
	}

	public void setEmpDept(Department dept) {
		this.empDept = dept;
	}

	public Date getEmpHireDate() {
		return empHireDate;
	}

	public void setEmpHireDate(Date empHireDate) {
		this.empHireDate = empHireDate;
	}

	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	public int getEmpMgr() {
		return empMgr;
	}

	public void setEmpMgr(int empMgr) {
		this.empMgr = empMgr;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpNo() {
		return new Integer(empNo);
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo.intValue();
	}
	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public Employee(){
	}
	
	public Employee(int empNo, String empName, String empJob, int empMgr, Date empHireDate, double empSal, double empComm, int empDeptNo) {
		super();
		// TODO Auto-generated constructor stub
		this.empNo = empNo;
		this.empName = empName;
		this.empJob = empJob;
		this.empMgr = empMgr;
		this.empHireDate = empHireDate;
		this.empSal = empSal;
		this.empComm = empComm;
		this.empDept.setDeptNo(empDeptNo);
	}

}
