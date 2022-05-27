package hotel.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.entity.User;

@Controller
@RequestMapping("/thanks")
public class ThanksController {
	@GetMapping()
	public String showThanks() {
		return "thanksregister";
	}
	@PostMapping
	public String processThanks(User user, Model model) {
		model.addAttribute(user);
		
		return "redirect:/login";
	}
}
