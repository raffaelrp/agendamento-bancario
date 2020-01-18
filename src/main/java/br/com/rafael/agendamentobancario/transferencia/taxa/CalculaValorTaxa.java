package br.com.rafael.agendamentobancario.transferencia.taxa;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface CalculaValorTaxa {
	
	BigDecimal calculaValorTaxa(LocalDate dataRealizadaAgendamento, LocalDate dataDoAgendamento, BigDecimal valorDaTransferencia);

}
