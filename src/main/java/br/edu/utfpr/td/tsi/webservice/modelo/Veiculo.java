package br.edu.utfpr.td.tsi.webservice.modelo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Veiculo {

	@Valid
	private Emplacamento emplacamento;
	@Min(value = 1700, message = "Ano de Fabricação inválido")
	private int anoFabricacao;
	@NotBlank
	private String cor;
	@NotBlank
	private String marca;
	@NotBlank
	private String tipoVeiculo;
	

	public Veiculo() {
	}

	public Veiculo(int anoFabricacao, String cor, String marca, String tipoVeiculo, Emplacamento emplacamento) {
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
		this.marca = marca;
		this.tipoVeiculo = tipoVeiculo;
		this.emplacamento = emplacamento;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public Emplacamento getEmplacamento() {
		return emplacamento;
	}

	public void setEmplacamento(Emplacamento emplacamento) {
		this.emplacamento = emplacamento;
	}

	@Override
	public String toString() {
		return "Veiculo [anoFabricacao=" + anoFabricacao + ", cor=" + cor + ", marca=" + marca + ", tipoVeiculo="
				+ tipoVeiculo + ", emplacamento=" + emplacamento + "]";
	}
	
	
}
