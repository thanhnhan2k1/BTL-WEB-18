package hotel.web;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.data.RoomRepository;
import hotel.entity.Room;
import hotel.entity.SearchRoom;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/searchFreeRoom")
public class SearchRoomController {
	
	private RoomRepository roomRepo;
	
	@Autowired
	public SearchRoomController(RoomRepository roomRepo) {
		this.roomRepo = roomRepo;
	}
	@ModelAttribute
	public void addRoomsToModel(@RequestParam(name="checkin") Date checkin, @RequestParam(name="checkout") Date checkout, Model model, HttpSession session) {
		List<Room> rooms = new ArrayList<>();
		SearchRoom search = new SearchRoom();
		//Date ci = Date.valueOf(checkin);
		//Date co = Date.valueOf(checkout);
		search.setCheckin(checkin);
		search.setCheckout(checkout);
		session.setAttribute("checkin", checkin);
		session.setAttribute("checkout", checkout);
		roomRepo.searchFreeRoom(search).forEach(rooms::add);
		model.addAttribute("listroom", rooms);
		log.info("Search room: "+search.getCheckin()+" "+search.getCheckout());
	}
	
	@GetMapping()
	public String showRoomsList(@RequestParam(required = false ,name="checkin") Date checkin, @RequestParam(required = false, name="checkout") Date checkout, Model model, HttpSession session) {
		
		return "searchFreeRoom";
	}
	@PostMapping()
	public String showRoomDetail(SearchRoom search, Model model, HttpSession session) {
		ArrayList<Room> rooms = new ArrayList<>();
		roomRepo.searchFreeRoom(search).forEach(rooms::add);
		model.addAttribute("roomlist", rooms);
		
		return "searchFreeRoom";
	}
}
