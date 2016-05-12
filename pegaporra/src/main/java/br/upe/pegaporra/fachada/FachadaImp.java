package br.upe.pegaporra.fachada;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import br.upe.pegaporra.negocio.CadastroAgendamento;
import br.upe.pegaporra.negocio.CadastroConta;
import br.upe.pegaporra.negocio.CadastroPost;
import br.upe.pegaporra.negocio.CadastroUsuario;

@Service
public class FachadaImp implements Fachada{

	@Autowired
	private CadastroUsuario usuario;
	@Autowired
	private CadastroPost post;
	@Autowired
	private CadastroConta conta;
	@Autowired
	private CadastroAgendamento agendamento;
	
	//Metodos Usuario
	public void adcionar(Usuario u) throws UsuarioExistenteException {
		this.usuario.adcionar(u);
	}
	
	public void removerUsuario(String cpf) throws UsuarioInexistenteException {
		this.usuario.remover(cpf);
	}
	
	public List<Usuario> listarUsuario() {
		return this.usuario.listar();
	}

	public void atualizar(Usuario u) throws UsuarioInexistenteException {
		this.usuario.atualizar(u);
		
	}

	public Usuario buscarCpf(String cpf) throws UsuarioInexistenteException {
		return this.usuario.buscarCpf(cpf);
	}

	
	//Metodos Post
	public void adcionar(Post p) throws PostExistenteException {
		this.post.adcionar(p);
		
	}

	public void atualizar(Post p) throws PostInexistenteException {
		this.post.atualizar(p);
		
	}

	public void removerPost(Long id) throws PostInexistenteException {
		this.post.remover(id);
		
	}

	public List<Post> listarPost() {
		return this.post.listar();
	}

	public Post buscarIdPost(Long id) throws PostInexistenteException {
		return this.post.buscarId(id);
	}

	
	//Metodos Conta
	public void adcionar(Conta c) throws ContaExistenteException {
		this.conta.adcionar(c);
		
	}

	public void atualizar(Conta c) throws ContaInexistenteException {
		this.conta.atualizar(c);
		
	}

	public void removerConta(String email) throws ContaInexistenteException {
		this.conta.remover(email);
		
	}

	public List<Conta> listarConta() {
		return this.conta.listar();
	}

	public Conta buscarEmail(String email) throws ContaInexistenteException {
		return this.conta.buscarEmail(email);
	}

	
	//Metodos Agendamento
	public void adcionar(Agendamento a) throws AgendamentoExistenteException {
		this.agendamento.adcionar(a);
		
	}

	public void atualizar(Agendamento a) throws AgendamentoInexistenteException {
		this.agendamento.atualizar(a);
		
	}

	public void removerAgendamento(Long id) throws AgendamentoInexistenteException {
		this.agendamento.remover(id);
		
	}

	public List<Agendamento> listarAgendamento() {
		return this.agendamento.listar();
	}

	public Agendamento buscarData(Date data) throws AgendamentoInexistenteException {
		return this.agendamento.buscarData(data);
	}

	public Agendamento buscarHora(Date hora) throws AgendamentoInexistenteException {
		return this.agendamento.buscarHora(hora);
	}

	public Agendamento buscarIdAgendamento(Long id) throws AgendamentoInexistenteException {
		return this.agendamento.buscarId(id);
	}
	
	
}
