package hotel.data;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import hotel.entity.OrderDetail;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long>{
	ArrayList<OrderDetail> findByroomid(int roomid);
}
