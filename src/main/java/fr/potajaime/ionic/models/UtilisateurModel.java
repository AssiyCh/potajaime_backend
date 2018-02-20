package fr.potajaime.ionic.models;

public class UtilisateurModel {
	
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String carteId;
	private int potagerId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCarteId() {
		return carteId;
	}
	public void setCarteId(String carteId) {
		this.carteId = carteId;
	}
	public int getPotagerId() {
		return potagerId;
	}
	public void setPotagerId(int potagerId) {
		this.potagerId = potagerId;
	}
	
}
