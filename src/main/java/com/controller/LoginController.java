package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "signUp",method = RequestMethod.GET)
	public ModelAndView signUpController(HttpServletRequest req) {  // DI for request object 
		String emailid = req.getParameter("emailid");
		String password = req.getParameter("password");
		String typeofuser = req.getParameter("typeofuser");
		ModelAndView mav = new ModelAndView();
		
		int status = loginService.SignUp(emailid,password,typeofuser);
		if(status == 1)
		{
			mav.setViewName("signupsuccess.jsp");
		}else {
			mav.setViewName("failure.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value = "signIn",method = RequestMethod.POST)  // di for request object 
	public ModelAndView signInController(HttpServletRequest req) {
		String emailid = req.getParameter("emailid");
		String password = req.getParameter("password");
		String typeofuser = req.getParameter("typeofuser");
		ModelAndView mav = new ModelAndView();

		int status = loginService.SignIn(emailid,password,typeofuser);
		if (status == 1) {
			if (typeofuser.equals("admin")) {
				mav.setViewName("adminsuccess.jsp");
			} else if (typeofuser.equals("customer")) {
				mav.setViewName("customersuccess.jsp");
			} else {
				mav.setViewName("failure.jsp");
			}
		} else {
			mav.setViewName("failure.jsp");
		}
		return mav;
		
	}
}
