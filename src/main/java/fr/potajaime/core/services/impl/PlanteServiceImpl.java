package fr.potajaime.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.potajaime.core.entities.Plante;
import fr.potajaime.core.repositories.PlanteRepository;
import fr.potajaime.core.services.PlanteService;

@Service
public class PlanteServiceImpl implements PlanteService{

	@Autowired
	PlanteRepository planteRepository;

	@Override
	public void addPlante(Plante plante) {
		planteRepository.save(plante);
	}

	@Override
	public Plante getPlanteById(int idPlante) {

		return planteRepository.findOne(idPlante);
	}

	@Override
	public List<Plante> getAllPlantes() {
		List<Plante> plantes = new ArrayList<>();
		planteRepository.findAll().forEach(plantes::add);
		return plantes;
	}

	@Override
	public void updatePlante(Plante plante, int idPlante) {
		if(getPlanteById(idPlante) != null){
			planteRepository.save(plante);
		}
	}

	@Override
	public void deletePlante(int idPlante) {
		planteRepository.delete(idPlante);
	}
	
	
}
