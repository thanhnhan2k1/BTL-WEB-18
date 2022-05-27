package hotel.entity;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import hotel.data.RoomRepository;
import lombok.Data;

@Data
public class Cart {
	public Cart(int int1, int int2) {
		// TODO Auto-generated constructor stub
		this.id = int1;
		this.roomcode = int2;
	}
	private int id;
	private int roomcode;
	private int userid;
}
