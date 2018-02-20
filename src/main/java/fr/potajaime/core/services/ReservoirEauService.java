package fr.potajaime.core.services;

import java.util.List;

import fr.potajaime.core.entities.ReservoireEau;

public interface ReservoirEauService {

	public void addReservoireEau(ReservoireEau reservoireEau);
	
	public ReservoireEau getReservoireEauById(int idReservoireEau);
	
	public List<ReservoireEau> getAllReservoiresEau();
	
	public void updateReservoireEau(ReservoireEau reservoireEau, int idReservoire);
	
	public void deleteReservoireEeau(int idReservoireEau);
}
