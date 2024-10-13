package com.bean;

import java.sql.Time;

public class Doctor {

	public int did;
	public String dname;
	public int age;
	public long phoneno;
	public Time[] slotAvailibility; 
	
	public Time[] getSlotAvailibility() {
		return slotAvailibility;
	}
	public void setSlotAvailibility(Time[] slotAvailibility) {
		this.slotAvailibility = slotAvailibility;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	
	
}