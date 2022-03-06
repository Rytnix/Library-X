package com.application.Bookshelf.service;

import com.application.Bookshelf.objects.Catagory;
import com.application.Bookshelf.repositories.CatagoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatagoryService {

    public CatagoryRepository catagoryRepository;

    public List<Catagory> findAllCatagory(){

        return catagoryRepository.findAll();

    }

    public Catagory findCatagoryById(Long id){
        Catagory catagory;
        catagory = catagoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Catagory not found "));

        return catagory;
    }

    public void addCatagory(Catagory catagory){
        catagoryRepository.save(catagory);
    }

    public void removeCatagory(Long id){
        Catagory catagory = catagoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Catagory not found"));
        catagoryRepository.delete(catagory);
    }
}
