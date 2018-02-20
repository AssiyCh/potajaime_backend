package fr.potajaime.core.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 * Classe représentant les tutoriels enregistrés àfin d'accompagner et aider les utilisateurs du Potager.
 *
 */
@Entity
public class Tutoriel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTutoriel;
	private String description;
	
	@ManyToMany(mappedBy = "tutoriels")
	private List<Potager> potagers;
	
	public Tutoriel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Tutoriel(int idTutoriel, String description) {
		super();
		this.idTutoriel = idTutoriel;
		this.description = description;
	}
	
	public Tutoriel(String description) {
		super();
		this.description = description;
	}
	
	public int getIdTutoriel() {
		return idTutoriel;
	}
	
	public void setIdTutoriel(int idTutoriel) {
		this.idTutoriel = idTutoriel;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
