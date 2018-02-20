package fr.potajaime.core.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 * Classe représentant les information du réservoire d'eau (comme le niveau d'eau)
 *
 */
@Entity
public class ReservoireEau {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReservoire;
	private String niveauEau;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "reservoireEau")
	private Potager potager;
	
	public ReservoireEau() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReservoireEau(int idReservoire, String niveauEau) {
		super();
		this.idReservoire = idReservoire;
		this.niveauEau = niveauEau;
	}


	public ReservoireEau(String niveauEau) {
		super();
		this.niveauEau = niveauEau;
	}
	
	public int getIdReservoire() {
		return idReservoire;
	}
	public void setIdReservoire(int idReservoire) {
		this.idReservoire = idReservoire;
	}
	public String getNiveauEau() {
		return niveauEau;
	}
		
	public void setNiveauEau(String niveauEau) {
		this.niveauEau = niveauEau;
	}

	public Potager getPotager() {
		return potager;
	}

	public void setPotager(Potager potager) {
		this.potager = potager;
	}
	
	
}
