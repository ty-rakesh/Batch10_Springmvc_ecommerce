package com.te.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmvc.beans.EmployeeInfoBean;
import com.te.springmvc.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO dao;

	@Override
	public EmployeeInfoBean authenticate(Integer id, String pwd) {

		return dao.authenticate(id, pwd);
	}

	@Override
	public EmployeeInfoBean getEmpData(Integer id) {
		return dao.getEmpData(id);
	}

	@Override
	public boolean addEmp(EmployeeInfoBean employeeInfoBean) {

		return dao.addEmp(employeeInfoBean);
	}

	@Override
	public boolean updateEmp(EmployeeInfoBean infoBean) {

		return dao.updateEmp(infoBean);
	}

	@Override
	public boolean deleteEmp(Integer id) {

		return dao.deleteEmp(id);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		return dao.getAllEmployeeDetails();
	}

}

