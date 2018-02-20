package fr.potajaime.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.potajaime.core.entities.Indicateur;
import fr.potajaime.core.repositories.IndicateurRepository;
import fr.potajaime.core.services.IndicateurService;

@Service
public class IndicateurServiceImpl  implements IndicateurService{
	
	@Autowired
	IndicateurRepository indicateurRepository;

	@Override
	public void addIndicateur(Indicateur indicateur) {
		indicateurRepository.save(indicateur);
		
	}

	@Override
	public Indicateur getIndicateurById(int idIndicateur) {
		return indicateurRepository.findOne(idIndicateur);
	}

	@Override
	public List<Indicateur> getAllIndicateurs() {
		List<Indicateur> indicateurs = new ArrayList<>();
		indicateurRepository.findAll().forEach(indicateurs::add);
		return indicateurs;
	}

	@Override
	public void updateIndicateur(Indicateur indicateur, int idIdicateur) {
		if(getIndicateurById(idIdicateur) != null){
			indicateurRepository.save(indicateur);
		}
	}

	@Override
	public void deleteIndicateur(int idIndicateur) {
		indicateurRepository.delete(idIndicateur);
	}
	
	
}
