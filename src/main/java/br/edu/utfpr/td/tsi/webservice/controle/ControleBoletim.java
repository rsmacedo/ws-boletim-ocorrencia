package br.edu.utfpr.td.tsi.webservice.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.regras.RegrasBoletim;

@Component
public class ControleBoletim {

	@Autowired
	private RegrasBoletim regraBoletim;

	public void redirecionarNovoCadastro(BoletimFurtoVeiculo b) {
		regraBoletim.cadastrar(b);
	}

}
