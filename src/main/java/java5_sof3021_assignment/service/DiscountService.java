package java5_sof3021_assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java5_sof3021_assignment.entity.Discount;
import java5_sof3021_assignment.entity.DiscountDetails;
import java5_sof3021_assignment.repository.DiscountDetailRepository;
import java5_sof3021_assignment.repository.DiscountRepository;

@Service
public class DiscountService {
	@Autowired
	DiscountRepository discountRepository;
	
	public List<Discount> getAll() {
		List<Discount> discountDetails = discountRepository.findAll();
		return discountDetails;
	}
	
	public List<Discount> findByUsername(String name){
		List<Discount> discounts = discountRepository.findByNameLike(name);
		return discounts;
	}
	
	public void create(Discount discount){
		discountRepository.save(discount);
	}
	
	public void update(Discount discount){
		discountRepository.save(discount);
	}
//	Tìm theo id
	public Discount findById(Integer id){
		Discount discount = discountRepository.findById(id).get();
		return discount;
	}
	
	public void delete(Integer id){
		discountRepository.deleteById(id);;
	}
}
