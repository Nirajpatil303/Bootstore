package com.Bookstore.Bookstore.Controller;

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
    public @ResponseBody List<Book> getallbooks(){
        return BookService.getAllBooks();
    }
    @GetMapping(path= "/{id}")
    public @ResponseBody Book getbookbyid(@PathVariable long id){
        return BookService.getBookById(id);
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

    @DeleteMapping(path="/{id}")
    public  Boolean deletebyid(@PathVariable Long id){
        BookService.deletebook(id);
        return true;
    }

}
