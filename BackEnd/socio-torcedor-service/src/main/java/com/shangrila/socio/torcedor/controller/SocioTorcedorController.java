package com.shangrila.socio.torcedor.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shangrila.socio.torcedor.exception.SocioBadRequestException;
import com.shangrila.socio.torcedor.exception.SocioNotFoundException;
import com.shangrila.socio.torcedor.model.Relacionamento;
import com.shangrila.socio.torcedor.model.Socio;
import com.shangrila.socio.torcedor.proxy.SocioTorcedorServiceProxy;
import com.shangrila.socio.torcedor.repository.RelacionamentoRepository;
import com.shangrila.socio.torcedor.service.SocioTorcedorService;
import com.shangrila.socio.torcedor.util.ClubesFactory;

import io.swagger.annotations.ApiModel;


@RestController
@ApiModel(description = "All details about the SocioController.")
public class SocioTorcedorController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SocioTorcedorService service;

	@Autowired
	private SocioTorcedorServiceProxy proxy;
	
	@Autowired
	private RelacionamentoRepository repositoryRelacionamento;
	
	@Autowired
	private ClubesFactory clubeFactory;

	@Autowired
	private Environment environment;
	
	@GetMapping(path = "/socio-torcedor-service/socios")
	public List<Socio> retrieveSocioFilter() {

		List<Socio> resultList = service.findAll();
		
		if (resultList.isEmpty())
			throw new SocioNotFoundException("Not Found");
		return resultList;

	}

	@GetMapping(path = "/socio-torcedor-service/socios/{id}")
	public Socio retrieveSocio(@PathVariable String id) {

		Socio socio = service.findByEmail(id);
		
		if (socio == null)
			throw new SocioNotFoundException("id -" + id);
	
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveSocioFilter());
		socio.add(linkTo.withRel("all-socios  - Porta  >>> " + environment.getProperty("local.server.port")));
		return socio;
	}
	
	@GetMapping(path = "/socio-torcedor-service/socios/{id}/campaings")
	public List<Relacionamento> retrieveCampaingOfSocio(@PathVariable String id) {
		Socio socio = service.findByEmail(id);
		
		if (socio == null) 
			throw new SocioNotFoundException("id - " + id);
		
		
		Integer idSoccerTeam = clubeFactory.createIdClube(socio.getIdSoccerTeam()+"");
		
		MultiValueMap<String, String> uriVariables = new LinkedMultiValueMap<>();
		uriVariables.add("idSoccerTeam", idSoccerTeam+"");
		Optional<List<Relacionamento>> campaingList = proxy.retrieveTeams(uriVariables);
		
		
		return repositoryRelacionamento.saveAll(campaingList.get());

	}
	

	@PostMapping(path = "/socio-torcedor-service/socios")
	@HystrixCommand(fallbackMethod="fallbackRetrieve")
	public List<Relacionamento> createSocioTorcedor(@Valid @RequestBody Socio socio) {

		Socio findByEmail = service.findByEmail(socio.getEmail());
		// Parametro do fallback
		Integer createIdClube = clubeFactory.createIdClube(socio.getNameSoccer());
		socio.setIdSoccerTeam(createIdClube);

		if (findByEmail != null)
			throw new SocioBadRequestException("Not available");

		 service.save(socio);

		MultiValueMap<String, String> uriVariables = new LinkedMultiValueMap<>();
		uriVariables.add("idSoccerTeam", socio.getIdSoccerTeam() + "");
		// FeignClient
		Optional<List<Relacionamento>> response = proxy.retrieveTeams(uriVariables);

		log.info("{}", response + " Porta do Servico >>>>>>  "+ environment.getProperty("local.server.port"));
		
		
		return repositoryRelacionamento.saveAll(response.get());

	}
	
	public List<Relacionamento>  fallbackRetrieve(Socio socio) {
		log.info("Chamando o fallback");
		List<Relacionamento> result = new ArrayList<>();
		MultiValueMap<String, String> uriVariables = new LinkedMultiValueMap<>();
		uriVariables.add("idSoccerTeam", socio.getIdSoccerTeam()+"");
		Optional<List<Relacionamento>> campaingList = proxy.retrieveTeams(uriVariables);
		if (campaingList.isPresent()) {
			List<Relacionamento> rersource = campaingList.get();
			result =repositoryRelacionamento.saveAll(rersource);
		}
		
		return result;
	}

}
