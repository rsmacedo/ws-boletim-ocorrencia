package br.edu.utfpr.td.tsi.webservice.regras;


import java.util.ArrayList;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;

public interface IRegrasBoletim {

	public void cadastrar(BoletimFurtoVeiculo boletim);
	
	public void deletar(String id);
	
	public void alterar(BoletimFurtoVeiculo boletim, String id);
	
	/*
	public ArrayList<BoletimFurtoVeiculo> listarTodos();
	
	public ArrayList<BoletimFurtoVeiculo> buscarPorId(String id);
	
	public ArrayList<BoletimFurtoVeiculo> buscarPorCidade(String cidade);
	
	public ArrayList<BoletimFurtoVeiculo> buscarPorPeriodo(String periodo); 
	*/
	
	public ArrayList<BoletimFurtoVeiculo> buscarBoletim(String identificador, String cidade, String periodo);
	

}
