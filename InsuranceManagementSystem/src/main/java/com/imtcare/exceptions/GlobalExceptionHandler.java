package com.imtcare.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

public class GlobalExceptionHandler {

			// For Customizing our error body as a response if any error occurs then we make little changes
			
			// For Client Exception
			@ExceptionHandler(ClientNotFoundException.class)
			public ResponseEntity<CustomizeError> clientNotFoundExceptionExceptionHandler(ClientNotFoundException bnf, WebRequest req){
				
				CustomizeError customizeError= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
				
				return new ResponseEntity<CustomizeError>(customizeError, HttpStatus.BAD_REQUEST);
			}
			
			
			// For Claim Exception
			@ExceptionHandler(ClaimNotFoundException.class)
			public ResponseEntity<CustomizeError> claimNotFoundExceptionHandler(ClaimNotFoundException bnf, WebRequest req){
				
				CustomizeError customizeError= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
				
				return new ResponseEntity<CustomizeError>(customizeError, HttpStatus.BAD_REQUEST);
			}
			
			
			// For Policy Exception
			@ExceptionHandler(PolicyNotFoundException.class)
			public ResponseEntity<CustomizeError> policyNotFoundExceptionHandler(PolicyNotFoundException bnf, WebRequest req){
				
				CustomizeError customizeError= new CustomizeError(LocalDateTime.now(), bnf.getMessage(), req.getDescription(false));
				
				return new ResponseEntity<CustomizeError>(customizeError, HttpStatus.BAD_REQUEST);
			}
			
			
			// For exception if no uri found with given name
			// Also add properties for NoHandlerFoundException to application.properties
			
			@ExceptionHandler(NoHandlerFoundException.class)
			public ResponseEntity<CustomizeError> notFoundUri(NoHandlerFoundException nhf, WebRequest req){
				
				CustomizeError customizeError= new CustomizeError(LocalDateTime.now(), nhf.getMessage(), req.getDescription(false));
				
				return new ResponseEntity<CustomizeError>(customizeError, HttpStatus.BAD_REQUEST);
			}
			
			
			//To handle any generic type of exception, if occurs
			
			@ExceptionHandler(Exception.class)
			public ResponseEntity<CustomizeError> anyGenericException(Exception e, WebRequest req){
				
				CustomizeError customizeError= new CustomizeError(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
				
				return new ResponseEntity<CustomizeError>(customizeError, HttpStatus.BAD_REQUEST);
			}
			
			// Handling the validation exception
			
			@ExceptionHandler(MethodArgumentNotValidException.class)
			public ResponseEntity<CustomizeError> validationErr(MethodArgumentNotValidException me){
				
				CustomizeError customizeError= new CustomizeError(LocalDateTime.now(), "Validation Error", me.getBindingResult().getFieldError().getDefaultMessage());
				
				return new ResponseEntity<CustomizeError>(customizeError, HttpStatus.BAD_REQUEST);

			}
}
