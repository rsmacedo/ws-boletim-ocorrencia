package br.edu.utfpr.td.tsi.webservice.controle.persistencia.validacao;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.validacao.constraints.PlacaVeiculo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacaVeiculoValidation implements ConstraintValidator<PlacaVeiculo, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String placa = value == null ? "" : value;
		return placa.matches("[a-z-A-Z]{3}[0-9][A-Za-z0-9][0-9]{2}");
	}
	
	

}
