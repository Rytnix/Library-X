package com.application.Bookshelf.repositories;

import com.application.Bookshelf.objects.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {

}
