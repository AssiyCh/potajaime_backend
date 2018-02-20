package fr.potajaime.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.potajaime.core.entities.ReservoireEau;
import fr.potajaime.core.repositories.ReservoirEauRepository;
import fr.potajaime.core.services.ReservoirEauService;

@Service
public class ReservoireEauServiceImpl implements ReservoirEauService {

	@Autowired
	ReservoirEauRepository reservoirEauRepository;

	@Override
	public void addReservoireEau(ReservoireEau reservoireEau) {

		reservoirEauRepository.save(reservoireEau);
	}

	@Override
	public ReservoireEau getReservoireEauById(int idReservoireEau) {
		return reservoirEauRepository.findOne(idReservoireEau);
	}

	@Override
	public List<ReservoireEau> getAllReservoiresEau() {
		List<ReservoireEau> reservoires = new ArrayList<>();
		reservoirEauRepository.findAll().forEach(reservoires::add);
		return reservoires;
	}

	@Override
	public void updateReservoireEau(ReservoireEau reservoireEau, int idReservoire) {
		if(getReservoireEauById(idReservoire) != null){
			reservoirEauRepository.save(reservoireEau);	
		}
	}

	@Override
	public void deleteReservoireEeau(int idReservoireEau) {
		reservoirEauRepository.delete(idReservoireEau);
	}
	
	
}
