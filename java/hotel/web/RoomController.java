package hotel.web;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.data.RoomRepository;
import hotel.entity.Cart;
import hotel.entity.Room;
import hotel.entity.SearchRoom;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/rooms")
public class RoomController {
	private RoomRepository roomRepo;
	
	@Autowired
	public RoomController(RoomRepository roomRepo) {
		this.roomRepo = roomRepo;
	}
	@ModelAttribute
	public void addRoomsToModel(Model model) {
		List<Room> rooms = new ArrayList<>();
		roomRepo.findAll().forEach(rooms::add);
		model.addAttribute("listroom", rooms);
		model.addAttribute("search", new SearchRoom());
		//log.info("List room: "+rooms);
	}
	
	@GetMapping()
	public String showRoomsList(Model model, HttpSession session) {
		addRoomsToModel(model);
		String username = (String) session.getAttribute("username");
		if(username==null) {
			return "usererrors";
		}
		return "rooms";
	}
	@GetMapping("/detailRoom")
	public String detailRooms(@RequestParam("code") int code, Model model) {
		Room roomX = roomRepo.findbyCode(code);
		model.addAttribute("room", roomX);
		model.addAttribute("image", roomX.getRoom_img());
		return "detailRoomuser";
	}
	
	@PostMapping()
	public String showRoomDetail(SearchRoom search, Model model, HttpSession session) {
		ArrayList<Room> rooms = new ArrayList<>();
		roomRepo.searchFreeRoom(search).forEach(rooms::add);
		model.addAttribute("roomlist", rooms);
		//log.info("Search room: "+search.getCheckin()+" "+search.getCheckout());
		return "redirect:/searchFreeRoom";
	}
	
}
