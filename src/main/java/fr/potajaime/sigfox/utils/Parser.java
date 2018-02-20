package fr.potajaime.sigfox.utils;

import fr.potajaime.core.entities.Indicateur;


public interface Parser {
	
	public Indicateur parse(String data) throws Exception;

}
