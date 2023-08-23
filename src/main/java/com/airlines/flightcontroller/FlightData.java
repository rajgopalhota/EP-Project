package com.airlines.flightcontroller;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.airlines.flightbean.FlightBean;
import com.airlines.flightentity.Flight;
@ManagedBean(name="flight" ,eager=true)
@RequestScoped
public class FlightData {
	private String source;
	private String dest;
	private String date;
	private String adults;
	private String child;
	private String econ;
	private String resMsg;
public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAdults() {
		return adults;
	}

	public void setAdults(String adults) {
		this.adults = adults;
	}

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	public String getEcon() {
		return econ;
	}

	public void setEcon(String econ) {
		this.econ = econ;
	}

	public FlightBean getEb() {
		return eb;
	}

	public void setEb(FlightBean eb) {
		this.eb = eb;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	private List<Flight> list;
	  
	  public List<Flight> getList() {
	    try {
	      list = eb.getFlightData();
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	    return list;
	  }
	  public void setList(List<Flight> list) {
	    this.list = list;
	  }

	//	Lookups
	@EJB(lookup = "java:global/EP-Project/FlightBeanimp!com.airlines.flightbean.FlightBean")
	  public FlightBean eb;

	  public String insert() {
	    try {
	      Flight e = new Flight();
	      e.setSource(source);
	      e.setDest(dest);
	      e.setDate(date);
	      e.setAdults(adults);
	      e.setChild(child);
	      e.setEcon(econ);
	      System.out.println("Sucess!");
	      resMsg = eb.insertData(e);
	    } catch (Exception e1) {
	    	resMsg = e1.getMessage();
	    	System.out.println("123456780");
	    }
	    return "home.jsf";
	  
	  }
}
