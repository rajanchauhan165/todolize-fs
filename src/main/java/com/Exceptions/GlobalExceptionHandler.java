package com.Exceptions;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> userExceptionHandler(UserException ue, WebRequest wr){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setDescription(wr.getDescription(false));
		errorDetails.setMessage(ue.getMessage());
		errorDetails.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception ue, WebRequest wr){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setDescription(wr.getDescription(false));
		errorDetails.setMessage(ue.getMessage());
		errorDetails.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
}
