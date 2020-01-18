package br.com.rafael.agendamentobancario.transferencia.taxa;

import java.math.BigDecimal;
import java.time.LocalDate;


public class CalculaValorTaxaA implements CalculaValorTaxa{

	private final static BigDecimal VALOR_FIXO = new BigDecimal("3");
	
	private final static BigDecimal PORCENTAGEM_TAXA = new BigDecimal("0.03");
	
	public BigDecimal calculaValorTaxa(LocalDate dataRealizadaAgendamento, LocalDate dataDoAgendamento, BigDecimal valorDaTransferencia) {

		BigDecimal valorPercentualDaTaxa = valorDaTransferencia.multiply(PORCENTAGEM_TAXA);
		BigDecimal valorTaxa = VALOR_FIXO.add(valorPercentualDaTaxa);
		return valorTaxa;
		
	}
}
