package br.edu.utfpr.td.tsi.webservice.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.regras.IRegrasBoletim;
import jakarta.validation.Valid;

@Component
public class ControleBoletim {

	@Autowired
	private IRegrasBoletim regraBoletim;

	public void redirecionarNovoCadastro(@Valid BoletimFurtoVeiculo b) {
		regraBoletim.cadastrar(b);
	}

}
