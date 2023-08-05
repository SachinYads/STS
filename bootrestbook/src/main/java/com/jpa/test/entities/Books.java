package com.jpa.test.entities;
public class Books {
	private int id;
	private String title;
	private String author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
		public Books(int id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}
		public Books() {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}
			@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
}