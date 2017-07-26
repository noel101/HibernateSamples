package org.as.hbsamples.dao;

import java.util.Collection;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Example;
import net.sf.hibernate.expression.Expression;

import org.as.hbsamples.exceptions.BusinessException;
import org.as.hbsamples.exceptions.InfrastructureException;
import org.as.hbsamples.util.HibernateUtil;
import org.as.hbsamples.vo.Employee;

public class EmployeeDAO {

	public EmployeeDAO() {
	}

	public Employee getEmpByEmpNo(int empNo) throws BusinessException {
		Employee emp = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			emp = (Employee) session.load(Employee.class, new Integer(empNo));
			tx.commit();
			session.close();
		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
		return emp;
	}

	public void makePersistent(Employee emp) throws InfrastructureException {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
			session.close();
		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
	}

	public void update(Employee emp) throws InfrastructureException {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(emp);
			tx.commit();
			session.close();
		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
	}

	public void makeTransient(Employee employee) throws InfrastructureException {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.delete(employee);
			tx.commit();
			session.close();
		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
	}

	public Collection findAll() throws InfrastructureException {

		Collection emps;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			emps = session.createCriteria(Employee.class).list();
		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
		return emps;
	}

	public Collection findByJob(String str) throws InfrastructureException {
//select * from emp where empjob = "clerk" and sal > 1300;
		Collection emps;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(Employee.class);
			//where empjob= 'salesman'
			Criteria crit1 = crit.add(Expression.eq("empJob",str));
			emps = crit1.add(Expression.gt("empSal", 1300.00)).list();
		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
		return emps;
	}

	public Collection findByNameMatch(String str)
			throws InfrastructureException {

		Collection items;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(Employee.class);
			items = crit.add(Expression.like("empName", str)).list();
		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
		return items;
	}

	public Collection findByExample(Employee exampleEmployee)
			throws InfrastructureException {
		Collection emps;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(Employee.class);
			emps = crit.add(Example.create(exampleEmployee).excludeZeroes())
					.list();
		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
		return emps;
	}

	public Collection findallUsingHQL() throws InfrastructureException {
		Collection emps;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query q = session
					.createQuery("from  Employee as e where e.empName='Scott'");
			System.out.println(q.getQueryString());
			emps = q.list();
		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
		return emps;
	}

	//named query
	public Collection findallwithAboveaSalaryValue(double sal)
			throws InfrastructureException {

		Collection emps;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query q = session.getNamedQuery("empsalquery");
			q.setDouble("salValue", sal);
			emps = q.list();
		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
		return emps;
	}

}
