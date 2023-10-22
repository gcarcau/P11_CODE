package com.medhead.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medhead.api.model.Specialisations;
import com.medhead.api.repository.SpecialisationsRepository;


import lombok.Data;

@Data
@Service
public class SpecialisationsService {
	@Autowired
	private SpecialisationsRepository specialisationRepository;

	public Specialisations getSpecialisations(final Long id) {
		return specialisationRepository.findByIdSpecialisations(id);
	}

	public Iterable<Specialisations> getSpecialisations() {
		return specialisationRepository.findAll();
	}

	public Specialisations getSpecialisations(String name) {
		return specialisationRepository.findByName(name);
	}
}
