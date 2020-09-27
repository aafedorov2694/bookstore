package com.example.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.CategoryRepository;

@Controller
public class BookstoreController {

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository catrep;
	

	@RequestMapping("/booklist")
	public String ShowBooks(Model model) {

		model.addAttribute("books", repository.findAll());
		
		return "booklist";

	}

	@RequestMapping("/addbook")
	public String BookAdd(@ModelAttribute Book book, Model model) {

		model.addAttribute("book", book);
		model.addAttribute("categories", catrep.findAll());
		
		return "addbook";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String BookSubmit(@ModelAttribute Book book, Model model) {

		repository.save(book);

		return "redirect:/booklist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		
		repository.deleteById(bookId);
		
		return "redirect:../booklist";
	}
	
	

	@RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
	
	public String modifyBook(@PathVariable("id") Long bookId, Model model) {
		Optional<Book> book = repository.findById(bookId);
		model.addAttribute("book", book);
		model.addAttribute("categories", catrep.findAll());
		
		return "modifybook";
	}

	
	
}
