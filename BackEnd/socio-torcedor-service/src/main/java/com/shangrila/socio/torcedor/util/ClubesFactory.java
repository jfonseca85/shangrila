package com.shangrila.socio.torcedor.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangrila.socio.torcedor.model.Clubes;
import com.shangrila.socio.torcedor.repository.ClubesRepository;

@Component
public class ClubesFactory {
	
	private static final Integer TIME_NAO_CADASTRADO = 999;
	@Autowired
	private ClubesRepository repository;
	
	public Integer createIdClube (String nomeClube) {
		
		List<Clubes> clubesDesc = repository.findAll();
		Integer result = null;
		for (Clubes clubes : clubesDesc) {
			if (clubes.getNomeClube().equalsIgnoreCase(nomeClube)) 
				result = clubes.getIdSoccerTeam();
		}
		
		if (result == null) result = TIME_NAO_CADASTRADO;
		
		return result;
		
	}
}
