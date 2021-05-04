package com.te.springmvc.beans;
import java.io.Serializable;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class EmployeeInfoBean  implements Serializable{

	@Id
	@Column(name = "id")
	private Integer empId;
	
	@Column
	private String name;
	
	@Column(name = "dob")
//	@DateTimeFormat(iso = ISO.DATE)
	private Date birthDate;
	
	@Column
	private String password;
	
}
