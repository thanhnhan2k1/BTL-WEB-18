package hotel.web;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.data.RoomRepository;
import hotel.entity.Room;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/manageRoom/add")
public class AddRoomController {
	private final RoomRepository roomRepo;

	@Autowired
	public AddRoomController(RoomRepository roomRepo) {
		this.roomRepo = roomRepo;
	}
	@GetMapping()
	public String addRoom(Model model) {
		model.addAttribute("room", new Room(0,null,null,0,null,0));
		return "addroom";
	}
	@PostMapping("/add")
	public String saveRoom(Room room, Model model) {
		log.info("Product saved: " + room);
		try {
			Room r = roomRepo.findbyCode(room.getCode());
			return "addRoom";
		}
		catch(EmptyResultDataAccessException e) {
			roomRepo.save(room);
			model.addAttribute(room);
			log.info("Product saved: " + room);
			e.printStackTrace();
			return "redirect:/manageRoom";
		}
	}
}
*/