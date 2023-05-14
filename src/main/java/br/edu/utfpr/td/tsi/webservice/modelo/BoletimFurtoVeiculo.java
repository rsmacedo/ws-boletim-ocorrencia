package br.edu.utfpr.td.tsi.webservice.modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class BoletimFurtoVeiculo implements Serializable {


	private static final long serialVersionUID = 2306212553812141268L;
	@NotBlank
	private String crime;
	private String identificador;
	@NotNull @Past
	private Date dataOcorrencia;
	@NotBlank
	private String periodoOcorrencia;
	@NotNull @Valid
	private Parte parte;
	@NotNull @Valid
	private Endereco localOcorrencia;
	@NotNull @Valid
	private Veiculo veiculoFurtado;
	String pattern = "dd/MM/yyyy";
	SimpleDateFormat formato = new SimpleDateFormat(pattern);

	public BoletimFurtoVeiculo() {
	}

	public String getCrime() {
		return crime;
	}

	public void setCrime(String crime) {
		this.crime = crime;
	}
	
	

	public BoletimFurtoVeiculo(@NotBlank String crime, String identificador, @NotBlank String dataOcorrencia,
			@NotBlank String periodoOcorrencia, @NotNull @Valid Parte parte, @NotNull @Valid Endereco localOcorrencia,
			@NotNull @Valid Veiculo veiculoFurtado) throws ParseException {
		this.crime = crime;
		this.identificador = identificador;
		this.dataOcorrencia = formato.parse(dataOcorrencia);
		this.periodoOcorrencia = periodoOcorrencia;
		this.parte = parte;
		this.localOcorrencia = localOcorrencia;
		this.veiculoFurtado = veiculoFurtado;
	}

	public BoletimFurtoVeiculo(
			String identificador, 
			String periodoOcorrencia, 
			Parte parte, 
			Endereco localOcorrencia,
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

	public String getDataOcorrencia() throws ParseException {
		return formato.format(dataOcorrencia);
	}

	public void setDataOcorrencia(String dataOcorrencia) throws ParseException {
		Date data = formato.parse(dataOcorrencia);
		this.dataOcorrencia = (data);
	}

	public void setPeriodoOcorrencia(String periodoOcorrencia) {
		this.periodoOcorrencia = periodoOcorrencia;
	}

	public Parte getParte() {
		return null;
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
				+ localOcorrencia + ", veiculoFurtado=" + veiculoFurtado + "] Eu sou lindo demais";
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
