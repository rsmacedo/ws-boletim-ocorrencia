package br.edu.utfpr.td.tsi.webservice.regras;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.BoletimDAO;
import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import jakarta.ws.rs.core.Response;

@Component
public class RegrasBoletim implements IRegrasBoletim {

	@Autowired
	private BoletimDAO boletimDAO;

	@Override
	public void cadastrar(BoletimFurtoVeiculo boletim) {
		boletimDAO.persistir(boletim);

	}

	@Override
	public void deletar(String id) {
		boletimDAO.deletar(id);

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

	@Override
	public ArrayList<BoletimFurtoVeiculo> buscarPorPeriodo(String periodo) {
		return boletimDAO.buscarPorPeriodo(periodo);
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> buscarBoletim(String identificador, String cidade) {
		ArrayList<BoletimFurtoVeiculo> bd = new ArrayList<>();
		if (identificador != null) {
			bd = buscarPorId(identificador);
			return bd;
		}
		if (cidade != null) {
			bd = buscarPorCidade(cidade);
			return bd;
		} else
			bd = listarTodos();
		return bd;
	}

}
