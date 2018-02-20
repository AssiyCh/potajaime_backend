package fr.potajaime.core.services;

import java.util.List;

import fr.potajaime.core.entities.Commentaire;

public interface CommentaireService {

	public void addCommentaire(Commentaire commentaire);
	
	public Commentaire getCommentaireById(int idCommentaire);
	
	public List<Commentaire> getAllCommentaires();
	
	public void updateCommentaire(Commentaire commentaire, int idCommentaireAchanger);
	
	public void deleteCommentaire(int idCommentaire);
}
