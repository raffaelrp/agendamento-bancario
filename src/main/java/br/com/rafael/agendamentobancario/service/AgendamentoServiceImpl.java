package br.com.rafael.agendamentobancario.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafael.agendamentobancario.models.Agendamento;
import br.com.rafael.agendamentobancario.repository.AgendamentoRepository;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{
	
	@Autowired
	AgendamentoRepository agendamentoRepository;

	@Override
	@Transactional
	public Agendamento save(Agendamento agendamento) {
		return agendamentoRepository.save(agendamento);
		
	}

}
