package com.shangrila.marketing.campaing.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shangrila.marketing.campaing.exception.CampaingBadRequestException;
import com.shangrila.marketing.campaing.exception.CampaingNotFoundException;
import com.shangrila.marketing.campaing.model.Campaing;
import com.shangrila.marketing.campaing.service.MarkectingCampaingService;
import com.shangrila.marketing.campaing.util.MarketingCampaingBussines;

@RestController
public class MarketingCampaingController {

	@Autowired
	private MarkectingCampaingService service;
	@Autowired
	private MarketingCampaingBussines bussines;

	@GetMapping(path = "/marketing-campaing-service/campaings")
	@HystrixCommand(fallbackMethod="fallbackRetrieve")
	public List<Campaing> retrieveCampaingFilter(@RequestParam final MultiValueMap<String, String> parameters) {
		try {
			List<Campaing> resultList = service.retrieveMarketingCampaignEffective(parameters);
			if (resultList.isEmpty()) throw new CampaingNotFoundException("Not Found");
			
			return resultList;
			
		} catch (NullPointerException e) {
			throw new CampaingBadRequestException("Only the property idSoccerTeam is valid eg.: <PATH>?idSoccerTeam=20002");
		}
	}
	
	public List<Campaing>  fallbackRetrieve(MultiValueMap<String, String> parameters) {
			System.out.println("<<<<<<<<<>>>>>>>>>>>>>>>>");
		return new ArrayList<Campaing>();
	}

	@GetMapping(path = "/marketing-campaing-service/campaings/{id}")
	public Campaing retrieveCampaing(@PathVariable int id) {

		Optional<Campaing> campaing = service.findByDateEndCampaingGreaterThanAndIdCampaing(LocalDate.now(), id);

		if (!campaing.isPresent())
			throw new CampaingNotFoundException("id -" + id);

		Campaing resource = campaing.get();
//		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveCampaingFilter(null));
//		resource.add(linkTo.withRel("all-campaings"));
		return resource;
	}

//	@DeleteMapping(path = "/marketing-campaing-service/campaings/{id}")
//	public void deleteCampaing(@PathVariable int id) {
//		service.deleteById(id);
//	}

	@PostMapping(path = "/marketing-campaing-service/campaings/")
	public ResponseEntity<Object> createMarketingCampaing(@Valid @RequestBody Campaing campaing) {
		List<Campaing> resultList = service.retrieveMarketingCampaignEffective(null);
		
		Comparator<Campaing> c = new Comparator<Campaing>() {
			public int compare(Campaing u1, Campaing u2) {
				return u1.getDateEndCampaing().compareTo(u2.getDateEndCampaing());
			}
		};

		resultList.sort(c);
		bussines.indexedBinarySearch(resultList, campaing);
		Campaing savedCampaing = service.save(campaing);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCampaing.getIdCampaing()).toUri();
		return ResponseEntity.created(location).build();

	}

//	@PutMapping(path = "/marketing-campaing-service/campaings")
//	public ResponseEntity<Object> editMarketingCampaing(@Valid @RequestBody Campaing campaing) {
//
//		if (campaing.getIdCampaing() == null)
//			throw new CampaingBadRequestException("Campaign id is null >> " + campaing.getIdCampaing());
//
//		Campaing savedCampaing = service.save(campaing);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedCampaing.getIdCampaing()).toUri();
//		return ResponseEntity.created(location).build();
//
//	}

}
