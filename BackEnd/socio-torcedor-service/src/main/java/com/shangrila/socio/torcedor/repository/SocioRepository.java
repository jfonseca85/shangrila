package com.shangrila.socio.torcedor.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.shangrila.socio.torcedor.model.Socio;
import com.shangrila.socio.torcedor.model.SocioId;

@Repository
@RepositoryRestResource(collectionResourceRel="socios", path="socios")
public interface SocioRepository extends JpaQueryDslPredicateRepository<Socio, SocioId> {

	Socio findByEmail(String email);	
	
}