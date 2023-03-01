package com.ajayvaidya.SpringBootDemo1.error;
import com.ajayvaidya.SpringBootDemo1.entity.ErrorMessage;
import com.ajayvaidya.SpringBootDemo1.entity.ExceptionResponse;

//import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> deptNotFound(DepartmentNotFoundException exception,
    		WebRequest request){
    	ErrorMessage msg = new ErrorMessage(exception.getMessage(), HttpStatus.NOT_FOUND);
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    	
    }
//	@ExceptionHandler(DepartmentNotFoundException.class)
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	public @ResponseBody ExceptionResponse handleResourceNotFound(final DepartmentNotFoundException exception,
//			final HttpServletRequest request) {
//
//		ExceptionResponse error = new ExceptionResponse();
//		error.setErrorMessage(exception.getMessage());
//		error.callerURL(request.getRequestURI());
//
//		return error;
//	}
}