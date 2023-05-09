package br.edu.utfpr.td.tsi.webservice.regras;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.BoletimDAO;
import br.edu.utfpr.td.tsi.webservice.controle.persistencia.VeiculoDAO;
import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;


@Component
public class regrasVeiculoTeste implements RegrasVeiculo {

	@Autowired
	private VeiculoDAO veiculoDAO;
	
	@Autowired BoletimDAO boletimDAO;
	
	private ArrayList<BoletimFurtoVeiculo> bd = new ArrayList<>();

	@Override
	public Veiculo buscarPorPlaca(String placa) {
		bd = boletimDAO.listarTodos();
		return veiculoDAO.buscarPorPlaca(placa, bd);
	}

	@Override
	public ArrayList<Veiculo> buscarPorCor(String cor) {
		bd = boletimDAO.listarTodos();
		return veiculoDAO.buscarPorCor(cor, bd);
	}

	@Override
	public ArrayList<Veiculo> buscarPorTipo(String tipo) {
		bd = boletimDAO.listarTodos();
		return veiculoDAO.buscarPorTipo(tipo, bd);
	}

	

}
