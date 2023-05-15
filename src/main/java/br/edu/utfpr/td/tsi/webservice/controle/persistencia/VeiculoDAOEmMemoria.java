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
		adicionarEnvolvimento(bd);
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getVeiculoFurtado().getEmplacamento().getPlaca().equals(placa)) {
				veiculos.add(b.getVeiculoFurtado());
			}
		}
		return veiculos;

	}

	@Override
	public ArrayList<Veiculo> buscarPorCor(String cor, ArrayList<BoletimFurtoVeiculo> bd) {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		adicionarEnvolvimento(bd);
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
		adicionarEnvolvimento(bd);
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
		adicionarEnvolvimento(bd);
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
		EnvolvidoEm envolvido = new EnvolvidoEm();
		ArrayList<EnvolvidoEm> listaEnvolvimento = new ArrayList<>();
		
		for(BoletimFurtoVeiculo b: bd) {
			envolvido.setIdentificador(b.getIdentificador());
			envolvido.setCrime(b.getCrime());
			if(!listaEnvolvimento.contains(envolvido)) {
				listaEnvolvimento.add(envolvido);
			b.getVeiculoFurtado().setEnvolvidoEm(listaEnvolvimento);
			}
			envolvido.setCrime(null);
			envolvido.setIdentificador(null);
		}
	}
	

	
	// implentar a persistrncia

}
