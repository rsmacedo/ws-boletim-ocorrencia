package br.edu.utfpr.td.tsi.webservice.regras;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.IBoletimDAO;
import br.edu.utfpr.td.tsi.webservice.controle.persistencia.IVeiculoDAO;
import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;

@Component
public class RegrasVeiculo implements IRegrasVeiculo {

	@Autowired
	private IVeiculoDAO veiculoDAO;

	@Autowired
	IBoletimDAO boletimDAO;

	private ArrayList<BoletimFurtoVeiculo> bd = new ArrayList<>();

	public ArrayList<Veiculo> buscarPorPlaca(String placa) {
		bd = boletimDAO.listarTodos();
		return veiculoDAO.buscarPorPlaca(placa, bd);
	}

	public ArrayList<Veiculo> buscarPorCor(String cor) {
		bd = boletimDAO.listarTodos();
		return veiculoDAO.buscarPorCor(cor, bd);
	}

	public ArrayList<Veiculo> buscarPorTipo(String tipo) {
		bd = boletimDAO.listarTodos();
		return veiculoDAO.buscarPorTipo(tipo, bd);
	}

	public ArrayList<Veiculo> buscarPorCorETipo(String cor, String tipo) {
		bd = boletimDAO.listarTodos();
		return veiculoDAO.buscarPorCorETipo(cor, tipo, bd);
	}

	public ArrayList<Veiculo> listarTodos() {
		bd = boletimDAO.listarTodos();
		return veiculoDAO.listarTodos(bd);
	}

	public Veiculo gerenciarVeiculo(Veiculo veiculo) {
		String cor = veiculo.getCor().toUpperCase();
		String tipo = veiculo.getTipoVeiculo().toUpperCase();
		veiculo.setCor(cor);
		veiculo.setTipoVeiculo(tipo);
		return veiculo;
	}

	@Override
	public ArrayList<Veiculo> buscarVeiculo(String placa, String cor, String tipo) {
		ArrayList<Veiculo> veiculos = new ArrayList<>();

		if (placa != null) {
			veiculos = buscarPorPlaca(placa);
		} else if (cor != null && tipo != null) {
			veiculos = buscarPorCorETipo(cor, tipo);
		} else if (cor != null) {
			veiculos = buscarPorCor(cor);
		} else if (tipo != null) {
			veiculos = buscarPorTipo(tipo);
		} else {
			veiculos = listarTodos();
		}

		return veiculos;
	}

}
