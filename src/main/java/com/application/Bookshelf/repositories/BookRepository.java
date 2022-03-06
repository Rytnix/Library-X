package com.application.Bookshelf.repositories;

import com.application.Bookshelf.objects.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository<Book ,Long> {
}
