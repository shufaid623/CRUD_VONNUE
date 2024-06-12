package com.example.demo.CustomException;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

	private LocalDateTime timestamp;
	private String message;
	private String details;

}
