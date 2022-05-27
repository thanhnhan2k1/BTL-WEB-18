package hotel.entity;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
	private int id;

	private String name;
	
	private Date birthday;

	private String address;

	private String phone;

	private String email;

	private String username;

	private String password;
	
	private int role;

	public User(String name, Date birthday, String address, String phone, String email, String username,
			String password) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public User(int id, String name, Date birthday, String address, String phone, String email, String username,
			String password, int role) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	
}
