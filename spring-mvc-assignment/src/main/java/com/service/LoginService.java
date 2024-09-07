package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginDao;

@Service
public class LoginService {

	
	@Autowired
	LoginDao loginDao;
	
	public int SignIn(String emailid, String password, String typeofuser)
	{
		List<Map<String, Object>> User = loginDao.signIn(emailid,password,typeofuser);
		if(User.isEmpty())
		{
			return 0;
		}
		else {
			return 1;
		}
		
	}
	
	public int SignUp(String emailid, String password, String typeofuser)
	{
		return loginDao.signUp(emailid,password,typeofuser);
		
	}
}
