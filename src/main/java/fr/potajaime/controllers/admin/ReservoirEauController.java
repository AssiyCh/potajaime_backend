package fr.potajaime.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.potajaime.core.entities.ReservoireEau;
import fr.potajaime.core.services.ReservoirEauService;

@RestController
@RequestMapping("/reservoirEau")
public class ReservoirEauController {
	
	@Autowired
	ReservoirEauService reservoirEauService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addReservoirEau(@RequestBody ReservoireEau reservoireEau){
		
		reservoirEauService.addReservoireEau(reservoireEau);
	}
	
	@RequestMapping(value = "/get/{idReservoireEau}")
	public ReservoireEau getReservoirEauById(@PathVariable int idReservoireEau){
	
		return reservoirEauService.getReservoireEauById(idReservoireEau);
	}
	
	@RequestMapping(value="/get/all")
	public List<ReservoireEau> getReservoiresEau(){
		return reservoirEauService.getAllReservoiresEau(); 
	}
	
	@RequestMapping(value = "/update/{idReservoireEau}" , method = RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateReservoireEau(@RequestBody ReservoireEau reservoireEau, @PathVariable int idReservoireEau){
		 reservoirEauService.updateReservoireEau(reservoireEau, idReservoireEau);
		
	}
	
	@RequestMapping(value ="/delete/{idReservoireEau}", method = RequestMethod.DELETE)
	public void deleteReservoirEau(@PathVariable int idReservoireEau){
		reservoirEauService.deleteReservoireEeau(idReservoireEau);
	}
	
	
}
