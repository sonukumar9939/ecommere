package com.user.core.userManagement.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.user.core.userManagement.customException.UserAlreadyExistsException;

@ControllerAdvice
public class ExceptionTransalator extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionTransalator.class);

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		logger.error(ex.getMessage() , ex);
		List<ValidationFieldError> fieldErrors = new ArrayList<>();
		ex.getBindingResult().getFieldErrors().forEach(objectError -> {
			ValidationErrorCode validationErrorCode = ValidationErrorCode.valueOf(objectError.getCode());
			fieldErrors.add(new ValidationFieldError(objectError.getField(), validationErrorCode.getErrorCode(),objectError.getDefaultMessage()));
		});
		ValidationErrorResponse errorResponse = new ValidationErrorResponse(ErrorCode.VALIDATION_ERROR.getCode(),
				messageSource.getMessage("error.validation", null, LocaleContextHolder.getLocale()), fieldErrors);
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {

		logger.error(ex.getMessage(), ex);
		ValidationFieldError fieldError = new ValidationFieldError(ex.getKey(), ErrorCode.USER_ALREADY_EXISTS.getCode(),
				messageSource.getMessage("user.already.exists", null, LocaleContextHolder.getLocale()));
		return new ResponseEntity<Object>(fieldError, HttpStatus.BAD_REQUEST);

	}

}
