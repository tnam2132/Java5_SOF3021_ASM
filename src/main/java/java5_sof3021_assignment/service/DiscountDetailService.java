package java5_sof3021_assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java5_sof3021_assignment.entity.Category;
import java5_sof3021_assignment.entity.DiscountDetails;
import java5_sof3021_assignment.entity.Product;
import java5_sof3021_assignment.repository.DiscountDetailRepository;

@Service
public class DiscountDetailService {
	@Autowired
	DiscountDetailRepository detailRepository;

	public List<DiscountDetails> getAll() {
		List<DiscountDetails> discountDetails = detailRepository.findAll();
		return discountDetails;
	}
	
	public Page<Product> getTop10(Pageable pageable) {
		Page<Product> discountDetails = detailRepository.getTop10(pageable);
		return discountDetails;
	}
	
//	public List<DiscountDetails> findByUsername(String username){
//		List<DiscountDetails> accounts = detailRepository.findByNameLike(username);
//		return accounts;
//	}
	
	public void create(DiscountDetails details){
		detailRepository.save(details);
	}
	
	public void update(DiscountDetails details){
		detailRepository.save(details);
	}
//	Tìm theo id
	public DiscountDetails findById(Integer id){
		DiscountDetails discountDetails = detailRepository.findById(id).get();
		return discountDetails;
	}
	
	public void delete(Integer id){
		detailRepository.deleteById(id);;
	}
}
