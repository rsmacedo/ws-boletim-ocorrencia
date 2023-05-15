package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;

public interface IBoletimDAO {
	
	public ArrayList<BoletimFurtoVeiculo> lerBanco();
	
	public void persistir(BoletimFurtoVeiculo boletim);
	
	public void deletar(String id);
	
	public void alterar(BoletimFurtoVeiculo boletim, String id);
	
	public ArrayList<BoletimFurtoVeiculo> listarTodos();
	
	public ArrayList<BoletimFurtoVeiculo> buscarPorId(String id);
	
	public ArrayList<BoletimFurtoVeiculo> buscarPorCidade(String cidade);
	
	public ArrayList<BoletimFurtoVeiculo> buscarPorPeriodo(String periodo);
	
	public ArrayList<BoletimFurtoVeiculo> buscarPorCidadeEPeriodo(String cidade, String periodo);


}
