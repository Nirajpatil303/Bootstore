package com.Bookstore.Bookstore.Service;

import com.Bookstore.Bookstore.DTO.BookDTO;
import com.Bookstore.Bookstore.Enitity.Book;
import com.Bookstore.Bookstore.Enitity.BookRepo;
import com.Bookstore.Bookstore.Enitity.CategoryRepo;
import com.Bookstore.Bookstore.Enitity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;


   //All Get Methods

       public Book getBookById (Long id){
       return (Book) bookRepo.findById(id).orElse(null);
   }


       public List<BookDTO> getAllBooks () {
        List<Book> books = bookRepo.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(Book book : books){
            BookDTO bookDTO = convertToDTO(book);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
   }

    public BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setCategoryName(book.getCategory().getName());
        bookDTO.setTotalCount(book.getTotalCount());
        bookDTO.setSold(book.getSold());
        return bookDTO;
    }

       public int getNumberOfBooksAvailableById (Long id){
       if (bookRepo.existsById(id)) {
           Book book = (Book) bookRepo.findById(id).orElse(null);
           return (book != null) ? book.getTotalCount() : 0;
       } else {
           throw new RuntimeException("Book not found by given id: " + id);
       }
   }

    //Put Method
    public Book updateBook(Book book) {
        if (bookRepo.existsById(book.getId())) {
            return (Book) bookRepo.save(book);
        } else {
            throw new RuntimeException("Book not found");
        }
    }
    //Post method
    public Book addabook(Book book) {
        if (bookRepo.existsById(book.getId())) {
            throw new RuntimeException("Book already exist by this id");
        } else {
            return bookRepo.save(book);
        }
    }
    //delete method
    public void deletebook(Long id) {
        bookRepo.deleteById(id);
    }

    // 5. Sell a Book by id and quantity
    public String sellBook(Long id, int quantity) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.getTotalCount() >= quantity) {
            book.setTotalCount(book.getTotalCount() - quantity);
            book.setSold(book.getSold() + quantity);
            bookRepo.save(book);
            return "Book sold successfully";
        } else {
            throw new RuntimeException("Not enough books available");
        }
    }

}
