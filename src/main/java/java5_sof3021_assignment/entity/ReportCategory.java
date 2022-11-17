package java5_sof3021_assignment.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReportCategory implements Serializable{
	@Id
	private Category loai;
	private Double doanhThu;
	private long soLuong;
}