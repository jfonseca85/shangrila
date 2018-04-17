package com.shangrila.marketing.campaing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CampaingNotFoundException extends RuntimeException {
	public CampaingNotFoundException(String message) {
		super(message);
	}
}
