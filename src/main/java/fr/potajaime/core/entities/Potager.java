package fr.potajaime.core.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
/**
 * 
 * Classe représentant le Potager et intéragissant avec les différentes autres classes.
 *
 */
@Entity
public class Potager {
	
	@Id
	private int idPotager;
	private String nomPotager;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "carte_id", nullable = false)
	private Carte carte;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "reservoir_eau_id", nullable = false)
	private ReservoireEau reservoireEau;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "potager", cascade = CascadeType.ALL)
	private List<Indicateur> indicateurs;
	
	@OneToMany(mappedBy = "potager" , cascade= CascadeType.ALL)
	private List<Zone> zones;
	
	@ManyToMany
	@JoinTable(name = "potager_tuto", 
			   joinColumns = @JoinColumn(name= "id_potager", referencedColumnName ="idPotager"),
			   inverseJoinColumns = @JoinColumn(name = "id_tutoriel", referencedColumnName = "idTutoriel"))
	private List<Tutoriel> tutoriels;
	
	
	public Potager() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Potager(String nomPotager) {
		super();
		this.nomPotager = nomPotager;
	}


	public Potager(int idPotager, String nomPotager) {
		super();
		this.idPotager = idPotager;
		this.nomPotager = nomPotager;
	}

	public int getIdPotager() {
		return idPotager;
	}

	public void setIdPotager(int idPotager) {
		this.idPotager = idPotager;
	}
	public String getNomPotager() {
		return nomPotager;
	}
	public void setNomPotager(String nomPotager) {
		this.nomPotager = nomPotager;
	}



	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public ReservoireEau getReservoireEau() {
		return reservoireEau;
	}



	public void setReservoireEau(ReservoireEau reservoireEau) {
		this.reservoireEau = reservoireEau;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	public List<Indicateur> getIndicateurs() {
		return indicateurs;
	}



	public void setIndicateurs(List<Indicateur> indicateurs) {
		this.indicateurs = indicateurs;
	}



	public List<Tutoriel> getTutoriels() {
		return tutoriels;
	}



	public void setTutoriels(List<Tutoriel> tutoriels) {
		this.tutoriels = tutoriels;
	}



	public List<Zone> getZones() {
		return zones;
	}



	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}

	
	
	
}
