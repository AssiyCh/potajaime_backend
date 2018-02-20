package fr.potajaime.core.services;

import java.util.List;

import fr.potajaime.core.entities.Tutoriel;

public interface TutorielService {

	public void addTutoriel(Tutoriel tutoriel);
	
	public Tutoriel getTutorielById(int idTutoriel);
	
	public List<Tutoriel> getAllTutoriels();
	
	public void updateTutoriel(Tutoriel tutoriel, int idTutoriel);
	
	public void deleteTutoriel(int idTutoriel);
}
