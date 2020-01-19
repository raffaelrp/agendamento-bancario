package br.com.rafael.agendamentobancario.taxa;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import br.com.rafael.agendamentobancario.transferencia.taxa.CalculaValorTaxa;
import br.com.rafael.agendamentobancario.transferencia.taxa.CalculaValorTaxaC;

public class CalculoTaxaTipoCTest {

	@Test
	public void TestaSeCalculoTaxaTipoCComDiferencaEntreOnzeEVinteDiasEstaCorreto() {

		//Variaveis para Transação entre 11 e 20 dias
		LocalDate dataRealizadaAgendamento = LocalDate.of(2020, 1, 1);
		LocalDate dataDoAgendamento = LocalDate.of(2020, 1, 12);
		BigDecimal valorDaTransferencia = new BigDecimal("1000");

		CalculaValorTaxa tipoDeCalculo = new CalculaValorTaxaC();

		BigDecimal valorTaxaCalculada = tipoDeCalculo.calculaValorTaxa(dataRealizadaAgendamento, dataDoAgendamento, valorDaTransferencia);

		Assert.isTrue(valorTaxaCalculada.compareTo(new BigDecimal("80.00")) == 0, "Valor deve ser igual a 80.00");
		
	}
	
	@Test
	public void TestaSeCalculoTaxaTipoCComDiferencaEntreVinteEUmETrintaDiasEstaCorreto() {

		//Variaveis para Transação entre 21 e 30 dias
		LocalDate dataRealizadaAgendamento = LocalDate.of(2020, 1, 1);
		LocalDate dataDoAgendamento = LocalDate.of(2020, 1, 22);
		BigDecimal valorDaTransferencia = new BigDecimal("1000");

		CalculaValorTaxa tipoDeCalculo = new CalculaValorTaxaC();

		BigDecimal valorTaxaCalculada = tipoDeCalculo.calculaValorTaxa(dataRealizadaAgendamento, dataDoAgendamento, valorDaTransferencia);

		Assert.isTrue(valorTaxaCalculada.compareTo(new BigDecimal("60.00")) == 0, "Valor deve ser igual a 60.00");
		
	}	
	
	@Test
	public void TestaSeCalculoTaxaTipoCComDiferencaEntreTrintaEUmEQuarentaDiasEstaCorreto() {

		//Variaveis para Transação entre 31 a 40 dias
		LocalDate dataRealizadaAgendamento = LocalDate.of(2020, 1, 1);
		LocalDate dataDoAgendamento = LocalDate.of(2020, 2, 3);
		BigDecimal valorDaTransferencia = new BigDecimal("1000");

		CalculaValorTaxa tipoDeCalculo = new CalculaValorTaxaC();

		BigDecimal valorTaxaCalculada = tipoDeCalculo.calculaValorTaxa(dataRealizadaAgendamento, dataDoAgendamento, valorDaTransferencia);

		Assert.isTrue(valorTaxaCalculada.compareTo(new BigDecimal("40.00")) == 0, "Valor deve ser igual a 40.00");
		
	}
	
	@Test
	public void TestaSeCalculoTaxaTipoCComMaisDeQuarentaDiasEValorTransferenciaMaiorQueCemMil() {

		//Variaveis para Transação superior a 40 dias e valor de transferencia maior que 100 mil.
		LocalDate dataRealizadaAgendamento = LocalDate.of(2020, 1, 1);
		LocalDate dataDoAgendamento = LocalDate.of(2020, 2, 12);
		BigDecimal valorDaTransferencia = new BigDecimal("100001");

		CalculaValorTaxa tipoDeCalculo = new CalculaValorTaxaC();

		BigDecimal valorTaxaCalculada = tipoDeCalculo.calculaValorTaxa(dataRealizadaAgendamento, dataDoAgendamento, valorDaTransferencia);

		Assert.isTrue(valorTaxaCalculada.compareTo(new BigDecimal("2000.02")) == 0, "Valor deve ser igual a 2000.02‬");
		
	}		
}
