package fr.potajaime.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.potajaime.core.entities.Commentaire;
import fr.potajaime.core.services.CommentaireService;
import fr.potajaime.core.services.PlanteService;

@RestController
@RequestMapping("/commentaire")
public class CommentaireController {

	
	@Autowired
	CommentaireService commentaireService;
	
	@Autowired
	PlanteService planteService;
	
	@RequestMapping( value="/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void addCarte(@RequestBody Commentaire commentaire){
		commentaireService.addCommentaire(commentaire);
	}
	
	@RequestMapping(value = "/get/{idCommentaire}")
	public Commentaire getCommentaireById( @PathVariable int idCommentaire){
		return commentaireService.getCommentaireById(idCommentaire);
	}
	
	@RequestMapping(value = "/get/all") 
	public List<Commentaire> getAllCommentaires() {
		return commentaireService.getAllCommentaires();
	}

    @RequestMapping(value = "/update/{idCommentaire}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCommentaire(@RequestBody Commentaire Commentaire, @PathVariable int idCommentaire) {
    	commentaireService.updateCommentaire(Commentaire, idCommentaire);
    }

    @RequestMapping(value = "/delete/{idCommentaire}", method = RequestMethod.DELETE) 
    public void deleteCommentaire(@PathVariable int idCommentaire) {
    	commentaireService.deleteCommentaire(idCommentaire); 
    }
    
    //En se basant sur la relation entre le Commentaire et la plante 
    
	@RequestMapping(value = "/getComments/plante/{idPlante}") 
    public List<Commentaire> getCommentaireOfPlanteById(@PathVariable int idPlante) {
        return planteService.getPlanteById(idPlante).getCommentaires();
    }
	
	@RequestMapping(value = "/deleteCommentaires/plante/{idPlante}")
	public void deleteCommentairesOfPlanteById(@PathVariable int idPlante){
		 List<Commentaire> Commentaires = planteService.getPlanteById(idPlante).getCommentaires();
		 for (Commentaire Commentaire : Commentaires) {
			 commentaireService.deleteCommentaire(Commentaire.getIdCommentaire());
		}
	}
}
