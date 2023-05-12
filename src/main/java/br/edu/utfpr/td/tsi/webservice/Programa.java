package br.edu.utfpr.td.tsi.webservice;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.Endereco;
import br.edu.utfpr.td.tsi.webservice.modelo.Parte;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.webservice")
public class Programa {

	public static void main(String[] args) {
		SpringApplication.run(Programa.class, args);

		String path = "C:\\temp\\furtos.csv";
		readDataLineByLine(path);
		
		List<BoletimFurtoVeiculo> boletins = new ArrayList<>();
		
	}

	// Java code to illustrate reading a
	// CSV file line by line
	public static void readDataLineByLine(String file) {

		try {

			// Create an object of filereader
			// class with CSV file as a parameter.
			
			FileReader filereader = new FileReader(file);

			// create csvReader object passing
			// file reader as a parameter
			CSVParser parser = new CSVParserBuilder().withSeparator('\t').build();
			CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();
			String[] linha;

			// we are going to read data line by line
			while ((linha = csvReader.readNext()) != null) {
				BoletimFurtoVeiculo boletim = new BoletimFurtoVeiculo();
				boletim.setIdentificador(linha[1]);
				boletim.setPeriodoOcorrencia(linha[7]);
				System.out.println(boletim);
				
				/*
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date dataOcorrencia = format.parse(colunas[1]);
				
				 Endereco endereco = new Endereco(colunas[4], colunas[5], colunas[6], colunas[7], colunas[8]);
				 Veiculo veiculo = new Veiculo(colunas[9], colunas[10], colunas[11], colunas[12], colunas[13]);
				 Parte parte = new Parte(colunas[14], colunas[15], colunas[16], colunas[17]);
				 
				 BoletimFurtoVeiculo boletim = new BoletimFurtoVeiculo(colunas[0], dataOcorrencia, colunas[2], parte, endereco, veiculo);
				 */


			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
