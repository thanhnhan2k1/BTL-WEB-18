package hotel.web;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.data.CartRepository;
import hotel.data.RoomRepository;
import hotel.entity.Cart;
import hotel.entity.Room;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/cart")
@Slf4j
public class CartController {
	private final CartRepository cartRepo;
	private final RoomRepository roomRepo;
	@Autowired
	public CartController(CartRepository cartRepo, RoomRepository roomRepo) {
		this.cartRepo = cartRepo;
		this.roomRepo = roomRepo;
	}
	@ModelAttribute
	public void addRoomtoCart(@RequestParam(name="id") int code, Model model) {
		ArrayList<Cart> carts = new ArrayList<>();
		try{
			cartRepo.checkExists(code);
			
		}catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			cartRepo.save(code);
		}
		cartRepo.findAll().forEach(carts::add);
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
	public String showmycart(@RequestParam(name="id") int code, ArrayList<Room> rooms, Model model, HttpSession session) {
		//addRoomtoCart(code, model);
		//model.addAttribute("rooms", rooms);
		String username = (String) session.getAttribute("username");
		if(username==null) {
			return "usererrors";
		}
		model.addAttribute("cart", rooms);
		return "cart";
	}
	
	@PostMapping(name = "payment")
	public String paymentform(ArrayList<Room> rooms, Model model) {
		return "redirect:/payment";
	}
}
