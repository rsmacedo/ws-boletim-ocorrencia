package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.excecoes.boletim.BoletimNaoAlteradoException;
import br.edu.utfpr.td.tsi.webservice.excecoes.boletim.BoletimNaoEncontradoException;
import br.edu.utfpr.td.tsi.webservice.excecoes.boletim.BoletimNaoExcluidoException;
import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.EnvolvidoEm;
import br.edu.utfpr.td.tsi.webservice.utils.CSVReaderUtil;
import jakarta.validation.Valid;

@Component
public class BoletimDAOEmMemoria implements IBoletimDAO {

	private ArrayList<BoletimFurtoVeiculo> bd = lerBanco();

	@Override
	public void persistir(@Valid BoletimFurtoVeiculo boletim) {

		if (bd.add(boletim)) {
			return;
		}

		throw new BoletimNaoExcluidoException("Falha ao tentar cadastrar boletim");

	}

	@Override
	public void deletar(String id) {

		for (BoletimFurtoVeiculo b : bd) {
			if (b.getIdentificador().equals(id)) {
				bd.remove(b);

				return;
			}
		}

		throw new BoletimNaoExcluidoException("Falha ao tentar excluir boletim");

	}

	@Override
	public void alterar(@Valid BoletimFurtoVeiculo boletim, String id) {
		if (id.isBlank()) {
			throw new BoletimNaoAlteradoException("Falha ao tentar alterar boletim");
		}

		for (BoletimFurtoVeiculo b : bd) {
			if (b.getIdentificador().equals(id)) {
				bd.remove(b);
				bd.add(boletim);

				return;
			}
		}

		throw new BoletimNaoAlteradoException("Falha ao tentar alterar boletim");

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
