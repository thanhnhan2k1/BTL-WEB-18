package hotel.data;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import hotel.entity.Room;
import hotel.entity.SearchRoom;

public interface RoomRepository {
	Iterable<Room> findAll();
	Room findbyname(String name);
	Room findbyCode(int code);
	Room saveRoom(Room room);
	void save(Room room);
	void update(Room room);
	Iterable<Room> searchFreeRoom(SearchRoom search);
	void delete(Room room);
	
}
