package com.Bookstore.Bookstore.Enitity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String title;
    private String author;
    @ManyToOne
    @JoinColumn( name = "Category_id")
    @JsonIgnore
    private Category category;
    @Min(value=0,message = "Price cannot be negative")
    private float price;
    @Min(value=0, message = "Count cannot be negative" )
    private int totalCount;
    @Min(value=0,message = "total sell cannot be negative")
    private int sold;



}
