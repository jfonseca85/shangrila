package com.shangrila.marketing.campaing.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.shangrila.marketing.campaing.model.Campaing;
import com.shangrila.marketing.campaing.model.QCampaing;
import com.shangrila.marketing.campaing.repository.CampingRepository;

@Service
public class MarkectingCampaingService {

	@Autowired
	private CampingRepository repository;

	public List<Campaing> retrieveMarketingCampaignEffective(MultiValueMap<String, String> parameters) {

		BooleanExpression dateEndCampaingExpression = QCampaing.campaing.dateEndCampaing.after(LocalDate.now());

		if (parameters.isEmpty())
			return repository.findAll(dateEndCampaingExpression);

		try {
		
			String idSoccerTeam = parameters.getFirst("idSoccerTeam");
			BooleanExpression idSoccerTeamPrecicate = QCampaing.campaing.idSoccerTeam.eq(Integer.parseInt(idSoccerTeam));
			BooleanExpression SoccerTeamPrecicateEffective = dateEndCampaingExpression.and(idSoccerTeamPrecicate);
			return repository.findAll(SoccerTeamPrecicateEffective);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public Campaing save(Campaing campaing) {
		return repository.save(campaing);
	}

	public void deleteById(int id) {
		repository.deleteById(id);

	}

	public Optional<Campaing> findByDateEndCampaingGreaterThanAndIdCampaing(LocalDate time, int id) {
		return repository.findByDateEndCampaingGreaterThanAndIdCampaing(time, id);
	}

}
