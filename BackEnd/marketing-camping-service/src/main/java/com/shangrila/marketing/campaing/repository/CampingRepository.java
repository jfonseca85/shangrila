package com.shangrila.marketing.campaing.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.shangrila.marketing.campaing.model.Campaing;

@Repository
public interface CampingRepository extends JpaQueryDslPredicateRepository<Campaing, Integer> {
	
	public Optional<Campaing> findByDateEndCampaingGreaterThanAndIdCampaing(LocalDate now, Integer id);

	public void deleteByIdCampaing(int id);
	
}