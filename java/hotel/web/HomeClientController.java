package hotel.web;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.entity.User;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/homepage")
public class HomeClientController {
	@GetMapping
	public String homeClient() {
		return "home";
	}
}
