package br.upe.pegaporra.negocio;

import java.util.List;

import br.upe.pegaporra.entidades.Usuario;
import br.upe.pegaporra.excecao.UsuarioExistenteException;
import br.upe.pegaporra.excecao.UsuarioInexistenteException;

public interface CadastroUsuario {

	public void adcionar(Usuario u) throws UsuarioExistenteException;
	public void atualizar(Usuario u) throws UsuarioInexistenteException;
	public void remover(String cpf) throws UsuarioInexistenteException;
	public List<Usuario> listar();
	public Usuario buscarCpf(String cpf) throws UsuarioInexistenteException;

}
