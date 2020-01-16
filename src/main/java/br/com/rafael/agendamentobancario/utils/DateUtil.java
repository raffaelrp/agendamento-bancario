package br.com.rafael.agendamentobancario.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {
	
	public static long CalculaDiasEntreDatas(LocalDate primeiraData, LocalDate segundaData) {
		
		long numeroDeDiasEntreDatas = ChronoUnit.DAYS.between(primeiraData, segundaData);
		
		return numeroDeDiasEntreDatas;
	}

}
