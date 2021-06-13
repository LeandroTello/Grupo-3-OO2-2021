package com.TPOO2.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.TPOO2.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/")
public class LoginController {
	
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.HOME_INDEX);
		User user = (User) SecurityContextHolder.getContext().getAuthentication ().getPrincipal();
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@GetMapping("/login")
	public String login(Model model,
						@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewRouteHelper.USER_LOGIN;
	}
	
	
	@GetMapping("/logout")
	public String logout(Model model,
			@RequestParam(name="error",required=false) String error) {
		model.addAttribute("error", error);
		return ViewRouteHelper.USER_LOGOUT;
	}
	
	@GetMapping("/loginsuccess")
	public String loginCheck() {
		return ViewRouteHelper.USER_ROOT;
	}
}
