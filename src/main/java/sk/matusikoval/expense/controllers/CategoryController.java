package sk.matusikoval.expense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sk.matusikoval.expense.entities.Category;
import sk.matusikoval.expense.exceptions.CategoryAlreadyExistsException;
import sk.matusikoval.expense.exceptions.CategoryNotFoundException;
import sk.matusikoval.expense.services.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
    @GetMapping("/{id}")
    public @ResponseBody Category getCategoryById(@PathVariable("id") Long id) throws CategoryNotFoundException {  
        return categoryService.getCategoryById(id);
    }
	
	@GetMapping
	public @ResponseBody List<Category> getAllCategories() {	
		List<Category> categories = categoryService.getAllCategories();
		return categories;
	}
	
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) throws CategoryAlreadyExistsException {   
    	categoryService.addCategory(category);
    	return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCategory(@PathVariable("id") Long id) throws CategoryNotFoundException {
    	categoryService.deleteCategory(id);
        return ResponseEntity.ok(id);
    }
    
    @PutMapping
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) throws CategoryNotFoundException {
    	categoryService.updateCategory(id, category);
    	return ResponseEntity.ok(category);
    }
}
