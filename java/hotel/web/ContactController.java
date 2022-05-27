package hotel.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.entity.Contact;

@Controller
@RequestMapping("/contact")
public class ContactController {
	@GetMapping()
	public String showContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact";
	}
	@PostMapping
	public String processContact(Contact con , Model model) {
		String message="Cảm ơn bạn đã liên hệ với chúng tôi. Chúng tôi sẽ hồi âm bạn sớm nhất có thể.";
		model.addAttribute("message", message);
		
		return "contact";
	}
}
