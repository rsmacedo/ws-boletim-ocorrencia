package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;

@Component
public class VeiculoDAOEmMemoria implements VeiculoDAO {


	@Override
	public Veiculo buscarPorPlaca(String placa, ArrayList<BoletimFurtoVeiculo> bd) {
		Veiculo veiculo = new Veiculo();
		for(BoletimFurtoVeiculo b: bd) {
			if(b.getVeiculoFurtado().getEmplacamento().getPlaca().equals(placa)) {
				veiculo = b.getVeiculoFurtado();
			}
		}
		return veiculo;
		
	}

	@Override
	public ArrayList<Veiculo> buscarPorCor(String cor, ArrayList<BoletimFurtoVeiculo> bd) {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		for(BoletimFurtoVeiculo b: bd) {
			if(b.getVeiculoFurtado().getCor().equals(cor)) {
				veiculos.add(b.getVeiculoFurtado());
			}
		}
		return veiculos;
	}

	@Override
	public ArrayList<Veiculo> buscarPorTipo(String tipo, ArrayList<BoletimFurtoVeiculo> bd) {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		for(BoletimFurtoVeiculo b: bd) {
			if(b.getVeiculoFurtado().getTipoVeiculo().equals(tipo)) {
				veiculos.add(b.getVeiculoFurtado());
			}
		}
		return veiculos;
	}

	
	

	// implentar a persistrncia

}
