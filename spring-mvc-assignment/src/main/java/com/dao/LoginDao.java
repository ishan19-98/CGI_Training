package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int signUp(String emailid, String password, String typeofuser) {
	try {
	return jdbcTemplate.update("insert into login values(?,?,?)", emailid, password,typeofuser);
	} catch (Exception e) {
		System.err.println(e);
		return 0;
	}
	}
	
	public List<Map<String, Object>> signIn(String emailid, String password, String typeofuser) {
		try {
		return jdbcTemplate.queryForList("select * from login where emailid=? and password=? and typeofuser=? ", emailid,password,typeofuser);
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
		}
}
