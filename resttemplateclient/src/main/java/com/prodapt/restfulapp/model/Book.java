package com.prodapt.restfulapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
	private Integer bookId;
	private String bookName;
	private String author;
	private Double price;
	private String publisher;

}
