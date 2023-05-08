package br.edu.utfpr.td.tsi.webservice.regras;


import java.util.ArrayList;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;

public interface RegrasBoletim {

	public void cadastrar(BoletimFurtoVeiculo boletim);
	
	public void deletar(String boletim);
	
	public void alterar(BoletimFurtoVeiculo boletim, String id);
	
	public ArrayList<BoletimFurtoVeiculo> listarTodos();
	

}
