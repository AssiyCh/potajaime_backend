package fr.potajaime.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.potajaime.core.entities.Plante;
import fr.potajaime.core.services.PlanteService;

@RestController
@RequestMapping("/plante") 
public class PlanteController {

	@Autowired
	PlanteService planteService;
	
	@RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void addPlante(@RequestBody Plante Plante){
		planteService.addPlante(Plante);
	}
	
	@RequestMapping(value = "/get/{idPlante}")
    public Plante getPlanteById(@PathVariable int idPlante) {
        return planteService.getPlanteById(idPlante);
    }
	
	@RequestMapping(value = "/get/all") 
	public List<Plante> getAllPlantes() {
		return planteService.getAllPlantes();
	}

    @RequestMapping(value = "/update/{idPlante}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePlante(@RequestBody Plante Plante, @PathVariable int idPlante) {
    	planteService.updatePlante(Plante, idPlante);
    }

    @RequestMapping(value = "/delete/{idPlante}", method = RequestMethod.DELETE) 
    public void deletePlante(@PathVariable("idPlante") int idPlante) {
    	planteService.deletePlante(idPlante); 
    }
}
