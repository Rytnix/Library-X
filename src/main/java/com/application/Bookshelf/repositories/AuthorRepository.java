package com.application.Bookshelf.repositories;

import com.application.Bookshelf.objects.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
