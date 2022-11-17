package java5_sof3021_assignment.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="order_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
}