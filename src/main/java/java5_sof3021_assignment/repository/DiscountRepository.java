package java5_sof3021_assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java5_sof3021_assignment.entity.Account;
import java5_sof3021_assignment.entity.Category;
import java5_sof3021_assignment.entity.Discount;
import java5_sof3021_assignment.entity.Product;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer>{
	List<Discount> findByNameLike(String name);
}
