package fr.potajaime.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.potajaime.core.entities.Indicateur;
import fr.potajaime.core.services.IndicateurService;
import fr.potajaime.core.services.PotagerService;

@RestController
@RequestMapping("/indicateur")
public class IndicateurController {

	@Autowired
	IndicateurService indicateurService;
	
	@Autowired
	PotagerService potagerService;
	
	@RequestMapping(value="/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void addIndicateur(@RequestBody Indicateur Indicateur){
		indicateurService.addIndicateur(Indicateur);
	}
	
	@RequestMapping(value = "/get/{idIndicateur}")
    public Indicateur getIndicateurById(@PathVariable int idIndicateur) {
        return indicateurService.getIndicateurById(idIndicateur);
    }
	
	@RequestMapping(value = "/get/all") 
	public List<Indicateur> getAllIndicateurs() {
		return indicateurService.getAllIndicateurs();
	}
	
	@RequestMapping(value= "/update/{idIndicateur}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateIndicateur(@RequestBody Indicateur Indicateur, @PathVariable int idIndicateur) {
		indicateurService.updateIndicateur(Indicateur, idIndicateur);
    }

    @RequestMapping(value = "/delete/{idIndicateur}", method = RequestMethod.DELETE) 
    public void deleteIndicateur(@PathVariable int idIndicateur) {
    	indicateurService.deleteIndicateur(idIndicateur); 
    }
    
    //En se basant sur la relation entre le Indicateur et le potager 
    
	@RequestMapping(value = "/getIndicateurs/potager/{idPotager}") 
    public List<Indicateur> getIndicateurOfPotagerById(@PathVariable int idPotager) {
        return potagerService.getPotagerById(idPotager).getIndicateurs();
    }
	
	@RequestMapping(value = "/potager/{idPotager}/deleteIndicateurs")
	public void deleteIndicateursOfPotagerById(@PathVariable int idPotager){
		 List<Indicateur> Indicateurs = potagerService.getPotagerById(idPotager).getIndicateurs();
		 for (Indicateur Indicateur : Indicateurs) {
			 indicateurService.deleteIndicateur(Indicateur.getIdIndicateur());
		}
	}
}
