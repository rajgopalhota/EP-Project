package com.airlines.flightbean;

import java.util.List;


import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
//import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.airlines.flightentity.Flight;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class FlightBeanimp implements FlightBean{
	@Override
	public String insertData(Flight e) throws Exception {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EP-Project");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(e);
	    em.getTransaction().commit();
	    em.close();
	    emf.close();

	    return "Booked Successfully!";
	  }

	@Override
	public List<Flight> getFlightData()  throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EP-Project");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    TypedQuery<Flight> query = em.createQuery("SELECT e FROM Flight e", Flight.class);
	    List<Flight> list = query.getResultList();
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
	    return list;
	}
}
