package br.edu.utfpr.td.tsi.webservice.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
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
	public Response mostrarTexto() {

		// busquei no banco de dados uma informacao
		BoletimFurtoVeiculo b = new BoletimFurtoVeiculo();

		return Response.ok("Rafael vc conseguiu!").build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarPessoa(BoletimFurtoVeiculo b) {

		regrasBoletim.cadastrar(b);
		return Response.ok(b).build();

	}

}
