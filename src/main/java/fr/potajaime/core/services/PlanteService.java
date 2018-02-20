package fr.potajaime.core.services;

import java.util.List;

import fr.potajaime.core.entities.Plante;

public interface PlanteService {

	public void addPlante(Plante plante);
	
	public Plante getPlanteById(int idPlante);
	
	public List<Plante> getAllPlantes();
	
	public void updatePlante(Plante plante, int idPlante);
	
	public void deletePlante(int idPlante);
}
