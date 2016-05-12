package br.upe.pegaporra.persistencia;

import org.springframework.data.repository.CrudRepository;

import br.upe.pegaporra.entidades.Agendamento;
import br.upe.pegaporra.entidades.Conta;
import br.upe.pegaporra.entidades.Post;

public interface RepositorioPost extends CrudRepository<Post, Long> {

	public Post findByAgendamento(Agendamento agendamento);
	public Post findById(Long id);
	public Post findByConta(Conta conta);
}
