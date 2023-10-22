package com.medhead.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medhead.api.model.Specialisations;

@Repository
public interface SpecialisationsRepository extends CrudRepository<Specialisations, Long> {
	@Query(value="SELECT DISTINCT specialisations.* FROM specialisations WHERE specialisations.groupe = :nom",nativeQuery=true)
	 public Specialisations findByName(@Param("nom") String Name);
	
	@Query(value="SELECT * FROM specialisations WHERE specialisations.id = :id",nativeQuery = true)
	public Specialisations findByIdSpecialisations(@Param("id") Long idSpecialisation);
}
