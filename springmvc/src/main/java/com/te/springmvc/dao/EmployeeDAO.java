package com.te.springmvc.dao;
import java.util.List;

import com.te.springmvc.beans.EmployeeInfoBean;

public interface EmployeeDAO {

	public EmployeeInfoBean authenticate(Integer id , String pwd);
	
	public EmployeeInfoBean getEmpData(Integer id);
	
	public boolean addEmp(EmployeeInfoBean employeeInfoBean);
	
	public boolean updateEmp(EmployeeInfoBean infoBean);
	
	public boolean deleteEmp(Integer id);
	
	public List<EmployeeInfoBean> getAllEmployeeDetails();
}
