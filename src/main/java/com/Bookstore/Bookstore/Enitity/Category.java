package com.Bookstore.Bookstore.Enitity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany (mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> book;
}
