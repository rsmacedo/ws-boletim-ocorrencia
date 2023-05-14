package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.utils.CSVReaderUtil;
import jakarta.validation.Valid;

@Component
public class BoletimDAOEmMemoria implements BoletimDAO {

	private ArrayList<BoletimFurtoVeiculo> bd = lerBanco();

	@Override
	public void persistir(@Valid BoletimFurtoVeiculo boletim) {
		bd.add(boletim);
		System.out.println("Boletim salvo no banco de dados: " + boletim);

	}

	@Override
	public void deletar(String id) {
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getIdentificador().equals(id)) {
				bd.remove(b);
				return;
			}
		}
		System.out.println("Boletim excluído com sucesso!");

	}

	@Override
	public void alterar(@Valid BoletimFurtoVeiculo boletim, String id) {
		for (BoletimFurtoVeiculo b : bd) {
			if (boletim.getIdentificador().equals(id)) {
				bd.remove(b);
				bd.add(boletim);
				return;
			}
		}
		System.out.println("Boletim alterado com sucesso!");

	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> listarTodos() {
		return bd;
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> buscarPorId(String id) {
		ArrayList<BoletimFurtoVeiculo> boletimBusca = new ArrayList<>();
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getIdentificador().equals(id)) {
				boletimBusca.add(b);
			}
		}
		return boletimBusca;
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> buscarPorCidade(String cidade) {
		ArrayList<BoletimFurtoVeiculo> boletins = new ArrayList<>();
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getLocalOcorrencia().getCidade().equals(cidade)) {
				boletins.add(b);
			}
		}
		return boletins;
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> buscarPorPeriodo(String periodo) {
		ArrayList<BoletimFurtoVeiculo> boletins = new ArrayList<>();
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getPeriodoOcorrencia().equals(periodo)) {
				boletins.add(b);
			}
		}
		return boletins;
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> buscarPorCidadeEPeriodo(String cidade, String periodo) {
		ArrayList<BoletimFurtoVeiculo> boletins = new ArrayList<>();
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getLocalOcorrencia().getCidade().equals(cidade) && b.getPeriodoOcorrencia().equals(periodo)) {
				boletins.add(b);
			}
		}

		return boletins;
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> lerBanco() {
		String path = "C:\\temp\\furtos.csv";
		ArrayList<BoletimFurtoVeiculo> boletins = CSVReaderUtil.readDataLineByLine(path);
		return boletins;
	}

}
