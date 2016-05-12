package br.upe.pegaporra.negocio;

import java.util.List;

import br.upe.pegaporra.entidades.Conta;
import br.upe.pegaporra.excecao.ContaExistenteException;
import br.upe.pegaporra.excecao.ContaInexistenteException;

public interface CadastroConta {

	public void adcionar(Conta c) throws ContaExistenteException;
	public void atualizar(Conta c) throws ContaInexistenteException;
	public void remover(String email) throws ContaInexistenteException;
	public List<Conta> listar();
	public Conta buscarEmail(String email) throws ContaInexistenteException;

}
