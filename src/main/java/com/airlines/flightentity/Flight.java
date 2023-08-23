package com.airlines.flightentity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="flight")
public class Flight implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String source;
	private String dest;
	private String date;
	private String adults;
	private String child;
	private String econ;
	
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
}
