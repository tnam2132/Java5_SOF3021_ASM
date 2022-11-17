package java5_sof3021_assignment.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReportDate implements Serializable{
	@Id
	private Date createDate;
	private Double doanhThu;
	private long soLuong;
}