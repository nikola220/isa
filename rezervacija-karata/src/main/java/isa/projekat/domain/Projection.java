package isa.projekat.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Projection {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="proj_id")
	private Long id;
	
	private LocalDateTime date;	
	
	private double price;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
	private Film film;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aud_id")
    private Auditorium aud;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Auditorium getAud() {
		return aud;
	}

	public void setAud(Auditorium aud) {
		this.aud = aud;
	}
    
    
}
