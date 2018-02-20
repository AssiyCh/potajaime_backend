package fr.potajaime.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe représentant les commentaires écrits sur les plantes.
 *
 */
@Entity
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCommentaire;
	private String commentaire;
	
	@ManyToOne
	@JoinColumn(name = "plante_id")
	private Plante plante;
	
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Commentaire(int idCommentaire, String commentaire) {
		super();
		this.idCommentaire = idCommentaire;
		this.commentaire = commentaire;
	}
	
	public Commentaire(String commentaire) {
		super();
		this.commentaire = commentaire;
	}

	public int getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Plante getPlante() {
		return plante;
	}

	public void setPlante(Plante plante) {
		this.plante = plante;
	}
	
	
	
	
}
