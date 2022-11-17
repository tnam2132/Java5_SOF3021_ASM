package java5_sof3021_assignment.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java5_sof3021_assignment.entity.Account;
import java5_sof3021_assignment.entity.Category;
import java5_sof3021_assignment.entity.OrderDetail;
import java5_sof3021_assignment.entity.Product;
import java5_sof3021_assignment.entity.ReportCategory;
import java5_sof3021_assignment.entity.ReportDate;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
	List<OrderDetail> findByIdEquals(Integer Id);
	Page<OrderDetail> findByIdEquals(Integer Id, Pageable pageable);
	@Query("SELECT new ReportCategory(d.product.category,sum(d.price*d.quantity),"
			+ " sum(d.quantity)) FROM OrderDetail d GROUP BY d.product.category")
	Page<ReportCategory> revenueByCategory(Pageable pageable);
	
	@Query("SELECT new ReportDate(d.order.createdDate,sum(d.price*d.quantity),"
			+ " sum(d.quantity)) FROM OrderDetail d GROUP BY d.order.createdDate")
	Page<ReportDate> revenueByDate(Pageable pageable);
}
