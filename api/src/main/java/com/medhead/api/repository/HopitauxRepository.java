package com.medhead.api.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medhead.api.model.Hopitaux;


@Repository
public interface HopitauxRepository extends CrudRepository<Hopitaux, Long>{
	@Query(value="SELECT * FROM hopitaux WHERE hopitaux.id IN :lstId",nativeQuery = true)
	public Iterable<Hopitaux> findByIdList(@Param("lstId") Collection<String> idList);
	
	@Query(value="SELECT * FROM hopitaux WHERE hopitaux.id = :id",nativeQuery = true)
	public Optional<Hopitaux> findByIdHopitaux(@Param("id") Long idHopitaux);
}
