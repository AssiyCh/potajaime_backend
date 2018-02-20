package fr.potajaime.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.potajaime.core.entities.Carte;
import fr.potajaime.core.entities.Potager;
import fr.potajaime.core.entities.ReservoireEau;
import fr.potajaime.core.entities.Utilisateur;
import fr.potajaime.core.repositories.UtilisateurRepository;
import fr.potajaime.core.services.CarteService;
import fr.potajaime.core.services.PotagerService;
import fr.potajaime.core.services.UtilisateurServices;
import fr.potajaime.ionic.models.UtilisateurModel;

@Service
public class UtilisateurServicesImpl  implements UtilisateurServices{

	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private CarteService carteService;
	
	@Autowired
	private PotagerService potagerService;
	
	@Override
	public UtilisateurModel addUtilisateur( UtilisateurModel user) {
		
		Utilisateur u = new Utilisateur(user.getNom(), user.getPrenom(), user.getEmail());
		u.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		Carte carte = carteService.getCarteById(user.getCarteId());
		
		Potager potager = new Potager();
		potager.setCarte(carte);
		potager.setUtilisateur(u);
		potager.setNomPotager("NomPotager");
		
		ReservoireEau eau = new ReservoireEau("");
		potager.setReservoireEau(eau);
		carte.setPotager(potager);
		potagerService.addPotager(potager);

		if(utilisateurRepository.save(u) != null) {
			user.setPotagerId(potager.getIdPotager());
			return user;
		}else 
			return null;
		
		
	}

	@Override
	public boolean updateUtilisateur(UtilisateurModel user) {
		// TODO Auto-generated method stub
		return false;
	}

}
