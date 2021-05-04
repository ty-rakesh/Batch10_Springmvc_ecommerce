package com.te.springmvc.service;

import java.util.List;

import com.te.springmvc.beans.EmployeeInfoBean;

public interface EmployeeService {
	public EmployeeInfoBean authenticate(Integer id, String pwd);

	public EmployeeInfoBean getEmpData(Integer id);

	public boolean addEmp(EmployeeInfoBean employeeInfoBean);

	public boolean updateEmp(EmployeeInfoBean infoBean);

	public boolean deleteEmp(Integer id);

	public List<EmployeeInfoBean> getAllEmployeeDetails();
}

