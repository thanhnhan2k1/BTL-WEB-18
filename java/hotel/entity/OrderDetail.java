package hotel.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.sql.*;

import lombok.Data;

@Data
@Entity
@Table(name = "OrderDetails")
public class OrderDetail{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date createAt;
	private int roomid;
	
	private int userid;
	
	private Date checkin;
	
	private Date checkout;
	
	private int amount;
	
	private int price;
	
	private float saleoff;
	
	@PrePersist
	void createAt() {
		this.createAt = new Date(System.currentTimeMillis());
	}
}
