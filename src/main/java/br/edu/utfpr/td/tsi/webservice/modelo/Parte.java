package br.edu.utfpr.td.tsi.webservice.modelo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Parte {

	@NotBlank
	private String nome;
	@Email
	private String email;
	@NotBlank
	private String telefone;
	@NotBlank
	private String tipoEnvolvimento;

	public Parte() {
	}

	public Parte(String nome, String email, String telefone, String tipoEnvolvimento) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.tipoEnvolvimento = tipoEnvolvimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipoEnvolvimento() {
		return tipoEnvolvimento;
	}

	public void setTipoEnvolvimento(String tipoEnvolvimento) {
		this.tipoEnvolvimento = tipoEnvolvimento;
	}

	@Override
	public String toString() {
		return "Parte [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", tipoEnvolvimento="
				+ tipoEnvolvimento + "]";
	}

}
