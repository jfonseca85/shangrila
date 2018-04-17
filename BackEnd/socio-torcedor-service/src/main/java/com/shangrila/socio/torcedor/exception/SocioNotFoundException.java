package com.shangrila.socio.torcedor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SocioNotFoundException extends RuntimeException {
	public SocioNotFoundException(String message) {
		super(message);
	}
}
