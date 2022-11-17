package java5_sof3021_assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java5_sof3021_assignment.entity.Discount;
import java5_sof3021_assignment.entity.OrderDetail;
import java5_sof3021_assignment.entity.ReportCategory;
import java5_sof3021_assignment.entity.ReportDate;
import java5_sof3021_assignment.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
	@Autowired
	OrderDetailRepository orderDetailRepository;
//	getAll+Page
	public Page<OrderDetail> getAll(Pageable pageable) {
		Page<OrderDetail> orderDetails = orderDetailRepository.findAll(pageable);
		return orderDetails;
	}
	//Tìm theo Id
	public List<OrderDetail> findByUsername(Integer Id){
		List<OrderDetail> discounts = orderDetailRepository.findByIdEquals(Id);
		return discounts;
	}
	
	public void create(OrderDetail orderDetail){
		orderDetailRepository.save(orderDetail);
	}
	
	public void update(OrderDetail orderDetail){
		orderDetailRepository.save(orderDetail);
	}
//	Tìm theo id
	public OrderDetail findById(Integer id){
		OrderDetail orderDetail = orderDetailRepository.findById(id).get();
		return orderDetail;
	}
	
//	Tìm theo id+ page
	public Page<OrderDetail> findById(Integer id, Pageable pageable){
		Page<OrderDetail> orderDetail = orderDetailRepository.findByIdEquals(id , pageable);
		return orderDetail;
	}
	public void delete(Integer id){
		orderDetailRepository.deleteById(id);;
	}
//	Theo loại
	public Page<ReportCategory> revenueByCategory(Pageable pageable){
		Page<ReportCategory> reports = orderDetailRepository.revenueByCategory(pageable);;
		return reports;
	}
//	Theo thời gian
	public Page<ReportDate> revenueByDate(Pageable pageable){
		Page<ReportDate> reports = orderDetailRepository.revenueByDate(pageable);;
		return reports;
	}
}
