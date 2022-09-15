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
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name",length = 100 , nullable = false , unique = true)
    public String name ;

    @Column(name = "description" , length = 250 , nullable = false)
    public String description;

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @ManyToMany(mappedBy = "authors" , cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();
}
