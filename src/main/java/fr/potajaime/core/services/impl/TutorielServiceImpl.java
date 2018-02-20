package fr.potajaime.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.potajaime.core.entities.Tutoriel;
import fr.potajaime.core.repositories.TutorielRepository;
import fr.potajaime.core.services.TutorielService;

@Service
public class TutorielServiceImpl implements TutorielService {

	@Autowired
	TutorielRepository tutorielRepository;

	public void addTutoriel(Tutoriel tutoriel) {
		tutorielRepository.save(tutoriel);
	}

	public Tutoriel getTutorielById(int idTutoriel) {
		return tutorielRepository.findOne(idTutoriel);
	}

	public List<Tutoriel> getAllTutoriels() {
		List<Tutoriel> potagers = new ArrayList<>();
		tutorielRepository.findAll().forEach(potagers::add);
		return potagers;
	}

	public void updateTutoriel(Tutoriel tutoriel, int idTutoriel) {
			if (getTutorielById(idTutoriel) != null) {
				tutorielRepository.save(tutoriel);
			}
	}

	public void deleteTutoriel(int idTutoriel) {
		tutorielRepository.delete(idTutoriel);
	}

}
