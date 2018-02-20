package fr.potajaime.core.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.potajaime.core.entities.Commentaire;
import fr.potajaime.core.repositories.CommentaireRepository;
import fr.potajaime.core.services.CommentaireService;

@Service
public class CommentaireServiceImpl implements CommentaireService{

		@Autowired
		CommentaireRepository commentaireRepository;

		@Override
		public void addCommentaire(Commentaire commentaire) {
			commentaireRepository.save(commentaire);
		}

		@Override
		public Commentaire getCommentaireById(int idCommentaire) {
			return commentaireRepository.findOne(idCommentaire);
		}

		@Override
		public List<Commentaire> getAllCommentaires() {
			List<Commentaire> commentaires  = new ArrayList<>();
			commentaireRepository.findAll().forEach(commentaires::add);
			return commentaires;
		}

		@Override
		public void updateCommentaire(Commentaire commentaire, int idCommentaireAchanger) {
			if(getCommentaireById(idCommentaireAchanger)!= null){
			commentaireRepository.save(commentaire);
		
			}
		}

		@Override
		public void deleteCommentaire(int idCommentaire) {
			commentaireRepository.delete(idCommentaire);
		}
		
		
}
