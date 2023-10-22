package com.medhead.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="hopitaux")
public class Hopitaux {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="localisation")
	private String localisation;
	
	@Column(name="longitude")
	private String longitude;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="nombrelits")
	private Integer nombreLit;
	
	private String distance;
	
	public Long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getNombreLits() {
		try {
			String retour;
			retour = nombreLit.toString();
			return retour;				
		}
		catch(Exception e) {
			return "Erreur NbLits";
		}
	}
	public String getLatitude() {
		return latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public String getLocalisation() {
		return localisation;		
	}
	
}