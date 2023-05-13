package br.edu.utfpr.td.tsi.webservice.endpoint;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.Emplacamento;
import br.edu.utfpr.td.tsi.webservice.modelo.Endereco;
import br.edu.utfpr.td.tsi.webservice.modelo.Parte;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;
import br.edu.utfpr.td.tsi.webservice.regras.RegrasBoletim;
import br.edu.utfpr.td.tsi.webservice.utils.CSVReaderUtil;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("boletim/all")
@Component
public class ListaBoletinsEndpoint {

	@Autowired
	private RegrasBoletim regrasBoletim;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarBoletins() throws ParseException {

		/*
		 * Parte p = new Parte("Rafael", "raffah@gmail.com", "44998195112", "vitima");
		 * Endereco e = new Endereco("Rua Carlos", 261, "Jardim Tocantins",
		 * "Toledo","PR"); Emplacamento placa = new Emplacamento("AOX", "PR", "Toledo");
		 * Veiculo v = new Veiculo(2016, "preto", "Honda", "moto", placa); LocalDate dia
		 * = LocalDate.of(2023, Month.MAY, 8); DateTimeFormatter formatador =
		 * DateTimeFormatter.ofPattern("dd/MM/yyyy"); String valorFormatado =
		 * dia.format(formatador); //BoletimFurtoVeiculo b = new
		 * BoletimFurtoVeiculo("01", dia, "tarde", p, e, v); //Date data = new Date();
		 * BoletimFurtoVeiculo b = new BoletimFurtoVeiculo("01", "tarde", p, e, v);
		 */

		ArrayList<BoletimFurtoVeiculo> bd = new ArrayList<>();

		// CSVReaderUtil.readDataLineByLine(path);

		bd = regrasBoletim.listarTodos();
		// bd.add(b);

		return Response.ok(bd).build();

	}

}
