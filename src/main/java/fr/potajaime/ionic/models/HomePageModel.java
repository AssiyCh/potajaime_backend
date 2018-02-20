package fr.potajaime.ionic.models;

import java.util.List;

public class HomePageModel {
	
	private float humidity;
	private float temperature;
	private float water;
	private float light;
	
	private List<EvenementModel> evenements;

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getWater() {
		return water;
	}

	public void setWater(float water) {
		this.water = water;
	}

	public float getLight() {
		return light;
	}

	public void setLight(float light) {
		this.light = light;
	}

	public List<EvenementModel> getEvenements() {
		return evenements;
	}

	public void setEvenements(List<EvenementModel> evenements) {
		this.evenements = evenements;
	}
	
}
