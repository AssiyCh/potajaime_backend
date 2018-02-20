package fr.potajaime.core.services;

import java.util.List;

import fr.potajaime.core.entities.Zone;

public interface ZoneService {

	public void addZone(Zone zone);
	
	public Zone getZoneById(int idZone);
	
	public List<Zone> getAllZones();
	
	public void updateZone(Zone zone, int idZone);
	
	public void deleteZone(int idZone);
}
