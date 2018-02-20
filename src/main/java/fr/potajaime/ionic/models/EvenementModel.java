package fr.potajaime.ionic.models;

import java.util.Date;

public class EvenementModel {
	
	private int idEvenement;
	private String label;
	private Date dateDebut;
	private Date dateFin;
	
	private boolean done;

	public int getIdEvenement() {
		return idEvenement;
	}

	public void setIdEvenement(int idEvenement) {
		this.idEvenement = idEvenement;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}


}
