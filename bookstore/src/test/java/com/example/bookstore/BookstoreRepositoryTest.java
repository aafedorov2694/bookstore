package com.example.bookstore;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.JUnitCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTest {
	
	
	
	@Autowired
	private BookRepository bookRps;
	
	@Autowired
	private CategoryRepository catRps;
	
	
	
	//--------------------------------BOOK------------------------------
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = bookRps.findByTitle("Java Garage");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Eben Hewitt");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Java", "Anton", 2000, 978078, 10, new Category("Fiction"));
		bookRps.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {

		Book book = new Book("Java", "Anton", 2000, 978078, 10, new Category("Fiction"));
		bookRps.save(book);
		bookRps.deleteById(book.getId());
		assertThat(bookRps.count()).isEqualTo(5);
		
	}
	
	// --------------------------CATEGORY----------------------------------------------
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> ctegories = catRps.findByName("Fiction");
		assertThat(ctegories).hasSize(1);
		assertThat(ctegories.get(0).getName()).isEqualTo("Fiction");
	}
	
	
	@Test
	public void createRep() {
		Category testcat = new Category("Coding");
		catRps.save(testcat);
		
		assertThat(testcat.getCategoryid()).isNotNull();
	}

	@Test
	public void deleteCategory() {

		Category testcat = new Category("Coding");
		catRps.save(testcat);
		
		
		catRps.deleteById(testcat.getCategoryid());
		assertThat(catRps.count()).isEqualTo(3);
		
	}
}
	
	