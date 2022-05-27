package hotel.entity;

import lombok.Data;
import java.sql.Date;

@Data
public class SearchRoom {
	private Date checkin;
	private Date checkout;
	public SearchRoom() {
		super();
	}
	
}
