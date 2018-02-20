package fr.potajaime.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.potajaime.core.entities.Evenement;
import fr.potajaime.core.repositories.EvenementRepository;
import fr.potajaime.core.services.EvenementService;

@Service
public class EvenementServiceImpl implements EvenementService {

	@Autowired
	EvenementRepository evenementRepository;

	@Override
	public void addEvenement(Evenement evenement) {
		evenementRepository.save(evenement);
	}

	@Override
	public Evenement getEvenementById(int idEvenement) {
		return evenementRepository.findOne(idEvenement);
	}

	@Override
	public List<Evenement> getAllEvenements() {
		List<Evenement> evenements  = new ArrayList<>();
		evenementRepository.findAll().forEach(evenements::add);
		return evenements;
	}

	@Override
	public void updateEvenement(Evenement evenement, int idEvenementAchanger) {
		if(getEvenementById(idEvenementAchanger)!= null){
			evenementRepository.save(evenement);
		}
	}

	@Override
	public void deleteEvenement(int idEvenement) {
		evenementRepository.delete(idEvenement);
	}
}
