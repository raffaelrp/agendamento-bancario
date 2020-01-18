package br.com.rafael.agendamentobancario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rafael.agendamentobancario.models.Agendamento;

@Repository
public interface AgendamentoRepository extends CrudRepository<Agendamento, Long> {

}
