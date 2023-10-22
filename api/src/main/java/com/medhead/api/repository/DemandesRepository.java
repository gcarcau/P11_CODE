package com.medhead.api.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medhead.api.model.Demandes;


@Repository
public interface DemandesRepository extends CrudRepository<Demandes, Long>{
	@Query(value="SELECT * FROM demandes WHERE demandes.id IN :lstId",nativeQuery = true)
	public Iterable<Demandes> findByIdList(@Param("lstId") Collection<String> idList);
	
	@Query(value="SELECT * FROM demandes WHERE demandes.id = :id",nativeQuery = true)
	public Optional<Demandes> findByIdDemandes(@Param("id") Long idDemandes);
}
