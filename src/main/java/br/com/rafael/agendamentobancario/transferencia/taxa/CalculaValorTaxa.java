package br.com.rafael.agendamentobancario.transferencia.taxa;

import java.math.BigDecimal;

import br.com.rafael.agendamentobancario.models.Agendamento;

public interface CalculaValorTaxa {
	
	BigDecimal calculaValorTaxa(Agendamento agendamento);

}
