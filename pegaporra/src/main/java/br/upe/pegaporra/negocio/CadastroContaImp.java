package br.upe.pegaporra.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.upe.pegaporra.entidades.Conta;
import br.upe.pegaporra.excecao.ContaExistenteException;
import br.upe.pegaporra.excecao.ContaInexistenteException;
import br.upe.pegaporra.persistencia.RepositorioConta;

@Service
public class CadastroContaImp implements CadastroConta{

	@Autowired
	private RepositorioConta repositorio;
	
	@Transactional(rollbackFor = ContaExistenteException.class)
	public void adcionar(Conta c) throws ContaExistenteException {
		try {
			buscarEmail(c.getEmail());
			throw new ContaExistenteException();
		}catch (ContaInexistenteException e) {
			repositorio.save(c);
		}
		
	}

	@Transactional(rollbackFor = ContaInexistenteException.class)
	public void atualizar(Conta c) throws ContaInexistenteException {
		Conta antigo = buscarEmail(c.getEmail());
		antigo.setPosts(c.getPosts());
		antigo.setSenha(c.getSenha());
		
		repositorio.save(antigo);
		
		
	}

	@Transactional(rollbackFor = ContaInexistenteException.class)
	public void remover(String email) throws ContaInexistenteException {
		repositorio.delete(buscarEmail(email));
		
	}

	public List<Conta> listar() {
		
		return (List<Conta>) repositorio.findAll();
	}

	public Conta buscarEmail(String email) throws ContaInexistenteException {
		Conta c = repositorio.findByEmail(email);
		if (c == null) {
			throw new ContaInexistenteException();
		}
		return c;
	}

}
