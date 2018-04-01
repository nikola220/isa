package isa.projekat.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Theatre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String desc;
	private String address;
	private ArrayList<Projection> projs; // projekcije
	private ArrayList<Auditorium> auds; //sale u pozoristu/bioskopu
	
	@Enumerated(EnumType.STRING)
	private TheatreType type;
	
	public Theatre() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public TheatreType getType() {
		return type;
	}

	public void setType(TheatreType type) {
		this.type = type;
	}

	public ArrayList<Projection> getProjs() {
		return projs;
	}

	public void setProjs(ArrayList<Projection> projs) {
		this.projs = projs;
	}

	public ArrayList<Auditorium> getAuds() {
		return auds;
	}

	public void setAuds(ArrayList<Auditorium> auds) {
		this.auds = auds;
	}
	
	
}
