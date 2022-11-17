package java5_sof3021_assignment.interface_Asm;

import java.util.Collection;

import java5_sof3021_assignment.entity.OrderDetail;

public interface ShoppingCartInterface {
	public OrderDetail add(Integer id);

	public void remove(Integer id);

	public OrderDetail update(Integer id, int qty);

	public void clear();

	public Collection<OrderDetail> getItems();

	public int getCount();

	public double getAmount();
}
