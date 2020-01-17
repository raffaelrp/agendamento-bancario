package br.com.rafael.agendamentobancario.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;
	
    @Column(name = "contaDeOrigem", length = 6, nullable = false)
	private String contaDeOrigem;
    
    @Column(name = "contaDeDestino", length = 6, nullable = false)
	private String contaDeDestino;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dataAgendada", nullable = false)
    private LocalDate dataAgendada;
    
    @Column(name = "dataRealizadaAgendamento", nullable = false)
	private LocalDate dataRealizadaAgendamento;

    @Column(name = "valorDaTransferencia", nullable = false)
	private BigDecimal valorDaTransferencia;
    
    @Column(name = "valorTaxa", nullable = false)
	private BigDecimal valorTaxa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContaDeOrigem() {
		return contaDeOrigem;
	}

	public void setContaDeOrigem(String contaDeOrigem) {
		this.contaDeOrigem = contaDeOrigem;
	}

	public String getContaDeDestino() {
		return contaDeDestino;
	}

	public void setContaDeDestino(String contaDeDestino) {
		this.contaDeDestino = contaDeDestino;
	}

	public LocalDate getDataAgendada() {
		return dataAgendada;
	}

	public void setDataAgendada(LocalDate dataAgendada) {
		this.dataAgendada = dataAgendada;
	}

	public LocalDate getDataRealizadaAgendamento() {
		return dataRealizadaAgendamento;
	}

	public void setDataRealizadaAgendamento(LocalDate dataRealizadaAgendamento) {
		this.dataRealizadaAgendamento = dataRealizadaAgendamento;
	}

	public BigDecimal getValorDaTransferencia() {
		return valorDaTransferencia;
	}

	public void setValorDaTransferencia(BigDecimal valorDaTransferencia) {
		this.valorDaTransferencia = valorDaTransferencia;
	}

	public BigDecimal getValorTaxa() {
		return valorTaxa;
	}

	public void setValorTaxa(BigDecimal valorTaxa) {
		this.valorTaxa = valorTaxa;
	}


    
}
