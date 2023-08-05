package com.prodapt.restfulapp.exceptions;



import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BookNotFoundException extends Exception{
	private String message;



}