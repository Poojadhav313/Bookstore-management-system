package com.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    private int id; 
	    private String title;
	    private String author;
	    private double price;
	    private String description;
	    
	    public Book() {}
	    
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
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		public Book(int id, String title, String author, double price, String description) {
			super();
			this.id = id;
			this.title = title;
			this.author = author;
			this.price = price;
			this.description = description;
		}
		
		@Override
	    public String toString() {
	        return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	    }


}
