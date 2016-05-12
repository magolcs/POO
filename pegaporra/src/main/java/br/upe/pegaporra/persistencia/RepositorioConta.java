package br.upe.pegaporra.persistencia;

import org.springframework.data.repository.CrudRepository;

import br.upe.pegaporra.entidades.Conta;

public interface RepositorioConta extends CrudRepository<Conta, Long>{

	public Conta findByEmailConta(String email);
}
