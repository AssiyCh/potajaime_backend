package fr.potajaime.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.potajaime.core.entities.Zone;
import fr.potajaime.core.services.PotagerService;
import fr.potajaime.core.services.ZoneService;

@RestController
@RequestMapping("/zone")
public class ZoneController {

	@Autowired
	ZoneService zoneService;
	
	@Autowired
	PotagerService potagerService;
	
	@RequestMapping(value= "/add",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void addZone(@RequestBody Zone Zone){
		zoneService.addZone(Zone);
	}
	
	@RequestMapping(value = "/get/{idZone}")
    public Zone getZoneById(@PathVariable int idZone) {
        return zoneService.getZoneById(idZone);
    }
	
	@RequestMapping(value = "/get/all") 
	public List<Zone> getAllZones() {
		return zoneService.getAllZones();
	}

    @RequestMapping(value= "/update/{idZone}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateZone(@RequestBody Zone Zone, @PathVariable int idZone) {
    	zoneService.updateZone(Zone, idZone);
    }

    @RequestMapping(value = "/delete/{idZone}", method = RequestMethod.DELETE) 
    public void deleteZone(@PathVariable int idZone) {
    	zoneService.deleteZone(idZone); 
    }
    
    //TODO
    //ajout services en relation
}
