package java5_sof3021_assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java5_sof3021_assignment.entity.Order;
import java5_sof3021_assignment.entity.Product;
import java5_sof3021_assignment.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	// getAll
	public List<Product> getAll() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	// getAll+phan trang
	public Page<Product> getAll(Pageable pageable) {
		Page<Product> products = productRepository.findAll(pageable);
		return products;
	}

	// Tìm theo name
	public Page<Product> findByNameLike(String name, Pageable pageable) {
		Page<Product> products = productRepository.findByNameLike(name, pageable);
		return products;
	}

	// Tìm theo Id
	public Product findById(Integer Id) {
		Product products = productRepository.findByIdEquals(Id);
		return products;
	}

	// Tìm theo loai hang+ Phan trang
	public Page<Product> findByCategory_Id(Integer categoryId, Pageable pageable) {
		Page<Product> page = productRepository.findByCategory_Id(categoryId, pageable);
		return page;
	}

	public void create(Product product) {
		productRepository.save(product);
	}

	public void update(Product product) {
		productRepository.save(product);
	}

	public void delete(Integer id) {
		productRepository.deleteById(id);
		;
	}
}
