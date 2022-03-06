package com.application.Bookshelf.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn" ,length = 50 , nullable = false , unique = true)
    private String isbn;

    @Column(name = "name",length = 50,nullable = false)
    public String name;

    @Column(name = "description",length = 250,nullable = false)
    public String description;

    public Book(String isbn, String name, String description) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_catagories" ,
            joinColumns = {@JoinColumn(name = "book_id")} ,
            inverseJoinColumns = {@JoinColumn(name = "catagory_id")})
    private Set<Catagory> catagories = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_publisher" ,
            joinColumns = {@JoinColumn(name = "book_id" )} ,
            inverseJoinColumns ={@JoinColumn(name = "publisher_id")} )
    private Set<Publisher> publishers = new HashSet<>();

public void removePublisher(Publisher publisher){
    this.publishers.remove(publisher);
    publisher.getBooks().remove(publisher);
}

public void addPublisher(Publisher publisher)
{
    this.publishers.add(publisher);
    publisher.getBooks().add(this);
}

public void removeAuthor(Author author){
    this.authors.remove(author);
    author.getBooks().remove(author);

}

public void addAuthor(Author author){
    this.authors.add(author);
    author.getBooks().add(this);
}

public void removeCatagory(Catagory catagory){
    this.catagories.remove(catagory);
    catagory.getBooks().remove(catagory);

}
public void addCatagory(Catagory catagory){
    this.catagories.add(catagory);
    catagory.getBooks().add(this);
}

}
