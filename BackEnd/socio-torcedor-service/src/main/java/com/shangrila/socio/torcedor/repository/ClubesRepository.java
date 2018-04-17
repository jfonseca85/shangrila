package com.shangrila.socio.torcedor.repository;

import org.springframework.stereotype.Repository;

import com.shangrila.socio.torcedor.model.Clubes;

@Repository
public interface ClubesRepository extends JpaQueryDslPredicateRepository<Clubes, Integer> {
	
}