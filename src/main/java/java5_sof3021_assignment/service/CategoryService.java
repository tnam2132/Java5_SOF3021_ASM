package java5_sof3021_assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java5_sof3021_assignment.entity.Category;
import java5_sof3021_assignment.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAll(){
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}
//	+Page
	public Page<Category> getAll(Pageable pageable){
		Page<Category> categories = categoryRepository.findAll(pageable);
		return categories;
	}
//	tìm kiếm + page
	public Page<Category> findByNameLike(String username, Pageable pageable){
		Page<Category> categories = categoryRepository.findByNameLike(username, pageable);
		return categories;
	}
	
	public void create(Category category){
		categoryRepository.save(category);
	}
	
	public void update(Category category){
		categoryRepository.save(category);
	}
//	Tìm theo id
	public Category findById(Integer id){
		Category category = categoryRepository.findById(id).get();
		return category;
	}
	
	public void delete(Integer id){
		categoryRepository.deleteById(id);;
	}
}
