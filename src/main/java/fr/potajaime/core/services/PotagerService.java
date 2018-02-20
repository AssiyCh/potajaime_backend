package fr.potajaime.core.services;

import java.util.List;

import fr.potajaime.core.entities.Potager;

public interface PotagerService {

	public void addPotager(Potager potager);
	
	public Potager getPotagerById(int idPotager);
	
	public List<Potager> getAllPotagers();
	
	public void updatePotager(Potager potager, int idPotager);
	
	public void deletePotager(int idPotager);
}
