package com.te.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc.beans.EmployeeInfoBean;
import com.te.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@Autowired
	private EmployeeService service;

	@GetMapping("/empLogin")
	public String getLoginPage() {
		return "empLogin";
	}

	@PostMapping("/empLogin")
	public String authenticate(Integer empId, String password, ModelMap map, HttpServletRequest request) {
		EmployeeInfoBean bean = service.authenticate(empId, password);
		if (bean != null) {
			System.out.println(" success login");
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedInfo", bean);
//			session.setMaxInactiveInterval(60);
			return "empHome";
		} else {
			System.out.println(" login failure");
			map.addAttribute("msg", " User Details Not Found");
			return "empLogin";
		}
	}//

	@GetMapping("/searchPage")
	public String getSearchPage(HttpSession session, ModelMap map) {

		if (session.getAttribute("loggedInfo") != null) {
			return "searchPage";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "empLogin";
		}

	}

	@GetMapping("/search")
	public String getEmployeeData(Integer id, ModelMap map,
			@SessionAttribute(name = "loggedInfo", required = false) EmployeeInfoBean infoBean) {
		if (infoBean != null) {
			EmployeeInfoBean employeeInfoBean = service.getEmpData(id);

			if (employeeInfoBean != null) {
				map.addAttribute("data", employeeInfoBean);
			} else {
				map.addAttribute("msg", "Details Not Found");
			}

			return "searchPage";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "empLogin";
		}

	}

	@GetMapping("/logout")
	public String handleLogout(HttpSession httpSession, ModelMap map) {
		httpSession.invalidate();
		map.addAttribute("msg", "logged out Successfully");
		return "empLogin";
	}//

	@GetMapping("/add")
	public String getAddPage(@SessionAttribute(name = "loggedInfo", required = false) EmployeeInfoBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			return "addEmp";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "empLogin";
		}
	}// end of getaddpage

	@PostMapping("/add")
	public String addEmployeeDetails(@SessionAttribute(name = "loggedInfo", required = false) EmployeeInfoBean infoBean,
			EmployeeInfoBean employeeInfo, ModelMap map) {
		if (infoBean != null) {
			if (service.addEmp(employeeInfo)) {
				map.addAttribute("msg", "Employee Details Added");
			} else {
				map.addAttribute("errMsg", "Details already exists");
			}
			return "addEmp";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "empLogin";
		}

	}//

	@GetMapping("/update")
	public String getUpdateFrom(@SessionAttribute(name = "loggedInfo", required = false) EmployeeInfoBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			map.addAttribute("id", infoBean.getEmpId());
			return "updatePage";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "empLogin";
		}
	}//

	@PostMapping("/update")
	public String getUpdateData(EmployeeInfoBean employeeInfoBean,
			@SessionAttribute(name = "loggedInfo", required = false) EmployeeInfoBean infoBean, ModelMap map) {
		if (infoBean != null) {
			if (service.updateEmp(employeeInfoBean)) {
				map.addAttribute("msg", "Details Updates");
			} else {
				map.addAttribute("msg", "Details Are not Updates");
			}

			map.addAttribute("id", infoBean.getEmpId());
			return "updatePage";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "empLogin";
		}
	}

	@GetMapping("/delete")
	public String getDeleteForm(@SessionAttribute(name = "loggedInfo", required = false) EmployeeInfoBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			return "deletePage";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "empLogin";
		}
	}

	@GetMapping("/deleteEmp")
	public String deletEmpData(Integer empId,
			@SessionAttribute(name = "loggedInfo", required = false) EmployeeInfoBean infoBean, ModelMap map) {
		if (infoBean != null) {
			if (service.deleteEmp(empId)) {
				map.addAttribute("msg", "Data Deleted Successfully");
			}

			return "deletePage";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "empLogin";
		}
	}

	@GetMapping("/getAll")
	public String getAllData(@SessionAttribute(name = "loggedInfo", required = false) EmployeeInfoBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			List<EmployeeInfoBean> beans = service.getAllEmployeeDetails();
			if (beans != null) {
				map.addAttribute("infobeans", beans);
			} else {
				map.addAttribute("msg", "No records Found");
			}
			return "searchPage";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "empLogin";
		}
	}

}
