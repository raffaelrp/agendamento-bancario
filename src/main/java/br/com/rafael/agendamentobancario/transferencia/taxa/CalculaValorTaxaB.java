package br.com.rafael.agendamentobancario.transferencia.taxa;

import java.math.BigDecimal;

import br.com.rafael.agendamentobancario.models.Agendamento;
import br.com.rafael.agendamentobancario.utils.DateUtil;

public class CalculaValorTaxaB implements CalculaValorTaxa {
	
	private final static BigDecimal VALOR_MULTIPLICADOR = new BigDecimal("12");
	
	public BigDecimal calculaValorTaxa(Agendamento agendamento) {
		
		long quantidadeDeDias = DateUtil.CalculaDiasEntreDatas(agendamento.getDataRealizadaAgendamento(), agendamento.getDataAgendada());
			
		BigDecimal valorTaxa =  new BigDecimal(quantidadeDeDias).multiply(VALOR_MULTIPLICADOR);
		return valorTaxa;
		
	}

}
