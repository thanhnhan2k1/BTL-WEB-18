package hotel.web;

import java.lang.ProcessHandle.Info;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import hotel.data.CartRepository;
import hotel.data.RoomRepository;
import hotel.entity.Cart;
import hotel.entity.Room;

@Controller
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
	private final CartRepository cartRepo;
	private final RoomRepository roomRepo;
	@Autowired
	public PaymentController(CartRepository cartRepo, RoomRepository roomRepo) {
		this.cartRepo = cartRepo;
		this.roomRepo = roomRepo;
	}
	@ModelAttribute
	public void getCart(Model model) {
		ArrayList<Cart> carts = new ArrayList<>();
		cartRepo.findAll().forEach(carts::add);
		ArrayList<Room> rooms = new ArrayList<>();
		for(Cart cart: carts) {
			Room r = roomRepo.findbyCode(cart.getRoomcode());
			rooms.add(r);
		}
		model.addAttribute("rooms", rooms);
	}
	@GetMapping
	public String showpayment(ArrayList<Room> rooms, Model model) {
		//model.addAttribute("rooms", rooms);
		log.info("rooms: "+ rooms.size());
		return "payment";
	}
}
