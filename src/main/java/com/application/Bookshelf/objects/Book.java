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
@Table(name = "books")
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
    private Set<Author> authors = new HashSet<Author>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_categories" ,
            joinColumns = {@JoinColumn(name = "book_id")} ,
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> categories = new HashSet<Category>();

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

public void removeCategory(Category category){
    this.categories.remove(category);
    category.getBooks().remove(category);

}
public void addCategory(Category category){
    this.categories.add(category);
    category.getBooks().add(this);
}

}
