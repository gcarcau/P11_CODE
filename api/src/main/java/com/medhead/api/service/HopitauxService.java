package com.medhead.api.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medhead.api.model.Hopitaux;
import com.medhead.api.repository.HopitauxRepository;
import lombok.Data;

@Data
@Service
public class HopitauxService {

	@Autowired
	private HopitauxRepository hopitauxRepository;
	public Optional<Hopitaux> getHopitaux(final long id){
		return hopitauxRepository.findByIdHopitaux(id);
		
	}
	
	public Iterable<Hopitaux> getHopitaux(){
		return hopitauxRepository.findAll();
	}
	
	public Iterable<Hopitaux> getHopitaux(Collection<String> lstId){
		return hopitauxRepository.findByIdList(lstId);
	}
	
	public void deleteHopitaux(final Long id) {
		hopitauxRepository.deleteById(id);
	}
	
	public Hopitaux saveHopitaux(Hopitaux hopitaux) {
		Hopitaux savedHopitaux = hopitauxRepository.save(hopitaux);
		return savedHopitaux;
	}

}