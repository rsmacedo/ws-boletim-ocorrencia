package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;

public interface VeiculoDAO {

	public ArrayList<Veiculo> buscarPorPlaca(String placa, ArrayList<BoletimFurtoVeiculo> bd);

	public ArrayList<Veiculo> buscarPorCor(String cor, ArrayList<BoletimFurtoVeiculo> bd);

	public ArrayList<Veiculo> buscarPorTipo(String tipo, ArrayList<BoletimFurtoVeiculo> bd);
	
	public ArrayList<Veiculo> buscarPorCorETipo(String cor, String tipo, ArrayList<BoletimFurtoVeiculo> bd);

}
