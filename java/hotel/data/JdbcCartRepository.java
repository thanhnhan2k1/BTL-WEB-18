package hotel.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hotel.entity.Cart;

@Repository
public class JdbcCartRepository implements CartRepository{
	private JdbcTemplate jdbc;
	@Autowired
	public JdbcCartRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	@Override
	public Iterable<Cart> findAll() {
		// TODO Auto-generated method stub
		return jdbc.query("Select id, roomcode, userid from Cart", this::mapRowtoCart);
	}

	@Override
	public int save(int code) {
		// TODO Auto-generated method stub
		jdbc.update("Insert into Cart(roomcode) values(?)", code);
		return code;
	}
	
	private Cart mapRowtoCart(ResultSet rs, int rowNum) throws SQLException {
		return new Cart(rs.getInt("id"), rs.getInt("roomcode"));
	}
	@Override
	public Cart checkExists(int code) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("select id, roomcode from Cart where roomcode=? ", this::mapRowtoCart, code);
	}
	@Override
	public void delete(int code) {
		// TODO Auto-generated method stub
		jdbc.update("delete from cart where id = ?", code);
	}
	@Override
	public Iterable<Cart> findByUserId(int userid) {
		// TODO Auto-generated method stub
		return jdbc.query("Select id, roomcode, userid from Cart where userid=?", this::mapRowtoCart, userid);
	}
}
