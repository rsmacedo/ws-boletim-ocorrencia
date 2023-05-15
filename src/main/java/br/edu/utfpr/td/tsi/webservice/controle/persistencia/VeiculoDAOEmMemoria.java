package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.EnvolvidoEm;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;

@Component
public class VeiculoDAOEmMemoria implements IVeiculoDAO {

	@Override
	public ArrayList<Veiculo> buscarPorPlaca(String placa, ArrayList<BoletimFurtoVeiculo> bd) {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		EnvolvidoEm envolvido = new EnvolvidoEm();
		// adicionarEnvolvimento(bd);
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getVeiculoFurtado().getEmplacamento().getPlaca().equals(placa)) {
				envolvido.setIdentificador(b.getIdentificador());
				adicionarEnvolvimento(bd);
				veiculos.add(b.getVeiculoFurtado());
			}

		}

		return veiculos;

	}

	@Override
	public ArrayList<Veiculo> buscarPorCor(String cor, ArrayList<BoletimFurtoVeiculo> bd) {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		// adicionarEnvolvimento(bd);
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getVeiculoFurtado().getCor().equals(cor)) {
				veiculos.add(b.getVeiculoFurtado());
			}
		}
		return veiculos;
	}

	@Override
	public ArrayList<Veiculo> buscarPorTipo(String tipo, ArrayList<BoletimFurtoVeiculo> bd) {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		// adicionarEnvolvimento(bd);
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getVeiculoFurtado().getTipoVeiculo().equals(tipo)) {
				veiculos.add(b.getVeiculoFurtado());
			}
		}
		return veiculos;
	}

	@Override
	public ArrayList<Veiculo> buscarPorCorETipo(String cor, String tipo, ArrayList<BoletimFurtoVeiculo> bd) {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		// adicionarEnvolvimento(bd);
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getVeiculoFurtado().getCor().equals(cor) && b.getVeiculoFurtado().getTipoVeiculo().equals(tipo)) {
				veiculos.add(b.getVeiculoFurtado());
			}
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

	// implentar a persistrncia

}
