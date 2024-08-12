package com.Bookstore.Bookstore.Controller;

import com.Bookstore.Bookstore.DTO.BookDTO;
import com.Bookstore.Bookstore.DTO.SellDTO;
import com.Bookstore.Bookstore.Enitity.Book;
import com.Bookstore.Bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Book")
public class BookController {

    @Autowired
    private BookService BookService;

    @GetMapping
    public @ResponseBody List<BookDTO> getallbooks(){
        return BookService.getAllBooks();
    }
    @GetMapping(path= "/{id}")
    public @ResponseBody BookDTO getbookbyid(@PathVariable long id){
        Book book = BookService.getBookById(id);
        return BookService.convertToDTO(book);
    }
    @GetMapping(path= "/Count/{id}" )
    public int getNumberOfBooksAvailableById(@PathVariable long id){
        return BookService.getNumberOfBooksAvailableById(id);
    }

    @PostMapping(path= "/add")
    public @ResponseBody Book addbook(@RequestBody Book book){
        return BookService.addabook(book);
    }

    @PutMapping(path= "/update")
    public @ResponseBody Book update(@RequestBody Book book){
        return BookService.updateBook(book);
    }

    @PostMapping(path="/sell")
    public String sellbook(@RequestBody SellDTO sellDTO){
        return BookService.sellBook(sellDTO.getId(),sellDTO.getQuantity());
    }

    @DeleteMapping(path="/{id}")
    public  Boolean deletebyid(@PathVariable Long id){
        BookService.deletebook(id);
        return true;
    }

}
