package com.application.Bookshelf;

import com.application.Bookshelf.objects.Author;
import com.application.Bookshelf.objects.Book;
import com.application.Bookshelf.objects.Category;
import com.application.Bookshelf.objects.Publisher;
import com.application.Bookshelf.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookshelfApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshelfApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService){
		return (args) -> {
			Book book1 =
					new Book("ABC", "Computer Application", "My first book");
			Author author1 =
					new Author("Test name1","Test Description");
			Publisher publisher1 =
					new Publisher("First Publisher");
			Category category1 =
					new Category("Business Books");

			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 =
					new Book("CDF","Operating System","My Second book");
			Author author2 =
					new Author("Test Name 2", "Test Description");
			Publisher publisher2 =
					new Publisher("Second Publisher");
			Category catagory2 =
					new Category("Computer Book");

			book2.addAuthor(author2);
			book2.addPublisher(publisher2);
			book2.addCategory(catagory2);
			bookService.createBook(book2);


			Book book3 =
					new Book("GHI","Theory of automata","My Third book");
			Author author3 =
					new Author("Test Name 3", "Test Description 3");
			Publisher publisher3 =
					new Publisher("Third Publisher");
			Category catagory3 =
					new Category("Engineering Book");

			book3.addAuthor(author3);
			book3.addPublisher(publisher3);
			book3.addCategory(catagory3);
			bookService.createBook(book3);



		};
	}

}
