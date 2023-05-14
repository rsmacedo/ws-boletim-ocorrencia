package br.edu.utfpr.td.tsi.webservice.regras;


import java.util.ArrayList;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;

public interface IRegrasVeiculo {

	/*
	public Veiculo buscarPorPlaca(String placa);
	public ArrayList<Veiculo> buscarPorTipo(String tipo); 
	*/
	
	public ArrayList<Veiculo> buscarVeiculo(String placa, String cor, String tipo);
	

}
