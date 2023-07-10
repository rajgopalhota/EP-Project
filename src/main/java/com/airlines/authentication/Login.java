package com.airlines.authentication;

import java.io.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.faces.application.FacesMessage;

@ManagedBean(name = "login", eager = true)
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	private String username;
	private String password;
	private String message;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public String validateUsernamePassword() {
		boolean valid = LoginDAO.validate(username, password);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", username);
			 FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage("You have logged in successfully", "You have successfully registered and logged in"));
			return "home";
			
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null,new FacesMessage("Incorrect Username and Passowrd","Please enter correct username and Password"));
			return "login";
		}
		
		
	}
	
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
}
