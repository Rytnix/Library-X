package com.application.Bookshelf.repositories;

import com.application.Bookshelf.objects.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatagoryRepository extends JpaRepository<Catagory,Long> {
}
