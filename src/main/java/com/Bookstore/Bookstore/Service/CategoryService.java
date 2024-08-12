package com.Bookstore.Bookstore.Service;

import com.Bookstore.Bookstore.Enitity.Book;
import com.Bookstore.Bookstore.Enitity.Category;
import com.Bookstore.Bookstore.Enitity.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepo.findAll();
    }

    public Category getcategoryById (Long id){
        return  categoryRepo.findById(id).orElse(null);
    }

    // 7. Get books by category
    public List<Book> getBooksByCategory(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return category.getBook() != null ? category.getBook() : new ArrayList<>();

    }

    // 8. Get Number of books sold per category
    public int getNumberOfBooksSoldPerCategory(Long id) {
        Category category1= categoryRepo.findById(id).orElseThrow(() -> new RuntimeException( "Catergory not found"));
        List<Book> books = category1.getBook();
        int total_sold=0;
        for (Book book: books){
            total_sold += book.getSold();
        }
        return total_sold;
    }

}
