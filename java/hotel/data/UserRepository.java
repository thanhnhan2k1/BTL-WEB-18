package hotel.data;

import java.util.List;

import hotel.entity.Account;
import hotel.entity.User;

public interface UserRepository {
	Iterable<User> findAll();
	User findByUsername(String username);
	User findByEmail(String email);
	User findById(int code);
	User check(Account acc);
	User saveAcc(User user);
	User update(User user);
	void deleteById(String id);
	List<User> search(String keyword);
}
