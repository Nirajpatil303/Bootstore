package com.Bookstore.Bookstore.Service;

import com.Bookstore.Bookstore.Enitity.Book;
import com.Bookstore.Bookstore.Enitity.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

   //All Get Methods

       public Book getBookById (Long id){
       return (Book) bookRepo.findById(id).orElse(null);
   }


       public List<Book> getAllBooks () {
       return (List<Book>) bookRepo.findAll();
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

    // 5. Sell a Book by id
    public void sellBook(Long id, int quantity) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.getTotalCount() >= quantity) {
            book.setTotalCount(book.getTotalCount() - quantity);
            book.setSold(book.getSold() + quantity);
            bookRepo.save(book);
        } else {
            throw new RuntimeException("Not enough books available");
        }
    }

    // 6. Sell List of Books
    public void sellBooks(List<Long> bookIds, List<Integer> quantities) {
        if (bookIds.size() != quantities.size()) {
            throw new IllegalArgumentException("Mismatch between book IDs and quantities");
        }
        for (int i = 0; i < bookIds.size(); i++) {
            sellBook(bookIds.get(i), quantities.get(i));
        }
    }

    // 7. Get books by category
//    public List<Book> getBooksByCategory(Category category) {
//        return bookRepo.findByCategory(category);
//    }
//
//    // 8. Get Number of books sold per category
//    public int getNumberOfBooksSoldPerCategory(Category category) {
//        List<Book> books = bookRepo.findByCategory(category);
//        return books.stream().mapToInt(Book::getSold).sum();
//    }

}
