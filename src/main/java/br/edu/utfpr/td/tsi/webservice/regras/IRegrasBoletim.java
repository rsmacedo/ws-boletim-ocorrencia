package br.edu.utfpr.td.tsi.webservice.regras;

import java.text.ParseException;
import java.util.ArrayList;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;

public interface IRegrasBoletim {

	public void cadastrar(BoletimFurtoVeiculo boletim);

	public void deletar(String id);

	public void alterar(BoletimFurtoVeiculo boletim, String id);

	public ArrayList<BoletimFurtoVeiculo> buscarBoletim(String identificador, String cidade, String periodo);

}
