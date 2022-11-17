package java5_sof3021_assignment.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java5_sof3021_assignment.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	List<Order> findByIdEquals(Integer Id);
	Page<Order> findByAddressLike(String keywords, Pageable pageable);
}
