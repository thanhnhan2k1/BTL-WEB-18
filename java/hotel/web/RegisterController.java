package hotel.web;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import hotel.data.UserRepository;
import hotel.entity.User;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {
	private final UserRepository userRepo;
	private String mes="";
	
	@Autowired
	public RegisterController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@GetMapping()
	public String registerForm(Model model) {
		model.addAttribute("user", new User(null, null ,null, null, null, null, null));
		model.addAttribute("mes", mes);
		return "register";
	}
	@PostMapping
	public String addAccount(User user, Model model) {
		try{
			User u = userRepo.findByEmail(user.getEmail());
			mes = "Email is existed. Please enter again.";
			model.addAttribute("mes", mes);
			return "redirect:/register";
		}
		catch(EmptyResultDataAccessException ex) {
			model.addAttribute("user", user);
			userRepo.saveAcc(user);
			log.info("Account saved:" + user);
			ex.printStackTrace();
			return "redirect:/thanks";
		}
	}
	
}
