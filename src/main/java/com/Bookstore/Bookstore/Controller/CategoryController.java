package com.Bookstore.Bookstore.Controller;

import com.Bookstore.Bookstore.Enitity.Book;
import com.Bookstore.Bookstore.Enitity.Category;
import com.Bookstore.Bookstore.Enitity.CategoryRepo;
import com.Bookstore.Bookstore.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public @ResponseBody List<Category>  getall (){
        return categoryService.getAllCategories();

    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Category getcategorybyid(@PathVariable long id){
        return categoryService.getcategoryById(id);
    }

    @PostMapping(path= "/add")
    public @ResponseBody Category addbook(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping(path="/book/{id}")
    public @ResponseBody  List<Book> getBooksByCategory(@PathVariable Long id) {
        return categoryService.getBooksByCategory(id);
    }

    @GetMapping(path="/booktotalcount/{id}")
    public @ResponseBody  int getnumberofbook(@PathVariable Long id) {
        return categoryService.getNumberOfBooksSoldPerCategory(id);
    }



}
