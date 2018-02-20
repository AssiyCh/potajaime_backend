package fr.potajaime.core.services;

import java.util.List;

import fr.potajaime.core.entities.Evenement;

public interface EvenementService {

	public void addEvenement(Evenement evenement);
	
	public Evenement getEvenementById(int idEvenement);
	
	public List<Evenement> getAllEvenements();
	
	public void updateEvenement(Evenement evenement, int idEvenement);
	
	public void deleteEvenement(int idEvenement);
	
}
