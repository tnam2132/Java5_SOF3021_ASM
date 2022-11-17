package java5_sof3021_assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@NotBlank(message = "{NotBlank.Account.username}")
	@Column(name = "username")
	private String username;

	@NotBlank(message = "{NotBlank.Account.fullname}")
	@Column(name = "fullname")
	private String fullname;

	@NotBlank(message = "{NotBlank.Account.password}")
	@Size(min = 4, max = 8, message ="{Size.Account.password}")
	@Column(name = "password")
	private String password;

	@NotBlank(message = "{NotBlank.Account.email}")
	@Column(name = "email")
	private String email;

	@NotBlank(message = "{NotBlank.Account.photo}")
	@Column(name = "photo")
	private String photo;

	@Column(name = "activated")
	private Integer activated;

	@Column(name = "admin")
	private Integer admin;
}