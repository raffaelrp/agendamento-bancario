package br.com.rafael.agendamentobancario.taxa;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import br.com.rafael.agendamentobancario.transferencia.taxa.CalculaValorTaxa;
import br.com.rafael.agendamentobancario.transferencia.taxa.CalculaValorTaxaB;

public class CalculoTaxaTipoBTest {

	@Test
	public void TestaSeCalculoTaxaTipoBEstaCorreto() {

		//Variaveis para Transação com 8 dias
		LocalDate dataRealizadaAgendamento = LocalDate.of(2020, 1, 1);
		LocalDate dataDoAgendamento = LocalDate.of(2020, 1, 9);
		BigDecimal valorDaTransferencia = new BigDecimal("1000");

		CalculaValorTaxa tipoDeCalculo = new CalculaValorTaxaB();

		BigDecimal valorTaxaCalculada = tipoDeCalculo.calculaValorTaxa(dataRealizadaAgendamento, dataDoAgendamento, valorDaTransferencia);

		Assert.isTrue(valorTaxaCalculada.compareTo(new BigDecimal("96.00")) == 0, "Valor deve ser igual a 96.00");
	}
	
}
