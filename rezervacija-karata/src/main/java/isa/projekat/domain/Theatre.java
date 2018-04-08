package isa.projekat.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy="theatre")
	private Collection<Auditorium> aud;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "theatre_repertoire", joinColumns = { @JoinColumn(name = "theatre_id") }, inverseJoinColumns = { @JoinColumn(name = "proj_id") })
	private Collection<Projection> repertoire;
	
	public Theatre() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TheatreType getTheatreType() {
		return theatreType;
	}

	public void setTheatreType(TheatreType theatreType) {
		this.theatreType = theatreType;
	}

	public Collection<Auditorium> getAud() {
		return aud;
	}

	public void setAud(Collection<Auditorium> aud) {
		this.aud = aud;
	}

	public Collection<Projection> getRepertoire() {
		return repertoire;
	}

	public void setRepertoire(Collection<Projection> repertoire) {
		this.repertoire = repertoire;
	}


}

