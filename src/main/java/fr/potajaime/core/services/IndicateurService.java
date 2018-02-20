package fr.potajaime.core.services;

import java.util.List;

import fr.potajaime.core.entities.Indicateur;

public interface IndicateurService {

	public void addIndicateur(Indicateur indicateur);
	
	public Indicateur getIndicateurById(int idIndicateur);
	
	public List<Indicateur> getAllIndicateurs();
	
	public void updateIndicateur(Indicateur indicateur, int idIdicateur);
	
	public void deleteIndicateur(int idIndicateur);
	
}
