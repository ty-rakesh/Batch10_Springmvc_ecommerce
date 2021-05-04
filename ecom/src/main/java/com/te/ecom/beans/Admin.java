package com.te.ecom.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "admin_info")
public class Admin {

	@Id
	@Column(name = "a_id")
	private int id;
	
	@Column(name = "a_password")
	private String password;
}