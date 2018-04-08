package isa.projekat.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Auditorium {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="aud_id")
	private Long id;
	
    @ManyToOne
    @JoinColumn(name="theatre_id")
	private Theatre theatre;
	
	private String name;
	
	private int row;
	
	private int col;
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "aud_proj", joinColumns = { @JoinColumn(name = "aud_id") }, inverseJoinColumns = { @JoinColumn(name = "proj_id") })
    private Set<Projection> projs = new HashSet<>();
	*/
	public Auditorium() {
		// TODO Auto-generated constructor stub
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*public Set<Projection> getProjs() {
		return projs;
	}

	public void setProjs(Set<Projection> projs) {
		this.projs = projs;
	}
	*/
	
	
}
