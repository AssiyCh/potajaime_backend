package fr.potajaime.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * Classe représentant l'indicateur retourné par le capteur (humidité et température).
 *
 */
@Entity
public class Indicateur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idIndicateur;
	private float humidity;
	private float temprature;
	
	@ManyToOne
	@JoinColumn(name = "potager_id")
	private Potager potager;
	
	
	public Indicateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Indicateur(int idIndicateur, float humidity, Long temprature) {
		super();
		this.idIndicateur = idIndicateur;
		this.humidity = humidity;
		this.temprature = temprature;
	}
	
	public Indicateur(float humidity, Long temprature) {
		super();
		this.humidity = humidity;
		this.temprature = temprature;
	}
	
	public int getIdIndicateur() {
		return idIndicateur;
	}
	
	public void setIdIndicateur(int idIndicateur) {
		this.idIndicateur = idIndicateur;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	
	public float getTemprature() {
		return temprature;
	}
	
	public void setTemprature(float temprature) {
		this.temprature = temprature;
	}

	public Potager getPotager() {
		return potager;
	}

	public void setPotager(Potager potager) {
		this.potager = potager;
	}
	
	
	
	
	
}
