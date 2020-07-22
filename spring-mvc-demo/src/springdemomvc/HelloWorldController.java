package springdemomvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	// m�todo para mostrar o form HTML
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// m�todo para processar o form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

}
