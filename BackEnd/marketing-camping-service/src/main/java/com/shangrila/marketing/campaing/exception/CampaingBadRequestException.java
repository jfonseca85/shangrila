package com.shangrila.marketing.campaing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CampaingBadRequestException extends RuntimeException {
	public CampaingBadRequestException(String message) {
		super(message);
	}
}
