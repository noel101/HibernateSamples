package org.as.hbsamples.client;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import org.as.hbsamples.dao.EmployeeDAO;
import org.as.hbsamples.vo.Department;
import org.as.hbsamples.vo.Employee;

public class EmployeeClient {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// insert a record
//			Employee newEmp = new Employee(400, "Ankur", "ANALYST", 1, new Date(), 1000.00, 50.00, 30);
//			insertRecord(newEmp);
		
		
		// update a record
//				updateName(1, "Scott");
		
		// delete a record
		
		//	deleteRecord(2);

		// find all
	//	Collection c  = getAllRecords();
			
		// select a record
		//Employee e = selectRecord(1);

		// Call get by job
		// list = callFindByJob("SALESMAN");

		// Call get by job
		//Collection list = callfindByNameMatch("%P%");
		
		// find by example
//		Employee emp = new Employee();
//		emp.setEmpJob("ANALYST");
//		emp.setEmpComm(50);
//		Collection list = callfindByExample(emp);
//		
		//find all using HQL
		Collection list = callfindallUsingHQL();
		
		//find all using HQL
	//	Collection list = findallwithAboveaSalaryValue();

	}

	public static Employee selectRecord(int empNo){
		EmployeeDAO empDAO = new EmployeeDAO();
		Employee e = empDAO.getEmpByEmpNo(empNo);
		System.out.println("Emp No: " + e.getEmpNo());
		System.out.println("Emp Name: " + e.getEmpName());
		System.out.println("Emp Mgr: " + e.getEmpMgr());
		System.out.println("=========== Dept Details");
		System.out.println("Deptno: " + e.getEmpDept().getDeptNo());
		System.out.println("Deptname: " + e.getEmpDept().getDeptName());
		System.out.println("DeptLoc: " + e.getEmpDept().getDeptLoc());
		return e;
	}

	public static void insertRecord(Employee emp) {
		EmployeeDAO empDAO = new EmployeeDAO();
		empDAO.makePersistent(emp);
	}

	public static void updateName(int empNo, String newName) {
		EmployeeDAO empDAO = new EmployeeDAO();
		Employee e = empDAO.getEmpByEmpNo(empNo);
		System.out.println("Emp No: " + e.getEmpNo());
		System.out.println("Emp Name: " + e.getEmpName());
		System.out.println("Emp Mgr: " + e.getEmpMgr());
		//update the name
		e.setEmpName(newName);
		empDAO.update(e);
	}
	
	public static void deleteRecord(int empNo) {
		EmployeeDAO empDAO = new EmployeeDAO();
		Employee e = empDAO.getEmpByEmpNo(empNo);
		System.out.println("Emp No: " + e.getEmpNo());
		System.out.println("Emp Name: " + e.getEmpName());
		System.out.println("Emp Mgr: " + e.getEmpMgr());		
		empDAO.makeTransient(e);
	}

	public static Collection getAllRecords() {
		EmployeeDAO empDAO = new EmployeeDAO();
		Collection list = 		empDAO.findAll();
		Iterator iter = list.iterator();
		Employee e;
		int count = 0;
		while (iter.hasNext()) {
			count++;
			e = (Employee) iter.next();
			System.out.println("Emp No: " + e.getEmpNo());
			System.out.println("Emp Name: " + e.getEmpName());
			System.out.println("Emp Mgr: " + e.getEmpMgr());
		}
		System.out.println("Total Count: " + count);		
		return list;
	}
	

	public static Collection callFindByJob(String job) {
		EmployeeDAO empDAO = new EmployeeDAO();
		Collection list = empDAO.findByJob(job);

		Iterator iter = list.iterator();
		Employee e;
		while (iter.hasNext()) {
			e = (Employee) iter.next();
			System.out.println("Emp No: " + e.getEmpNo());
			System.out.println("Emp Name: " + e.getEmpName());
			System.out.println("Emp Mgr: " + e.getEmpMgr());
		}
		return list;
	}
	
	public static Collection callfindByNameMatch(String pattern) {
		EmployeeDAO empDAO = new EmployeeDAO();
		Collection list = empDAO.findByNameMatch(pattern);

		Iterator iter = list.iterator();
		Employee e;
		while (iter.hasNext()) {
			e = (Employee) iter.next();
			System.out.println("Emp No: " + e.getEmpNo());
			System.out.println("Emp Name: " + e.getEmpName());
			System.out.println("Emp Mgr: " + e.getEmpMgr());
		}
		return list;
	}

	public static Collection callfindByExample(Employee emp) {
		EmployeeDAO empDAO = new EmployeeDAO();
		Collection list = empDAO.findByExample(emp);

		Iterator iter = list.iterator();
		Employee e;
		while (iter.hasNext()) {
			e = (Employee) iter.next();
			System.out.println("Emp No: " + e.getEmpNo());
			System.out.println("Emp Name: " + e.getEmpName());
			System.out.println("Emp Mgr: " + e.getEmpMgr());
			System.out.println("Emp JOB: " + e.getEmpJob());
			System.out.println("Emp JOB: " + e.getEmpComm());
		}
		return list;
	}
	
	public static Collection callfindallUsingHQL() {
		EmployeeDAO empDAO = new EmployeeDAO();
		Collection list = empDAO.findallUsingHQL();

		Iterator iter = list.iterator();
		Employee e;
		while (iter.hasNext()) {
			e = (Employee) iter.next();
			System.out.println("Emp No: " + e.getEmpNo());
			System.out.println("Emp Name: " + e.getEmpName());
			System.out.println("Emp Mgr: " + e.getEmpMgr());
		}
		return list;
	}
	
	
	public static Collection findallwithAboveaSalaryValue(){
		EmployeeDAO empDAO = new EmployeeDAO();
		Collection list = empDAO.findallwithAboveaSalaryValue(1000);

		Iterator iter = list.iterator();
		Employee e;
		while (iter.hasNext()) {
			e = (Employee) iter.next();
			System.out.println("Emp No: " + e.getEmpNo());
			System.out.println("Emp Name: " + e.getEmpName());
			System.out.println("Emp Mgr: " + e.getEmpMgr());
		}
		return list;		
		
	}
	
}
