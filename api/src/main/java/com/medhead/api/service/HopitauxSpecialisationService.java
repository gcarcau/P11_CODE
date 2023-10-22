package com.medhead.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medhead.api.model.HopitauxSpecialisation;
import com.medhead.api.repository.HopitauxSpecialisationRepository;

import lombok.Data;

@Data
@Service
public class HopitauxSpecialisationService {
	@Autowired()
    private HopitauxSpecialisationRepository hopitauxSpecialisationRepository;
	
	public Iterable<HopitauxSpecialisation> getHSByIdSpec(final Long id) {
        return hopitauxSpecialisationRepository.findByIDSpecialisation(id);
    }
	 
	 public Iterable<HopitauxSpecialisation> getHopitauxSpecialisation() {
	        return hopitauxSpecialisationRepository.findAll();
	    }
	 
	 public HopitauxSpecialisation saveHS(HopitauxSpecialisation HS) {
		 HopitauxSpecialisation savedHS = hopitauxSpecialisationRepository.save(HS);
		 return savedHS;
	 }
	
}
