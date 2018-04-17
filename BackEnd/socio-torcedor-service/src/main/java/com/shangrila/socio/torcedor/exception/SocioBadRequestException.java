package com.shangrila.socio.torcedor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SocioBadRequestException extends RuntimeException {
	public SocioBadRequestException(String message) {
		super(message);
	}
}
