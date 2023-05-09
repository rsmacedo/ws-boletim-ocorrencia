package br.edu.utfpr.td.tsi.webservice.regras;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.BoletimDAO;
import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;

@Component
public class regrasBoletimTeste implements RegrasBoletim {

	@Autowired
	private BoletimDAO boletimDAO;

	@Override
	public void cadastrar(BoletimFurtoVeiculo boletim) {
		boletimDAO.persistir(boletim);

	}

	@Override
	public void deletar(String boletim) {
		boletimDAO.deletar(boletim);
		
	}

	@Override
	public void alterar(BoletimFurtoVeiculo boletim, String id) {
		boletimDAO.alterar(boletim, id);
		
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> listarTodos() {
		return boletimDAO.listarTodos();
		
	}

}
