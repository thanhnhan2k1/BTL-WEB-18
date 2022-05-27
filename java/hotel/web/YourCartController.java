package hotel.web;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.data.CartRepository;
import hotel.data.RoomRepository;
import hotel.entity.Cart;
import hotel.entity.Room;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/yourCart")
public class YourCartController {
	private final CartRepository cartRepo;
	private final RoomRepository roomRepo;
	@Autowired
	public YourCartController(CartRepository cartRepo, RoomRepository roomRepo) {
		this.cartRepo = cartRepo;
		this.roomRepo = roomRepo;
	}
	
	@ModelAttribute
	public void yourCart(Model model, HttpSession session) {
		ArrayList<Cart> carts = new ArrayList<>();
		int userid = (int) session.getAttribute("userid");
		cartRepo.findByUserId(userid).forEach(carts::add);
		model.addAttribute("carts", carts);
		ArrayList<Room> rooms = new ArrayList<>();
		for(Cart cart: carts) {
			try {
			Room r = roomRepo.findbyCode(cart.getRoomcode());
			r.setChecked(false);
			rooms.add(r);
			}
			catch(EmptyResultDataAccessException ex) {
				ex.printStackTrace();
			}
		}
		model.addAttribute("rooms", rooms);
	}
	@GetMapping()
	public String showCart(ArrayList<Room> rooms,Model model) {
		return "cart";
	}
}
