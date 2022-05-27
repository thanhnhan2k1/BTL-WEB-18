package hotel.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.Session;
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
import hotel.entity.Account;
import hotel.entity.User;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {
	private final UserRepository userRepo;
	private String mes="";
	 
	@Autowired
	public LoginController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@GetMapping()
	public String showloginForm(Model model) {
		model.addAttribute("acc", new Account(null, null));
		model.addAttribute("mes", mes);
		return "login";
	}

	@PostMapping
	public String verifyAccount(Account acc, Model model, HttpSession session) {
		try {
			userRepo.check(acc);
			User u = userRepo.findByEmail(acc.getEmail());
			model.addAttribute("email", u.getEmail());
			model.addAttribute("username", u.getUsername());
			model.addAttribute("mes", mes);
			log.info("User login: "+u.getUsername());
			session.setAttribute("username", u.getUsername());
			session.setAttribute("userid", u.getId());
			if(u.getRole() == 1) {
				return "redirect:/homepage";
			}
			else {
				return "stats";
			}
		}
		catch(EmptyResultDataAccessException e) {
			//e.printStackTrace();
			mes = "Wrong username or password. Please enter again.";
			model.addAttribute("mes", mes);
			log.info("User login: "+acc+" "+mes);
			return "redirect:/login";
		}
	}

}
