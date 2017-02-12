package net.bloodbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.bloodbanking.dto.StateMstDTO;
import net.bloodbanking.service.LocationService;
import net.bloodbanking.service.LoginService;

@Controller
public class LoginController {	
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping("/signup")
	public ModelAndView signup(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		ModelAndView mv = new ModelAndView("signup");
		mv.addObject("name", name+" - Test - Loki");
		return mv;
	}
	
	@RequestMapping("/newpassword")
	public ModelAndView newpassword(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		ModelAndView mv = new ModelAndView("newpassword");
		mv.addObject("name", name+" - Test - Loki");
		return mv;
	}
}
