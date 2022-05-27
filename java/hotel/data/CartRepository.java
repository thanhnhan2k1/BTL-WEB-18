package hotel.data;

import java.util.Iterator;

import org.springframework.stereotype.Repository;

import hotel.entity.Cart;
public interface CartRepository {
	Iterable<Cart> findAll();
	Iterable<Cart> findByUserId(int userid);
	int save(int code);
	Cart checkExists(int code);
	void delete(int code);
}
