package hotel.entity;

import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Room {
	private int code;
	private String name;
	private String description;
	private String type;
	private int price;
	private String room_img;
	private float saleoff;
	private boolean checked;
	public Room(int id, int code, String name, String type, int price,  String room_img) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
		this.price = price;
		this.room_img = room_img;
	}
	public Room( int code, String name, String type, int price, String room_img) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
		this.price = price;
		this.room_img = room_img;
	}
	
	public Room() {
		// TODO Auto-generated constructor stub
	}
	public Room(int code, String name, String type, int price, String room_img, float saleoff) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
		this.price = price;
		this.room_img = room_img;
		this.saleoff = saleoff;
	}
	public Room(int code, String name, String description, String type, int price, String room_img, float saleoff
			) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.type = type;
		this.price = price;
		this.room_img = room_img;
		this.saleoff = saleoff;
		
	}
	
}