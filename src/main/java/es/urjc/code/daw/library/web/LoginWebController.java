package es.urjc.code.daw.library.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginWebController {
	
	@GetMapping(path="/login")
	public String login(Model model) {

		return "login";
	}

	@GetMapping(path="/loginerror")
	public String loginerror(Model model) {
		return "loginerror";
	}


	

}
