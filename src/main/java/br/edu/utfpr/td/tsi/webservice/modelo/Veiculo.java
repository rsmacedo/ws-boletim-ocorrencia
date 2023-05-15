package br.edu.utfpr.td.tsi.webservice.modelo;

import java.util.ArrayList;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Veiculo {

	@Valid
	private Emplacamento emplacamento;
	@Min(value = 1886, message = "Ano de Fabricação inválido")
	@Max(value = 2023, message = "Ano de Fabricação inválido")
	private int anoFabricacao;
	@NotBlank
	private String cor;
	@NotBlank
	private String marca;
	@NotBlank
	private String tipoVeiculo;
	private ArrayList<EnvolvidoEm> envolvidoEm;

	public Veiculo() {
		this.envolvidoEm = new ArrayList<EnvolvidoEm>();
	}

	public Veiculo(int anoFabricacao, String cor, String marca, String tipoVeiculo, Emplacamento emplacamento) {
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
		this.marca = marca;
		this.tipoVeiculo = tipoVeiculo;
		this.emplacamento = emplacamento;
		this.envolvidoEm = new ArrayList<EnvolvidoEm>();
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

	public ArrayList<EnvolvidoEm> getEnvolvidoEm() {
		return envolvidoEm;
	}

	public void setEnvolvidoEm(ArrayList<EnvolvidoEm> envolvidoEm) {
		this.envolvidoEm = envolvidoEm;
	}

	public void adicionarListaEnvolvido(EnvolvidoEm envolvidoEm) {
		if (this.envolvidoEm.contains(envolvidoEm)) {
			System.out.println(envolvidoEm + " já registrado");
		} else {
			this.envolvidoEm.add(envolvidoEm);
		}
	}
	/*
	 * public void adicionarEnvolvimento(ArrayList<BoletimFurtoVeiculo> bd) {
	 * for(BoletimFurtoVeiculo b: bd) {
	 * if(b.getVeiculoFurtado().getEmplacamento().getPlaca() ==
	 * this.emplacamento.getPlaca()) {
	 * this.envolvidoEm.setIdentificador(b.getIdentificador());
	 * this.envolvidoEm.setCrime(b.getCrime()); }else { this.envolvidoEm = null; } }
	 * }
	 */

	@Override
	public String toString() {
		return "Veiculo [anoFabricacao=" + anoFabricacao + ", cor=" + cor + ", marca=" + marca + ", tipoVeiculo="
				+ tipoVeiculo + ", emplacamento=" + emplacamento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(emplacamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(emplacamento, other.emplacamento);
	}

}
