package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;

@Component
public class BoletimDAOEmMemoria implements BoletimDAO {

	private ArrayList<BoletimFurtoVeiculo> bd = new ArrayList<>();

	@Override
	public void persistir(BoletimFurtoVeiculo b) {
		bd.add(b);
		System.out.println("Boletim salvo no banco de dados");
		System.out.println(bd);

	}

	@Override
	public void deletar(String b) {
		for(BoletimFurtoVeiculo boletim: bd) {
			if(boletim.getIdentificador().equals(b)) {
				bd.remove(boletim);
			}
		}
		System.out.println("Boletim excluído com sucesso!");
		System.out.println(bd);
		
	}

	@Override
	public void alterar(BoletimFurtoVeiculo b, String id) {
		for(BoletimFurtoVeiculo boletim: bd) {
			if(boletim.getIdentificador().equals(id)) {
				bd.remove(boletim);
				bd.add(b);
			}
		}
		System.out.println("Boletim alterado com sucesso!");
		System.out.println(bd);
		
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> listarTodos() {
		
		return bd;
		
	}
	

	// implentar a persistrncia

}
