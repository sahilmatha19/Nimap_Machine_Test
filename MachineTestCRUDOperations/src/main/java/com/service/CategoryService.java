package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Category;
import com.dao.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// Method to get categories with pagination
    public List<Category> getCategorywithPagination(int offset, int pageSize) {
        int start = offset * pageSize + 1; 
        int end = start + pageSize - 1;
        return categoryRepository.findCategoriesWithPagination(start, end);
    }
    
	//Save Details
	public Category createCategory(Category Category)
	{
		return categoryRepository.save(Category);
	}
	
	//get details by id
	public Category getCategoryById(Long id)
	{
		return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category Not Found"));
	}
	
	//delete details by id
	public void deleteCategoryById(Long id)
	{
		categoryRepository.deleteById(id);
	}
	
	//update details by id
	public Category updateCategoryById(Long id, Category Category)
	{
		Category c =  getCategoryById(id);
		c.setCategoryName(Category.getCategoryName());
		return categoryRepository.save(c);
	}
	
	//display all records
//	public List<Category> findAllCategory()
//	{
//	    return categoryRepository.findAll();
//	}
}
