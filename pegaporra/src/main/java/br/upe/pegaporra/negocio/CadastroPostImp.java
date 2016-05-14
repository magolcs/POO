package br.upe.pegaporra.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.upe.pegaporra.entidades.Post;
import br.upe.pegaporra.excecao.PostExistenteException;
import br.upe.pegaporra.excecao.PostInexistenteException;
import br.upe.pegaporra.persistencia.RepositorioPost;

@Service
public class CadastroPostImp implements CadastroPost{

	@Autowired
	private RepositorioPost repositorio;
	
	@Transactional(rollbackFor = PostExistenteException.class)
	public void adcionar(Post p) throws PostExistenteException {
		try {
			buscarId(p.getId());
			throw new PostExistenteException();
		}catch (PostInexistenteException e) {
			repositorio.save(p);
		}
		
	}

	@Transactional(rollbackFor = PostInexistenteException.class)
	public void atualizar(Post p) throws PostInexistenteException {
		Post antigo = buscarId(p.getId());
		antigo.setAgendamento(p.getAgendamento());
		antigo.setConta(p.getConta());
		antigo.setDescricao(p.getDescricao());
		antigo.setImg(p.getImg());
		
		repositorio.save(antigo);
		
	}

	@Transactional(rollbackFor = PostInexistenteException.class)
	public void remover(Long id) throws PostInexistenteException {
		repositorio.delete(buscarId(id));
		
	}

	public List<Post> listar() {
		
		return (List<Post>) repositorio.findAll();
	}

	public Post buscarId(Long id) throws PostInexistenteException {
		Post p = repositorio.findById(id);
		if (p == null) {
			throw new PostInexistenteException();
		}
		return p;
	}

}
