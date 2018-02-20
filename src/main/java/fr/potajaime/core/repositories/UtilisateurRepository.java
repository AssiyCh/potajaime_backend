package fr.potajaime.core.repositories;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.potajaime.core.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Serializable> {
	
    Utilisateur findByEmail(String email);
}
