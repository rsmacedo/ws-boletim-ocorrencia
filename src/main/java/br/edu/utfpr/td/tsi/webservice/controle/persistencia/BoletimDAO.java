package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;

public interface BoletimDAO {
	
	public void persistir(BoletimFurtoVeiculo boletim);
	
	public void deletar(String id);
	
	public void alterar(BoletimFurtoVeiculo boletim, String id);
	
	public ArrayList<BoletimFurtoVeiculo> listarTodos();
	
	public BoletimFurtoVeiculo buscarPorId(String id);
	
	public ArrayList<BoletimFurtoVeiculo> buscarPorCidade(String cidade);
	
	public ArrayList<BoletimFurtoVeiculo> buscarPorPeriodo(String periodo);


}
