package br.edu.utfpr.td.tsi.webservice.regras;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.IBoletimDAO;
import br.edu.utfpr.td.tsi.webservice.excecoes.boletim.BoletimNaoAlteradoException;
import br.edu.utfpr.td.tsi.webservice.excecoes.boletim.BoletimNaoEncontradoException;
import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.Endereco;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;

@Component
public class RegrasBoletim implements IRegrasBoletim {

	@Autowired
	private IBoletimDAO boletimDAO;

	@Override
	public void cadastrar(BoletimFurtoVeiculo boletim) {
		boletim = gerenciarDados(boletim);
		boletimDAO.persistir(boletim);

	}

	@Override
	public void deletar(String id) {

		if (id != null) {
			if (id.isBlank()) {
				throw new BoletimNaoEncontradoException("Falha ao tentar excluir boletim");
			} else {
				if (boletimDAO.deletar(id)) {
					return;
				} else {
					throw new BoletimNaoEncontradoException("Falha ao tentar excluir boletim");
				}
			}
		} else
			throw new BoletimNaoEncontradoException("Falha ao tentar excluir boletim");
	}

	@Override
	public void alterar(BoletimFurtoVeiculo boletim, String id) {
		boletim = gerenciarDados(boletim);
		
		if(!boletimDAO.alterar(boletim, id)) {
			throw new BoletimNaoAlteradoException("Falha ao tentar alterar boletim");
		}

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
	
	public BoletimFurtoVeiculo gerenciarDados(BoletimFurtoVeiculo boletim) {
		
		Endereco endereco = boletim.getLocalOcorrencia();
		String cidade = boletim.getLocalOcorrencia().getCidade().toUpperCase();
		endereco.setCidade(cidade);
		boletim.setLocalOcorrencia(endereco);
		
		String periodo = boletim.getPeriodoOcorrencia().toUpperCase();
		boletim.setPeriodoOcorrencia(periodo);
		
		RegrasVeiculo regrasVeiculo = new RegrasVeiculo();
		Veiculo veiculo = boletim.getVeiculoFurtado();
		veiculo = regrasVeiculo.gerenciarVeiculo(veiculo);
		boletim.setVeiculoFurtado(veiculo);
		
		return boletim;
		
	}

}
