package br.edu.utfpr.td.tsi.webservice.regras;


import java.util.ArrayList;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;

public interface RegrasVeiculo {

	
	public Veiculo buscarPorPlaca(String placa);
	
	public ArrayList<Veiculo> buscarPorCor(String cor);
	
	public ArrayList<Veiculo> buscarPorTipo(String tipo); 
	

}
