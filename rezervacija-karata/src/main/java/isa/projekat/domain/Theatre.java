package isa.projekat.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Theatre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7279009747372791242L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "theatre_id")
	private Long id;
	
	private String name;
	private String address;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private TheatreType theatreType;
	
	public Theatre() {
	}

	public String getTheatreName() {
		return name;
	}

	public void setTheatreName(String theatreName) {
		this.name = theatreName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public TheatreType getTheatreType() {
		return theatreType;
	}

	public void setTheatreType(TheatreType theatreType) {
		this.theatreType = theatreType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}

