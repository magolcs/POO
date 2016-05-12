package br.upe.pegaporra.fachada;

import java.util.Date;
import java.util.List;

import br.upe.pegaporra.entidades.Agendamento;
import br.upe.pegaporra.entidades.Conta;
import br.upe.pegaporra.entidades.Post;
import br.upe.pegaporra.entidades.Usuario;
import br.upe.pegaporra.excecao.AgendamentoExistenteException;
import br.upe.pegaporra.excecao.AgendamentoInexistenteException;
import br.upe.pegaporra.excecao.ContaExistenteException;
import br.upe.pegaporra.excecao.ContaInexistenteException;
import br.upe.pegaporra.excecao.PostExistenteException;
import br.upe.pegaporra.excecao.PostInexistenteException;
import br.upe.pegaporra.excecao.UsuarioExistenteException;
import br.upe.pegaporra.excecao.UsuarioInexistenteException;

public interface Fachada {
//colocar todos os metodos.
	
	//Metodos Usuario
	public void adcionar(Usuario u) throws UsuarioExistenteException;
	public void atualizar(Usuario u) throws UsuarioInexistenteException;
	public void removerUsuario(String cpf) throws UsuarioInexistenteException;
	public List<Usuario> listarUsuario();
	public Usuario buscarCpf(String cpf) throws UsuarioInexistenteException;

	//Metodos Post
	public void adcionar(Post p) throws PostExistenteException;
	public void atualizar(Post p) throws PostInexistenteException;
	public void removerPost(Long id) throws PostInexistenteException;
	public List<Post> listarPost();
	public Post buscarIdPost(Long id) throws PostInexistenteException;
	
	//Metodos Conta
	public void adcionar(Conta c) throws ContaExistenteException;
	public void atualizar(Conta c) throws ContaInexistenteException;
	public void removerConta(String email) throws ContaInexistenteException;
	public List<Conta> listarConta();
	public Conta buscarEmail(String email) throws ContaInexistenteException;
	
	//Metodo Agendamento
	public void adcionar(Agendamento a) throws AgendamentoExistenteException;
	public void atualizar(Agendamento a) throws AgendamentoInexistenteException;
	public void removerAgendamento(Long id) throws AgendamentoInexistenteException;
	public List<Agendamento> listarAgendamento();
	public Agendamento buscarData(Date data) throws AgendamentoInexistenteException;
	public Agendamento buscarHora(Date hora) throws AgendamentoInexistenteException;
	public Agendamento buscarIdAgendamento(Long id) throws AgendamentoInexistenteException;
}

