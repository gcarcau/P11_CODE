package com.medhead.api.model;

import lombok.Data;

@Data
public class HopitauxResultat {
	private Long id;
	private String localisation;
	private String distance;
	private Integer nombrelits;
}
