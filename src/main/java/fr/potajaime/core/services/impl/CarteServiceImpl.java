package fr.potajaime.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.potajaime.core.entities.Carte;
import fr.potajaime.core.repositories.CarteRepository;
import fr.potajaime.core.services.CarteService;

@Service
public class CarteServiceImpl implements CarteService{

	@Autowired
	CarteRepository carteRepository;
	
	@Override
	public void addCarte(Carte carte) {
		carteRepository.save(carte);
	}

	@Override
	public Carte getCarteById(String idCarte) {
		return carteRepository.findOne(idCarte);
	}

	@Override
	public List<Carte> getAllCartes() {
		List<Carte> cartes = new ArrayList<>();
		carteRepository.findAll().forEach(cartes::add);
		return cartes;
	}

	@Override
	public void updateCarte(Carte carte, String idCarte) {
		if(getCarteById(idCarte)!= null){
			carteRepository.save(carte);
		}
	}

	@Override
	public void deleteCarte(String idCarte) {
		carteRepository.delete(idCarte);
	}

	
}
