package br.com.rafael.agendamentobancario.taxa;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import br.com.rafael.agendamentobancario.transferencia.taxa.CalculaValorTaxa;
import br.com.rafael.agendamentobancario.transferencia.taxa.CalculaValorTaxaA;

public class CalculoTaxaTipoATest {

	@Test
	public void TestaSeCalculoTaxaTipoAEstaCorreto() {
		
		//Variaveis para Transação no mesmo dia
		LocalDate dataRealizadaAgendamento = LocalDate.of(2020, 1, 1);
		LocalDate dataDoAgendamento = LocalDate.of(2020, 1, 1);
		BigDecimal valorDaTransferencia = new BigDecimal("1000");

		CalculaValorTaxa tipoDeCalculo = new CalculaValorTaxaA();

		BigDecimal valorTaxaCalculada = tipoDeCalculo.calculaValorTaxa(dataRealizadaAgendamento, dataDoAgendamento, valorDaTransferencia);

		Assert.isTrue(valorTaxaCalculada.compareTo(new BigDecimal("33.00")) == 0, "Valor deve ser igual a 33.00");
	}
}
