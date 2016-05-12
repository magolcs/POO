package br.upe.pegaporra.negocio;

import java.util.Date;
import java.util.List;

import br.upe.pegaporra.entidades.Agendamento;
import br.upe.pegaporra.excecao.AgendamentoExistenteException;
import br.upe.pegaporra.excecao.AgendamentoInexistenteException;

public interface CadastroAgendamento {

	public void adcionar(Agendamento a) throws AgendamentoExistenteException;
	public void atualizar(Agendamento a) throws AgendamentoInexistenteException;
	public void remover(Long id) throws AgendamentoInexistenteException;
	public List<Agendamento> listar();
	public Agendamento buscarData(Date data) throws AgendamentoInexistenteException;
	public Agendamento buscarHora(Date hora) throws AgendamentoInexistenteException;
	public Agendamento buscarId(Long id) throws AgendamentoInexistenteException;
	
}
