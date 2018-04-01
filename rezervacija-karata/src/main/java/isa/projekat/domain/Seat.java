package isa.projekat.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private SeatingStatus status;
	
	private int row;
	private int col;
	
	private Auditorium aud;
	
	public SeatingStatus getStatus() {
		return status;
	}
	public void setStatus(SeatingStatus status) {
		this.status = status;
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
	public Auditorium getAud() {
		return aud;
	}
	public void setAud(Auditorium aud) {
		this.aud = aud;
	}
	
}
