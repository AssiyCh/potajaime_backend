package fr.potajaime.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.potajaime.core.entities.Zone;
import fr.potajaime.core.repositories.ZoneRepository;
import fr.potajaime.core.services.ZoneService;

@Service
public class ZoneServiceImpl implements ZoneService{
	
	@Autowired
	ZoneRepository zoneRepository;

	@Override
	public void addZone(Zone zone) {
		zoneRepository.save(zone);
	}

	@Override
	public Zone getZoneById(int idZone) {
		return zoneRepository.findOne(idZone);
	}

	@Override
	public List<Zone> getAllZones() {
		List<Zone> zones = new ArrayList<>();
		zoneRepository.findAll().forEach(zones::add);
		return zones;
	}

	@Override
	public void updateZone(Zone zone, int idZone) {
		if (getZoneById(idZone) != null) {
			zoneRepository.save(zone);
		}
	}

	@Override
	public void deleteZone(int idZone) {
		zoneRepository.delete(idZone);
	}
	
	
}
