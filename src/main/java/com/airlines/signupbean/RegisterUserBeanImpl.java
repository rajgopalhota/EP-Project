package com.airlines.signupbean;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.airlines.signupentity.RegisterUser;

@Stateless
public class RegisterUserBeanImpl implements RegisterUserBean{
	@Override
	  public String insertData(RegisterUser e) throws Exception {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EP-Project");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(e);
	    em.getTransaction().commit();
	    em.close();
	    emf.close();

	    return "signupsuccessfully";
	  }
}
