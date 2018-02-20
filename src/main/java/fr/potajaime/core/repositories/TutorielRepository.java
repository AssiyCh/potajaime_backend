package fr.potajaime.core.repositories;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.potajaime.core.entities.Tutoriel;

@Repository
public interface TutorielRepository extends CrudRepository<Tutoriel, Serializable>{

}
