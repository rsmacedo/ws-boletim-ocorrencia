package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.excecoes.boletim.BoletimNaoEncontradoException;
import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.EnvolvidoEm;
import br.edu.utfpr.td.tsi.webservice.utils.CSVReaderUtil;
import jakarta.validation.Valid;

@Component
public class BoletimDAOEmMemoria implements IBoletimDAO {

	private ArrayList<BoletimFurtoVeiculo> bd = lerBanco();

	@Override
	public void persistir(@Valid BoletimFurtoVeiculo boletim) {
		bd.add(boletim);
		System.out.println("Boletim salvo no banco de dados: " + boletim);

	}

	@Override
	public Boolean deletar(String id) {
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getIdentificador().equals(id)) {
				bd.remove(b);
				return true;
			}
		}

		return false;

	}

	@Override
	public boolean alterar(@Valid BoletimFurtoVeiculo boletim, String id) {
		boolean alterado = false;
		for (BoletimFurtoVeiculo b : bd) {
			if (boletim.getIdentificador().equals(id)) {
				bd.remove(b);
				bd.add(boletim);

				alterado = true;
			}
		}
		if (alterado) {
			return true;
		} else

			return false;

	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> listarTodos() {
		bd = adicionarListaEnvolvimento(bd);
		if (bd.isEmpty()) {
			throw new BoletimNaoEncontradoException("Nenhum boletim não encontrado");
		}
		return bd;
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> buscarPorId(String id) {
		ArrayList<BoletimFurtoVeiculo> boletim = new ArrayList<>();
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getIdentificador().equals(id)) {
				boletim.add(b);
				b = adicionarEnvolvimento(b);
			}
		}
		if (boletim.isEmpty()) {
			throw new BoletimNaoEncontradoException("Boletim não encontrado");
		}

		return boletim;
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> buscarPorCidade(String cidade) {
		cidade = cidade.toUpperCase();

		ArrayList<BoletimFurtoVeiculo> boletins = new ArrayList<>();
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getLocalOcorrencia().getCidade().equals(cidade)) {
				boletins.add(b);
			}
		}
		if (boletins.isEmpty()) {
			throw new BoletimNaoEncontradoException("Cidade não encontrada");
		}
		return boletins;
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> buscarPorPeriodo(String periodo) {
		periodo = periodo.toUpperCase();
		ArrayList<BoletimFurtoVeiculo> boletins = new ArrayList<>();
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getPeriodoOcorrencia().equals(periodo)) {
				boletins.add(b);
			}
		}

		if (boletins.isEmpty()) {
			throw new BoletimNaoEncontradoException("Período não encontrado");
		}

		return boletins;
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> buscarPorCidadeEPeriodo(String cidade, String periodo) {
		cidade = cidade.toUpperCase();
		periodo = periodo.toUpperCase();
		ArrayList<BoletimFurtoVeiculo> boletins = new ArrayList<>();
		for (BoletimFurtoVeiculo b : bd) {
			if (b.getLocalOcorrencia().getCidade().equals(cidade) && b.getPeriodoOcorrencia().equals(periodo)) {
				boletins.add(b);
			}
		}

		if (boletins.isEmpty()) {
			throw new BoletimNaoEncontradoException("Cidade ou período não encontrado");
		}

		return boletins;
	}

	@Override
	public ArrayList<BoletimFurtoVeiculo> lerBanco() {
		String path = "C:\\pasta\\temp\\furtos.csv";
		ArrayList<BoletimFurtoVeiculo> boletins = CSVReaderUtil.readDataLineByLine(path);
		return boletins;
	}

	public ArrayList<BoletimFurtoVeiculo> adicionarListaEnvolvimento(ArrayList<BoletimFurtoVeiculo> bd) {
		for (BoletimFurtoVeiculo b : this.bd) {
			EnvolvidoEm envolvido = new EnvolvidoEm();
			envolvido.setIdentificador(b.getIdentificador());
			envolvido.setCrime(b.getCrime());
			if (!b.getVeiculoFurtado().getEnvolvidoEm().contains(envolvido)) {
				b.getVeiculoFurtado().adicionarListaEnvolvido(envolvido);
			}
		}

		return bd;
	}

	public BoletimFurtoVeiculo adicionarEnvolvimento(BoletimFurtoVeiculo b) {
		EnvolvidoEm envolvido = new EnvolvidoEm();
		envolvido.setIdentificador(b.getIdentificador());
		envolvido.setCrime(b.getCrime());
		return b;
	}

}
