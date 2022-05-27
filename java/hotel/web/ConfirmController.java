package hotel.web;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.data.CartRepository;
import hotel.data.OrderDetailRepository;
import hotel.data.RoomRepository;
import hotel.entity.Cart;
import hotel.entity.OrderDetail;
import hotel.entity.Room;

@Controller
@RequestMapping("/confirm")
public class ConfirmController {
	private final CartRepository cartRepo;
	private final RoomRepository roomRepo;
	private final OrderDetailRepository odRepo;
	@Autowired
	public ConfirmController(CartRepository cartRepo, RoomRepository roomRepo, OrderDetailRepository odRepo) {
		this.cartRepo = cartRepo;
		this.roomRepo = roomRepo;
		this.odRepo = odRepo;
	}
	@GetMapping()
	public String showconfirm() {
		return "confirmco";
	}
	@PostMapping()
	public String showHome(HttpSession session) {
		ArrayList<Cart> carts = new ArrayList<>();
		cartRepo.findAll().forEach(carts::add);
		for(Cart cart: carts) {
			Date checkin = (Date) session.getAttribute("checkin");
			Date checkout = (Date) session.getAttribute("checkout");
			int userid = (int) session.getAttribute("userid");
			OrderDetail or = new OrderDetail();
			or.setCheckin(checkin);
			or.setCheckout(checkout);
			or.setUserid(userid);
			cartRepo.delete(cart.getId());
			Room r = roomRepo.findbyCode(cart.getRoomcode());
			or.setRoomid(r.getCode());
			or.setPrice(r.getPrice());
			or.setAmount((int)(r.getPrice()-(int)r.getPrice()*r.getSaleoff()));
			or.setSaleoff(r.getSaleoff());
			odRepo.save(or);
		}
		return "home";
	}
}
