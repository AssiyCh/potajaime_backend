package fr.potajaime.core.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * Classe représentant l'une des zones auxquelles est réparti un Potager.
 *
 */
@Entity
public class Zone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idZone;
	private String nomZone;
	
	@ManyToOne
	@JoinColumn(name = "zones")
	private Potager potager;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "zone_evenement",
			   joinColumns = @JoinColumn(name = "zone_id", referencedColumnName = "idZone"),
			   inverseJoinColumns = @JoinColumn(name = "evenement_id", referencedColumnName = "idEvenement"))
	private List<Evenement> evenements;
	
	@ManyToMany
	@JoinTable(name ="zone_brique", 
			   joinColumns = @JoinColumn(name="zone_id" , referencedColumnName = "idZone"), 
			   inverseJoinColumns = @JoinColumn(name="brique_id",referencedColumnName="idBrique"))			
	private List<Brique> briques;
	
	@ManyToOne
	@JoinColumn(name="id_plante")
	private Plante plante;

	public Zone() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Zone(String nomZone) {
		super();
		this.nomZone = nomZone;
	}


	public Zone(int idZone, String nomZone) {
		super();
		this.idZone = idZone;
		this.nomZone = nomZone;
	}

	public int getIdZone() {
		return idZone;
	}
	
	public void setIdZone(int idZone) {
		this.idZone = idZone;
	}
	
	public String getNomZone() {
		return nomZone;
	}
	
	public void setNomZone(String nomZone) {
		this.nomZone = nomZone;
	}

	public List<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}

	public Potager getPotager() {
		return potager;
	}

	public void setPotager(Potager potager) {
		this.potager = potager;
	}
	
	
}
