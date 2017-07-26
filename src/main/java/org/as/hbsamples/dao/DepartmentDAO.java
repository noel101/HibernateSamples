package org.as.hbsamples.dao;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.as.hbsamples.exceptions.BusinessException;
import org.as.hbsamples.exceptions.InfrastructureException;
import org.as.hbsamples.util.HibernateUtil;
import org.as.hbsamples.vo.Department;

public class DepartmentDAO {

	public DepartmentDAO() {
	}

	public Department getDept(int deptNo) throws InfrastructureException{
		Department dept = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			dept = (Department) session.load(Department.class, new Integer(deptNo));
		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
		return dept;
	}

	public void makePersistent(Department dept) throws InfrastructureException {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(dept);
			tx.commit();
			session.close();


		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
	}
	
	public void update(Department dept) throws InfrastructureException {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(dept);
			tx.commit();
			session.close();
			// HibernateUtil.getSession().save(dept);

		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
	}

	public void makeTransient(Department dept) throws InfrastructureException {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.delete(dept);
			tx.commit();
			session.close();
		} catch (HibernateException ex) {
			throw new InfrastructureException(ex);
		}
	}
}
