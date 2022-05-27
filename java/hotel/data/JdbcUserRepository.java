package hotel.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hotel.entity.Account;
import hotel.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

@Repository
public class JdbcUserRepository implements UserRepository{
	private JdbcTemplate jdbc;
	@Autowired
	public JdbcUserRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Iterable<User> findAll() {
		return jdbc.query("select id, name, dob, address, phone, email, username, password, role from User_Hotel", this::mapRowToUser);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("select id, name, dob, address, phone, email, username, password, role from User_Hotel where username=?", this::mapRowToUser, username);
	}

	@Override
	public User check(Account acc) {
		//jdbc.queryForObject("select username, password from User_Hotel where username=? and password=?", this::mapRowToUserAcc, )
		return jdbc.queryForObject("select id, name, dob, address, phone, email, username, password, role from User_Hotel where email=? and password=?", this::mapRowToUser, acc.getEmail(), acc.getPassword());
		
	}
	@Override
	public User saveAcc(User user) {
		// TODO Auto-generated method stub
		jdbc.update("insert into User_Hotel(name, dob, address, phone, email, username, password) values( ?, ?, ?, ?, ?, ?, ?)",
				user.getName(),
				user.getBirthday(),
				user.getAddress(),
				user.getPhone(),
				user.getEmail(),
				user.getUsername(),
				user.getPassword());
		return user;
	}
	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		jdbc.update("update User_Hotel Set id=?, name=?, dob=? ,address=?, phone=?, email=?, username=?, password=?) ",
				user.getId(),
				user.getName(),
				user.getBirthday(),
				user.getAddress(),
				user.getPhone(),
				user.getEmail(),
				user.getUsername(),
				user.getPassword());
		return user;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	public User mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
		return new User(rs.getInt("id"), rs.getString("name"),rs.getDate("dob"),rs.getString("address"),rs.getString("phone"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getInt("role"));
	}
	
	@Override
	public User findById(int code) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("select id, name, dob, address, phone, email, username, password, role from User_Hotel where id=?", this::mapRowToUser, code);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("select id, name, dob, address, phone, email, username, password, role from User_Hotel where email=?", this::mapRowToUser, email);
	}

	@Override
	public List<User> search(String keyword) {
		// TODO Auto-generated method stub
		String keywords = "%"+keyword+"%";
		return jdbc.query("select * from user_hotel c where c.name like ? or c.phone like ? ", this::mapRowToUser, keywords, keywords);
	}

}
