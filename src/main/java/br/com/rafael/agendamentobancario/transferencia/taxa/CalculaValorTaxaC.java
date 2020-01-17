package br.com.rafael.agendamentobancario.transferencia.taxa;

import java.math.BigDecimal;

import br.com.rafael.agendamentobancario.models.Agendamento;
import br.com.rafael.agendamentobancario.utils.DateUtil;

public class CalculaValorTaxaC implements CalculaValorTaxa {
	
	private final static BigDecimal PERCENTUAL_TAXA_ENTRE_11_E_20_DIAS = new BigDecimal("0.08");
	private final static BigDecimal PERCENTUAL_TAXA_ENTRE_21_E_30_DIAS = new BigDecimal("0.06");
	private final static BigDecimal PERCENTUAL_TAXA_ENTRE_31_E_40_DIAS = new BigDecimal("0.04");
	private final static BigDecimal PERCENTUAL_TAXA_ACIMA_40_DIAS_E_VALOR_SUPERIOR_100MIL = new BigDecimal("0.02");
	private final static BigDecimal VALOR_100MIL = new BigDecimal("100.000");
	

	public BigDecimal calculaValorTaxa(Agendamento agendamento) {
				
		BigDecimal valorTaxa = null;
		
		BigDecimal valorDaTransferencia = agendamento.getValorDaTransferencia();
		
		long quantidadeDeDias = DateUtil.CalculaDiasEntreDatas(agendamento.getDataRealizadaAgendamento(), agendamento.getDataAgendada());
		
		if(quantidadeDeDias > 10 &&  quantidadeDeDias <= 20) {
			valorTaxa = valorDaTransferencia.multiply(PERCENTUAL_TAXA_ENTRE_11_E_20_DIAS);
		}
		else if (quantidadeDeDias > 20 &&  quantidadeDeDias <= 30) {
			valorTaxa = valorDaTransferencia.multiply(PERCENTUAL_TAXA_ENTRE_21_E_30_DIAS);
		}
		else if(quantidadeDeDias > 30 &&  quantidadeDeDias <= 40) {
			valorTaxa = valorDaTransferencia.multiply(PERCENTUAL_TAXA_ENTRE_31_E_40_DIAS);
		}
		else if (quantidadeDeDias > 40 &&  agendamento.getValorDaTransferencia().compareTo(VALOR_100MIL) > 1) {
			valorTaxa = valorDaTransferencia.multiply(PERCENTUAL_TAXA_ACIMA_40_DIAS_E_VALOR_SUPERIOR_100MIL);
		}
		
		return valorTaxa;
	
	}
	
}
