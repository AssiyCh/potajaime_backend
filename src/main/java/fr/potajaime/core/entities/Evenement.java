package fr.potajaime.core.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * 
 * Classe représentant l'évenement pouvant avoir lieu au niveau du potager (plantation, labourage, récolte, arrosage..)  
 *
 */
@Entity
public class Evenement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEvenement;
	
	private String label;
	private Date dateDebut;
	private Date dateFin;
	
	private boolean done;
	
	@ManyToMany(mappedBy = "evenements")
	private List<Zone> zone;
	
	public Evenement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Evenement(String label, Date dateDebut, Date dateFin, boolean done, List<Zone> zone) {
		super();
		this.label = label;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.done = done;
		this.zone = zone;
	}




	public int getIdEvenement() {
		return idEvenement;
	}

	public void setIdEvenement(int idEvenement) {
		this.idEvenement = idEvenement;
	}

	
	public List<Zone> getZone() {
		return zone;
	}

	public void setZone(List<Zone> zone) {
		this.zone = zone;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	
	
	
	

	
}
