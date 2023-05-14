package br.edu.utfpr.td.tsi.webservice.modelo;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.validacao.constraints.PlacaVeiculo;
import jakarta.validation.constraints.NotBlank;

public class Emplacamento {

	@NotBlank @PlacaVeiculo
	private String placa;
	@NotBlank
	private String estado;
	@NotBlank
	private String cidade;

	public Emplacamento() {
	}

	public Emplacamento(String placa, String estado, String cidade) {
		this.placa = placa;
		this.estado = estado;
		this.cidade = cidade;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Emplacamento [placa=" + placa + ", estado=" + estado + ", cidade=" + cidade + "]";
	}

}
