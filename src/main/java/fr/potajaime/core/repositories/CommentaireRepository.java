package fr.potajaime.core.repositories;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.potajaime.core.entities.Commentaire;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire, Serializable> {

}
