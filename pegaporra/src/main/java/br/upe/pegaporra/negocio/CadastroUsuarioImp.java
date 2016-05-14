package br.upe.pegaporra.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.upe.pegaporra.entidades.Usuario;
import br.upe.pegaporra.excecao.UsuarioExistenteException;
import br.upe.pegaporra.excecao.UsuarioInexistenteException;
import br.upe.pegaporra.persistencia.RepositorioUsuario;

@Service
public class CadastroUsuarioImp implements CadastroUsuario{

	@Autowired
	private RepositorioUsuario repositorio;
	
	@Transactional(rollbackFor = UsuarioExistenteException.class)
	public void adcionar(Usuario u) throws UsuarioExistenteException {
		try {
			buscarCpf(u.getCpf());
			throw new UsuarioExistenteException();
		}catch (UsuarioInexistenteException e) {
			repositorio.save(u);
		}
		
	}

	@Transactional(rollbackFor = UsuarioInexistenteException.class)
	public void atualizar(Usuario u) throws UsuarioInexistenteException {
		Usuario antigo = buscarCpf(u.getCpf());
		antigo.setNome(u.getNome());
		antigo.setSenha(u.getSenha());
		antigo.setEmail(u.getEmail());
		antigo.setContas(u.getContas());
		
		repositorio.save(antigo);
		
	}

	@Transactional(rollbackFor = UsuarioInexistenteException.class)
	public void remover(String cpf) throws UsuarioInexistenteException {
		repositorio.delete(buscarCpf(cpf));
		
	}

	public List<Usuario> listar() {
		
		return (List<Usuario>) repositorio.findAll();
	}

	public Usuario buscarCpf(String cpf) throws UsuarioInexistenteException {
		Usuario u = repositorio.findByCpf(cpf);
		if (u == null) {
			throw new UsuarioInexistenteException();
		}
		return u;
	}

}
