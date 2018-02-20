package fr.potajaime.core.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * Classe représentant les informations de la Plante.
 *
 */
@Entity
public class Plante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPlante;
	
	private String nomPlante;
	private String photo;
	private String typePlante;
	
	@OneToMany(mappedBy ="plante", cascade = CascadeType.ALL)
	private List<Commentaire> commentaires;
	
	@OneToMany(mappedBy = "plante", cascade= CascadeType.ALL)
	private List<Zone> zones;
	
	public Plante() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Plante(int idPlante, String nomPlante, String photo, String typePlante) {
		super();
		this.idPlante = idPlante;
		this.nomPlante = nomPlante;
		this.photo = photo;
		this.typePlante = typePlante;
	}
	
	public Plante(String nomPlante, String photo, String typePlante) {
		super();
		this.nomPlante = nomPlante;
		this.photo = photo;
		this.typePlante = typePlante;
	}
	
	public int getIdPlante() {
		return idPlante;
	}
	
	public void setIdPlante(int idPlante) {
		this.idPlante = idPlante;
	}
	
	public String getNomPlante() {
		return nomPlante;
	}
	
	public void setNomPlante(String nomPlante) {
		this.nomPlante = nomPlante;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getTypePlante() {
		return typePlante;
	}
	
	public void setTypePlante(String typePlante) {
		this.typePlante = typePlante;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
	
	
}
