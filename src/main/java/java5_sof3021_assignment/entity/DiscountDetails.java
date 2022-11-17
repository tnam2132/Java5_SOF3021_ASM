package java5_sof3021_assignment.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="discount_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name="discount_id")
	private Discount discount;
	
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
}