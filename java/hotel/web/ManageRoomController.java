package hotel.web;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.data.RoomRepository;
import hotel.entity.Room;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/manageRoom")
public class ManageRoomController {
	private final RoomRepository roomRepo;

	@Autowired
	public ManageRoomController(RoomRepository roomRepo) {
		this.roomRepo = roomRepo;
	}

	@ModelAttribute
	public void addRoomToModel(Model model) {
		ArrayList<Room> rooms = new ArrayList<>();
		roomRepo.findAll().forEach(rooms::add);
		model.addAttribute("rooms", rooms);
	}

	@GetMapping
	public String showRoom(HttpSession session) {
		int role = (int) session.getAttribute("role");
		String username = (String) session.getAttribute("username");
		if( role == 1|| username==null) {
			return "error";
		}
		return "manageroom";
	}
	
	@GetMapping("/detailRoom")
	public String detailRoom(@RequestParam("code") int code, Model model) {
		Room roomX = roomRepo.findbyCode(code);
		model.addAttribute("room", roomX);
		return "detailRoom";
	}
	
	@GetMapping("/add")
	public String addRoom(Model model) {
		model.addAttribute("room", new Room());
		return "addroom";
	}

	@GetMapping("/editForm")
	public String editFormRoom(@RequestParam("code") int code, Model model) {
		Room roomX = roomRepo.findbyCode(code);
		model.addAttribute("room", roomX);
		return "editroom";
	}
	
	@GetMapping("/confirmDelete")
	public String confirmDeleteRoom(@RequestParam("code") int code, Model model) {
		Room roomX = roomRepo.findbyCode(code);
		model.addAttribute("room", roomX);
		return "deleteroom";
	}

	@PostMapping("/delete")
	public String deleteRoom(Room room, Model model) {
		roomRepo.delete(room);
		return "redirect:/manageRoom";
	}

	@PostMapping("/add")
	public String saveRoom(@Valid Room room, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "addRoom";
		else {
			roomRepo.save(room);
			model.addAttribute(room);
			log.info("Product saved: " + room);
			return "redirect:/manageRoom";
		}
	}

	@PostMapping("/edit")
	public String editProduct(Room room, Model model) {
		roomRepo.update(room);
		model.addAttribute(room);
		log.info("Product saved: " + room);
		return "redirect:/manageRoom";
	}
}
