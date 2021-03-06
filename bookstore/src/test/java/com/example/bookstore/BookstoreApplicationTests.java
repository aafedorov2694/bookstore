package com.example.bookstore;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.web.BookstoreController;
import com.example.bookstore.web.SecurityController;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookstoreController bookStoreCntrl;
	
	@Autowired
	private SecurityController securityCntrl;
	
	
	
	@Test
	void contextLoads() throws Exception {
		assertThat(bookStoreCntrl).isNotNull();
		assertThat(securityCntrl).isNotNull();
	}

}
