package com.example.bookstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	public long categoryid;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="category")

	private List<Book> book;

	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	

	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}
	
	
	
	

	
		
}
