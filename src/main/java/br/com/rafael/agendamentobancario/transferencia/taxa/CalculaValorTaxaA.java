package br.com.rafael.agendamentobancario.transferencia.taxa;

import java.math.BigDecimal;

import br.com.rafael.agendamentobancario.models.Agendamento;

public class CalculaValorTaxaA implements CalculaValorTaxa{

	private final static BigDecimal VALOR_FIXO = new BigDecimal("2");
	
	private final static BigDecimal PORCENTAGEM_TAXA = new BigDecimal("0.03");
	
	public BigDecimal calculaValorTaxa(Agendamento agendamento) {

		BigDecimal valorPercentualDaTaxa = agendamento.getValorDaTransferencia().multiply(PORCENTAGEM_TAXA);
		BigDecimal valorTaxa = VALOR_FIXO.add(valorPercentualDaTaxa);
		return valorTaxa;
		
	}
}
