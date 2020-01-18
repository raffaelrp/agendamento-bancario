package br.com.rafael.agendamentobancario.transferencia.taxa;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.rafael.agendamentobancario.utils.DateUtil;

public class CalculaValorTaxaB implements CalculaValorTaxa {
	
	private final static BigDecimal VALOR_MULTIPLICADOR = new BigDecimal("12");
	
	public BigDecimal calculaValorTaxa(LocalDate dataRealizadaAgendamento, LocalDate dataDoAgendamento, BigDecimal valorDaTransferencia) {
		
		long quantidadeDeDias = DateUtil.CalculaDiasEntreDatas(dataRealizadaAgendamento, dataDoAgendamento);

		BigDecimal valorTaxa =  new BigDecimal(quantidadeDeDias).multiply(VALOR_MULTIPLICADOR);
		return valorTaxa;
		
	}

}
