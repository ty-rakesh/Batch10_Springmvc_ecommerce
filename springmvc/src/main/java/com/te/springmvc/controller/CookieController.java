package com.te.springmvc.controller;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/cookies")
public class CookieController {
	
	@GetMapping("/cookiepage")
	public String getCookiePage(){
		return "cookie";	
		}
	
	
	@GetMapping("/createcookie")
	public String createCookie(ModelMap map,HttpServletResponse responce){
		Cookie cookie=new Cookie("technoelevate", "batch10");
		responce.addCookie(cookie);
		map.addAttribute("msg","cookie created sucessfully");
		
		return "cookie";	
		}
	
	@GetMapping("/showcookie")
	public String getCookie(@CookieValue(name="technoelevate",required=false)String value,ModelMap map){
		if(value!=null){
			map.addAttribute("msg","cookie found");
			map.addAttribute("cookievalue",value);
		}
		return "cookie";
	}

}
