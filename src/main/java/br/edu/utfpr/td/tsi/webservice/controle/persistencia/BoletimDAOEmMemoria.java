package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;

@Component
public class BoletimDAOEmMemoria implements BoletimDAO {

	private ArrayList<BoletimFurtoVeiculo> bd = new ArrayList<>();

	@Override
	public void persistir(BoletimFurtoVeiculo b) {
		bd.add(b);
		System.out.println("Boletim salvo no banco de dados");
		System.out.println(b);

	}

	// implentar a persistrncia

}
