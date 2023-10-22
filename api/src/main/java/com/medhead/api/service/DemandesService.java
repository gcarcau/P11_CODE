package com.medhead.api.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medhead.api.model.Demandes;
import com.medhead.api.repository.DemandesRepository;
import lombok.Data;

@Data
@Service
public class DemandesService {

	@Autowired
	private DemandesRepository demandesRepository;
	public Optional<Demandes> getHopitaux(final long id){
		return demandesRepository.findByIdDemandes(id);
		
	}
	
	public Iterable<Demandes> getDemandes(){
		return demandesRepository.findAll();
	}
	
	public Iterable<Demandes> getDemandes(Collection<String> lstId){
		return demandesRepository.findByIdList(lstId);
	}
	
	public void deleteDemandes(final Long id) {
		demandesRepository.deleteById(id);
	}
	
	public Demandes saveDemandes(Demandes demandes) {
		Demandes savedDemandes = demandesRepository.save(demandes);
		return savedDemandes;
	}
	
	

}