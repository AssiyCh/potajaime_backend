package fr.potajaime.core.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * 
 * Classe représentant l'utilisateur du Potager.
 *
 */
@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String prenom;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
	private List<Potager> potagers;
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(String email, String password) {
		super();
		this.password = password;
		this.email = email;
	}
	public Utilisateur(int id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	public Utilisateur(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public List<Potager> getPotagers() {
		return potagers;
	}
	public void setPotagers(List<Potager> potagers) {
		this.potagers = potagers;
	}
	

	

}
