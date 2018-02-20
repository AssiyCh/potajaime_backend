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
import fr.potajaime.core.entities.Tutoriel;
import fr.potajaime.core.services.PotagerService;
import fr.potajaime.core.services.TutorielService;

@RestController
@RequestMapping("/tutoriel")
public class TutorielController {

	@Autowired
	TutorielService tutorielService;
	
	@Autowired
	PotagerService potagerService;

	@RequestMapping( value= "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void addTutoriel(@RequestBody Tutoriel tutoriel){
		tutorielService.addTutoriel(tutoriel);
	}
	
	@RequestMapping(value = "/get/{idTutoriel}")
    public Tutoriel getTutorielById(@PathVariable int idTutoriel) {
        return tutorielService.getTutorielById(idTutoriel);
    }
	
	@RequestMapping(value = "/get/all") 
	public List<Tutoriel> getAllTutoriels() {
		return tutorielService.getAllTutoriels();
	}

    @RequestMapping(value = "/update/{idTutoriel}" , method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTutoriel(@RequestBody Tutoriel tutoriel, @PathVariable int idTutoriel) {
    	tutorielService.updateTutoriel(tutoriel, idTutoriel);
    }

    @RequestMapping(value = "/delete/{idTutoriel}", method = RequestMethod.DELETE) 
    public void deleteTutoriel(@PathVariable int idTutoriel) {
    	tutorielService.deleteTutoriel(idTutoriel); 
    }
    
    //En se basant sur la relation entre le tutoriel et le potager 
    
	@RequestMapping(value = "/potager/{idPotager}/getTutos") 
    public List<Tutoriel> getTutorielOfPotagerById(@PathVariable int idPotager) {
        return potagerService.getPotagerById(idPotager).getTutoriels();
    }
	
	@RequestMapping(value = "/potager/{idPotager}/deleteTutos")
	public void deleteTutorielsOfPotagerById(@PathVariable int idPotager){
		 List<Tutoriel> tutoriels = potagerService.getPotagerById(idPotager).getTutoriels();
		 for (Tutoriel tutoriel : tutoriels) {
			tutorielService.deleteTutoriel(tutoriel.getIdTutoriel());
		}
	}
}
