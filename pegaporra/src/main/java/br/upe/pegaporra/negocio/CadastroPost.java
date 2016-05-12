package br.upe.pegaporra.negocio;

import java.util.List;

import br.upe.pegaporra.entidades.Post;
import br.upe.pegaporra.excecao.PostExistenteException;
import br.upe.pegaporra.excecao.PostInexistenteException;

public interface CadastroPost {

	public void adcionar(Post p) throws PostExistenteException;
	public void atualizar(Post p) throws PostInexistenteException;
	public void remover(Long id) throws PostInexistenteException;
	public List<Post> listar();
	public Post buscarId(Long id) throws PostInexistenteException;
	
}
