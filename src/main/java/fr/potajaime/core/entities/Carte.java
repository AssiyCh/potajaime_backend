package fr.potajaime.core.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 
 * Classe représentant les informations de la carte ratachée à plusieurs capteurs au niveau du Potager.
 *
 */
@Entity
public class Carte {
	
	@Id
	private String idCarte;
	
	private String nomCarte;
	private String position;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "carte")
	private Potager potager;
	
	public Carte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Carte(String nomCarte, String position) {
		super();
		this.nomCarte = nomCarte;
		this.position = position;
	}
	
	public Carte(String idCarte, String nomCarte, String position) {
		super();
		this.idCarte = idCarte;
		this.nomCarte = nomCarte;
		this.position = position;
	}

	public String getIdCarte() {
		return idCarte;
	}
	
	public void setIdCarte(String idCarte) {
		this.idCarte = idCarte;
	}
	
	public String getNomCarte() {
		return nomCarte;
	}
	
	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}

	public Potager getPotager() {
		return potager;
	}

	public void setPotager(Potager potager) {
		this.potager = potager;
	}

	
	
	
	
	
	
}
