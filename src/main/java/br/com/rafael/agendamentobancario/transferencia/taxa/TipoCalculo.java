package br.com.rafael.agendamentobancario.transferencia.taxa;

import java.math.BigDecimal;

import br.com.rafael.agendamentobancario.models.Agendamento;
import br.com.rafael.agendamentobancario.utils.DateUtil;



public class TipoCalculo {
	
	public static CalculaValorTaxa getTipoCalculo(Agendamento agendamento) {
		switch (verificaQualTipoDeCalculo(agendamento)) {
		case "TIPO_A":
			return new CalculaValorTaxaA();
		case "TIPO_B":
			return new CalculaValorTaxaB();
		case "TIPO_C":
			return new CalculaValorTaxaC();
		default:
			return null;
		}
		
	}
	
	private final static BigDecimal VALOR_100MIL = new BigDecimal("100.000");
	
	private static String verificaQualTipoDeCalculo(Agendamento agendamento) {
		
		long quantidadeDeDias = DateUtil.CalculaDiasEntreDatas(agendamento.getDataRealizadaAgendamento(), agendamento.getDataAgendada() );
		
		if (quantidadeDeDias == 0) {
			return "TIPO_A";
		}
		else if(quantidadeDeDias > 0 && quantidadeDeDias <= 10 ) {
			return "TIPO_B";
		}
		else if(quantidadeDeDias > 10 && quantidadeDeDias <= 40 || quantidadeDeDias > 40 && agendamento.getValorDaTransferencia().compareTo(VALOR_100MIL) > 1) {
			return "TIPO_C";
		}
		return null;
	}

}
