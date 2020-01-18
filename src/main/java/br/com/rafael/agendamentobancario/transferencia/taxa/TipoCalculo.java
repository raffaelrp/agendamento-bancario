package br.com.rafael.agendamentobancario.transferencia.taxa;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.rafael.agendamentobancario.utils.DateUtil;


public class TipoCalculo {
	
	private final static BigDecimal VALOR_100MIL = new BigDecimal("100000");
	
	public static CalculaValorTaxa getTipoCalculo(LocalDate dataRealizadaAgendamento, LocalDate dataDoAgendamento, BigDecimal valorDaTransferencia) throws Exception 
	{
		return verificaQualTipoDeCalculo(dataRealizadaAgendamento, dataDoAgendamento, valorDaTransferencia);
	}
	
	private static CalculaValorTaxa verificaQualTipoDeCalculo(LocalDate dataRealizadaAgendamento, LocalDate dataDoAgendamento, BigDecimal valorDaTransferencia) throws Exception {

		long quantidadeDeDias = DateUtil.CalculaDiasEntreDatas(dataRealizadaAgendamento, dataDoAgendamento);

		if (quantidadeDeDias == 0) 
		{
			return new CalculaValorTaxaA();
		}
		else if(quantidadeDeDias > 0 && quantidadeDeDias <= 10 ) 
		{
			return new CalculaValorTaxaB();
		}
		else if(quantidadeDeDias > 10 && quantidadeDeDias <= 40) 
		{
			return new CalculaValorTaxaC();
		} 
		else if (quantidadeDeDias > 40 && valorDaTransferencia.compareTo(VALOR_100MIL) > 0) 
		{
			return new CalculaValorTaxaC();
		}
		else {
			throw new Exception("Não ha taxa aplicavel para esta transação");
		}
	}

}
