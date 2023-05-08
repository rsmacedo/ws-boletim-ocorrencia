package br.edu.utfpr.td.tsi.webservice.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BoletimFurtoVeiculo {

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	private String identificador;
	private Date dataOcorrencia;
	private String periodoOcorrencia;
	@JsonIgnore
	private Parte parte;
	private Endereco localOcorrencia;
	private Veiculo veiculoFurtado;

	public BoletimFurtoVeiculo() {
	}

	public BoletimFurtoVeiculo(String identificador, String periodoOcorrencia, Parte parte, Endereco localOcorrencia,
			Veiculo veiculoFurtado) {
		this.identificador = identificador;
		this.periodoOcorrencia = periodoOcorrencia;
		this.parte = parte;
		this.localOcorrencia = localOcorrencia;
		this.veiculoFurtado = veiculoFurtado;
	}

	public BoletimFurtoVeiculo(String identificador, Date dataOcorrencia, String periodoOcorrencia, Parte parte,
			Endereco localOcorrencia, Veiculo veiculoFurtado) {
		this.identificador = identificador;
		this.dataOcorrencia = dataOcorrencia;
		this.periodoOcorrencia = periodoOcorrencia;
		this.parte = parte;
		this.localOcorrencia = localOcorrencia;
		this.veiculoFurtado = veiculoFurtado;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public String getPeriodoOcorrencia() {
		return periodoOcorrencia;
	}

	public void setPeriodoOcorrencia(String periodoOcorrencia) {
		this.periodoOcorrencia = periodoOcorrencia;
	}

	public Parte getParte() {
		return parte;
	}

	public void setParte(Parte parte) {
		this.parte = parte;
	}

	public Endereco getLocalOcorrencia() {
		return localOcorrencia;
	}

	public void setLocalOcorrencia(Endereco localOcorrencia) {
		this.localOcorrencia = localOcorrencia;
	}

	public Veiculo getVeiculoFurtado() {
		return veiculoFurtado;
	}

	public void setVeiculoFurtado(Veiculo veiculoFurtado) {
		this.veiculoFurtado = veiculoFurtado;
	}

	@Override
	public String toString() {
		String dataFormatada = (dataOcorrencia != null ? formato.format(dataOcorrencia) : "");
		return "BoletimFurtoVeiculo [identificador=" + identificador + ", dataOcorrencia="
				+ dataFormatada + ", periodoOcorrencia="
				+ periodoOcorrencia + ", localOcorrencia=" + localOcorrencia + ", veiculoFurtado=" + veiculoFurtado
				+ "]";
	}

}
