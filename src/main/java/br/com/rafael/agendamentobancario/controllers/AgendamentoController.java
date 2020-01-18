package br.com.rafael.agendamentobancario.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.rafael.agendamentobancario.models.Agendamento;
import br.com.rafael.agendamentobancario.repository.AgendamentoRepository;
import br.com.rafael.agendamentobancario.service.AgendamentoService;

@Controller
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendamentoService;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("agendamento", new Agendamento());

		return "agendamento.html";
	}

	@GetMapping("agendamento")
	public void index(Model model) {
		main(model);
	}
	
    @GetMapping("listAgendamentos")
    public String showUpdateForm(Model model) {
        model.addAttribute("agendamentoList", agendamentoRepository.findAll());
        return "listaAgendamento";
    }

	@PostMapping("/cadastrarAgendamento")
	public String cadastrarAgendamento(@ModelAttribute Agendamento agendamento, Model model) {

		try {

			agendamentoService.save(agendamento);

			model.addAttribute("agendamento",new Agendamento());
			model.addAttribute("message", "Transferencia agendada com Sucesso");
			model.addAttribute("alertClass", "alert-success");;

		} catch (Exception e) {

			model.addAttribute("message", e.getMessage());
			model.addAttribute("alertClass", "alert-danger");

		}

		return "agendamento"; 
	}


}
