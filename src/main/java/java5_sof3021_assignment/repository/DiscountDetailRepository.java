package java5_sof3021_assignment.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java5_sof3021_assignment.entity.DiscountDetails;
import java5_sof3021_assignment.entity.Product;

@Repository
public interface DiscountDetailRepository extends JpaRepository<DiscountDetails, Integer>{
	@Query("SELECT p.product FROM DiscountDetails p")
	Page<Product> getTop10(Pageable pageable);
//	List<DiscountDetails> findByNameLike(String name);
}
