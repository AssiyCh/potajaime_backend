package fr.potajaime.core.services;

import java.util.List;

import fr.potajaime.core.entities.Brique;

public interface BriqueService {

	public void addBrique(Brique brique);
	
	public Brique getBriqueById(int idBrique);
	
	public List<Brique> getAllBriques();
	
	public void updateBrique(Brique brique, int idBrique);
	
	public void deleteBrique(int idBrique);
	
}
