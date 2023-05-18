package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.excecoes.veiculo.VeiculoNaoEncontradoException;
import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.EnvolvidoEm;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;

@Component
public class VeiculoDAOEmMemoria implements IVeiculoDAO {

	@Override
	public ArrayList<Veiculo> buscarPorPlaca(String placa, ArrayList<BoletimFurtoVeiculo> bd) {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		EnvolvidoEm envolvido = new EnvolvidoEm();
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getVeiculoFurtado().getEmplacamento().getPlaca().equals(placa)) {
				envolvido.setIdentificador(b.getIdentificador());
				adicionarEnvolvimento(bd);
				veiculos.add(b.getVeiculoFurtado());
			}
		}

		if (veiculos.isEmpty()) {
			throw new VeiculoNaoEncontradoException("Veículo não encontrado");
		}

		return veiculos;

	}

	@Override
	public ArrayList<Veiculo> buscarPorCor(String cor, ArrayList<BoletimFurtoVeiculo> bd) {
		cor = cor.toUpperCase();
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getVeiculoFurtado().getCor().equals(cor)) {
				veiculos.add(b.getVeiculoFurtado());
			}
		}

		if (veiculos.isEmpty()) {
			throw new VeiculoNaoEncontradoException("Cor não encontrada");
		}

		return veiculos;
	}

	@Override
	public ArrayList<Veiculo> buscarPorTipo(String tipo, ArrayList<BoletimFurtoVeiculo> bd) {
		tipo = tipo.toUpperCase();
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getVeiculoFurtado().getTipoVeiculo().equals(tipo)) {
				veiculos.add(b.getVeiculoFurtado());
			}
		}

		if (veiculos.isEmpty()) {
			throw new VeiculoNaoEncontradoException("Tipo não encontrado");
		}

		return veiculos;
	}

	@Override
	public ArrayList<Veiculo> buscarPorCorETipo(String cor, String tipo, ArrayList<BoletimFurtoVeiculo> bd) {
		cor = cor.toUpperCase();
		tipo = tipo.toUpperCase();

		ArrayList<Veiculo> veiculos = new ArrayList<>();
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getVeiculoFurtado().getCor().equals(cor) && b.getVeiculoFurtado().getTipoVeiculo().equals(tipo)) {
				veiculos.add(b.getVeiculoFurtado());
			}
		}

		if (veiculos.isEmpty()) {
			throw new VeiculoNaoEncontradoException("Cor ou tipo não encontrado");
		}

		return veiculos;
	}

	@Override
	public ArrayList<Veiculo> listarTodos(ArrayList<BoletimFurtoVeiculo> bd) {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		adicionarEnvolvimento(bd);

		for (BoletimFurtoVeiculo b : bd) {
			veiculos.add(b.getVeiculoFurtado());
		}
		return veiculos;
	}

	public void adicionarEnvolvimento(ArrayList<BoletimFurtoVeiculo> bd) {

		for (BoletimFurtoVeiculo b : bd) {
			EnvolvidoEm envolvido = new EnvolvidoEm();
			envolvido.setIdentificador(b.getIdentificador());
			envolvido.setCrime(b.getCrime());
			b.getVeiculoFurtado().adicionarListaEnvolvido(envolvido);
		}
	}

}
