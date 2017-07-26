package org.as.hbsamples.client;

import org.as.hbsamples.dao.DepartmentDAO;
import org.as.hbsamples.util.HibernateUtil;
import org.as.hbsamples.vo.Department;

public class DepartmentClient {
	/**
	 * @param args
	 */
public static void main(String[] args) {

	//Department dept = new Department(500,"Security","LA");
	//insertRecord(dept);
	
	// Select dept
	Department dept = selectRecord(30);
	
	//insert a record


	//update a record	
	 	//updateDeptLocation(50, "Chicago");
//	delete a record
	//deleteRecord(500);
	}
	public static void insertRecord(Department dept) {
		DepartmentDAO deptDAO = new DepartmentDAO();
		deptDAO.makePersistent(dept);
	}

	public static Department selectRecord(int deptNo) {
		DepartmentDAO deptDAO = new DepartmentDAO();
		Department dept = deptDAO.getDept(deptNo);
		System.out.println("Item id: " + dept.getDeptName());
		System.out.println("Item name: " + dept.getDeptLoc());
		return dept;
	}

	public static void updateDeptLocation(int deptNo, String deptLoc) {
		DepartmentDAO deptDAO = new DepartmentDAO();
		Department dept = deptDAO.getDept(deptNo);
		
		System.out.println("Item id: " + dept.getDeptName());
		System.out.println("Item name: " + dept.getDeptLoc());
		dept.setDeptLoc(deptLoc);
		deptDAO.update(dept);
	}

	public static void deleteRecord(int deptNo) {
		DepartmentDAO deptDAO = new DepartmentDAO();
		Department dept = deptDAO.getDept(deptNo);
		//Department dept = new Department();
		//dept.setDeptNo(deptNo);
		System.out.println("Item id: " + dept.getDeptName());
		System.out.println("Item name: " + dept.getDeptLoc());
		deptDAO.makeTransient(dept);
	}
}
