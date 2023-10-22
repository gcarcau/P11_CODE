package com.medhead.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medhead.api.model.HopitauxSpecialisation;

@Repository
public interface HopitauxSpecialisationRepository extends CrudRepository<HopitauxSpecialisation,Long>{

	@Query(value="SELECT DISTINCT * FROM hopitauxspecialisation WHERE hopitauxspecialisation.idspecialisation = :idspe",nativeQuery=true)
	 public Iterable<HopitauxSpecialisation> findByIDSpecialisation(@Param("idspe") Long idspecialisations);
}
