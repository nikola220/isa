package isa.projekat.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Theatre theatre;
	private Time time;
	private int discPercent;
	private double discPrice;
	
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int getDiscPercent() {
		return discPercent;
	}
	public void setDiscPercent(int discPercent) {
		this.discPercent = discPercent;
	}
	public double getDiscPrice() {
		return discPrice;
	}
	public void setDiscPrice(double discPrice) {
		this.discPrice = discPrice;
	}
	
}
