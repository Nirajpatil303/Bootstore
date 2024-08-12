package com.Bookstore.Bookstore.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Data
@Getter
@Setter
public class BookDTO {
    private long id;
    private String title;
    private String author;
    private float price;
    private String categoryName; // or long categoryId
    private int totalCount;
    private int sold;

}
