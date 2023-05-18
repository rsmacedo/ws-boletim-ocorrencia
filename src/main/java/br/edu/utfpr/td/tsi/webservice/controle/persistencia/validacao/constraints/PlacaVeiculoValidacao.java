package br.edu.utfpr.td.tsi.webservice.controle.persistencia.validacao.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.validacao.PlacaVeiculoValidador;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = PlacaVeiculoValidador.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PlacaVeiculoValidacao {

	String message() default "Placa de carro inválida";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
