package br.edu.utfpr.td.tsi.webservice.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BoletimFurtoVeiculo {

	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    

	private String identificador;
	private LocalDate dataOcorrencia;
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

	public BoletimFurtoVeiculo(String identificador, LocalDate dataOcorrencia, String periodoOcorrencia, Parte parte,
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

	public String getDataOcorrencia() {
		String valorFormatado = dataOcorrencia.format(formatador);
		return valorFormatado;
	}

	public void setDataOcorrencia(LocalDate dataOcorrencia) {
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
		return "BoletimFurtoVeiculo [formatador=" + formatador + ", identificador=" + identificador
				+ ", dataOcorrencia=" + dataOcorrencia + ", periodoOcorrencia=" + periodoOcorrencia + ", parte=" + parte
				+ ", localOcorrencia=" + localOcorrencia + ", veiculoFurtado=" + veiculoFurtado + "]";
	}



}
