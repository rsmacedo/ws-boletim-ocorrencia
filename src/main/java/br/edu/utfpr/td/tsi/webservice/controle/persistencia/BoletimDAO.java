package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;

public interface BoletimDAO {
	
	public void persistir(BoletimFurtoVeiculo b);
	
	public void deletar(String b);
	
	public void alterar(BoletimFurtoVeiculo b, String id);
	
	public ArrayList<BoletimFurtoVeiculo> listarTodos();


}
