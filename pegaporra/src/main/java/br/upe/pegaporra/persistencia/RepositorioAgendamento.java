package br.upe.pegaporra.persistencia;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import br.upe.pegaporra.entidades.Agendamento;

public interface RepositorioAgendamento extends CrudRepository<Agendamento, Long> {

	public Agendamento findByData(Date data);
	public Agendamento findByHora(Date hora);
	//public Agendamento findById(Long id); // remover e substituir por findByOne
}
