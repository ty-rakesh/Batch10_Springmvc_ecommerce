package com.te.springmvc.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springmvc.beans.EmployeeInfoBean;
import com.te.springmvc.customexp.EmployeeException;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public EmployeeInfoBean authenticate(Integer id, String pwd) {

		EmployeeInfoBean employeeInfoBean = null;
		try {
     		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();

			String getData = "from EmployeeInfoBean where empId=:id and password=:pwd";

			Query query = manager.createQuery(getData);
			query.setParameter("id", id);
			query.setParameter("pwd", pwd);

			employeeInfoBean = (EmployeeInfoBean) query.getSingleResult();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return employeeInfoBean;
	}// end of authenticate

	@Override
	public EmployeeInfoBean getEmpData(Integer id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager manager = factory.createEntityManager();
		EmployeeInfoBean bean = manager.find(EmployeeInfoBean.class, id);
		return bean;
	}

	@Override
	public boolean addEmp(EmployeeInfoBean employeeInfoBean) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(employeeInfoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateEmp(EmployeeInfoBean infoBean) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			EmployeeInfoBean orgData = manager.find(EmployeeInfoBean.class, infoBean.getEmpId());

			if (infoBean.getName() != null && infoBean.getName() != "") {
				orgData.setName(infoBean.getName());
			}

			if (infoBean.getBirthDate() != null) {
				orgData.setBirthDate(infoBean.getBirthDate());
			}

			if (infoBean.getPassword() != null && infoBean.getPassword() != "") {
				orgData.setPassword(infoBean.getPassword());
			}

			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteEmp(Integer id) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			EmployeeInfoBean infoBean = manager.find(EmployeeInfoBean.class, id);
			manager.remove(infoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {

			e.printStackTrace();

			throw new EmployeeException("The Data is not present");
		}
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployeeDetails() {

		List<EmployeeInfoBean> employeeInfoBeans = null;

		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();

			Query query = manager.createQuery("from EmployeeInfoBean");

			employeeInfoBeans = query.getResultList();
			
			
		} catch (Exception e) {
			employeeInfoBeans = null;
			e.printStackTrace();
		}

		return employeeInfoBeans;
	}

}
