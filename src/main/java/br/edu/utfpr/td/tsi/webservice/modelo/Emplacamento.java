package br.edu.utfpr.td.tsi.webservice.modelo;

import java.util.Objects;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.validacao.constraints.PlacaVeiculoValidacao;
import jakarta.validation.constraints.NotBlank;

public class Emplacamento {

	@Override
	public int hashCode() {
		return Objects.hash(placa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emplacamento other = (Emplacamento) obj;
		return Objects.equals(placa, other.placa);
	}

	@NotBlank @PlacaVeiculoValidacao
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
