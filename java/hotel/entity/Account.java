package hotel.entity;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
	@NotBlank(message="Email is required!")
	private String email;
	
	@NotBlank(message="Password is required!")
	private String password;
}
