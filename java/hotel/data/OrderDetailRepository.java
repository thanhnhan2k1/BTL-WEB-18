package hotel.data;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import hotel.entity.OrderDetail;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long>{
	@Query(value = "Select * from order_details WHERE roomid =?1 and checkout > ?2 AND checkin < ?3", nativeQuery = true)
	ArrayList<OrderDetail> findByroomidcheckoutcheckin(int roomid, Date checkout, Date checkin);
}
