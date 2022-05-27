package hotel.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminpage")
public class AdminHomeController {
	@GetMapping
	public String homeClient() {
		return "adminpage";
	}
}
