package br.upe.pegaporra.negocio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.upe.pegaporra.entidades.Agendamento;
import br.upe.pegaporra.excecao.AgendamentoExistenteException;
import br.upe.pegaporra.excecao.AgendamentoInexistenteException;
import br.upe.pegaporra.persistencia.RepositorioAgendamento;

@Service
public class CadastroAgendamentoImp implements CadastroAgendamento{

	@Autowired
	private RepositorioAgendamento repositorio;
	
	@Transactional(rollbackFor = AgendamentoExistenteException.class)
	public void adcionar(Agendamento a) throws AgendamentoExistenteException {
		try {
			buscarHora(a.getHora());
			throw new AgendamentoExistenteException();
		}catch (AgendamentoInexistenteException e) {
			repositorio.save(a);
		}
		
	}

	@Transactional(rollbackFor = AgendamentoInexistenteException.class)
	public void atualizar(Agendamento a) throws AgendamentoInexistenteException {
		Agendamento antigo = buscarId(a.getId());
		antigo.setData(a.getData());
		antigo.setHora(a.getHora());
		antigo.setPosts(a.getPosts());

		repositorio.save(antigo);
	}

	@Transactional(rollbackFor = AgendamentoInexistenteException.class)
	public void remover(Long id) throws AgendamentoInexistenteException {
		repositorio.delete(buscarId(id));
		
	}

	public List<Agendamento> listar() {
		
		return (List<Agendamento>) repositorio.findAll();
	}

	public Agendamento buscarData(Date data) throws AgendamentoInexistenteException {
		Agendamento a = repositorio.findByData(data);
		if (a == null) {
			throw new AgendamentoInexistenteException();
		}
		return a;
	}

	public Agendamento buscarHora(Date hora) throws AgendamentoInexistenteException {
		Agendamento a = repositorio.findByHora(hora);
		if (a == null) {
			throw new AgendamentoInexistenteException();
		}
		return a;
	}

	public Agendamento buscarId(Long id) throws AgendamentoInexistenteException {
		Agendamento a = repositorio.findOne(id);
		if (a == null) {
			throw new AgendamentoInexistenteException();
		}
		return a;
	}

}
