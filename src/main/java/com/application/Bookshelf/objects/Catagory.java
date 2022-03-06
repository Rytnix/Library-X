package com.application.Bookshelf.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "catagories")
public class Catagory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" , length = 250 , nullable = false , unique = true)
    private String name;

    public Catagory( String name) {
        this.name = name;
    }


    @ManyToMany(mappedBy = "catagories",cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();


}
