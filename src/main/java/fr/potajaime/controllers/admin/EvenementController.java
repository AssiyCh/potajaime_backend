package fr.potajaime.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.potajaime.core.entities.Evenement;
import fr.potajaime.core.services.EvenementService;

@RestController
@RequestMapping("/evenement")
public class EvenementController {

	@Autowired
	EvenementService evenementService;
	
	@RequestMapping( value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void addEvenement(@RequestBody Evenement Evenement){
		evenementService.addEvenement(Evenement);
	}
	
	@RequestMapping(value = "/get/{idEvenement}")
    public Evenement getEvenementById(@PathVariable int idEvenement) {
        return evenementService.getEvenementById(idEvenement);
    }
	
	@RequestMapping(value = "/get/all") 
	public List<Evenement> getAllEvenements() {
		return evenementService.getAllEvenements();
	}

    @RequestMapping(value = "/update/{idEvenement}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEvenement(@RequestBody Evenement Evenement, @PathVariable int idEvenement) {
    	evenementService.updateEvenement(Evenement, idEvenement);
    }

    @RequestMapping(value = "/delete/{idEvenement}", method = RequestMethod.DELETE) 
    public void deleteEvenement(@PathVariable int idEvenement) {
    	evenementService.deleteEvenement(idEvenement); 
    }
}
