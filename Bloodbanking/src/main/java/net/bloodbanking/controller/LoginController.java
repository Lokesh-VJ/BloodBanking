package net.bloodbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.bloodbanking.service.LoginService;

@Controller
public class LoginController {	
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/signup.html")
	public ModelAndView signup(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		ModelAndView mv = new ModelAndView("signup");
		mv.addObject("name", name+" - Test - Loki");
		return mv;
	}
	
	@RequestMapping("/newpassword.html")
	public ModelAndView newpassword(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		ModelAndView mv = new ModelAndView("newpassword");
		mv.addObject("name", name+" - Test - Loki");
		return mv;
	}
}
