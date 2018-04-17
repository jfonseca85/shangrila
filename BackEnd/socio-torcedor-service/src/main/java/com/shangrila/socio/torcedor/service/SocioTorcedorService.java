package com.shangrila.socio.torcedor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangrila.socio.torcedor.model.Socio;
import com.shangrila.socio.torcedor.repository.SocioRepository;

@Service
public class SocioTorcedorService {

	@Autowired
	private SocioRepository repository;

	public List<Socio> findAll() {
		return repository.findAll();
	}

	public Socio save(Socio socio) {
		return repository.save(socio);
	}

	public Socio findByEmail(String email) {
		return repository.findByEmail(email);
	}

}
