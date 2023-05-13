package br.edu.utfpr.td.tsi.webservice.modelo;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BoletimFurtoVeiculo implements Serializable {

	private String identificador;
	private Date dataOcorrencia;
	private String periodoOcorrencia;
	@JsonIgnore
	private Parte parte;
	private Endereco localOcorrencia;
	private Veiculo veiculoFurtado;

	public BoletimFurtoVeiculo() {
	}

	public BoletimFurtoVeiculo(DateTimeFormatter formatador, String identificador, Date dataOcorrencia,
			String periodoOcorrencia, Parte parte, Endereco localOcorrencia, Veiculo veiculoFurtado) {
		this.identificador = identificador;
		this.dataOcorrencia = dataOcorrencia;
		this.periodoOcorrencia = periodoOcorrencia;
		this.parte = parte;
		this.localOcorrencia = localOcorrencia;
		this.veiculoFurtado = veiculoFurtado;
	}

	public BoletimFurtoVeiculo(String identificador, String periodoOcorrencia, Parte parte, Endereco localOcorrencia,
			Veiculo veiculoFurtado) {
		this.identificador = identificador;
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

	public String getPeriodoOcorrencia() {
		return periodoOcorrencia;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
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
		return "BoletimFurtoVeiculo [identificador=" + identificador + ", dataOcorrencia=" + dataOcorrencia
				+ ", periodoOcorrencia=" + periodoOcorrencia + ", parte=" + parte + ", localOcorrencia="
				+ localOcorrencia + ", veiculoFurtado=" + veiculoFurtado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoletimFurtoVeiculo other = (BoletimFurtoVeiculo) obj;
		return Objects.equals(identificador, other.identificador);
	}
	

}
