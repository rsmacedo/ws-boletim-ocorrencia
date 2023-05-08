package br.edu.utfpr.td.tsi.webservice.endpoint;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.Emplacamento;
import br.edu.utfpr.td.tsi.webservice.modelo.Endereco;
import br.edu.utfpr.td.tsi.webservice.modelo.Parte;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;
import br.edu.utfpr.td.tsi.webservice.regras.RegrasBoletim;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("endpoint")
@Component
public class Endpoint {

	@Autowired
	private RegrasBoletim regrasBoletim;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response mostrarTexto() throws ParseException {

		// busquei no banco de dados uma informacao
		Parte p = new Parte("Rafael", "raffah@gmail.com", "44998195112", "vitima");
		Endereco e = new Endereco("Rua Carlos", 261, "Jardim Tocantins", "Toledo", "PR");
		Emplacamento placa = new Emplacamento("AOX", "PR", "Toledo");
		Veiculo v = new Veiculo(2016, "preto", "Honda", "moto", placa);
		Date data = new Date();
		BoletimFurtoVeiculo b = new BoletimFurtoVeiculo("01", data, "tarde", p, e, v);

		return Response.ok(b).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarPessoa(BoletimFurtoVeiculo b) {

		regrasBoletim.cadastrar(b);
		return Response.ok(b).build();

	}

}
