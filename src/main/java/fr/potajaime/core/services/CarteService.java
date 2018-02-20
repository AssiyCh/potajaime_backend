package fr.potajaime.core.services;

import java.util.List;
import fr.potajaime.core.entities.Carte;


public interface CarteService {

	public void addCarte(Carte carte);
	
	public Carte getCarteById(String idCarte);
	
	public List<Carte> getAllCartes();
	
	public void updateCarte(Carte carte , String idCarte);
	
	public void deleteCarte(String idCarte);
}
