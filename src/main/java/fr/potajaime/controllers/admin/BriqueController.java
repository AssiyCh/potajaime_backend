package fr.potajaime.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.potajaime.core.entities.Brique;
import fr.potajaime.core.services.BriqueService;

@RestController
@RequestMapping("/brique")
public class BriqueController {

	@Autowired
	BriqueService briqueService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void addBrique(@RequestBody Brique Brique){
		briqueService.addBrique(Brique);
	}
	
	@RequestMapping(value = "/get/{idBrique}")
    public Brique getBriqueById(@PathVariable int idBrique) {
        return briqueService.getBriqueById(idBrique);
    }
	
	@RequestMapping(value = "/get/all") 
	public List<Brique> getAllBriques() {
		return briqueService.getAllBriques();
	}

    @RequestMapping(value = "/update/{idBrique}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBrique(@RequestBody Brique Brique, @PathVariable int idBrique) {
    	briqueService.updateBrique(Brique, idBrique);
    }

    @RequestMapping(value = "/delete/{idBrique}", method = RequestMethod.DELETE) 
    public void deleteBrique(@PathVariable int idBrique) {
    	briqueService.deleteBrique(idBrique); 
    }
}
