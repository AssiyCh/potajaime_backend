package fr.potajaime.ionic.controllers;

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
import fr.potajaime.ionic.models.HomePageModel;
import fr.potajaime.ionic.models.ModelsAdapter;

@RestController(value="ionicPotagerController")
@RequestMapping("/ionic/potager")
public class PotagerController {
	
	@Autowired
	private PotagerService potagerService;
	
	ModelsAdapter adapter = new ModelsAdapter();

	@RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void addPotager(@RequestBody Potager potager){
		potagerService.addPotager(potager);
	}
	
	@RequestMapping(value = "/home/{idPotager}") 
    public HomePageModel getPotagerById(@PathVariable int idPotager) {
		Potager potager = potagerService.getPotagerById(idPotager);
		HomePageModel pageModel = adapter.getHomePageModelFrom(potager);
        return pageModel;
    }
	
	@RequestMapping(value = "/all") 
	public List<Potager> getAllPotagers() {
		
		return potagerService.getAllPotagers();
	}

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePotager(@RequestBody Potager potager, @PathVariable int idPotager) {
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
    public void deletePotager(@PathVariable int idPotager) {
    	potagerService.deletePotager(idPotager); 
    }
}
