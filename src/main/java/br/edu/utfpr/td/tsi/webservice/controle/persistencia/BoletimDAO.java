package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;

public interface BoletimDAO {
	
	public void persistir(BoletimFurtoVeiculo b);

}
