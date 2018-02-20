package fr.potajaime.core.services;


import fr.potajaime.ionic.models.UtilisateurModel;


public interface UtilisateurServices {
	
	public UtilisateurModel addUtilisateur(UtilisateurModel user);
	
	public boolean updateUtilisateur(UtilisateurModel user);
	
}
