package br.com.rafael.agendamentobancario.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafael.agendamentobancario.models.Agendamento;
import br.com.rafael.agendamentobancario.repository.AgendamentoRepository;
import br.com.rafael.agendamentobancario.transferencia.taxa.CalculaValorTaxa;
import br.com.rafael.agendamentobancario.transferencia.taxa.TipoCalculo;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{
	
	@Autowired
	AgendamentoRepository agendamentoRepository;

	@Override
	@Transactional
	public Agendamento save(Agendamento agendamento) throws Exception {
		
		boolean isDataAnteriorAHoje = agendamento.getDataAgendada().isBefore(LocalDate.now());
		
		if (isDataAnteriorAHoje)
		throw new Exception("Nao é permitido agendamento para datas anteriores a hoje.");

		agendamento.setDataRealizadaAgendamento(LocalDate.now());

		CalculaValorTaxa tipoDeCalculo = TipoCalculo.getTipoCalculo(agendamento.getDataRealizadaAgendamento(), agendamento.getDataAgendada(), agendamento.getValorDaTransferencia());

		BigDecimal valorTaxaCalculada = tipoDeCalculo.calculaValorTaxa(agendamento.getDataRealizadaAgendamento(), agendamento.getDataAgendada(), agendamento.getValorDaTransferencia());

		agendamento.setValorTaxa(valorTaxaCalculada);

		return agendamentoRepository.save(agendamento);

	}

}
