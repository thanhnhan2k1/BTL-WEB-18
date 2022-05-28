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
//import hotel.entity.Account;
//import hotel.entity.User;

@Slf4j
@Controller
@RequestMapping("/profile")
public class ProfileController {
	 

	@GetMapping()
	public String showloginForm(Model model) {
		return "profile";
	}

}
