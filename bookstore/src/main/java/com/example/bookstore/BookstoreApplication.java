package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;
import com.example.bookstore.model.User;
import com.example.bookstore.model.UserRepository;



@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	  @Bean

     public CommandLineRunner runner(BookRepository repository, CategoryRepository catrep, UserRepository urepository ){
        return args -> {
        	
        	
          	log.info("some categories");
          	catrep.save(new Category("Programming"));
          	catrep.save(new Category("Fiction"));
          	catrep.save(new Category("Magic"));
          	
          	log.info("fetch all categories");
        	for(Category Categoty : catrep.findAll()) {
        			log.info(Categoty.toString());
        			
        	
        	}
        	
        	log.info("some books");
        	repository.save(new Book("Crime and Punishment", "Fedor Dostoyevskiy", 2000, 978078, 10, catrep.findByName("Fiction").get(0)));
        	repository.save(new Book("Hands-On Full Stack Development", "Juha Hinkula", 2019, 1838822364, 10, catrep.findByName("Fiction").get(0)));
        	repository.save(new Book("Java Garage", "Eben Hewitt", 2004, 0321246233, 20, catrep.findByName("Fiction").get(0)));
        	repository.save(new Book("Java threads", "Scott Oaks", 2004, 596007825, 25, catrep.findByName("Fiction").get(0)));
        	repository.save(new Book("Optimizing Java", "Doug Hawkins", 2015, 1771374861,25, catrep.findByName("Fiction").get(0)));
        	
        
        			
        			
        			log.info("some users");
        			User user1 = new User("user", "$2a$10$a3bG.2M0LEg4aCq9ycVa6etLQZ7D7tou5lcAkckY9LUVOU8GZVPqG", "user@gmail.com", "USER");
        			User user2 = new User("admin", "$2a$10$cbouXPh/kSf50SSv1AA1a.l99DaaEmBqTFmxhnmejVBAfRNQ5d1LS", "admin@gmail.com", "ADMIN");
        			
        			urepository.save(user1);
        			urepository.save(user2);
        			
        			log.info("fetch all books");
                	for(Book Book : repository.findAll()) {
                			log.info(Book.toString());
                			
                			
        	
        	}
                	
        
        	
        };
      } 
    }
