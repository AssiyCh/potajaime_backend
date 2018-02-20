package fr.potajaime.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.potajaime.core.entities.Carte;
import fr.potajaime.core.services.CarteService;
import fr.potajaime.core.services.PotagerService;

@RestController
@RequestMapping("/carte")
public class CarteController {
	
	@Autowired
	CarteService carteService;
	
	@Autowired
	PotagerService potagerService;
	
	@RequestMapping( value="/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void addCarte(@RequestBody Carte carte){
		carteService.addCarte(carte);;
	}
	
	@RequestMapping(value = "/get/{idCarte}")
    public Carte getCarteById(@PathVariable String idCarte) {
        return carteService.getCarteById(idCarte);
    }
	
	@RequestMapping(value = "/get/all") 
	public List<Carte> getAllCartes() {
		return carteService.getAllCartes();
	}

    @RequestMapping(value = "/update/{idCarte}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCarte(@RequestBody Carte carte, @PathVariable String idCarte) {
    	carteService.updateCarte(carte, idCarte);
    }

    @RequestMapping(value = "/delete/{idCarte}", method = RequestMethod.DELETE) 
    public void deleteCarte(@PathVariable String idCarte) {
    	carteService.deleteCarte(idCarte); 
    }
    
    //la relation avec le potager
    @RequestMapping(value= "/get/potager/{idPotager}")
    public Carte getCarteByIdPotager(@PathVariable int idPotager){
    	return potagerService.getPotagerById(idPotager).getCarte();
    }
    
    //TODO
    @RequestMapping(value ="/delete/potager/{idPotager}", method = RequestMethod.DELETE)
    public void deleteCarteByIdPotager(@PathVariable int idPotager){
    	Carte carte = potagerService.getPotagerById(idPotager).getCarte();
    	if(carte.getIdCarte() != null)
    		carteService.deleteCarte(carte.getIdCarte());
    	
    }
	
}
