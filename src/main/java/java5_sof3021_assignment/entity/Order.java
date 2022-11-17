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
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createdDate = new Date();

	@Column(name="address")
	private String address;
	
	@Column(name="status")
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Account account;
}