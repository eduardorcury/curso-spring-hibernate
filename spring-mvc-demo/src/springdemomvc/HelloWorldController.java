package springdemomvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	// m�todo para ler os dados e adicionar ao model
	@RequestMapping("/processFormVersionTwo")
	public String caps(HttpServletRequest request, Model model) {
		
		// ler o par�metro do form
		String name = request.getParameter("studentName");
		
		// converter para letra mai�scula
		name = name.toUpperCase();
		
		// criar a mensagem
		String result = "Ol�! " + name;
		
		// adicionar a mensagem ao model
		model.addAttribute("message", result);
		
		return "helloworld";
	}

}
