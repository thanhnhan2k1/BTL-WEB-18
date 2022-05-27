package hotel.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import hotel.entity.Room;
import hotel.entity.SearchRoom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;

@Repository
public class JdbcRoomRepository implements RoomRepository{
	private JdbcTemplate jdbc;
	@Autowired
	public JdbcRoomRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	public Iterable<Room> findAll(){
		return jdbc.query("Select code, name, des, type, price, room_img, saleoff from Room_Hotel", this::mapRowtoRoom);
	}
	public Room findbyname(String name) {
		return jdbc.queryForObject("Select code, name, des, type, price, room_img, saleoff from Room_Hotel where name=?", this::mapRowtoRoom, name);
	}
	private Room mapRowtoRoom(ResultSet rs, int rowNum) throws SQLException{
		// TODO Auto-generated method stub
		return new Room(rs.getInt("code"), rs.getString("name"), rs.getString("des"), rs.getString("type"), rs.getInt("price"), rs.getString("room_img"), rs.getFloat("saleoff"));
	}
	@Override
	public Room findbyCode(int code) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("Select * from Room_Hotel where code=?", this::mapRowtoRoom, code);
	}
	@Override
	public Room saveRoom(Room room) {
		// TODO Auto-generated method stub
		jdbc.update("Insert into Room_Hotel(code, name, des, type, price, room_img, saleoff values(?, ?, ?, ?, ?, ?,?)", room.getCode()
				,room.getName(),
				room.getDescription(),
				room.getType(),
				room.getPrice(),
				room.getRoom_img(),
				room.getSaleoff());
		return room;
	}
	@Override
	public Iterable<Room> searchFreeRoom(SearchRoom search) {
		// TODO Auto-generated method stub
		String s = "SELECT * FROM Room_Hotel WHERE code NOT IN (SELECT roomid FROM order_details WHERE checkout > ? AND checkin < ?)";
		return jdbc.query(s, this::mapRowtoRoom, search.getCheckin(), search.getCheckout());
	}
	@Override
	public void delete(Room room) {
		// TODO Auto-generated method stub
		jdbc.update("delete from Room_hotel where code=?", room.getCode());
	}
	@Override
	public void save(Room room) {
		// TODO Auto-generated method stub
		jdbc.update("Insert into Room_Hotel(code, name, des, type, price, room_img, saleoff) values(?, ?, ?, ?, ?, ?, ?)", 
				room.getCode()
				,room.getName(),
				room.getDescription(),
				room.getType(),
				room.getPrice(),
				room.getRoom_img(),
				room.getSaleoff());
	}
	@Override
	public void update(Room room) {
		// TODO Auto-generated method stub
		jdbc.update("Update Room_Hotel set code=?, name=?, description=?, type=?, price=?, room_img=?, saleoff=? where code=?", 
				room.getCode()
				,room.getName(),
				room.getDescription(),
				room.getType(),
				room.getPrice(),
				room.getRoom_img(),
				room.getSaleoff(),room.getCode());
	}
}
