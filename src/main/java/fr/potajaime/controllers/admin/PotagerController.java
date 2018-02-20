package fr.potajaime.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.potajaime.core.entities.Potager;
import fr.potajaime.core.services.PotagerService;

@RestController
@RequestMapping("/potager")
public class PotagerController {
	
	@Autowired
	private PotagerService potagerService;

	@RequestMapping( value="/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void addPotager(@RequestBody Potager potager){
		potagerService.addPotager(potager);
	}
	
	@RequestMapping(value = "/get/{idPotager}") 
    public Potager getPotagerById(@PathVariable int idPotager) {
        return potagerService.getPotagerById(idPotager);
    }
	
	@RequestMapping(value = "/get/all") 
	public List<Potager> getAllPotagers() {
		
		return potagerService.getAllPotagers();
	}

    @RequestMapping(value= "/update/{idPotager}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePotager(@RequestBody Potager potager, @PathVariable int idPotager) {
    }

    @RequestMapping(value = "/delete/{idPotager}", method = RequestMethod.DELETE) 
    public void deletePotager(@PathVariable int idPotager) {
    	potagerService.deletePotager(idPotager); 
    }
}
