package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Account;
import com.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String IndexPageController(Model mm, Account account)
	{
	
		return "index";
	}
	
	@RequestMapping(value="/storeaccountdetails", method=RequestMethod.POST)
	public String createAccountController(Model mm, Account account)
	{
		String result = accountService.createAccount(account);
		mm.addAttribute("msg",result);
		return "index";
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.POST)
	public String depositController(Model mm, Account account)
	{
		String result = accountService.deposit(account);
		mm.addAttribute("msg1",result);
		return "index";
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	public String withdrawController(Model mm, Account account)
	{
		String result = accountService.withdraw(account);
		mm.addAttribute("msg2",result);
		return "index";
	}
	
	@RequestMapping(value="/checkBalance", method=RequestMethod.GET)
	public String checkBalanceController(Model mm, Account account)
	{
		String result = accountService.checkBalance(account);
		mm.addAttribute("msg3",result);
		return "index";
	}
	
	
}
