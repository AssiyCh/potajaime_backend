package fr.potajaime.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.potajaime.core.entities.Potager;
import fr.potajaime.core.repositories.PotagerRepository;
import fr.potajaime.core.services.CarteService;
import fr.potajaime.core.services.PotagerService;

@Service
public class PotagerServiceImpl implements PotagerService {

	@Autowired
	PotagerRepository potagerRepository;
	
	@Autowired
	CarteService carteService;

	
	public void addPotager(Potager potager){
		potagerRepository.save(potager);
	}
	
    public Potager getPotagerById(int idPotager) {
        return potagerRepository.findOne(idPotager);
    }
	
	public List<Potager> getAllPotagers() {
		List<Potager> potagers = new ArrayList<>();
		potagerRepository.findAll().forEach(potagers::add);
		return potagers;
	}

    public void updatePotager(Potager potager, int idPotager) {
    	if(getPotagerById(idPotager) != null){
    		potagerRepository.save(potager);
    	}
    }

    public void deletePotager(int idPotager) {
    	potagerRepository.delete(idPotager); 
    }


}
