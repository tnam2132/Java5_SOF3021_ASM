package java5_sof3021_assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java5_sof3021_assignment.entity.Order;
import java5_sof3021_assignment.entity.OrderDetail;
import java5_sof3021_assignment.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	public List<Order> getAll() {
		List<Order> orders = orderRepository.findAll();
		return orders;
	}
//	+Page
	public Page<Order> getAll(Pageable pageable) {
		Page<Order> orders = orderRepository.findAll(pageable);
		return orders;
	}
//	Tìm kiếm + page
	public Page<Order> findByAddressLike(String address, Pageable pageable){
		Page<Order> orders = orderRepository.findByAddressLike(address, pageable);
		return orders;
	}
	
	//Tìm theo Id
	public List<Order> findByUsername(Integer Id){
		List<Order> orders = orderRepository.findByIdEquals(Id);
		return orders;
	}
	
	public void create(Order order){
		orderRepository.save(order);
	}
	
	public void update(Order order){
		orderRepository.save(order);
	}
//	Tìm theo id
	public Order findById(Integer id){
		Order order = orderRepository.findById(id).get();
		return order;
	}
	
	public void delete(Integer id){
		orderRepository.deleteById(id);;
	}
}
