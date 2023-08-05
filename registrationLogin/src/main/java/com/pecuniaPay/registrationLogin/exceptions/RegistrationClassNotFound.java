package com.pecuniaPay.registrationLogin.exceptions;
import org.springframework.stereotype.Component;

@Component
public class RegistrationClassNotFound extends Exception{
	String message;
	public RegistrationClassNotFound(String message) {
		super("Registration Service Down "+message);
	}
	public String getMessage() {
		return message;
	}
	public RegistrationClassNotFound() {
		super();
	}
	@Override
	public String toString() {
		return "RegistrationClassNotFound [message=" + message + "]";
	}
	
}