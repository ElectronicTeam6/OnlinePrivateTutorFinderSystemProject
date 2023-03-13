package com.optfs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(NullUserFound.class)
	public ResponseEntity<String> nullUserFoundException(NullUserFound nufe) {
		return new ResponseEntity<>(nufe.getMessage(),HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(UserIdCannotBeNull.class)
	public ResponseEntity<String> nullUserIdFoundException(UserIdCannotBeNull uidcnn) {
		return new ResponseEntity<String>(uidcnn.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<String> userAlreadyExist(UserAlreadyExistException uae) {
		return new ResponseEntity<String>(uae.getMessage(),HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<String> cantLoginUser(InvalidCredentialsException invc) {
		return new ResponseEntity<String>(invc.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NullValuesFoundException.class)
	public ResponseEntity<String> nullValueFound(NullValuesFoundException invc) {
		return new ResponseEntity<String>(invc.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
}
