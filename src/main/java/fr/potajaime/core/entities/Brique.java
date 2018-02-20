package fr.potajaime.core.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Brique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idBrique;
	private String typeBrique;
	
	@ManyToMany(mappedBy = "briques")
	private List<Zone> zones;
	
	public Brique() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Brique(int idBrique, String typeBrique) {
		super();
		this.idBrique = idBrique;
		this.typeBrique = typeBrique;
	}
	
	public Brique(String typeBrique) {
		super();
		this.typeBrique = typeBrique;
	}
	
	public int getIdBrique() {
		return idBrique;
	}
	
	public void setIdBrique(int idBrique) {
		this.idBrique = idBrique;
	}
	
	public String getTypeBrique() {
		return typeBrique;
	}
	
	public void setTypeBrique(String typeBrique) {
		this.typeBrique = typeBrique;
	}

	public List<Zone> getZones() {
		return zones;
	}

	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}
	
	
}
