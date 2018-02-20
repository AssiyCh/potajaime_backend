package fr.potajaime.ionic.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import fr.potajaime.core.services.UtilisateurServices;
import fr.potajaime.ionic.models.UtilisateurModel;



@RestController
@CrossOrigin(origins="*")
public class SignupController {

	@Autowired
	private UtilisateurServices utilisateurServices;


    
    @PostMapping("/signup")
    public String signUp( @RequestBody UtilisateurModel user) {
    	UtilisateurModel utilisateurModel = utilisateurServices.addUtilisateur(user);
    	if(utilisateurModel != null) {
    		return String.valueOf(utilisateurModel.getPotagerId());
    	}else {
    		return "Error";
    	}
    }
    
    
    
  
    
    
    
    
 
}
