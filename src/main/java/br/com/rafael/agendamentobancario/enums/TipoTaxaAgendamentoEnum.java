package br.com.rafael.agendamentobancario.enums;

public enum TipoTaxaAgendamentoEnum {

	TAXA_TIPO_A("A"),
	TAXA_TIPO_B("B"),
	TAXA_TIPO_C("C");

	private String tipo;
	
	private TipoTaxaAgendamentoEnum(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo(){
		return this.tipo;
	}

	
	
}
