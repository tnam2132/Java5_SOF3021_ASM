package java5_sof3021_assignment.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java5_sof3021_assignment.entity.Order;
import java5_sof3021_assignment.entity.OrderDetail;
import java5_sof3021_assignment.entity.Product;
import java5_sof3021_assignment.interface_Asm.ShoppingCartInterface;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartInterface{
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	OrderService orderService;
	@Autowired
	ProductService productService;
	@Autowired
	AccountService accountService;
	@Autowired
	SessionService sessionService;
	
	Map<Integer, OrderDetail> map = new HashMap<>();
	@Override
	public OrderDetail add(Integer id) {
		OrderDetail orderDetail = new OrderDetail();
		if (map.get(id) != null) {
			orderDetail = map.get(id);
			orderDetail.setQuantity(orderDetail.getQuantity()+1);
			map.put(id, orderDetail);
			return null;
		}else {
			Order order = new Order();//Tạo order mới để orderDetail có order id
			order.setId(1);
//			order.setAccount(accountService.findByUsername(sessionService.get("username")));
//			order.setAddress("HN");
//			order.setStatus(0);
//			orderService.create(order);
			Product product = productService.findById(id);//Tạo product mới để orderDetail có product id
			orderDetail.setOrder(order);
			orderDetail.setProduct(product);
			orderDetail.setPrice(product.getPrice());
			orderDetail.setQuantity(1);
			map.put(id, orderDetail);
			return null;
		}
	}

	@Override
	public OrderDetail update(Integer id, int qty) {
		OrderDetail orderDetail = map.get(id);
		orderDetail.setQuantity(qty);
		map.put(id, orderDetail);
		return null;
	}
	
	@Override
	public void remove(Integer id) {
		map.remove(id);
		
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Collection<OrderDetail> getItems() {
		Collection<OrderDetail> orderDetails = map.values();
		return orderDetails;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
