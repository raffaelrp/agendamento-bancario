package br.com.rafael.agendamentobancario.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.rafael.agendamentobancario.models.Agendamento;
import br.com.rafael.agendamentobancario.service.AgendamentoService;

@Controller
public class AgendamentoController {
	
	private String message;

			
	@Autowired
	private AgendamentoService agendamentoService;
	
    @GetMapping("/")
    public String main(Model model) {
    	 model.addAttribute("agendamento", new Agendamento());

        return "agendamento.html";
    }
    
    @GetMapping("/agendamento.html")
    public void index(Model model) {
    	main(model);
    }
    
    @PostMapping("/cadastrarAgendamento")
    public String cadastrarAgendamento(@ModelAttribute Agendamento agendamento) {
    	
    	Agendamento agendamentoSalvo = agendamentoService.save(agendamento);

        return "agendamento.html"; 
    }


}
