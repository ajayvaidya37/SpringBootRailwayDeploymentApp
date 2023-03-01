package com.ajayvaidya.SpringBootDemo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

//
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

	private String message;
	private HttpStatus status;
//	public String getMessage() {
//		return message;
//	}
//	public void setMessage(String message) {
//		this.message = message;
//	}
//	public HttpStatus getStatus() {
//		return status;
//	}
//	public void setStatus(HttpStatus status) {
//		this.status = status;
//	}
//	public ErrorMessage(String message, HttpStatus status) {
//		super();
//		this.message = message;
//		this.status = status;
//	}
//	public ErrorMessage() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	@Override
//	public String toString() {
//		return "ErrorMessage [message=" + message + ", status=" + status + "]";
//	}

	
	
}
