package br.edu.utfpr.td.tsi.webservice.regras;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.IBoletimDAO;
import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import jakarta.ws.rs.core.Response;

@Component
public class RegrasBoletim implements IRegrasBoletim {

	@Autowired
	private IBoletimDAO boletimDAO;

	@Override
	public void cadastrar(BoletimFurtoVeiculo boletim) {
		boletimDAO.persistir(boletim);

	}

	@Override
	public Boolean deletar(String id) {

		if (id != null) {
			if (id.isBlank()) {
				return false;
			} else {
				if (boletimDAO.deletar(id)) {
					return true;
				} else {
					return false;
				}
			}
		} else
			return false;

	}

	@Override
	public void alterar(BoletimFurtoVeiculo boletim, String id) {
		
		boletimDAO.alterar(boletim, id);

	}

	public ArrayList<BoletimFurtoVeiculo> listarTodos() {

		return boletimDAO.listarTodos();

	}

	public ArrayList<BoletimFurtoVeiculo> buscarPorId(String id) {
		
		return boletimDAO.buscarPorId(id);
	}

	public ArrayList<BoletimFurtoVeiculo> buscarPorCidade(String cidade) {

		return boletimDAO.buscarPorCidade(cidade);
	}

	public ArrayList<BoletimFurtoVeiculo> buscarPorPeriodo(String periodo) {

		return boletimDAO.buscarPorPeriodo(periodo);
	}

	public ArrayList<BoletimFurtoVeiculo> buscarPorCidadeEPeriodo(String cidade, String periodo) {
		
		return boletimDAO.buscarPorCidadeEPeriodo(cidade, periodo);
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> buscarBoletim(String identificador, String cidade, String periodo) {
		
		ArrayList<BoletimFurtoVeiculo> bd = new ArrayList<>();
		if (identificador != null) {
			bd = buscarPorId(identificador);
		} else if (cidade != null && periodo != null) {
			bd = buscarPorCidadeEPeriodo(cidade, periodo);
		} else if (cidade != null) {
			bd = buscarPorCidade(cidade);
		} else if (periodo != null) {
			bd = buscarPorPeriodo(periodo);
		} else
			bd = listarTodos();
		return bd;
	}

}
