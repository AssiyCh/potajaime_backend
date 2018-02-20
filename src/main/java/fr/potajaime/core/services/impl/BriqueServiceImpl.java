package fr.potajaime.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.potajaime.core.entities.Brique;
import fr.potajaime.core.repositories.BriqueRepository;
import fr.potajaime.core.services.BriqueService;

@Service
public class BriqueServiceImpl implements BriqueService {

	@Autowired
	BriqueRepository briqueRepository;
	
	@Override
	public void addBrique(Brique brique) {
		briqueRepository.save(brique);
	}

	@Override
	public Brique getBriqueById( int idBrique) {
		
		return briqueRepository.findOne(idBrique);
	}

	@Override
	public List<Brique> getAllBriques() {
		
		List<Brique> briques = new ArrayList<>();
		briqueRepository.findAll().forEach(briques::add);
		return briques;
	}

	@Override
	public void updateBrique(Brique brique, int idBrique) {
		//Brique briqueAmodifier
		if(getBriqueById(idBrique)!= null){
			briqueRepository.save(brique);
			}
	}

	@Override
	public void deleteBrique(int idBrique) {
		briqueRepository.delete(idBrique);
	}

}
