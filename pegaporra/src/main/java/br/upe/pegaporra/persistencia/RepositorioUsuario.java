package br.upe.pegaporra.persistencia;

import org.springframework.data.repository.CrudRepository;

import br.upe.pegaporra.entidades.Usuario;

public interface RepositorioUsuario extends CrudRepository<Usuario, String>{
	
	public Usuario findByCpf(String cpf);

}
