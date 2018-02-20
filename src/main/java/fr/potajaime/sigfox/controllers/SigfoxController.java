package fr.potajaime.sigfox.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.potajaime.core.entities.Indicateur;
import fr.potajaime.sigfox.utils.Parser;
import fr.potajaime.sigfox.utils.SigfoxParser;

@RestController
@CrossOrigin(origins = "*")
public class SigfoxController {
	
	

	List<Indicateur> indicateurs = new ArrayList<Indicateur>();
	@Autowired
	Parser sigfoxParser;
	Logger log;
	
	
	public SigfoxController() {
		//sigfoxParser = new SigfoxParser();
		log = Logger.getLogger(SigfoxController.class);
	}
	
	
	
	@RequestMapping(value="/sigfox", produces = "application/json")
	List<Indicateur> index() {
	  try {
		sigfoxParser.parse("");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return indicateurs;
	}
	  
	  
	
  	@RequestMapping(method = RequestMethod.POST, value="/sigfox/data", produces = "application/json")
	@ResponseBody
	public void getjsonData(@RequestBody String body) {
  		Indicateur indicateur = null;
		try {
			indicateur = sigfoxParser.parse(body);
			log.info("L'indicateur est ajoutée");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		if(indicateur != null) indicateurs.add(indicateur);
	}
  	
  	
	
}
