package com.te.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.springmvc.customexp.EmployeeException;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmployeeException.class)
	public String handleExp(EmployeeException exception, HttpServletRequest request) {
		request.setAttribute("expMsg", exception.getMessage());
		return "header";
	}
}

