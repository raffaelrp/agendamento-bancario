package br.com.rafael.agendamentobancario.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataAgendada", nullable = false)
    private Date dataAgendada;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataRealizadaAgendamento", nullable = false)
	private Date dataRealizadaAgendamento;

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

	public Date getDataAgendada() {
		return dataAgendada;
	}

	public void setDataAgendada(Date dataAgendada) {
		this.dataAgendada = dataAgendada;
	}

	public Date getDataRealizadaAgendamento() {
		return dataRealizadaAgendamento;
	}

	public void setDataRealizadaAgendamento(Date dataRealizadaAgendamento) {
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
