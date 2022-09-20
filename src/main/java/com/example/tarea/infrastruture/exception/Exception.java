package com.example.tarea.infrastruture.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Exception extends RuntimeException{

	private String message;
	private HttpStatus status;

	public Exception(String message, HttpStatus status) {
		super(message);
		this.message = message;
		this.status = status;
	}
}
