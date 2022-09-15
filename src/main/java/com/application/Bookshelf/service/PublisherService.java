package com.application.Bookshelf.service;

import com.application.Bookshelf.objects.Publisher;
import com.application.Bookshelf.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {


    @Autowired
    public PublisherRepository publisherRepository;

    public List<Publisher> findAllPublisher(){

        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found"));

        return publisher;
    }

    public void addPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }
    public void updatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void removePublisher(Long id){
        Publisher publisher= publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found"));
publisherRepository.deleteById(publisher.getId());
    }

}
