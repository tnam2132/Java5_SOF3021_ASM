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
@Table(name="discount")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="value")
	private Float value;

	@Column(name="start_date")
	private Date start_date;
	
	@Column(name="end_date")
	private Date end_date;
	
	@Column(name="available")
	private Integer available;
}