package br.edu.utfpr.td.tsi.webservice.controle.persistencia.validacao.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.*;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.validacao.PlacaVeiculoValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = PlacaVeiculoValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PlacaVeiculo {
	
	String message() default "Placa de carro inválida";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};

}
