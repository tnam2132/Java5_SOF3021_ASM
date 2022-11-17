package java5_sof3021_assignment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="name")
	private String name;

	@Column(name="image")
	private String image;

	@Column(name="price")
	private Double price;

	@Column(name="available")
	private Integer available;
	
	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate = new Date();
	
	@Temporal(TemporalType.DATE)
	@Column(name="last_modified_date")
	private Date last_modified_date = new Date();
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="created_user_id")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name="last_modified_user_id")
	private Account last_modified_account;
}