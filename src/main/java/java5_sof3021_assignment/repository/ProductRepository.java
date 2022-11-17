package java5_sof3021_assignment.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java5_sof3021_assignment.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	Product findByIdEquals(Integer id);
	@Query("SELECT p FROM Product p WHERE p.category.id = ?1")
	Page<Product> findByCategory_Id(Integer categoryId, Pageable pageable);
	Page<Product> findByNameLike(String keywords, Pageable pageable);
	
}
