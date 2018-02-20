package fr.potajaime.ionic.models;

import java.util.ArrayList;
import java.util.List;

import fr.potajaime.core.entities.Evenement;
import fr.potajaime.core.entities.Potager;
import fr.potajaime.core.entities.Zone;

public class ModelsAdapter {
	
	
	
	public HomePageModel getHomePageModelFrom(Potager potager) {
		
		HomePageModel homePageModel = new HomePageModel();
		homePageModel.setHumidity(potager.getIndicateurs().get(potager.getIndicateurs().size()-1).getHumidity());
		homePageModel.setTemperature(potager.getIndicateurs().get(potager.getIndicateurs().size()-1).getTemprature());
		homePageModel.setWater(100);
		homePageModel.setLight(100);
		homePageModel.setEvenements(zoneEvenementToModels(potager.getZones()));

		return homePageModel;
	}
	
	
	
	
	public List<EvenementModel> zoneEvenementToModels(List<Zone> zones){
		
		List<EvenementModel> evenementModels = new ArrayList<>();
		
		if( zones != null)
			for( Zone zone : zones)
				evenementModels.addAll(evenementsToEvenemeModel(zone.getEvenements()));
		
		return evenementModels;
	}
	
	
	
	
	
	public List<EvenementModel> evenementsToEvenemeModel(List<Evenement> evenements){
		
		List<EvenementModel> evenementModels = new ArrayList<>();
		
		if( evenementModels != null)
			for( Evenement evenement : evenements ) {
				EvenementModel model = new EvenementModel();
				model.setDateDebut(evenement.getDateDebut());
				model.setDateFin(evenement.getDateFin());
				model.setDone(evenement.isDone());
				model.setLabel(evenement.getLabel());
				model.setIdEvenement(evenement.getIdEvenement());
				evenementModels.add(model);
			}
				
			
		return evenementModels;
	}

	
	
	
}
