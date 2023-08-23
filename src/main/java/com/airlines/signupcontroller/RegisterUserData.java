package com.airlines.signupcontroller;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.airlines.signupbean.RegisterUserBean;
import com.airlines.signupentity.RegisterUser;
@ManagedBean(name = "register", eager = true)
@RequestScoped
public class RegisterUserData {
	private String username=null;
	private String email=null;
	private String pass=null;
	private String resMsg;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
//	Lookups
	@EJB(lookup = "java:global/EP-Project/RegisterUserBeanImpl!com.airlines.signupbean.RegisterUserBean")
	  private RegisterUserBean eb;

	  public String insert() {
	    try {
	      RegisterUser e = new RegisterUser();
	      e.setUsername(username);
	      e.setEmail(email);
	      e.setPass(pass);
	      System.out.println("password" + pass + "..........");
	      resMsg = eb.insertData(e);
	    } catch (Exception e1) {
	    	resMsg = e1.getMessage();
	    }
	    return "login";
	  }

}
