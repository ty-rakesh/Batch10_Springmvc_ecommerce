package com.te.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestDeligation {

	
	@GetMapping("/redirect")
	public String redirectExample(){
		return "redirect:https://youtube.com";
		
	}
	
	
	@GetMapping("/forward")
	public String forwardExample(ModelMap map){
		map.addAttribute("msg", "request was forwarded");
		return "forward:empLogin";
	}
}
