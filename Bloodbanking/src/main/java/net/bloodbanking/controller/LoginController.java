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
	
	@RequestMapping("/hello")
	public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		locationService.loadStateById(new StateMstDTO());
		ModelAndView mv = new ModelAndView("forgotPassword");
		mv.addObject("name", name+" - Test - Loki");
		return mv;
	}
}
