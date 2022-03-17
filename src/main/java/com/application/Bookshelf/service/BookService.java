package com.application.Bookshelf.service;

import com.application.Bookshelf.objects.Book;
import com.application.Bookshelf.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
   @Autowired
    private BookRepository bookRepository;
public List<Book> findAllBooks(){
    return bookRepository.findAll();
}
public Book findBookById(Long id){
    Book book ;
    book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

    return book;
}
public void createBook(Book book){
    bookRepository.save(book);
}
public void deleteBook(Long id){
    Book book =bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

    bookRepository.deleteById(book.getId());
}
public void updateBook(Book book){
   bookRepository.save(book) ;
}
}
