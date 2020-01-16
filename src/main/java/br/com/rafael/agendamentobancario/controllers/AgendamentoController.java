package br.com.rafael.agendamentobancario.controllers;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

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

	private Agendamento agendamento = newAgendamento();
	
	@ModelAttribute(value = "agendamento")
	public Agendamento newAgendamento()
	{
	    return new Agendamento();
	}
	
	
	@Autowired
	private AgendamentoService agendamentoService;
	
    @GetMapping("/")
    public String main() {

        return "agendamento.html";
    }
    
    @PostMapping("/cadastrarAgendamento")
    public String cadastrarAgendamento() {
    	
    	agendamentoService.save(agendamento);

        return "agendamento.html"; 
    }

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

}
