package com.medhead.api.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="demandes")
public class Demandes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="date")
	private Date date;
	
	//adresse saisie
	@Column(name="adresse") 
	private String adresse;
	
	//Hopital retourné si un hopital a été trouvé , Message d'erreur en cas d'erreur
	@Column(name="retour") 
	private String retour;
		
}