package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;

@Component
public class BoletimDAOEmMemoria implements BoletimDAO {

	private ArrayList<BoletimFurtoVeiculo> bd = new ArrayList<>();

	@Override
	public void persistir(BoletimFurtoVeiculo boletim) {
		bd.add(boletim);
		System.out.println("Boletim salvo no banco de dados");
		System.out.println(bd);

	}

	@Override
	public void deletar(String id) {
		for(BoletimFurtoVeiculo b: bd) {
			if(b.getIdentificador().equals(id)) {
				bd.remove(b);
				return;
			}
		}
		System.out.println("Boletim excluído com sucesso!");
		System.out.println(bd);
		
	}

	@Override
	public void alterar(BoletimFurtoVeiculo boletim, String id) {
		for(BoletimFurtoVeiculo b: bd) {
			if(boletim.getIdentificador().equals(id)) {
				bd.remove(b);
				bd.add(boletim);
				return;
			}
		}
		System.out.println("Boletim alterado com sucesso!");
		System.out.println(bd);
		
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> listarTodos() {
		
		return bd;
		
	}

	@Override
	public BoletimFurtoVeiculo buscarPorId(String id) {
		BoletimFurtoVeiculo boletim = new BoletimFurtoVeiculo();
		for(BoletimFurtoVeiculo b: bd) {
			if(b.getIdentificador().equals(id)) {
				boletim = b;
			}
		}
		return boletim;
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> buscarPorCidade(String cidade) {
		ArrayList<BoletimFurtoVeiculo> boletins = new ArrayList<>();
		for(BoletimFurtoVeiculo b: bd) {
			if(b.getLocalOcorrencia().getCidade().equals(cidade)) {
				boletins.add(b);
			}
		}
		return boletins;
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> buscarPorPeriodo(String periodo) {
		ArrayList<BoletimFurtoVeiculo> boletins = new ArrayList<>();
		for(BoletimFurtoVeiculo b: bd) {
			if(b.getPeriodoOcorrencia().equals(periodo)) {
				boletins.add(b);
			}
		}
		return boletins;
	}
	

	// implentar a persistrncia

}
