package com.example.demo.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;

@Data
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class QuestionaireException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public QuestionaireException(String exceptionmessage) {
		super(exceptionmessage);
		this.message=exceptionmessage;
	}

}
