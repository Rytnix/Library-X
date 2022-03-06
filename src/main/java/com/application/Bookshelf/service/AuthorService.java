package com.application.Bookshelf.service;

import com.application.Bookshelf.objects.Author;
import com.application.Bookshelf.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    public AuthorRepository authorRepository;

    public List<Author> findAllAuthor(){
       return authorRepository.findAll();

    }

    public Author findAuthorById(Long id){
  Author author;
  author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
  return author;
    }

    public void addAuthor(Author author){
        authorRepository.save(author);
    }

    public void removeAuthor(Long id){
        Author author;
        author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        authorRepository.delete(author);

    }


}
