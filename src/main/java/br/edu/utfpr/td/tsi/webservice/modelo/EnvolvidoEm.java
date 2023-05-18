package br.edu.utfpr.td.tsi.webservice.modelo;

import java.util.Date;
import java.util.Objects;

public class EnvolvidoEm {

	private String crime;
	private String identificador;
	private Date dataOcorrencia;
	private String periodoOcorrencia;
	private Parte parte;
	private Endereco localOcorrencia;
	private Veiculo veiculoFurtado;

	public EnvolvidoEm() {
	}

	public String getCrime() {
		return crime;
	}

	public String getIdentificador() {
		return identificador;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public String getPeriodoOcorrencia() {
		return periodoOcorrencia;
	}

	public Parte getParte() {
		return parte;
	}

	public Endereco getLocalOcorrencia() {
		return localOcorrencia;
	}

	public Veiculo getVeiculoFurtado() {
		return veiculoFurtado;
	}

	public void setCrime(String crime) {
		this.crime = crime;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
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
		EnvolvidoEm other = (EnvolvidoEm) obj;
		return Objects.equals(identificador, other.identificador);
	}

}
