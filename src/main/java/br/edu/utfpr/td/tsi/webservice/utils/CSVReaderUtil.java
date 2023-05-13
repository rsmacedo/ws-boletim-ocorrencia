package br.edu.utfpr.td.tsi.webservice.utils;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.Emplacamento;
import br.edu.utfpr.td.tsi.webservice.modelo.Endereco;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;

public class CSVReaderUtil {

	public static ArrayList<BoletimFurtoVeiculo> readDataLineByLine(String file) {

		ArrayList<BoletimFurtoVeiculo> boletins = new ArrayList<>();

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {

			// Create an object of filereader
			// class with CSV file as a parameter.

			FileReader filereader = new FileReader(file);

			// create csvReader object passing
			// file reader as a parameter
			CSVParser parser = new CSVParserBuilder().withSeparator('\t').build();
			CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();
			String[] coluna;
			csvReader.readNext();

			// we are going to read data line by line
			while ((coluna = csvReader.readNext()) != null) {
				BoletimFurtoVeiculo boletim = new BoletimFurtoVeiculo();
				Endereco endereco = new Endereco();
				Veiculo veiculo = new Veiculo();
				Emplacamento emplacamento = new Emplacamento();
				boletim.setIdentificador(coluna[1]);
				Date data = formato.parse(coluna[5]);
				boletim.setDataOcorrencia(data);
				boletim.setPeriodoOcorrencia(coluna[7]);
				boletim.setParte(null);
				endereco.setLogradouro(coluna[13]);
				endereco.setNumero(Integer.parseInt(coluna[14]));
				endereco.setBairro(coluna[15]);
				endereco.setCidade(coluna[16]);
				endereco.setEstado(coluna[17]);
				boletim.setLocalOcorrencia(endereco);
				emplacamento.setPlaca(coluna[44]);
				emplacamento.setEstado(coluna[45]);
				emplacamento.setCidade(coluna[46]);
				veiculo.setEmplacamento(emplacamento);
				veiculo.setCor(coluna[47]);
				veiculo.setMarca(coluna[48]);
				if (coluna[49] == "")
					veiculo.setAnoFabricacao(0);
				else
					veiculo.setAnoFabricacao(Integer.parseInt(coluna[49]));
				veiculo.setTipoVeiculo(coluna[51]);
				boletim.setVeiculoFurtado(veiculo);
				boletim.setVeiculoFurtado(veiculo);

				if(boletins.contains(boletim)) {
					System.out.println("Boletim não adicionado, duplicidade" + boletim);
				}
				boletins.add(boletim);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boletins;

	}
}
