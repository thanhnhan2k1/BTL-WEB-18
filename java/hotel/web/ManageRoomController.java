package hotel.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hotel.entity.Room;
import hotel.data.RoomRepository;

import org.springframework.validation.BindingResult;

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
	public String showRoom() {
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
		model.addAttribute("room", new Room(0,null,null,0,null,0));
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
		model.addAttribute(room);
		return "redirect:/manageRoom";
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

	@PostMapping("/edit")
	public String editProduct(Room room, Model model) {
		roomRepo.update(room);
		model.addAttribute(room);
		log.info("Product saved: " + room);
		return "redirect:/manageRoom";
	}
}