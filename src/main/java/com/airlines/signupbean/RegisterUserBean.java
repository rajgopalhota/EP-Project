package com.airlines.signupbean;

import javax.ejb.Remote;

import com.airlines.signupentity.RegisterUser;

@Remote
public interface RegisterUserBean {
	public String insertData(RegisterUser e) throws Exception;
}
