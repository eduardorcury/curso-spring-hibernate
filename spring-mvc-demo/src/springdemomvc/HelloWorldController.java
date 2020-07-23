package springdemomvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// método para mostrar o form HTML
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// método para processar o form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// método para ler os dados e adicionar ao model
	@RequestMapping("/processFormVersionTwo")
	public String caps(HttpServletRequest request, Model model) {
		
		// ler o parâmetro do form
		String name = request.getParameter("studentName");
		
		// converter para letra maiúscula
		name = name.toUpperCase();
		
		// criar a mensagem
		String result = "Olá! " + name;
		
		// adicionar a mensagem ao model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	// usando @RequestParam
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String name, 
			Model model) {
		
		// converter para letra maiúscula
		name = name.toUpperCase();
		
		// criar a mensagem
		String result = "Olá! (versão três) " + name;
		
		// adicionar a mensagem ao model
		model.addAttribute("message", result);
		
		return "helloworld";
	}

}
